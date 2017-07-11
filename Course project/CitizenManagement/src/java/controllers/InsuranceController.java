/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.CitizensController.mySQLCredential;
import credentials.MySQLCredential;
import dao.SocialInsuranceMySqlDAO;
import exceptions.DALException;
import insurance.SocialInsuranceRecord;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import storages.SocialInsuranceStorage;

/**
 *
 * @author aizeeck
 */
public class InsuranceController {
    
    private InsuranceController() {}
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mySQLCredential = new MySQLCredential(
                "jdbc:mysql://localhost:3306/CitizenManagement",
                "root",
                "root"
        );
    }
    
    public static void addInsurance(SocialInsuranceRecord insurance, int citizenId) throws SQLException, DALException {
        SocialInsuranceStorage socialInsuranceStorage = new SocialInsuranceMySqlDAO(mySQLCredential);
        socialInsuranceStorage.insert(insurance, citizenId);
    }
    
    public static List<SocialInsuranceRecord> getInsurancesSorted(int citizenId) throws DALException, SQLException {
        List<SocialInsuranceRecord> insuranceRecords = new ArrayList<>();
        SocialInsuranceStorage socialInsuranceStorage = new SocialInsuranceMySqlDAO(mySQLCredential);
        insuranceRecords.addAll(socialInsuranceStorage.select(citizenId));
        insuranceRecords.sort(new Comparator<SocialInsuranceRecord>(){
            @Override
            public int compare(SocialInsuranceRecord o1, SocialInsuranceRecord o2) {
                LocalDate ins1Date = LocalDate.of(o1.getYear(), o1.getMonth(), 1);
                LocalDate ins2Date = LocalDate.of(o2.getYear(), o2.getMonth(), 1);
                return ins1Date.compareTo(ins2Date);
            }
        });
        return insuranceRecords;
    }
}
