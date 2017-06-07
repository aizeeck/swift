import personaldetails.Citizen;

import java.sql.*;

/**
 * Created by aizeeck on 07.06.17.
 */
public class CitizenStorageEmptyDAO {
    private MySQLCredential mySQLCredential;

    public CitizenStorageEmptyDAO(MySQLCredential credential) throws SQLException {
        this.mySQLCredential = credential;
    }

    public int clearSorage(Citizen citizen) throws DALException {
        int last_id = 0;
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());) {
            CallableStatement statement = connection.prepareCall("{call clear_storage()}");
        } catch (SQLException e1) {
            throw new DALException();
        }
        return last_id;
    }

}
