/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.CitizensController.mySQLCredential;
import credentials.MySQLCredential;
import dao.MySqlEducationStorage;
import education.Education;
import exceptions.DALException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import storages.EducationStorage;

/**
 *
 * @author aizeeck
 */
public class EducationController {
    
    private EducationController() {}
    
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
    
    public static void addEducation(Education education, int citizenId) throws SQLException, DALException {
        EducationStorage educationStorage = new MySqlEducationStorage(mySQLCredential);
        educationStorage.insert(education, citizenId);
    }
    
    public static List<Education> getEducations (int citizenId) throws SQLException, DALException {
        EducationStorage educationStorage = new MySqlEducationStorage(mySQLCredential);
        List<Education> educations = new ArrayList<>();
        educations = educationStorage.getEducationById(citizenId);
        educations.sort(new Comparator<Education>(){
            @Override
            public int compare(Education o1, Education o2) {
                return o1.getGraduationDate().compareTo(o2.getGraduationDate());
            }
        });
        return educations;
    }
}
