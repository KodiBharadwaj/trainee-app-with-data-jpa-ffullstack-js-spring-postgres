package com.ust.traineeapp.service;
import com.ust.traineeapp.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineeService {

    Trainee saveTrainee(Trainee trainee);

    Trainee getTraineeById(int id);

    void deleteTrainee(int id);

    List<Trainee> getAllTrainees();

    Trainee updateTrainee(int id, Trainee trainee);

    Trainee findTraineeByName(String name);

    List<Trainee> findTraineeByLocation(String location);

    List<Trainee> findTraineeByMonthAndYear(int month, int year);

}
