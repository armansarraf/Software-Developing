package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame {

    JLabel enterName = new JLabel("For Login Please Enter Your Name");
    JLabel courseName = new JLabel("Course Name");
    JLabel courseId = new JLabel("Course ID");
    JLabel courseSection = new JLabel("Course section");
    JTextField enteredName = new JTextField(10);
    JTextField inputCourseName = new JTextField(10);
    JTextField inputCourseId = new JTextField(10);
    JTextField inputCourseSection = new JTextField(10);
    JTextArea output = new JTextArea();
    JButton login = new JButton("Login");
    JButton logout = new JButton("Logout");
    JButton searchCatalogue = new JButton("Search Course");
    JButton takeCourse = new JButton("Take Course");
    JButton removeCourse = new JButton("Remove Course");
    JButton allCourseCat = new JButton("See Course Catalogue");
    JButton studentRegisteredCourse = new JButton("See Registered courses");
    JButton close = new JButton("CLOSE");
    JScrollPane scrollPane;


    public View() {

        setSize(700, 400);
        setResizable(false);
        setTitle("Course Registration");
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        output.setBounds(200, 40, 400, 300);
        output.setBorder(new LineBorder(Color.BLACK));
        output.setEditable(false);

        scrollPane.setBounds(200, 40, 410, 300);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.getViewport().add(output);

        allCourseCat.setBounds(5, 40, 180, 30);
        searchCatalogue.setBounds(5, 72, 180, 30);
        takeCourse.setBounds(5, 104, 180, 30);
        removeCourse.setBounds(5, 136, 180, 30);
        studentRegisteredCourse.setBounds(5, 168, 180, 30);
        close.setBounds(5, 200, 180, 30);
        enterName.setBounds(8, 5, 200, 30);
        output.setBounds(200, 40, 410, 300);
        enteredName.setBounds(220, 10, 150, 20);
        login.setBounds(380, 10, 80, 20);
        logout.setBounds(470, 10, 80, 20);
        courseName.setBounds(5, 270, 100, 20);
        courseId.setBounds(5, 295, 100, 20);
        courseSection.setBounds(5, 320, 100, 20);
        inputCourseName.setBounds(107, 270, 80, 20);
        inputCourseId.setBounds(107, 297, 80, 20);
        inputCourseSection.setBounds(107, 321, 80, 20);

        add(scrollPane);
        add(logout);
        add(login);
        add(enteredName);
        add(output);
        add(allCourseCat);
        add(enterName);
        add(studentRegisteredCourse);
        add(removeCourse);
        add(takeCourse);
        add(searchCatalogue);
        add(courseName);
        add(courseId);
        add(inputCourseName);
        add(inputCourseId);
        add(courseSection);
        add(inputCourseSection);
        add(close);

        repaint();
        setVisible(true);
    }

    public JButton getEnter() {
        return login;
    }

    public JButton getReset() {
        return logout;
    }

    public JButton getAllCourseCat() {
        return allCourseCat;
    }

    public JButton getTakeCourse() {
        return takeCourse;
    }

    public JButton getSearchCatalogue() {
        return searchCatalogue;
    }

    public JButton getRemoveCourse() {
        return removeCourse;
    }

    public JButton getStudentRegisteredCourse() {
        return studentRegisteredCourse;
    }

    public JButton getClose() {
        return close;
    }

    public JTextField getEnteredName() {
        return enteredName;
    }

    public JTextField getInputCourseName() {
        return inputCourseName;
    }

    public JTextField getInputCourseId() {
        return inputCourseId;
    }

    public JTextField getInputCourseSection() {
        return inputCourseSection;
    }

    public void setEnterName() {
        enteredName.setText("");
    }

    public void setOutput(String result) {
        output.setText(result);
        scrollPane.getViewport().setView(output);
    }

    public void addActionListener(ActionListener listenForCalculateButton) {
        login.addActionListener(listenForCalculateButton);
        logout.addActionListener(listenForCalculateButton);
        allCourseCat.addActionListener(listenForCalculateButton);
        searchCatalogue.addActionListener(listenForCalculateButton);
        takeCourse.addActionListener(listenForCalculateButton);
        removeCourse.addActionListener(listenForCalculateButton);
        studentRegisteredCourse.addActionListener(listenForCalculateButton);
        close.addActionListener(listenForCalculateButton);

    }
}
