package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.time.YearMonth;
import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.Connection;

public class LoginController {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Button signupButton;


    public void loginButtonOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()){
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }



    public void signupButtonOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        createAccountForm();
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() throws SQLException, ClassNotFoundException {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verifyLogin = "SELECT count(1) FROM users WHERE username = '" + usernameTextField.getText() +
                "' AND password = '" + enterPasswordField.getText() +"'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if (queryResult.getInt(1)==1) {
                    loginMessageLabel.setText("Congrats");
                    //createAccountForm(); replace this with something that takes you to calendar view
                    viewCalendar();
                } else {
                    loginMessageLabel.setText(("Invalid login"));
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccountForm(){
        try{
            System.out.println("You reached account form");
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 520, 443));
            registerStage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void viewCalendar(){
        try{
            System.out.println("You reached the calendar");
            Parent root = FXMLLoader.load(getClass().getResource("fullCalendar.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(new FullCalendarView(YearMonth.now()).getView()));
            registerStage.show();

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }



}
