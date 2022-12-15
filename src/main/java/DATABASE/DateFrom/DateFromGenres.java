package DATABASE.DateFrom;

import DATABASE.Configs;

import java.sql.*;

public class DateFromGenres extends Configs {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from genres");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("genre_id"));
                System.out.println(resultSet.getString("genre_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
