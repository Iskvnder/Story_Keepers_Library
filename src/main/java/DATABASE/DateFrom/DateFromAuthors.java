package DATABASE.DateFrom;

import DATABASE.Configs;

import java.sql.*;

public class DateFromAuthors extends Configs {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from authors");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("author_id"));
                System.out.println(resultSet.getString("first_name"));
                System.out.println(resultSet.getString("second_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
