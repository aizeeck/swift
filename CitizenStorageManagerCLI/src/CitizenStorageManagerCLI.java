import DataObjectsFactories.AddressFactory;
import DataObjectsFactories.EducationFactory;
import address.Address;
import education.Education;
import insurance.SocialInsuranceRecord;
import personaldetails.Citizen;
import personaldetails.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aizeeck on 26.05.17.
 */
public class CitizenStorageManagerCLI {

    public static void main(String[] args) throws FileNotFoundException, SQLException, DALException {
        Scanner scanner = null;
        if (args.length != 0) {
            File dataFile = new File(args[0]);
            scanner = new Scanner(new FileReader(dataFile));
        } else {
            scanner = new Scanner(System.in);
        }
        trancateTables();
        dataImport(scanner);
    }

    private static void trancateTables() throws SQLException, DALException {
        MySQLCredential mySQLCredential = new MySQLCredential(
                "jdbc:mysql://192.168.1.100:3306/CitizenManagement",
                "aizeeck",
                new Scanner(System.in).nextLine());
        CitizenStorageEmptyDAO citizenStorageEmptyDAO = new CitizenStorageEmptyDAO(mySQLCredential);
        citizenStorageEmptyDAO.clearSorage();
    }

    private static void dataImport(Scanner scanner) throws SQLException, DALException {
        System.out.println(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

        MySQLCredential mySQLCredential = new MySQLCredential(
                "jdbc:mysql://192.168.1.100:3306/CitizenManagement",
                "aizeeck",
                new Scanner(System.in).nextLine());

        //skip the first line with the num of records
        scanner.nextLine();

        while (scanner.hasNext()) {
            String personLine = scanner.nextLine();
            String insuranceLine = scanner.nextLine();
            String[] personSplit = personLine.split(";");
            String[] insuranceSplit = insuranceLine.split(";");

            //instance DO
            Citizen citizen = new Citizen(
                    personSplit[0],
                    personSplit[1],
                    personSplit[2],
                    (personSplit[3].equals("M") ? Gender.Male : Gender.Female),
                    Integer.parseInt(personSplit[5]),
                    LocalDate.parse(personSplit[4], formatter)
            );
            if (personSplit.length > 14) {
                Education education = EducationFactory.createEducation(personSplit);
            }
            Address address = AddressFactory.createAddress(personSplit);

            //instance DAOs
            CitizenStorage citizenDAO = new CitizenMySqlDAO(mySQLCredential);
            SocialInsuranceMySqlDAO socialInsuranceDAO = new SocialInsuranceMySqlDAO(mySQLCredential);
            AddressStorage addressDAO = new AddressMySqlDAO(mySQLCredential);

            //write DOs to db
            int citizenId = citizenDAO.insert(citizen);
            addressDAO.insert(address, citizenId);
            List<SocialInsuranceRecord> socialInsuranceRecords = new ArrayList<>();
            for (int i = 0; i < insuranceSplit.length; i++) {
                int counter = 0;
                //read single insurance record
                socialInsuranceRecords.add(new SocialInsuranceRecord(
                        Integer.parseInt(insuranceSplit[i]),
                        Integer.parseInt(insuranceSplit[i + 1]),
                        Double.parseDouble(insuranceSplit[i + 2])));
                //set cursor to the next insurance record
                i += 2;
            }

            //write to db the list of the citizen's insurances
            socialInsuranceDAO.insert(socialInsuranceRecords, citizenId);
        }
        System.out.println(LocalDateTime.now());
    }
}