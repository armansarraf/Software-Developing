
import java.util.ArrayList;

public class CourseCat {

    private ArrayList<Course> courseList;

    public CourseCat() {
        courseList = loadFromDB();
    }

    private static ArrayList<Course> loadFromDB() {
        //In real life course would be loaded for the database or at least some sort of file
        //on disk.

        //So imagine this is being loaded from the database!

        ArrayList<Course> imaginaryDB = new ArrayList<Course>();

        imaginaryDB.add(new Course("ENGG", 233));
        imaginaryDB.add(new Course("ENGG", 220));
        imaginaryDB.add(new Course("ENSF", 607));
        imaginaryDB.add(new Course("ENSF", 608));
        imaginaryDB.add(new Course("ENSF", 609));
        imaginaryDB.add(new Course("ENSF", 611));
        imaginaryDB.add(new Course("PHYS", 259));
        imaginaryDB.add(new Course("PHYS", 245));
        imaginaryDB.add(new Course("PHYS", 219));

        return imaginaryDB;
    }

    public ArrayList<Course> searchCat(String courseName) {
        ArrayList<Course> foundCourses = new ArrayList<Course>();
        //search for courses that their name matches courseName and add to the
        //foundCourses array
        for (Course c : courseList) {
            if (c.getCourseName().equals(courseName)) {
                foundCourses.add(new Course(c.getCourseName(), c.getCourseNum()));
                return foundCourses;
            }
        }
        System.err.println("Course " + courseName + " does NOT exist!");
        return null;
    }

    public Course searchCat(String courseName, int courseNum) {
        for (Course c : courseList) {
            if (c.getCourseNum() == courseNum && c.getCourseName().equals(courseName)) {
                return c;
            }
        }
        System.err.println("Course " + courseName + " " + courseNum + " does NOT exist!");
        return null;
    }

    public void createOffering(Course theCourse, int secNum, int secCap) {
        if (theCourse != null) {
            Offering theOffering = new Offering(secNum, secCap);
            theOffering.setTheCourse(theCourse);   //I set theCourse object reference in the Course
            theCourse.addOffering(theOffering);

        }
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

}
