package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
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

    public void loginButtonOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()){
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Please enter username and password");
        }
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
                } else {
                    loginMessageLabel.setText(("Invalid login"));
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
