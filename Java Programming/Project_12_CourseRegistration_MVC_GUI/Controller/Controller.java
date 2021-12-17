package Controller;

import View.View;
import Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {
    View theView;
    Model theModel;

    public Controller(View theView, Model theModel) {
        this.theModel = theModel;
        this.theView = theView;
        theView.addActionListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            try {
                if (e.getSource() == theView.getEnter()) theModel.login(theView.getEnteredName().getText());
                if (e.getSource() == theView.getReset()) theView.setEnterName();
                if (e.getSource() == theView.getAllCourseCat()) theView.setOutput(theModel.allCourses());
                if (e.getSource() == theView.getSearchCatalogue())
                    theView.setOutput(theModel.searchCourse(theView.getInputCourseName().getText(), Integer.parseInt(theView.getInputCourseId().getText())));
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
