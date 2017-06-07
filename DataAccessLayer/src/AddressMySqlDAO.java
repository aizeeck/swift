
import address.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aizeeck on 23.05.17.
 */
public class AddressMySqlDAO implements AddressStorage {
    private MySQLCredential mySQLCredential;

    public AddressMySqlDAO(MySQLCredential credential) throws SQLException {
        this.mySQLCredential = credential;
    }

    @Override
    public int insert(Address address, int citizenId) throws DALException {
        int last_id = 0;
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());) {
            CallableStatement statement = connection.prepareCall("{call insert_address(?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("country", address.getCountry());
            statement.setString("city", address.getCity());
            statement.setString("municipality", address.getMunicipality());
            statement.setString("postal_code", address.getMunicipality());
            statement.setString("street", address.getStreet());
            statement.setString("num", address.getNumber());
            if (address.getFloor() != null) {
                statement.setInt("floor", address.getFloor());
            } else {
                statement.setNull("floor", Types.INTEGER);
            }

            if (address.getApartmentNo() != null) {
                statement.setInt("apartmentNo", address.getApartmentNo());
            } else {
                statement.setNull("apartmentNo", Types.INTEGER);
            }
            statement.setInt("citizen_id", citizenId);
            statement.registerOutParameter("last_id", Types.INTEGER);
            statement.execute();
            last_id = statement.getInt("last_id");
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new DALException();
        }
        return last_id;
    }

    @Override
    public List<Address> select(int citizenId) throws DALException {
        List<Address> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Addresses WHERE citizen_id = ?");
            statement.setInt(1, citizenId);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    result.add(new Address(
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("municipality"),
                        resultSet.getString("postal_code"),
                        resultSet.getString("street"),
                        resultSet.getString("number"),
                        resultSet.getInt("floor"),
                        resultSet.getInt("apartmentNo")));
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new DALException();
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
