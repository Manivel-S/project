package com.ideas2it.ems.model.trainermodel;

import java.util.List;

import com.ideas2it.ems.model.traineemodel.Trainee;

public class Trainer {

    private int id;
    private String name;
    private float experience;
    private String emailId;
    private long phoneNumber;
    private String Designation;
    private List<Trainee> traineeList;

    public void setTrainee(List<Trainee> traineeList) {
        this.traineeList = traineeList;
    }

    public List<Trainee> getTrainee() {
        return traineeList;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
       return name;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public float getExperience() {
       return experience;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
       return emailId;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber() {
       return phoneNumber;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public String getDesignation() {
       return Designation;
    }
    
    public void setId(int id) {
       this.id = id;
    }
    
    public int getId() {
       return id;
    }     

    public String toString() {
        StringBuilder collectData = new StringBuilder();
        collectData.append("\nTrainer id         : ").append(id)
                   .append("\nTrainer name       : ").append(name)
                   .append("\nTrainer experience : ").append(experience)
                   .append("\nTrainer EmailId    : ").append(emailId)
                   .append("\nTrainer Designation: ").append(Designation)
                   .append("\nTrainer PhoneNumber: ").append(phoneNumber);
        return collectData.toString();
    }
}