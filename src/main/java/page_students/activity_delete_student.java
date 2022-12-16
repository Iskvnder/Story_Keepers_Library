package page_students;

import DATABASE.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class activity_delete_student {
    @FXML
    Button deleteButton;
    @FXML
    TextField studentId;

    @FXML
    void initialize(){
        deleteButton.setOnAction(actionEvent -> {
            try {
                deleteButton(studentId.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void deleteButton(String studentId) throws SQLException, ClassNotFoundException {

        String insert = "DELETE FROM STUDENTS WHERE(student_id = "+ studentId + ")";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        PreparedStatement preparedStatement = databaseHandler.getDbConnection().prepareStatement(insert);

        preparedStatement.executeUpdate();

    }
}
