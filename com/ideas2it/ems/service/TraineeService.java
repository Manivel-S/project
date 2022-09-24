package com.ideas2it.ems.service.traineeservice;

import java.util.ArrayList;
import java.util.List;

public class TraineeService {

    TraineeDAO traineeDAO = new TraineeDAO();

    public void addDetail(Trainee trainee) {
        traineeDAO.addTrainee(trainee);
    }

    public List<Trainee> getDetails() {
       return traineeDAO.getTrainee();
    }
   
    public boolean isTraineeEmpty() {
        return traineeDAO.traineeList.isEmpty();
    }
    
    public boolean checkTraineeById (Integer id) throws UserNotFoundException {
        for(int index = 0; index < traineeDAO.traineeList.size(); index++) {
            if(id.equals(traineeDAO.traineeList.get(index).getId())) {
                return true;
             }
         }
        throw new UserNotFoundException("Trainee ID does not exist");
     }

    public int checkIndexById(Integer id) {
        int traineeIndex = 0;

        for (int index = 0; index < traineeDAO.traineeList.size(); index++) {
            if(id.equals(traineeDAO.traineeList.get(index).getId())) {
                traineeIndex = index;
            }
        }
        return traineeIndex;
    }

    public void updateName(Integer id, String name) {
        Integer traineeIndex = checkIndexById(id);
        Trainee trainee = getTrainee(traineeIndex);
        trainee.setName(name);
        traineeDAO.updateTrainee(traineeIndex, trainee);
    }
   
    public void updatePhoneNumber(Integer id, long phoneNumber) {
        Integer traineeIndex = checkIndexById(id);
        Trainee trainee = getTrainee(traineeIndex);
        trainee.setPhoneNumber(phoneNumber);
        traineeDAO.updateTrainee(traineeIndex, trainee);
    }

    public void updateDesignation(Integer id, String designation) {
        Integer traineeIndex = checkIndexById(id);
        Trainee trainee = getTrainee(traineeIndex);
        trainee.setDesignation(designation);
        traineeDAO.updateTrainee(traineeIndex, trainee);
    }

    public void updateEmailId(Integer id, String emailId) {
        Integer traineeIndex = checkIndexById(id);
        Trainee trainee = getTrainee(traineeIndex);
        trainee.setEmailId(emailId);
        traineeDAO.updateTrainee(traineeIndex, trainee);
    }


     public Trainee getTrainee(Integer id) {
        Integer traineeIndex = checkIndexById(id);
        return traineeDAO.getTrainee().get(traineeIndex);
    }

    public void  deleteId(Integer id) {
        int traineeIndex = checkIndexById(id);
        traineeDAO.deleteTrainee(traineeIndex);
    }
}