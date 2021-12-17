package com.example.project;

import com.example.project.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Used to test out all functionality related to animal profiles.
 * This class can be used to show or add all information and attributes
 * related to the animals
 * @author Michael Kissinger
 */
public class BackEndMKTest {

    public static void main(String[] args) throws SQLException {
        AnimalDatabase myDatabase = new AnimalDatabase();
        JDBCConnect myJDBC = new JDBCConnect();
        myJDBC.createConnection();

        boolean endApp = false;
        while (endApp == false) {
            Scanner menuSelection2 = new Scanner(System.in);
            System.out.println("Would you like to select another animal or exit?");
            System.out.println("1 - Select an animal");
            System.out.println("2 - Search all animals");
            System.out.println("3 - Exit");
            String option2 = menuSelection2.nextLine();

            switch (option2) {
                case "1":
                    //Testing Animal Search Back end, search by ID
                    Scanner myObj = new Scanner(System.in);
                    System.out.println("Please enter Animals ID");
                    String animalID = myObj.nextLine();
                    Animal myAnimal = myDatabase.findAnimal(Integer.parseInt(animalID));
                    System.out.println("You are in the animal page for: " + myAnimal.getName() + " with ID: " + myAnimal.getAnimalId());

                    boolean endSelect = false;
                    while (endSelect == false) {
                        Scanner menuSelection = new Scanner(System.in);
                        System.out.println("Please type 1 through 14 to select an option from the menu:");
                        System.out.println("1 - View all animal info");
                        System.out.println("2 - View animal status");
                        System.out.println("3 - View prescription info");
                        System.out.println("4 - View problem info");
                        System.out.println("5 - View history info");
                        System.out.println("6 - View photo info");
                        System.out.println("7 - View comment info");
                        System.out.println("8 - Update status");
                        System.out.println("9 - Add new prescription");
                        System.out.println("10 - Add new problem");
                        System.out.println("11 - Add new History");
                        System.out.println("12 - Add new photo");
                        System.out.println("13 - Add new comment");
                        System.out.println("14 - Select another Animal");

                        String option = menuSelection.nextLine();  //Read user input

                        switch (option) {
                            case "1":
                                System.out.println("Showing the info for: " + myAnimal.getName());
                                System.out.println(myAnimal);
                                break;
                            case "2":
                                System.out.println("Showing the status for: " + myAnimal.getName());
                                System.out.println(myAnimal.getStatus());
                                break;
                            case "3":
                                System.out.println("Showing the prescriptions for: " + myAnimal.getName());
                                System.out.println(myAnimal.getAnimalPrescriptions());
                                break;
                            case "4":
                                System.out.println("Showing the problems for: " + myAnimal.getName());
                                System.out.println(myAnimal.getAnimalProblems());
                                break;
                            case "5":
                                System.out.println("Showing the history for: " + myAnimal.getName());
                                System.out.println(myAnimal.getAnimalHistory());
                                break;
                            case "6":
                                System.out.println("Showing the photos for: " + myAnimal.getName());
                                for (AnimalHistory ah : myAnimal.getAnimalHistory()) {
                                    System.out.println(ah.getAnimalHistoryPhotos());
                                }
                                break;
                            case "7":
                                System.out.println("Showing the comments for: " + myAnimal.getName());
                                for (AnimalHistory ah : myAnimal.getAnimalHistory()) {
                                    System.out.println(ah.getAnimalHistoryComments());
                                }
                                break;
                            case "8":
                                myObj = new Scanner(System.in);
                                System.out.println("Please enter change to status: ");
                                String status = myObj.nextLine();
                                myAnimal.setStatus(status);
                                myAnimal = myDatabase.findAnimal(Integer.parseInt(animalID));
                                System.out.println("Status has been changed to: " + myAnimal.getStatus());
                                break;
                            case "9":
                                System.out.println("Adding new prescription");
                                System.out.println("Enter the scriptRecord:");
                                myObj = new Scanner(System.in);
                                String scriptRecord = myObj.nextLine();
                                System.out.println("Enter the drugName:");
                                myObj = new Scanner(System.in);
                                String drugName = myObj.nextLine();
                                System.out.println("Enter the deliveryMethod:");
                                myObj = new Scanner(System.in);
                                String deliveryMethod = myObj.nextLine();
                                System.out.println("Enter the userId:");
                                myObj = new Scanner(System.in);
                                String userId = myObj.nextLine();
                                System.out.println("Enter the date:");
                                myObj = new Scanner(System.in);
                                String date = myObj.nextLine();
                                System.out.println("Enter the dosage:");
                                myObj = new Scanner(System.in);
                                String dosage = myObj.nextLine();
                                System.out.println("Enter the instructions:");
                                myObj = new Scanner(System.in);
                                String instructions = myObj.nextLine();
                                System.out.println("Enter the treatmentMethod:");
                                myObj = new Scanner(System.in);
                                String treatmentMethod = myObj.nextLine();
                                System.out.println("Enter the animalId:");
                                myObj = new Scanner(System.in);
                                String animalId = myObj.nextLine();
//                                myJDBC.addAnimalPrescription(scriptRecord, drugName, deliveryMethod,
//                                        userId, date, dosage, instructions,
//                                        treatmentMethod, animalId);
                                break;
                            case "10":
                                System.out.println("Adding new Problem");
                                System.out.println("Enter the animalId:");
                                myObj = new Scanner(System.in);
                                animalId = myObj.nextLine();
                                System.out.println("Enter the disease:");
                                myObj = new Scanner(System.in);
                                String disease = myObj.nextLine();
                                System.out.println("Enter the description:");
                                myObj = new Scanner(System.in);
                                String description = myObj.nextLine();
//                                myJDBC.addAnimalProblem(animalId, disease, description);
                                break;
                            case "11":
                                System.out.println("Adding new History");
                                System.out.println("Enter the recordId:");
                                myObj = new Scanner(System.in);
                                String recordId = myObj.nextLine();
                                System.out.println("Enter the date:");
                                myObj = new Scanner(System.in);
                                date = myObj.nextLine();
                                System.out.println("Enter the measurement:");
                                myObj = new Scanner(System.in);
                                String measurement = myObj.nextLine();
                                System.out.println("Enter the value:");
                                myObj = new Scanner(System.in);
                                String value = myObj.nextLine();
                                System.out.println("Enter the userId:");
                                myObj = new Scanner(System.in);
                                userId = myObj.nextLine();
                                System.out.println("Enter the vaccination:");
                                myObj = new Scanner(System.in);
                                String vaccination = myObj.nextLine();
                                System.out.println("Enter the animalIdn:");
                                myObj = new Scanner(System.in);
                                animalId = myObj.nextLine();
//                                myJDBC.addAnimalHistory(recordId, date, measurement,
//                                        value, userId, vaccination, animalId);
                                break;
                            case "12":
                                System.out.println("Adding new photo");
                                System.out.println("Enter the recordId:");
                                myObj = new Scanner(System.in);
                                recordId = myObj.nextLine();
                                System.out.println("Enter the imageId:");
                                myObj = new Scanner(System.in);
                                String imageId = myObj.nextLine();
                                System.out.println("Enter the fileName:");
                                myObj = new Scanner(System.in);
                                String fileName = myObj.nextLine();
                                System.out.println("Enter the type:");
                                myObj = new Scanner(System.in);
                                String type = myObj.nextLine();
//                                myJDBC.addAnimalPhoto(recordId, imageId, fileName, type);
                                break;
                            case "13":
                                System.out.println("Adding new comment");
                                System.out.println("Enter the recordId:");
                                myObj = new Scanner(System.in);
                                recordId = myObj.nextLine();
                                System.out.println("Enter the commentId:");
                                myObj = new Scanner(System.in);
                                String commentId = myObj.nextLine();
                                System.out.println("Enter the description:");
                                myObj = new Scanner(System.in);
                                description = myObj.nextLine();
//                                myJDBC.addAnimalComment(recordId, commentId, description);
                                break;
                            case "14":
                                System.out.println("*** Selecting another Animal *** ");
                                endSelect = true;
                                break;
                        }
                    }
                    break;
                case "2":
                    for (Animal a : myDatabase.getAnimals()) {
                        System.out.println(a.getName() + ", has ID: " + a.getAnimalId());
                    }
                    break;
                case "3":
                    System.out.println("*** Exiting program *** ");
                    endApp = true;
                    break;
            }

        }
    }
}
