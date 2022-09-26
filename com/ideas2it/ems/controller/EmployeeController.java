package com.ideas2it.ems.controller;

import java.time.format.DateTimeParseException;
import java.time.LocalDate; 
import java.time.Period;  
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.ideas2it.ems.service.trainerservice.TrainerService;
import com.ideas2it.ems.service.traineeservice.TraineeService;
import com.ideas2it.ems.model.trainermodel.Trainer;
import com.ideas2it.ems.model.traineemodel.Trainee;
import com.ideas2it.ems.exception.UserNotFoundException;
import com.ideas2it.ems.util.ValidationUtil;

class EmployeeController {
    int trainerId = 1;
    int traineeId = 100;
    Scanner scanner = new Scanner(System.in);
    TrainerService trainerService = new TrainerService();
    TraineeService traineeService = new TraineeService();
    static Logger logger = LogManager.getLogger(EmployeeController.class);

    public static void main(String args[]) {
        EmployeeController controller = new EmployeeController();
        controller.chooseOperation();
    }

    public void chooseOperation() {
        int choice = 0;

        do {
            try {
                logger.info("\nselect\n1.Trainer\n2.Trainee\n3.exit");
                choice = getChoice();
                switch (choice) {
                    case 1:
                        trainerOperations();
                        break;

                    case 2:
                        traineeOperations();
                        break;

                    case 3:
                        System.exit(0);

                    default:
                       logger.warn("\nInvalid number");
                }
             } catch (InputMismatchException error) {
                logger.error("\nEnter numbers only....!");
            }
        } while (choice != 0); 
    }

    public void trainerOperations() {
        int choice = 0;
        do {
            try {
                logger.info("\nTrainer details");
                logger.info("\n1.Create\n2.Read\n3.Update\n4.Delete\n"
                            .concat("5.Search\n6.Exit\n"));
                choice = getChoice();
                switch (choice) {
                    case 1:
                        createTrainer();
                        break;

                    case 2:
                        readTrainer();
                        break;

                    case 3:
                        updateTrainer();
                        break;

                    case 4:
                        deleteTrainer();
                        break;

                    case 5:
                        searchTrainer();
                        break;

                    case 6:
                        logger.info("\nYou exit from trainer operation");
                        break;

                    default:
                        logger.warn("\nYou entred invalid number");
                }
            } catch (InputMismatchException error) {
                logger.error("\nEnter numbers only....!");
            }
        } while (choice != 6);
    }

    public void createTrainer() {
        Trainer trainer = new Trainer();
        System.out.println("Trainer id  : " + trainerId);
        trainer.setId(trainerId++);
        trainer.setName(getName());
        LocalDate dob = getDOB();
        trainer.setDOB(dob);
        trainer.setAge(getAge(dob));
        trainer.setExperience(getExperience());
        trainer.setEmailId(getEmailId());
        trainer.setPhoneNumber(getPhoneNumber());
        trainer.setDesignation(getDesignation());
        trainer.setTrainee(assignTrainee());
        trainerService.addDetail(trainer);
    }

    public List<Trainee> assignTrainee() {
        int choice = 0;
        int traineeID;
        int traineeIndex = 0;
        List<Trainee> traineeAssignList = new ArrayList<Trainee>();
        do {
            try {
                logger.info("\n1. assign exist trainee"
                            .concat("\n2.create trainee and assign")
                            .concat("\n3--exit "));
                choice = getChoice();
                switch (choice ) {
                    case 1:
                        if (traineeService.isTraineeListEmpty()) {
                            logger.info("\nTrainee list is empty");
                        } else {
                            traineeAssignList.add(assignExistTrainee());
                        }
                        break;

                    case 2:
                        createTrainee();
                        traineeIndex = traineeService.getDetails().size()-1;
                        traineeAssignList.add(traineeService.getDetails()
                                               .get(traineeIndex));
                        break;

                    case 3:
                        break;

                    default:
                        logger.warn("\nInvalid option");
                }
            } catch (InputMismatchException error) {
                logger.error("\nEnter numbers only....!");
            }
       } while (choice  != 3);
       return traineeAssignList;
    }

    public  Trainee assignExistTrainee() { 
        int traineeID;    
        logger.info("Available Trainee ID's");

        for (Trainee trainee : traineeService.getDetails()) {
            logger.info(trainee.getId());
        }
        logger.info("\nChoose the trainee id to assign");
        traineeID = scanner.nextInt();   
        return traineeService.getTrainee(traineeID);
    }

    public String getName() {
        String name;
        boolean isValid;
        do {
            logger.info("\nEnter employee name: ");
            name = scanner.nextLine();
            isValid = ValidationUtil.isValidPattern(ValidationUtil.namePattern,name);
            if (!(isValid)) {
                logger.warn("\nInvlaid name");
            }
        } while (!(isValid));
        return name;
    }

