package page_students;


import DATABASE.Configs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static DATABASE.Configs.*;

public class activity_list_of_students extends Configs implements Initializable {

    @FXML
    TableView<StudentsModel> listTable;
    @FXML
    TableColumn<StudentsModel, String> studentId;
    @FXML
    TableColumn<StudentsModel, String> firstName;
    @FXML
    TableColumn<StudentsModel, String> secondName;
    @FXML
    TableColumn<StudentsModel, String> gender;
    @FXML
    TableColumn<StudentsModel, String> clas;
    @FXML
    TableColumn<StudentsModel, String> birthDate;


    public void initialize(URL location, ResourceBundle resourceBundle) {
        try {
            studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            secondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
            gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            clas.setCellValueFactory(new PropertyValueFactory<>("clas"));
            birthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));

            listTable.setItems(getData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private ObservableList<StudentsModel> getData() {
        ObservableList<StudentsModel> studentsModels = null;
        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            studentsModels = FXCollections.observableArrayList();

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");

            while (resultSet.next()) {

                studentsModels.add( new StudentsModel(resultSet.getString("student_id"), resultSet.getString("first_name"),
                        resultSet.getString("second_name"), resultSet.getString("gender"), resultSet.getString("class"),
                        resultSet.getString("birth_date")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsModels;
    }
}