package DATABASE;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException
    {
        String connectionString = "jdbc:mysql//" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }

    public void addStudent(String genre_id, String genre_name) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + GenreConst.genreTable + "(" + GenreConst.genreId + "," + GenreConst.genreName + ")" + " VALUES(4, Russian Literature) ";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, genre_id);
            prSt.setString(2, genre_name);
            prSt.executeUpdate();
        } catch (SQLException E){
            E.printStackTrace();
        }
    }
}