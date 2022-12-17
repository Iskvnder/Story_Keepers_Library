package page_borrows;


import DATABASE.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class activity_borrow_by_student {

    @FXML
    Button searchButton;
    @FXML
    TextField studentId;

    public static String studentIdString;
    @FXML
    Button previousButton;


    public void goSelect(ActionEvent actionEvent) throws IOException {
        studentIdString = studentId.getText();
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_borrows/view_list_of_borrow_by_student.fxml")));
        Stage window = (Stage) searchButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }


    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_borrows/view_borrows.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}
