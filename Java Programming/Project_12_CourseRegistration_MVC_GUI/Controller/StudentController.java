package Controller;

import View.View;
import Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentController {
    View theView;
    Model theModel;

    public StudentController(View theView, Model theModel) {
        this.theModel = theModel;
        this.theView = theView;
        theView.addActionListener(new myListener());
    }

    class myListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            try {
                if (e.getSource() == theView.getTakeCourse())
                    theView.setOutput(theModel.takeCourse(theView.getInputCourseName().getText(), Integer.parseInt(theView.getInputCourseId().getText()), Integer.parseInt(theView.getInputCourseSection().getText())));
                if (e.getSource() == theView.getRemoveCourse())
                    theView.setOutput(theModel.removeCourse(theView.getInputCourseName().getText(), Integer.parseInt(theView.getInputCourseId().getText()), Integer.parseInt(theView.getInputCourseSection().getText())));
                if (e.getSource() == theView.getStudentRegisteredCourse())
                    theView.setOutput(theModel.registeredCourse());
                if (e.getSource() == theView.getClose()) System.exit(0);
            } catch (NumberFormatException ex) {
                System.out.println(ex.fillInStackTrace());
            }

        }

    }
}
