import Controller.*;
import Model.Model;
import View.View;

public class App {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        StudentController studentController = new StudentController(view, model);
        LoginController loginController = new LoginController(view,model);
        CourseCatController courseCatController = new CourseCatController(view,model);
    }

}
