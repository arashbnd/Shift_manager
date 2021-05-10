package sample;

import java.time.YearMonth;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        LoginController log = new LoginController();
//        log.createAccountForm();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

         primaryStage.initStyle(StageStyle.UNDECORATED);
         primaryStage.setScene(new Scene(root, 520, 400));

        // the calendar
//         primaryStage.setTitle("Full Calendar Example");
//         primaryStage.setScene(new Scene(new FullCalendarView(YearMonth.now()).getView()));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
