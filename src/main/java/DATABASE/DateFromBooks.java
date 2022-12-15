package DATABASE;

import java.sql.*;

public class DateFromBooks extends Configs{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from books");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("book_id"));
                System.out.println(resultSet.getString("quantity"));
                System.out.println(resultSet.getString("book_name"));
                System.out.println(resultSet.getString("page_count"));
                System.out.println(resultSet.getString("author_id"));
                System.out.println(resultSet.getString("genre_id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
