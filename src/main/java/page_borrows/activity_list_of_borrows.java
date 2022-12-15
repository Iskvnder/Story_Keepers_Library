package page_borrows;

import DATABASE.Configs;
import DATABASE.borrowsConst;
import com.mysql.cj.xdevapi.Column;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class activity_list_of_borrows extends Configs {
//    @FXML
//    private Column idBorrowColumn;
//    @FXML
//    private Column idStudentColumn;
//    @FXML
//    private Column idBookColumn;
//    @FXML
//    private Column takeDateColumn;
//    @FXML
//    private Column endDateColumn;
//    @FXML
//    private TableView<borrowsConst> showListTableView;
//
//    public void initialize(URL location, ResourceBundle resourceBundle){
//
//    }
//    @FXML
//    void showList() throws SQLException, ClassNotFoundException {
//
//        try {
//            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from borrows");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("take_date"));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//     }
//
//     public void showListTest(ActionEvent actionEvent){
//         borrowsConst borrowsConst = new borrowsConst("2","5", "3", "01-01-2001", "02-02-2002");
//        showListTableView.getItems().add(borrowsConst);
//     }
}
