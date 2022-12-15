package DATABASE.DateFrom;

import DATABASE.Configs;

import java.sql.*;

public class DateFromBorrows extends Configs {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from borrows");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("borrow_id"));
                System.out.println(resultSet.getString("student_id"));
                System.out.println(resultSet.getString("book_id"));
                System.out.println(resultSet.getString("take_date"));
                System.out.println(resultSet.getString("brought_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
