package com.ideas2it.ems.model.traineemodel;

public class Trainee {

    private int id;
    private String name;
    private String emailId;
    private long phoneNumber;
    private String Designation;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
       return name;
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
        collectData.append("\nTrainee id         : ").append(id)
                   .append("\nTrainee Name       : ").append(name)
                   .append("\nTrainee EmailId    : ").append(emailId)
                   .append("\nTrainee Designation: ").append(Designation)
                   .append("\nTrainee PhoneNumber: ").append(phoneNumber);
        return collectData.toString();
    }
}