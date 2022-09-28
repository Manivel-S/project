package com.ideas2it.employeemanagement.model.traineemodel;

import java.time.LocalDate;

public class Trainee {

    private int id;
    private String name;
    private int age;
    private LocalDate dob;
    private String emailId;
    private long phoneNumber;
    private String Designation;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
       return name;
    }

     public void setDOB(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDOB() {
       return dob;
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

    public void setAge(int age) {
       this.age = age;
    }
    
    public int getAge() {
       return age;
    }

    public String toString() {
        StringBuilder collectData = new StringBuilder();
        collectData.append("\nTrainee id         : ").append(id)
                   .append("\nTrainee Name       : ").append(name)
                   .append("\nTrainee DOB        : ").append(dob)
                   .append("\nTrainee Age        : ").append(age)
                   .append("\nTrainee EmailId    : ").append(emailId)
                   .append("\nTrainee Designation: ").append(Designation)
                   .append("\nTrainee PhoneNumber: ").append(phoneNumber);
        return collectData.toString();
    }
}