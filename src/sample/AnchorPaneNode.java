package sample;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;

/**
 * Create an anchor pane that can store additional data.
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;
    private String position;

    /**
     * Create a anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    public AnchorPaneNode(Node...children) {
        super(children);

        // make a login object that gets the usernameTextfield
        this.setOnMouseClicked(e -> System.out.println("This pane's date is: " + date));

        // r-> object(LoginController.showSchedule)
//        LoginController LC = new LoginController();
//        this.setOnMouseClicked(e -> {
//            try {
//
//                LC.loadUserWindow(); // this is all it's doing
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            } catch (ClassNotFoundException classNotFoundException) {
//                classNotFoundException.printStackTrace();
//            }
//        });

    }




    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
