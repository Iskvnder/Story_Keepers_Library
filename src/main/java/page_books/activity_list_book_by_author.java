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
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class activity_list_book_by_author extends Configs implements Initializable {

    @FXML
    TableView<BooksModel> listTableBooks;
    @FXML
    TableColumn<BooksModel, String> bookId;
    @FXML
    TableColumn<BooksModel, String> quantity;
    @FXML
    TableColumn<BooksModel, String> bookName;
    @FXML
    TableColumn<BooksModel, String> pageCount;
    @FXML
    TableColumn<BooksModel, String> authorId;
    @FXML
    TableColumn<BooksModel, String> genreId;
    @FXML
    TableColumn<BooksModel, String> bookDescription;
    @FXML
    Button previousButton;

    public void initialize(URL location, ResourceBundle resourceBundle) {
        try {
            bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
            quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
            pageCount.setCellValueFactory(new PropertyValueFactory<>("pageCount"));
            authorId.setCellValueFactory(new PropertyValueFactory<>("authorId"));
            genreId.setCellValueFactory(new PropertyValueFactory<>("genreId"));
            bookDescription.setCellValueFactory(new PropertyValueFactory<>("bookDescription"));

            listTableBooks.setItems(getData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private ObservableList<BooksModel> getData() {

        ObservableList<BooksModel> BooksModel = null;
        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            BooksModel = FXCollections.observableArrayList();

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery ("select * from books where author_id = " + activity_book_by_author.authorIdString);

            while (resultSet.next()) {
                BooksModel.add( new BooksModel(resultSet.getString("book_id"), resultSet.getString("quantity"),
                        resultSet.getString("book_name"), resultSet.getString("page_count"), resultSet.getString("author_id"),
                        resultSet.getString("genre_id"), resultSet.getString("book_description")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BooksModel;
    }

    public void switchPage(ActionEvent actionEvent) throws IOException {
        Parent root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/page_books/view_book_by_author.fxml")));
        Stage window = (Stage) previousButton.getScene().getWindow() ;
        window.setScene(new Scene(root, 1920, 1080));
    }
}
