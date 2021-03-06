package dao;

import credentials.MySQLCredential;
import exceptions.DALException;
import personaldetails.Citizen;
import personaldetails.Gender;
import storages.CitizenStorage;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by aizeeck on 23.05.17.
 */
public class CitizenMySqlDAO implements CitizenStorage {
    private MySQLCredential mySQLCredential;

    public CitizenMySqlDAO(MySQLCredential credential) throws SQLException {
        this.mySQLCredential = credential;
    }

    @Override
    public int insert(Citizen citizen) throws DALException {
        int last_id = 0;
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());) {
            CallableStatement statement = connection.prepareCall("{call insert_citizen(?,?,?,?,?,?,?)}");
            statement.setString("first_name", citizen.getFirstName());
            statement.setString("middle_name", citizen.getMiddleName());
            statement.setString("last_name", citizen.getLastName());
            statement.setString("gender", citizen.getGender().name().substring(0,1));
            statement.setDouble("height", citizen.getHeight());
            statement.setDate("date_of_birth", java.sql.Date.valueOf(citizen.getDateOfBirth()));
            statement.registerOutParameter("last_id", Types.INTEGER);
            statement.execute();
            last_id = statement.getInt("last_id");
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new DALException("Can not write to storage Citizen " + 
                    citizen.getFirstName() + " " +
                    citizen.getMiddleName() + " " +
                    citizen.getLastName() + " " +
                    citizen.getDateOfBirth());
        }
        return last_id;
    }

    @Override
    public List<Citizen> select(int citizenId) throws DALException {
        List<Citizen> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Citizens WHERE id = ?");
            statement.setInt(1, citizenId);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    Citizen citizen = new Citizen(
                            resultSet.getString("first_name"),
                            resultSet.getString("middle_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("gender").equals("M") ? Gender.Male : Gender.Female,
                            resultSet.getInt("height"),
                            LocalDate.parse(resultSet.getDate("date_of_birth").toString())
                    );
                    result.add(citizen);
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new DALException("Citizen can cot be retreived from storrage. Citizen id = " + citizenId);
        }
        return result;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}