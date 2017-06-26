package console;
import DataObjectsFactories.AddressParser;
import DataObjectsFactories.EducationParser;
import address.Address;
import credentials.MySQLCredential;
import dao.AddressMySqlDAO;
import dao.CitizenMySqlDAO;
import dao.CitizenStorageEmptyDAO;
import dao.SocialInsuranceMySqlDAO;
import education.Education;
import exceptions.DALException;
import insurance.SocialInsuranceRecord;
import personaldetails.Citizen;
import personaldetails.Gender;
import storages.AddressStorage;
import storages.CitizenStorage;
import storages.EducationStorage;
import dao.MySqlEducationStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aizeeck on 26.05.17.
 */
public class CitizenStorageManagerCLI {

    public static void main(String[] args) throws FileNotFoundException, SQLException, DALException {
        Scanner scanner = null;
        System.out.println(Arrays.toString(args));
        if (args.length != 0) {
            File dataFile = new File(args[0]);
            scanner = new Scanner(new FileReader(dataFile));
        } else {
            scanner = new Scanner(System.in);
        }

        MySQLCredential mySQLCredential = new MySQLCredential(
                "jdbc:mysql://localhost:3306/CitizenManagement",
                "root",
                "jeans4587");

        trancateTables(mySQLCredential);
        dataImport(scanner, mySQLCredential);
    }

    private static void trancateTables(MySQLCredential mySQLCredential) throws SQLException, DALException {
        CitizenStorageEmptyDAO citizenStorageEmptyDAO = new CitizenStorageEmptyDAO(mySQLCredential);
        citizenStorageEmptyDAO.clearSorage();
    }

    private static void dataImport(Scanner scanner, MySQLCredential mySQLCredential) throws SQLException, DALException {
        System.out.println(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

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
            List<Education> educations = new ArrayList<>();
            if (personSplit.length > 14) {
                educations = EducationParser.createEducation(personSplit);
            }

            Address address = AddressParser.createAddress(personSplit);

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
            
            EducationStorage educationStorage = new MySqlEducationStorage(mySQLCredential);
            if (educations.size() > 0) {
                for (Education education : educations) {
                    educationStorage.insert(education, citizenId);
                }
            }
        }
        System.out.println(LocalDateTime.now());
    }
}