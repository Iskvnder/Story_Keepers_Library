package page_books;

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

public class activity_authors {
    @FXML
    Button authorListButton;
    @FXML
    Button mainButton;

    @FXML
    Button previousButton;
    @FXML
    Button studentsButton;
    @FXML
    Button borrowsButton;
    @FXML
    Button closeButton;
    @FXML
    Button bookByAuthorButton;

    private Stage stage;
    private Parent root;

    public void switchToMain(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_main/view_main.fxml")));

        Stage window = (Stage) mainButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void switchToStudents(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_students/view_students.fxml")));
        Stage window = (Stage) studentsButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void switchToBorrows(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_borrows/view_borrows.fxml")));
        Stage window = (Stage) borrowsButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void showListOfAuthors(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_list_of_authors.fxml")));
        Stage window = (Stage) authorListButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_books.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void showListByAuthor(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_book_by_author.fxml")));
        Stage window = (Stage) bookByAuthorButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }

    public void close(ActionEvent actionEvent) throws IOException {
        Platform.exit();
    }
}
