package DATABASE;

import java.sql.*;

public class DateFromStudents extends Configs{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from students");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("student_id"));
                System.out.println(resultSet.getString("first_name"));
                System.out.println(resultSet.getString("second_name"));
                System.out.println(resultSet.getString("gender"));
                System.out.println(resultSet.getString("class"));
                System.out.println(resultSet.getString("birth_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
