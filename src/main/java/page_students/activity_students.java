package page_students;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class activity_students {
    @FXML
    Button listOfStudents;
    @FXML
    Button deleteStudent;
    @FXML
    Button addStudent;
    @FXML
    Button mainButton;
    @FXML
    Button borrowsButton;
    @FXML
    Button booksButton;
    @FXML
    Button closeButton;

    private Stage stage;
    private Parent root;

    public void switchToMain(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_main/view_main.fxml")));

        Stage window = (Stage) mainButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void switchToBooks(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_books.fxml")));
        Stage window = (Stage) booksButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void switchToBorrows(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_borrows/view_borrows.fxml")));
        Stage window = (Stage) borrowsButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
    public void showListOfStudents(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_students/view_list_of_students.fxml")));
        Stage window = (Stage) borrowsButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void showAddStudent(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_students/view_add_student.fxml")));
        Stage window = (Stage) borrowsButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void showDeleteStudent(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_students/view_delete_student.fxml")));
        Stage window = (Stage) borrowsButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void close(ActionEvent actionEvent) throws IOException {
        Platform.exit();
    }
}
