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

public class activity_list_of_genres extends Configs implements Initializable {

    @FXML
    TableView<GenreModel> listTableGenres;
    @FXML
    TableColumn<GenreModel, String> genreId;
    @FXML
    TableColumn<GenreModel, String> genreName;
    @FXML
    Button previousButton;


    public void initialize(URL location, ResourceBundle resourceBundle) {
        try {
            genreId.setCellValueFactory(new PropertyValueFactory<>("genreId"));
            genreName.setCellValueFactory(new PropertyValueFactory<>("genreName"));

            listTableGenres.setItems(getData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private ObservableList<GenreModel> getData() {
        ObservableList<GenreModel> GenreModel = null;
        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            GenreModel = FXCollections.observableArrayList();

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from genres");

            while (resultSet.next()) {

                GenreModel.add( new GenreModel(resultSet.getString("genre_id"), resultSet.getString("genre_name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GenreModel;
    }

    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_genres.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}