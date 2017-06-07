
import insurance.SocialInsuranceRecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aizeeck on 23.05.17.
 */
public class SocialInsuranceMySqlDAO implements SocialInsuranceStorage, SocialInsuranceInsertionAPI {
    private MySQLCredential mySQLCredential;

    public SocialInsuranceMySqlDAO(MySQLCredential credential) throws SQLException {
        this.mySQLCredential = credential;
    }

    @Override
    public int insert(SocialInsuranceRecord record, int citizenId) throws DALException {
        int last_id = 0;
        if (!(record instanceof SocialInsuranceRecord)){
            throw new DALException();
        }
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());) {
            CallableStatement statement = connection.prepareCall("{call insert_social_insurance(?,?,?,?,?)}");
            SocialInsuranceRecord socialInsurance = (SocialInsuranceRecord) record;
            statement.setInt("yr", socialInsurance.getYear());
            statement.setInt("mon", socialInsurance.getMonth());
            statement.setDouble("amount", socialInsurance.getAmount());
            statement.setInt("citizen_id", citizenId);
            statement.registerOutParameter("last_id", Types.INTEGER);
            statement.execute();
            last_id = statement.getInt("last_id");
        } catch (SQLException e1) {
            throw new DALException();
        }
        return last_id;
    }

    @Override
    public void insert(List<SocialInsuranceRecord> records, int citizenId) throws DALException {
        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());
        Statement statement = connection.createStatement()) {
            StringBuilder query = new StringBuilder().append("INSERT INTO SocialInsurances (year, month, amount, citizen_id) VALUES ");
            for (SocialInsuranceRecord record : records) {
                query.append("\n(" + record.getYear() +  ", " + record.getMonth() + ", " + record.getAmount() + ", " + citizenId + "), ");
            }
            query.setCharAt(query.lastIndexOf(","), ';');
            statement.execute(query.toString());
        } catch (SQLException e) {
            throw new DALException();
        }
    }

    @Override
    public List<SocialInsuranceRecord> select(int citizenId) throws DALException {
        List<SocialInsuranceRecord> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(
                mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM SocialInsurances WHERE citizen_id = ?");
            statement.setInt(1, citizenId);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    result.add(new SocialInsuranceRecord (resultSet.getInt("year"),
                            resultSet.getInt("month"), resultSet.getDouble("amount")));
                }
            }
        } catch (SQLException e1) {
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
