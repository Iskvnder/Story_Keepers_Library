package page_books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class activity_book_by_genre {

    @FXML
    Button searchButton;
    @FXML
    TextField genreId;

    public static String genreIdString;
    @FXML
    Button previousButton;


    public void goSelect(ActionEvent actionEvent) throws IOException {
        genreIdString = genreId.getText();
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_list_of_book_by_genre.fxml")));
        Stage window = (Stage) searchButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }


    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_genres.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}