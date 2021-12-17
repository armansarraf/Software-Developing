import java.util.Scanner;

//This is my "FrontEnd!"
public class CourseRegApp {

    public static void main(String[] args) {

        int studentId = 0;
        CourseCat cat = new CourseCat();  //This loads the courses from our "DB"
        Student st1 = new Student("Sara", studentId++);
        Student st2 = new Student("Joe", studentId++);

        // Adding some offering to existing courses
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

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        String courseName;
        int courseNumber;
        String studentName;

        // Console-Based interface
        System.out.println("****** Welcome to Course Registration ******\n");
        System.out.println("Please enter your name: ");
        studentName = scanner.next();
        Student newStudent = new Student(studentName, studentId++);

        while (option != 6) {

            // User choose one option from the list below
            System.out.println("Please enter '1' to search for catalogue courses: \n" +
                    "Please enter '2' to take a course: \n" +
                    "Please enter '3' to remove a course from your list: \n" +
                    "Please enter '4' to view all courses in catalogue list: \n" +
                    "Please enter '5' to to see your registered courses: \n" +
                    "Please enter '6' to Quit!\n");
            option = scanner.nextInt();

            switch (option) {

                // Search for catalogue courses
                case 1:
                    System.out.println("***** Search Catalogue Menu *****\n");
                    System.out.println("Please enter the desired course name (eg. ENSF): ");
                    courseName = scanner.next();
                    System.out.println("Please enter the desired course number (eg. 607): ");
                    courseNumber = scanner.nextInt();
                    System.out.println(cat.searchCat(courseName, courseNumber) + "\n");
                    break;

                // Take a course
                case 2:
                    System.out.println("***** Course Enroll Menu *****\n");
                    System.out.println("Please enter the course name you want to take (eg. ENGG): ");
                    courseName = scanner.next();
                    System.out.println("Please enter the course number you want to take (eg. 233): ");
                    courseNumber = scanner.nextInt();
                    System.out.println("Please enter section number (eg. 1):  ");
                    int secNum = scanner.nextInt();
                    newStudent.registerForCourse(cat, courseName, courseNumber, secNum);
                    System.out.println("You have successfully registered!\n");
                    break;

                // Remove a course
                case 3:
                    System.out.println("***** Course Remove Menu *****\n");
                    System.out.println("Please enter the course name you want to remove (eg. ENGG): ");
                    courseName = scanner.next();
                    System.out.println("Please enter the course number you want to remove (eg. 233): ");
                    courseNumber = scanner.nextInt();
                    System.out.println("Please enter section number (eg. 1):  ");
                    int secNum1 = scanner.nextInt();
                    newStudent.removeReg(cat, courseName, courseNumber, secNum1);
                    System.out.println("You have successfully removed " + courseName + "\n");
                    break;

                // View all courses in catalogue list
                case 4:
                    System.out.println("***** Course List Menu *****\n");
                    System.out.println(cat.getCourseList());
                    break;

                // Student's registered course
                case 5:
                    System.out.println("***** Student CourseList Menu *****\n");

                    if (newStudent.getRegList().isEmpty()) {
                        System.out.println("You have not registered for any course yet!\n");
                        break;
                    } else
                        System.out.println("You have successfully registered in:\nCourseName | Course Number | Section");
                    for (int i = 0; i < newStudent.getRegList().size(); i++) {
                        System.out.print(newStudent.getRegList().get(i).getTheOffering().getTheCourse().getCourseName() + "\t\t\t");
                        System.out.print(newStudent.getRegList().get(i).getTheOffering().getTheCourse().getCourseNum() + "\t\t\t\t");
                        System.out.println((newStudent.getRegList().get(i).getTheOffering().getSectionNum()) + "\n");
                    }
                    break;
            }
        }
    }
}
