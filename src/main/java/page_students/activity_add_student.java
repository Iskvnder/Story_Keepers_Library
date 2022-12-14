package page_students;

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

public class activity_add_student  {
    @FXML
    Button addButton;
    @FXML
    TextField studentId;
    @FXML
    TextField studentName;
    @FXML
    TextField studentSurname;
    @FXML
    TextField studentGender;
    @FXML
    TextField studentClas;
    @FXML
    TextField studentBirthDate;
    @FXML
    Button previousButton;

    @FXML
    void initialize(){
        addButton.setOnAction(actionEvent -> {
            try {
                addStudent(studentId.getText(), studentName.getText(), studentSurname.getText(), studentGender.getText(),studentClas.getText(),studentBirthDate.getText());
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void addStudent(String studentId, String studentName, String studentSurname,
                           String studentGender, String studentClas, String studentBirthDate) throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO STUDENTS(student_id, first_name, second_name, gender, class, birth_date) VALUES (?,?,?,?,?,?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        PreparedStatement preparedStatement = databaseHandler.getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, studentName);
            preparedStatement.setString(3, studentSurname);
            preparedStatement.setString(4, studentGender);
            preparedStatement.setString(5, studentClas);
            preparedStatement.setString(6, studentBirthDate);

            preparedStatement.executeUpdate();

    }

    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_students/view_students.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}