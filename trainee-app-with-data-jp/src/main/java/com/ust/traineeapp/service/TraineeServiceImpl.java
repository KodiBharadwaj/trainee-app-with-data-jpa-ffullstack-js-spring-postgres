package com.ust.traineeapp.service;

import com.ust.traineeapp.exception.RecordNotFoundException;
import com.ust.traineeapp.model.Trainee;

import java.util.List;
import com.ust.traineeapp.repository.ProjectRepository;
import com.ust.traineeapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepository traineeRepo;

    @Autowired
    private ProjectRepository projectRepo;

    @Override
    public Trainee saveTrainee(Trainee trainee) {
        if(traineeRepo.existsById(trainee.getId())){
            throw new RuntimeException("Trainee with ID " + trainee.getId() + " Already Present");
        }

        // with no project class
         return traineeRepo.save(trainee);

// for one to one
//        Trainee savedTrainee = traineeRepo.save(trainee);
//        Project project = savedTrainee.getProject();
//        project.setTrainee(savedTrainee);
//        projectRepo.save(project);
//        return savedTrainee;

// for one to many
//        Trainee savedTrainee = traineeRepo.save(trainee);
//        return savedTrainee;

// for many to one

//        if(traineeRepo.existsById(trainee.getId())){
//            throw new RuntimeException("Trainee with ID "+trainee.getId()+" Already Present");
//        }
//        Trainee savedTrainee = null;
//        if(trainee.getProject()!=null) {
//            Project project = projectRepo.findById(trainee.getProject().getId()).orElse(null);
//
//
//            if (project != null) {
//                trainee.setProject(project);
//                savedTrainee = traineeRepo.save(trainee);
//                project.getTrainees().add(savedTrainee);
//                projectRepo.save(project);
//            }
//            else{
//                savedTrainee = traineeRepo.save(trainee);
//            }
//        }
//        else {
//            savedTrainee = traineeRepo.save(trainee);
//        }
//
//
//        return savedTrainee;

    }

    @Override
    public Trainee getTraineeById(int id) {
        return traineeRepo.findById(id).orElseThrow(()->new RecordNotFoundException("Trainee with Id " + id + " not found"));
    }

    @Override
    public void deleteTrainee(int id) {
        traineeRepo.deleteById(id);
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return traineeRepo.findAll();
    }

    @Override
    public Trainee updateTrainee(int id, Trainee trainee) {
        if (!traineeRepo.existsById(id)){
            throw new RuntimeException("Trainee with ID "+id+" Not Found");
        }

        Trainee traineeToUpdate = getTraineeById(id);
        if(trainee.getName()!=null){
            traineeToUpdate.setName(trainee.getName());
        }
        if(trainee.getLocation()!=null){
            traineeToUpdate.setLocation(trainee.getLocation());
        }
        if(trainee.getJoinedDate()!=null){
            traineeToUpdate.setJoinedDate(trainee.getJoinedDate());
        }

        return traineeRepo.save(traineeToUpdate);
    }

    @Override
    public Trainee findTraineeByName(String name) {
        return traineeRepo.findByName(name).orElse(null);
    }

    @Override
    public List<Trainee> findTraineeByLocation(String location) {
        return traineeRepo.findByLocation(location);
    }

    @Override
    public List<Trainee> findTraineeByMonthAndYear(int month, int year){
        return traineeRepo.getAllByMonthAndYear(month, year);
    }
}
