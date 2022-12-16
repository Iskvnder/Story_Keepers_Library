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

public class activity_delete_borrow {
    @FXML
    Button deleteButton;
    @FXML
    TextField borrowId;
    @FXML
    Button previousButton;

    @FXML
    void initialize(){
        deleteButton.setOnAction(actionEvent -> {
            try {
                deleteButton(borrowId.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void deleteButton(String borrowId) throws SQLException, ClassNotFoundException {

        String insert = "DELETE FROM BORROWS WHERE(book_id = "+ borrowId + ")";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        PreparedStatement preparedStatement = databaseHandler.getDbConnection().prepareStatement(insert);

        preparedStatement.executeUpdate();

    }

    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_borrows/view_borrows_second.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}