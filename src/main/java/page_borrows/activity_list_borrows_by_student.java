package page_borrows;

import DATABASE.Configs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import page_books.activity_book_by_genre;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class activity_list_borrows_by_student extends Configs implements Initializable {

    @FXML
    TableView<BorrowsModel> listTable;
    @FXML
    TableColumn<BorrowsModel, String> borrowId;
    @FXML
    TableColumn<BorrowsModel, String> studentId;
    @FXML
    TableColumn<BorrowsModel, String> bookId;
    @FXML
    TableColumn<BorrowsModel, String> takeDate;
    @FXML
    TableColumn<BorrowsModel, String> broughtDate;
    @FXML
    Button previousButton;

    public void initialize(URL location, ResourceBundle resourceBundle) {
        try {
            borrowId.setCellValueFactory(new PropertyValueFactory<>("borrowId"));
            studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
            bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
            takeDate.setCellValueFactory(new PropertyValueFactory<>("takeDate"));
            broughtDate.setCellValueFactory(new PropertyValueFactory<>("broughtDate"));

            listTable.setItems(getData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private ObservableList<BorrowsModel> getData() {
        ObservableList<BorrowsModel> borrowsModels = null;
        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            borrowsModels = FXCollections.observableArrayList();

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from borrows where student_id = " + activity_borrow_by_student.studentIdString);

            while (resultSet.next()) {

                borrowsModels.add( new BorrowsModel(resultSet.getString("borrow_id"), resultSet.getString("student_id"),
                        resultSet.getString("book_id"), resultSet.getString("take_date"),
                        resultSet.getString("brought_date")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrowsModels;
    }
    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_borrows/view_borrow_by_student.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}