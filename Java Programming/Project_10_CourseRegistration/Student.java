import java.lang.annotation.Retention;
import java.util.ArrayList;

public class Student {

    private String studentName;
    private int studentId;
    private ArrayList<Registration> regList;    //list of course sections

    public Student(String studentName, int studentId) {
        setStudentName(studentName);
        setStudentId(studentId);
        setRegList(new ArrayList<Registration>());
    }

    public void registerForCourse(CourseCat cat, String courseName, int courseNum, int section) {
        Course myCourse = cat.searchCat(courseName, courseNum);
        //Now the student needs to make sure the section exists. and if it does, register!
        //A student registers by:
        //Creating a registration object
        //and calling the
        Offering theOffering = myCourse.getOfferingList().get(section - 1);//must fix this!!
        Registration reg = new Registration();
        reg.register(this, theOffering);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public ArrayList<Registration> getRegList() {
        return regList;
    }

    public void setRegList(ArrayList<Registration> regList) {
        this.regList = regList;
    }

    public void addRegistration(Registration registration) {
        // Handle course registration of maximum 6 courses
        if (regList.size() < 6) {
            regList.add(registration);
        } else
            System.out.println("***ERROR***\n You have already chosen 6 courses!\n");
    }

    public void removeReg(CourseCat cat, String coursename, int coursenumber, int sectionNumber) {
        Course theCourse = cat.searchCat(coursename, coursenumber);
        Offering offering = theCourse.getOfferingList().get(sectionNumber - 1);
        Registration match = compareReg(offering);
        if (offering != null && match != null) match.removeRegistration(this, offering);
    }

    public Registration compareReg(Offering theoffering) {
        ArrayList<Registration> offeringRegistration = theoffering.getStudentList();
        for (Registration registration : offeringRegistration) {
            if (registration.getTheStudent().equals(this)) return registration;
        }
        return null;
    }


    public void removeRegistration(Registration registration) {
        // TODO Auto-generated method stub
        regList.remove(registration);

    }

    @Override
    public String toString() {
        return studentName;
    }

}
