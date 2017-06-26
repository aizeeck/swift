import personaldetails.Citizen;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aizeeck on 15.06.17.
 */
public class CitizensController {
    MySQLCredential mySQLCredential;

    public CitizensController(String password) {
            mySQLCredential = new MySQLCredential(
                "jdbc:mysql://aizeeck.no-ip.org:3306/CitizenManagement",
                "aizeeck",
                "jeans4587");
    }

    public Citizen getCitizenById (int id) throws SQLException, DALException {
        CitizenMySqlDAO citizenMySqlDAO = new CitizenMySqlDAO(mySQLCredential);
        List<Citizen> citizen = citizenMySqlDAO.select(id);
        return citizen.get(0);
    }

}
