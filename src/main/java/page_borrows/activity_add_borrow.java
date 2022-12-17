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

public class activity_add_borrow {

    @FXML
    Button addButton;
    @FXML
    TextField borrowId;
    @FXML
    TextField studentId;
    @FXML
    TextField bookId;
    @FXML
    TextField takeDate;
    @FXML
    TextField broughtDate;
    @FXML
    Button previousButton;

    @FXML
    void initialize(){
        addButton.setOnAction(actionEvent -> {
            try {
                addStudent(studentId.getText(), borrowId.getText(), bookId.getText(), takeDate.getText(),broughtDate.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void addStudent(String borrowId, String studentId, String bookId,
                           String takeDate, String broughtDate) throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO borrows(borrow_id, student_id, book_id, take_date, brought_date) VALUES (?,?,?,?,?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        PreparedStatement preparedStatement = databaseHandler.getDbConnection().prepareStatement(insert);

        preparedStatement.setString(1, borrowId);
        preparedStatement.setString(2, studentId);
        preparedStatement.setString(3, bookId);
        preparedStatement.setString(4, takeDate);
        preparedStatement.setString(5, broughtDate);

        preparedStatement.executeUpdate();

    }

    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_borrows/view_borrows_second.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}