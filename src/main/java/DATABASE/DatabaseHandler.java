package DATABASE;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" +dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }

    public void showListOfBorrows
            (String borrowId, String studentId, String bookId, String takeDate, String broughtDate)
            throws SQLException, ClassNotFoundException {
        //SELECT * FROM BORROWS;
        String selectAll = "SELECT * FROM " + borrowsConst.borrowsTable;

        PreparedStatement ListOfBorrowsPrst = getDbConnection().prepareStatement(selectAll);
        ResultSet resultSet = ListOfBorrowsPrst.executeQuery();
        if(resultSet.next()){
            System.out.println("borrow_id");
        }

    }

}
