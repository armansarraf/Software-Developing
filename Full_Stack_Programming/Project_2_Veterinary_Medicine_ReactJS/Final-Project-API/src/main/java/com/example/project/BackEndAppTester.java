// package com.example.project;

// import com.example.project.model.*;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.*;
// import java.util.Scanner;

// /**
// * Test backend functionalities of User, Animal, and Databases
// *
// * @author Arman Hosseinsarraf
// */
// public class BackEndAppTester {

// public static void main(String[] args) throws SQLException {
// //This area is to test the various backend functionality.

// // Username and password of an existing user in DB
// int username = 5;
// int password = 7788;
// LoginChecker checker = new LoginChecker(username, password); // create an
// object of loginChecker with the username and password

// User user = null;
// checker.checkUsernamePassword(); // Checks to see if the information exist in
// the database
// if (checker.checkUsernamePassword()) {
// user = new User(username, password); // if yes, a new user object will be
// created

// // If the permission of the user is Admin, then create admin instance and
// checks their functions
// if (user.getPermission().equals("Admin")) {
// Admin admin = new Admin(user);

// // admin.editUser(new User(10, 8080), "Lname", "aaaa");

// // admin.blockUser(new User(2, 1212));
// // admin.printUsers();
// // admin.printAnimal();
// //
// System.out.println("--------------------------------------------------------------------------");
// // admin.addNewUser("Active", "7777", "Sarraf", "Arman",
// "40304114587","abc.ucalgary.ca", "m", "1995-12-03", "2016-11-11", "Admin");
// // admin.printUsers();
// }

// // If the permission of the user is Teacher, then create teacher instance and
// check their functions
// if (user.getPermission().equals("Teacher")) {
// TeachingTechnician teachingTechnician = new TeachingTechnician(user);
// // teachingTechnician.printUsers();
// //
// System.out.println("--------------------------------------------------------------------------");
// // teachingTechnician.blockStudent(new User(9, 3020));
// // teachingTechnician.printUsers();
// // System.out.println(teachingTechnician.searchAnimalByName("Ginger"));
// // System.out.println(teachingTechnician.searchAnimalByID(1));
// // System.out.println(teachingTechnician.searchAnimalByID(2));
// // teachingTechnician.requestAnimal(2);
// // System.out.println(teachingTechnician.searchAnimalByID(2));
// // teachingTechnician.addComment("9", "Survived");

// }

// // If the permission of the user is Student, then create student instance and
// check their functions
// if (user.getPermission().equals("Student")) {
// Student student = new Student(user);
// // student.addComment("8", "Survived");
// }

// // If the permission of the user is Health Technician, then create health
// technician instance and check their functions
// if (user.getPermission().equals("Health")) {
// HealthTechnician healthTechnician = new HealthTechnician(user);
// // healthTechnician.changeAnimalStatus(1, "AAAA");

// // healthTechnician.printAnimal();
// // healthTechnician.prescribeForAnimal( "4", "Rutin", "Oral", "456325",
// "2021-12-08", "20", "Give to the animal once a day with food", "To reduce
// pain", "101");
// // healthTechnician.showPrescribe(1);
// }

// // If the permission of the user is Care Attendant, then create care
// attendant instance and check their functions
// if (user.getPermission().equals("Care")) {
// CareAttendant careAttendant = new CareAttendant(user);
// // careAttendant.uploadPhoto("10", "Image1", "jpeg");
// // careAttendant.requestTreatment(1);
// // careAttendant.changeAnimalStatus(1, "Healed");
// // careAttendant.alertDiseaseProblem("1", "Blood", "Bondage");
// }
// }
// }
// }