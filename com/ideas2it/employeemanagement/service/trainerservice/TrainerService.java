package com.ideas2it.employeemanagement.service.trainerservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.employeemanagement.model.trainermodel.Trainer;
import com.ideas2it.employeemanagement.model.traineemodel.Trainee;
import com.ideas2it.employeemanagement.dao.trainerdao.TrainerDAO;
import com.ideas2it.employeemanagement.exception.UserNotFoundException;

public class TrainerService {

    TrainerDAO trainerDAO = new TrainerDAO();

    public void addDetail(Trainer trainer) {
        trainerDAO.addTrainer(trainer);
    }

    public List<Trainer> getDetails() {
      return trainerDAO.getTrainer();
    }

    public boolean isTrainerListEmpty() {
        return trainerDAO.getTrainer().isEmpty();   
    }

    public boolean checkTrainerById (Integer id) throws UserNotFoundException {
        for(int index = 0; index < trainerDAO.getTrainer().size(); index++) {
            if(id.equals(trainerDAO.getTrainer().get(index).getId())) {
                return true;
            }
        }
        throw new UserNotFoundException("Trainer ID does not exist");
    }

    public int checkIndexById(Integer number) {
        int trainerIndex= 0;

        for (int index = 0; index < trainerDAO.getTrainer().size(); index++) {
            if (number.equals(trainerDAO.getTrainer().get(index).getId())) {
                trainerIndex = index;
            }
        }
        return trainerIndex;
    }

     public void updateName(Integer id, String name) {
        Integer trainerIndex = checkIndexById(id);
        Trainer trainer = getTrainer(trainerIndex);
        trainer.setName(name);
        trainerDAO.updateTrainer(trainerIndex, trainer);
    }

    public void updateDOB(Integer id, LocalDate dob) {
        Integer trainerIndex = checkIndexById(id);
        Trainer trainer = getTrainer(trainerIndex);
        trainer.setDOB(dob);
        trainerDAO.updateTrainer(trainerIndex, trainer);
    }

    public void updateExperience(Integer id, float experience) {
        Integer trainerIndex = checkIndexById(id);
        Trainer trainer = getTrainer(trainerIndex);
        trainer.setExperience(experience);
        trainerDAO.updateTrainer(trainerIndex, trainer);
    }
   
    public void updatePhoneNumber(Integer id, long phoneNumber) {
        Integer trainerIndex = checkIndexById(id);
        Trainer trainer = getTrainer(trainerIndex);
        trainer.setPhoneNumber(phoneNumber);
        trainerDAO.updateTrainer(trainerIndex, trainer);
    }

    public void updateDesignation(Integer id, String designation) {
        Integer trainerIndex = checkIndexById(id);
        Trainer trainer = getTrainer(trainerIndex);
        trainer.setDesignation(designation);
        trainerDAO.updateTrainer(trainerIndex, trainer);
    }

    public void updateEmailId(Integer id, String emailId) {
        Integer trainerIndex = checkIndexById(id);
        Trainer trainer = getTrainer(trainerIndex);
        trainer.setEmailId(emailId);
        trainerDAO.updateTrainer(trainerIndex, trainer);
    }

    public void updateTrainee(Integer id, List<Trainee> trainee) {
        Integer trainerIndex = checkIndexById(id);
        Trainer trainer = getTrainer(trainerIndex);
        trainer.setTrainee(trainee);
        trainerDAO.updateTrainer(trainerIndex, trainer);
    }

    public String getId(Integer id) {
        Integer trainerIndex = checkIndexById(id);
        return trainerDAO.getTrainer().get(trainerIndex).toString();
    }

    public Trainer getTrainer(Integer id) {
        Integer trainerIndex = checkIndexById(id);
        return trainerDAO.getTrainer().get(trainerIndex);
    }

    public void  deleteId(Integer id) {
        int trainerIndex = checkIndexById(id);
        trainerDAO.deleteTrainer(trainerIndex);
    }

    public int alreadyExistPhoneNumber(long number){
         int flag = 0;
            for (Trainer trainer :  getDetails()) {
                 Long phoneNumber = trainer.getPhoneNumber();
                 if(number == phoneNumber) {
                     flag=1;
                }
            }
        return flag;
    }

    public int alreadyExistEmailId(String mailId){
         int flag = 0;
            for (Trainer trainer :  getDetails()) {
                 String emailId =trainer.getEmailId();
                 if(mailId.equals(emailId)) {
                     flag=1;
                }
            }
        return flag;
    }
}