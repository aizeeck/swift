package dao;

import credentials.MySQLCredential;
import exceptions.DALException;

import java.sql.*;

/**
 * Created by aizeeck on 07.06.17.
 */
public class CitizenStorageEmptyDAO {
    private MySQLCredential mySQLCredential;

    public CitizenStorageEmptyDAO(MySQLCredential credential) throws SQLException {
        this.mySQLCredential = credential;
    }

    public int clearSorage() throws DALException {
        int last_id = 0;
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());) {
            CallableStatement statement = connection.prepareCall("{call trancate_tables}");
            statement.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new DALException("Storage can not be cleared");
        }
        return last_id;
    }
}
