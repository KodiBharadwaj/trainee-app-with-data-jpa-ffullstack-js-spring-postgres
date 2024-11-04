package com.ust.traineeapp.api;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) // 201 Created, 409 Conflict
    public Trainee saveTrainee(@RequestBody Trainee trainee){
        return traineeService.saveTrainee(trainee);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK) // 200 Ok, 404 Not Found
    public Trainee getTrainee(@PathVariable("id") int id){
        return traineeService.getTraineeById(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK) // 200 Ok, 404 Not Found
    public List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }


    @GetMapping("/search")
    @ResponseStatus(code = HttpStatus.OK) // 200 Ok, 404 Not Found
    public Trainee findTraineeByName(@RequestParam("name") String name)
    {
        return traineeService.findTraineeByName(name);
    }

    @GetMapping("/location")
    @ResponseStatus(code = HttpStatus.OK) // 200 Ok, 404 Not Found
    public List<Trainee> getTraineeListByLocation(@RequestParam("location") String location){
        return traineeService.findTraineeByLocation(location);
    }

    @GetMapping("/month/{month}/year/{year}")
    @ResponseStatus(code = HttpStatus.OK) // 200 Ok, 404 Not Found
    public List<Trainee> findTraineeByMonthAndYear(@PathVariable int month,
                                                   @PathVariable int year){
        return traineeService.findTraineeByMonthAndYear(month, year);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content, 404 Not Found
    public void deleteTrainee(@PathVariable("id") int id){
        traineeService.deleteTrainee(id);
    }


//    @PutMapping("/{id}")
//    @ResponseStatus(code = HttpStatus.ACCEPTED)
//    public Trainee updateTrainee(@PathVariable int id,@RequestBody Trainee trainee){
//        return traineeService.updateTrainee(id,trainee);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainee> updateTrainee(@PathVariable("id") int id, @RequestBody Trainee trainee){
        if(traineeService.getTraineeById(id) != null){
            Trainee updatedTrainee = traineeService.updateTrainee(id, trainee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedTrainee); // 202 Accepted
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404 Not Found
        }
    }

}





