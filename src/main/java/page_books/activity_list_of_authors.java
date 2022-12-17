package page_books;

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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class activity_list_of_authors extends Configs implements Initializable {

    @FXML
    TableView<AuthorModel> listTableAuthors;
    @FXML
    TableColumn<AuthorModel, String> authorId;
    @FXML
    TableColumn<AuthorModel, String> firstName;
    @FXML
    TableColumn<AuthorModel, String> secondName;
    @FXML
    Button previousButton;

    public void initialize(URL location, ResourceBundle resourceBundle) {
        try {
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            secondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
            authorId.setCellValueFactory(new PropertyValueFactory<>("authorId"));

            listTableAuthors.setItems(getData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ObservableList<AuthorModel> getData() {
        ObservableList<AuthorModel> AuthorModel = null;
        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            AuthorModel = FXCollections.observableArrayList();

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from authors");

            while (resultSet.next()) {

                AuthorModel.add( new AuthorModel(resultSet.getString("author_id"), resultSet.getString("first_name"),
                        resultSet.getString("second_name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AuthorModel;
    }
    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_authors.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}
