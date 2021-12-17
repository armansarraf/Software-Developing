package Controller;

import Model.Model;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseCatController {
    View theView;
    Model theModel;

    public CourseCatController(View theView, Model theModel) {
        this.theModel = theModel;
        this.theView = theView;
        theView.addActionListener(new myListener());
    }

    class myListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

            try {
                if (e.getSource() == theView.getAllCourseCat()) theView.setOutput(theModel.allCourses());
                if (e.getSource() == theView.getSearchCatalogue())
                    theView.setOutput(theModel.searchCourse(theView.getInputCourseName().getText(), Integer.parseInt(theView.getInputCourseId().getText())));

            } catch (NumberFormatException ex) {
                System.out.println(ex.fillInStackTrace());
            }
        }
    }
}