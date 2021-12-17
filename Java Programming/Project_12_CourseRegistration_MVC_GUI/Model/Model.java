package Model;

import java.util.Scanner;

public class Model {
    CourseCat cat = new CourseCat();  //This loads the courses from our "DB"
    Student newStudent;
    int studentId = 0;

    public void login(String name) {
        newStudent = new Student(name, studentId++);
    }
    // View all courses in catalogue list

    public Model() {


        Student st1 = new Student("Sara", studentId++);
        Student st2 = new Student("Joe", studentId++);

        Course engg1 = cat.searchCat("ENGG", 233);
        if (engg1 != null) {
            cat.createOffering(engg1, 1, 45);
            cat.createOffering(engg1, 2, 50);
        }

        Course engg2 = cat.searchCat("ENGG", 220);
        if (engg2 != null) {
            cat.createOffering(engg2, 1, 20);
            cat.createOffering(engg2, 2, 30);
        }

        Course ensf = cat.searchCat("ENSF", 607);
        if (ensf != null) {
            cat.createOffering(ensf, 1, 100);
            cat.createOffering(ensf, 2, 100);
        }
        Course ensf_608 = cat.searchCat("ENSF", 608);
        if (ensf_608 != null) {
            cat.createOffering(ensf_608, 1, 120);
        }
        Course ensf_609 = cat.searchCat("ENSF", 609);
        if (ensf_609 != null) {
            cat.createOffering(ensf_609, 1, 200);
            cat.createOffering(ensf_609, 2, 150);
        }
        Course ensf_611 = cat.searchCat("ENSF", 611);
        if (ensf != null) {
            cat.createOffering(ensf_611, 1, 150);
        }

        Course phys = cat.searchCat("PHYS", 259);
        if (phys != null) {
            cat.createOffering(phys, 1, 60);
            cat.createOffering(phys, 2, 55);
        }

        // Registering two students manually to some courses
        st1.registerForCourse(cat, "ENSF", 608, 1);
        st1.registerForCourse(cat, "ENSF", 609, 2);
        st1.registerForCourse(cat, "ENSF", 611, 1);

        st2.registerForCourse(cat, "ENGG", 233, 2);
        st2.registerForCourse(cat, "ENSF", 611, 1);
        st2.registerForCourse(cat, "PHYS", 259, 2);
    }

    public String allCourses() {
        return "***** Course List Menu *****\n" + cat.getCourseList();
    }

    public String searchCourse(String name, int id) {
        return cat.searchCat(name, id) + "\n";
    }

    public String takeCourse(String courseName, int courseNumber, int secNum) {
        newStudent.registerForCourse(cat, courseName, courseNumber, secNum);
        return "You have successfully registered for " + courseName + " with course ID " + courseNumber + " in section " + secNum;
    }

    public String removeCourse(String courseName, int courseNumber, int secNum) {
        newStudent.removeReg(cat, courseName, courseNumber, secNum);
        return "You have successfully removed " + courseName + " with course ID " + courseNumber + " in section " + secNum;
    }

    public String registeredCourse() {
        if (newStudent.getRegList().isEmpty()) return ("You have not registered for any course yet!");
        String course = "Course Name\tCourse Number   Course Section\n";

        for (int i = 0; i < newStudent.getRegList().size(); i++) {
            course += newStudent.getRegList().get(i).getTheOffering().getTheCourse().getCourseName() + "\t ";
            course += newStudent.getRegList().get(i).getTheOffering().getTheCourse().getCourseNum() + "\t    ";
            course += newStudent.getRegList().get(i).getTheOffering().getSectionNum() + "\n";
        }
        return course;
    }

}
