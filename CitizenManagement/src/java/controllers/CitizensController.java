package controllers;

import address.Address;
import credentials.MySQLCredential;
import dao.AddressMySqlDAO;
import dao.CitizenMySqlDAO;
import education.Education;
import education.EducationDegree;
import exceptions.DALException;
import insurance.SocialInsuranceRecord;
import personaldetails.Citizen;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import storages.AddressStorage;
import storages.CitizenStorage;

public class CitizensController {

    static String username;
    static String password;
    static MySQLCredential mySQLCredential;

    private CitizensController(){}

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mySQLCredential = new MySQLCredential(
                "jdbc:mysql://localhost:3306/CitizenManagement",
                "root",
                "jeans4587"
        );
    }

    public static Citizen getCitizenById(int id) throws SQLException, DALException {
        CitizenStorage citizenMySqlDAO = new CitizenMySqlDAO(mySQLCredential);
        AddressStorage addressMySqlDAO = new AddressMySqlDAO(mySQLCredential);
        
        List<Citizen> citizen = citizenMySqlDAO.select(id);
        Address address = addressMySqlDAO.select(id);
        
        citizen.get(0).setAddress(addressMySqlDAO.select(id));
        
        List<Education> educations = new ArrayList<>();
        educations = EducationController.getEducations(id);
        educations.forEach((education) -> citizen.get(0).addEducation(education));
        
        List<SocialInsuranceRecord> insurances;
        insurances = InsuranceController.getInsurancesSorted(id);
        insurances.forEach((insurance) -> citizen.get(0).addSocialInsuranceRecord(insurance));
        
        return citizen.get(0);
    }
    
    public static boolean isPaymentRelevant(Citizen citizen) {
        if (!isGraduated(citizen.getEducations())) {
            return false;
        }
        
        List<SocialInsuranceRecord> insurancesSorted = citizen.getSocialInsuranceRecords();
        
        if(!areLastThreeMonthsPaid(insurancesSorted)) {
            return true;
        }
        
        return false;
    }
    
    private static boolean isGraduated(List<Education> educations) {
        for (Education education : educations) {
            if (education.isGraduated() && !education.getDegree().equals(EducationDegree.Primary)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean areLastThreeMonthsPaid(List<SocialInsuranceRecord> insurancesSorted) {
        LocalDate base = LocalDate.now().minusMonths(4);
        LocalDate lastPaidDate = LocalDate.of(
                insurancesSorted.get(insurancesSorted.size() - 1).getYear(),
                insurancesSorted.get(insurancesSorted.size() - 1).getMonth(),
                1);
        return lastPaidDate.compareTo(base) >= 0;
    }
    
    public static double calculateSocialPayment(List<SocialInsuranceRecord> insurancesSorted) {
        double paid = 0.00; 
        LocalDate baseEnd = LocalDate.now().minusMonths(4);
        LocalDate baseStart = baseEnd.minusMonths(24);
        
        for (int i = insurancesSorted.size() - 1; i >= 0; i--) {
            LocalDate forDate = LocalDate.of(
                insurancesSorted.get(i).getYear(),
                insurancesSorted.get(i).getMonth(),
                1);
            if(forDate.compareTo(baseStart) > 0 && forDate.compareTo(baseEnd) < 0) {
                paid += insurancesSorted.get(i).getAmount();
                System.out.println("for date: " + forDate + " " + paid);
            }
        }
        return paid/24;
    }
    
    public static void main(String[] args) throws SQLException, DALException {
        Citizen citizen  = CitizensController.getCitizenById(4911); // 76487 - false; 57456 - true
        System.out.println(citizen.getFirstName());
        citizen.getSocialInsuranceRecords().forEach((ins) -> System.out.println(ins.getYear() + "." + ins.getMonth() + " : " + ins.getAmount()));
        System.out.println(isPaymentRelevant(citizen));
        calculateSocialPayment(citizen.getSocialInsuranceRecords());
    }
    
}