    public LocalDate getDOB() {
        String dob;
        boolean isValid;
        LocalDate validDate = null;
        do {
            logger.info("Enter employee dob (YYYY-MM-DD): ");
            dob = scanner.nextLine();
            try {
                  validDate = LocalDate.parse(dob);
                 if(isValidAge(validDate)) {
                    isValid = true;
                 } else {
                    System.out.println("your not eligible ");
                   isValid = false;
                 }
            } catch (DateTimeParseException e) {
                logger.warn("invalid date ");
                isValid = false;
            }
            
        } while (!(isValid));
        return validDate;
    }

    public boolean isValidAge(LocalDate validDate) {
        LocalDate curDate = LocalDate.now();
        if( Period.between(validDate, curDate).getYears()>18) {
            return true;
        } else {
            return false;
        }
    }  

    public int getAge(LocalDate validDate) {
        LocalDate curDate = LocalDate.now();
        int age = Period.between(validDate, curDate).getYears();
        return age;
   }

    public float getExperience() {
        float experience = 0;
        boolean isValid = false;
        do {
            try {
                logger.info("Enter experience: ");
                experience = Float.parseFloat(scanner.nextLine());
                isValid = ValidationUtil
                          .isValidPattern(ValidationUtil.experiencePattern,
                                          Float.toString(experience));
            } catch (NumberFormatException error) {
                 logger.error("\nEnter numbers only\n"); 
                isValid = false;
            }
        } while (!(isValid));
        return experience;
    }

    public String getEmailId() {
        String emailId;
        boolean isValid = false;
        do {
            logger.info("Enter employee email ID: ");
            emailId = scanner.nextLine();
            isValid = ValidationUtil.isValidPattern(ValidationUtil.emailIdPattern, emailId);
            if (!(isValid)) {
                logger.warn("Invalid emailid");
            }
        } while (!(isValid));
        return emailId;
    }

    public long getPhoneNumber() {
        long phoneNumber = 0;
        boolean isValid = false;
        do {
            try {
                logger.info("Enter employee PhoneNumber: ");
                Scanner scanner = new Scanner(System.in);
                phoneNumber = Long.parseLong(scanner.nextLine());
                isValid = ValidationUtil
                          .isValidPattern(ValidationUtil.phoneNumberPattern,
                                          Long.toString(phoneNumber));
            } catch (InputMismatchException error) {
                logger.error("Enter numbers only\n");
                isValid = false;   
            } catch (NumberFormatException error) {
                logger.error("Enter numbers only\n");
                isValid = false;   
            }
            if (!(isValid)) {
                logger.warn("Invalid number");
            }
        } while (!(isValid));
        return phoneNumber;
    }

    public String getDesignation() {
        String designation;
        boolean isValid;
        do {
            logger.info("Enter employee Designation: ");
            designation = scanner.nextLine();
            isValid = ValidationUtil.isValidPattern(ValidationUtil.designationPattern,
                                                     designation);
            if (!(isValid)) {
                logger.warn("Invalid designation");
            }
        } while (!(isValid));
        return designation;
    }

    public void readTrainer() {

        if (trainerService.isTrainerEmpty()) {
            System.out.print("TrainerList does not exist");
        } else {
            List<Trainer> trainerList = trainerService.getDetails();
            for (Trainer trainer : trainerList) {
                logger.info(trainer);
                List<Trainee> traineeList = trainer.getTrainee();
                if (!(traineeList.isEmpty())) {
                    for(Trainee trainee : traineeList) {
                        logger.info("\n" + trainee);
                    }
                }
            }
        }
    }

    public void updateTrainer() {
        logger.info("\nEnter the ID want to update");
        Integer id = getChoice();
        System.out.print("Trainer ID : ");
        int choice = 0;
        try {
            if (trainerService.checkTrainerById(id)) {
                do {
                    logger.info("\n1.Name\n2.Experience\n3.Email ID"
                                .concat("\n4.PhoneNumber5\nDesignation")
                                .concat("\n6.DOB\n0. --> go back"));
                    logger.info("\nWhich information you want to change ");
                    logger.info("\nPlease select the number");
                    choice = getChoice();
                    switch (choice) {
                        case 1:
                            trainerService.updateName(id, getName());
                            logger.info("Updation completed...");
                            break;

                        case 2:
                            trainerService.updateExperience(id, getExperience());
                            logger.info("Updation completed...");
                            break;

                        case 3:
                            trainerService.updateEmailId(id, getEmailId());
                            logger.info("Updation completed...");
                            break;

                        case 4:
                            trainerService.updatePhoneNumber(id, getPhoneNumber());
                            logger.info("Updation completed...");
                            break;

                        case 5:
                            trainerService.updateDesignation(id, getDesignation());
                            logger.info("Updation completed...");
                            break;

                        case 6:
                            trainerService.updateDOB(id, getDOB());
                            System.out.println("Updation completed...");
                            break;

                        case 0:
                            break;

                        default:
                            logger.warn("\nEnter the valid options");
                    }
                } while (choice !=0 );
            } 
        } catch (UserNotFoundException error) {
            logger.error("\nTrainer does not exit");
        }
    }

