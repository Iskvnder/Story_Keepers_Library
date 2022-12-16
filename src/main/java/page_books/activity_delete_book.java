package page_books;

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

public class activity_delete_book {
    @FXML
    Button deleteButton;
    @FXML
    TextField bookId;
    @FXML
    Button previousButton;

    @FXML
    void initialize(){
        deleteButton.setOnAction(actionEvent -> {
            try {
                deleteButton(bookId.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void deleteButton(String bookId) throws SQLException, ClassNotFoundException {

        String insert = "DELETE FROM BOOKS WHERE(book_id = "+ bookId + ")";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        PreparedStatement preparedStatement = databaseHandler.getDbConnection().prepareStatement(insert);

        preparedStatement.executeUpdate();

    }

    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_books_second.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}
