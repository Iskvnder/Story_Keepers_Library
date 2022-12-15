package page_borrows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class activity_borrows_second {

    @FXML
    Button mainButton;
    @FXML
    Button booksButton;
    @FXML
    Button studentsButton;

    @FXML
    Button previousButton;

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

    public void switchToStudents(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_students/view_students.fxml")));
        Stage window = (Stage) studentsButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_borrows/view_borrows.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}