    public void searchTrainer() { 
        logger.info("Enter the ID want to search");
        Integer id = getChoice();
        logger.info("Trainer ID : ");
        try {
            if (trainerService.checkTrainerById(id)) {
                logger.info(trainerService.getId(id));
                List<Trainee> traineeList = trainerService.getTrainer(id)
                                            .getTrainee();
                if (!(traineeList.isEmpty())) {
                    for (Trainee trainee : traineeList) {
                        logger.info(trainee);
                    }
                }
            }
        } catch (UserNotFoundException error) {
            logger.error("\nTrainer does not exit");
        }
    }

    public void deleteTrainer() {
        logger.info("Enter the ID want to delete");
        Integer id = getChoice();
        logger.info("Trainer ID : ");
        try {
            if (trainerService.checkTrainerById(id)) {
                trainerService.deleteId(id);
                logger.info("Employee deleted...");
            }
        } catch (UserNotFoundException error) {
            logger.error("\nTrainer does not exit");
        } 
    }

    public void traineeOperations() {
        int choice = 0;

        do {
            try {
                logger.info("\ntrainee details");
                logger.info("\n1.create\n2.read\n3.update\n" 
                            .concat("4.delete\n5.search\n6.exit\n"));
                choice = getChoice();  
                switch (choice) {
                     case 1:
                        createTrainee();
                        break;

                    case 2:
                        readTrainee();
                        break;

                    case 3:
                        updateTrainee();
                        break;

                    case 4:
                        deleteTrainee();
                        break;

                    case 5:
                        searchTrainee();
                        break;

                    case 6:
                        logger.info("your exit from trainee service");
                        break;

                    default:
                        logger.warn("your entred invalid number");
                }
            } catch (InputMismatchException error) {
                logger.error("\nEnter numbers only....!");
            }
        } while (choice != 6);
    }


    public void createTrainee() {
        Trainee trainee = new Trainee();
        System.out.println("Trainee id  : " + traineeId);
        trainee.setId(traineeId++);
        trainee.setName(getName());
        LocalDate dob = getDOB();
        trainee.setDOB(dob);
        trainee.setAge(getAge(dob));
        trainee.setEmailId(getEmailId());
        trainee.setPhoneNumber(getPhoneNumber());
        trainee.setDesignation(getDesignation());
        traineeService.addDetail(trainee);
    }

    public void readTrainee() {

        if (traineeService.isTraineeListEmpty()) {
            logger.info("TraineeList does not exist");
        } else {
            List <Trainee> traineeList = traineeService.getDetails();
            for (Trainee trainee : traineeList) {
                logger.info(trainee);
            }
        }
    }

    public void updateTrainee() {
        logger.info("Enter the ID want to update");
        Integer id = getChoice();
        logger.info("\nTrainee ID : ");
        int choice = 0;
        try {
            if (traineeService.checkTraineeById(id)) {
                do {
                    try {
                        logger.info("\n1.Name\n2.Mail ID\n3.PhoneNumber"
                                    .concat("\n4.Designation\n5.DOB")
                                    .concat("\n0. -->go back"));
                        logger.info("\nWhich information you want to change ");
                        logger.info("\nplease select the number");

                        choice = getChoice();  
                        switch (choice) {
                            case 1:
                                traineeService.updateName(id, getName());
                                logger.info("Updation completed...");
                                break;

                            case 2:
                                traineeService.updateEmailId(id, getEmailId());
                                logger.info("Updation completed...");
                                break;

                            case 3:
                                traineeService.updatePhoneNumber(id, getPhoneNumber());
                                logger.info("Updation completed...");
                                break;

                            case 4:
                                traineeService.updateDesignation(id, getDesignation());
                                logger.info("Updation completed...");
                                break;

                            case 5:
                                traineeService.updateDOB(id, getDOB());
                                System.out.println("Updation completed...");
                                break;

                            case 0:
                                break;

                            default:
                                logger.warn("Enter the valid options");
                        }
                    } catch (InputMismatchException error) {
                        logger.error("\nEnter numbers only....!");
                    }
                } while (choice !=0 );
            }
        } catch (UserNotFoundException e) {
            logger.error("\nTrainee does not exit");
        }
    }

    public void searchTrainee() {
        logger.info("\nEnter the ID want to search");
        Integer id = getChoice();
        logger.info("Trainee ID : ");
        try {
            if (traineeService.checkTraineeById(id)) {
                logger.info(traineeService.getTrainee(id));
            }
        } catch (UserNotFoundException error) {
            logger.error("\nTrainee does not exit");
        }
    }

    public void deleteTrainee() {
        logger.info("\nEnter the ID want to delete");
        Integer id = getChoice();
        logger.info("Trainee ID : ");
        try {
            if (traineeService.checkTraineeById(id)) {
                traineeService.deleteId(id);
                logger.info("\nEmployee deleted..");
            }
        } catch (UserNotFoundException error) {
            logger.error("\nTrainee does not exit");
        }
    }

    public int getChoice() {
        int flag = 0;
        int choice = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                logger.info("\nEnter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                flag = 0;
            } catch (InputMismatchException error) {
                logger.error("\nEnter numbers only....!");
                flag = 1;
            } catch (NumberFormatException error) {
                logger.error("\nEnter numbers only....!");
                flag = 1;
            }
        } while (flag == 1);
        return choice;
    }
}