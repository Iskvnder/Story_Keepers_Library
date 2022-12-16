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

public class activity_add_book {
    @FXML
    Button addButton;
    @FXML
    TextField bookId;
    @FXML
    TextField quantity;
    @FXML
    TextField bookName;
    @FXML
    TextField pageCount;
    @FXML
    TextField authorId;
    @FXML
    TextField genreId;
    @FXML
    TextField bookDescription;
    @FXML
    Button previousButton;

    @FXML
    void initialize(){
        addButton.setOnAction(actionEvent -> {
            try {
                addStudent(bookId.getText(), quantity.getText(), bookName.getText(), pageCount.getText(),authorId.getText(),genreId.getText(), bookDescription.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void addStudent(String bookId, String quantity, String bookName,
                           String pageCount, String authorId, String genreId, String bookDescription) throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO books(book_id, quantity, book_name, page_count, author_id, genre_id, book_description) VALUES (?,?,?,?,?,?,?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        PreparedStatement preparedStatement = databaseHandler.getDbConnection().prepareStatement(insert);

        preparedStatement.setString(1, bookId);
        preparedStatement.setString(2, quantity);
        preparedStatement.setString(3, bookName);
        preparedStatement.setString(4, pageCount);
        preparedStatement.setString(5, authorId);
        preparedStatement.setString(6, genreId);
        preparedStatement.setString(7, bookDescription);

        preparedStatement.executeUpdate();

    }

    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_books_second.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}
