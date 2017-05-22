package lesson14.Task0_Sakila;

import java.sql.*;

/**
 * Created by aizeeck on 22.05.17.
 */
public class FilmDAO {
    private MySQLCredential mySQLCredential;

    public FilmDAO(MySQLCredential credential) throws SQLException {
        this.mySQLCredential = credential;
    }

    public int getFilmIdByName(String filmName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());
             PreparedStatement statement = connection.prepareStatement("SELECT film_id FROM film WHERE title=?");) {
            statement.setString(1, filmName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("film_id");
        }
    }
}
