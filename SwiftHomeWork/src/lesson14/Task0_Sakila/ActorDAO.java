package lesson14.Task0_Sakila;

import java.sql.*;

/**
 * Created by aizeeck on 22.05.17.
 */
public class ActorDAO {
    private MySQLCredential mySQLCredential;

    public ActorDAO(MySQLCredential credential) throws SQLException {
        this.mySQLCredential = credential;
    }

    public int insertIntoActor(String firstName, String lastName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());
             CallableStatement statement = connection.prepareCall("{call insert_actor(?,?,?)}");) {
            statement.setString("first_name", firstName);
            statement.setString("last_name", lastName);
            statement.registerOutParameter("new_actor_id", Types.INTEGER);
            statement.execute();
            return statement.getInt("new_actor_id");
        }
    }

    public void assignActorToFilm(int actorId, int filmId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());
             PreparedStatement statement = connection.prepareStatement("INSERT INTO film_actor (actor_id, film_id) VALUES (?, ?)");) {
            statement.setInt(1, actorId);
            statement.setInt(2, filmId);
            statement.execute();
        }
    }

    public int getActorIdByName(String firstName, String lastName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());
             PreparedStatement statement = connection.prepareStatement("SELECT actor_id FROM actor WHERE first_name=? AND last_name=?");) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("actor_id");
        }
    }
}
