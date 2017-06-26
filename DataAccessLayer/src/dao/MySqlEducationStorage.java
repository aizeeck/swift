package dao;

import credentials.MySQLCredential;
import storages.EducationStorage;
import education.Education;
import education.EducationDegree;
import education.GradedEducation;
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import exceptions.DALException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySqlEducationStorage implements EducationStorage {

    private final MySQLCredential mySQLCredential;

    public MySqlEducationStorage(MySQLCredential mySQLCredential) throws SQLException {
        this.mySQLCredential = mySQLCredential;
    }

    

    @Override
    public void insert(Education education, int citizenId) throws DALException {

        try (Connection con = DriverManager.getConnection(mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());
                CallableStatement statement = con.prepareCall("{call `sp_insert_education`(?, ?, ?, ?, ?, ?, ? )}")) {

            statement.setString("p_institutionName", education.getInstitutionName());
            statement.setDate("p_enrollmentDate", Date.valueOf(education.getEnrollmentDate()));
            statement.setDate("p_graduationDate", Date.valueOf(education.getGraduationDate()));
            statement.setString("p_degree", education.getDegree().toString());
            statement.setBoolean("p_graduaded", education.isGraduated());
            if (education instanceof PrimaryEducation) {
                statement.setNull("p_grade", Types.DOUBLE);
            } else {
                if (education.getGraduationDate().compareTo(LocalDate.of(2017, 5, 23)) > 0) {
                    statement.setNull("p_grade", Types.DOUBLE);
                } else {
                    statement.setFloat("p_grade", ((GradedEducation) education).getFinalGrade());
                }
                
            }
            statement.setInt("p_citizen_id", citizenId);

            statement.executeQuery();

        } catch (SQLException ex) {

            // SQLException is actually a linked list of Exceptions
            while (ex != null) {
                System.out.println(ex.getSQLState());
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                ex = ex.getNextException();
            }
            throw new DALException("Can not write to storage education of citizen with id " + citizenId);

        }
    }

    @Override
    public List<Education> getEducationById(int citizenId) throws DALException {
        List<Education> result = new ArrayList<>();

        String query = "SELECT * FROM Education "
                + "WHERE citizen_id = ? "
                + "ORDER BY `graduationDate` DESC ";

        try (Connection con = DriverManager.getConnection(mySQLCredential.getUrl(), mySQLCredential.getUname(), mySQLCredential.getPass());
                PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, citizenId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String institutionName = rs.getString("institutionName");
                    LocalDate enrollmentDate = rs.getDate("enrollmentDate").toLocalDate();
                    LocalDate graduationDate = rs.getDate("graduationDate").toLocalDate();
                    String degree = rs.getString("degree");
                    boolean graduaded = rs.getBoolean("graduaded");
                    float grade = rs.getFloat("grade");
                    
                    if (2 <= grade && grade <= 6) {
                        Education education = createEducation(institutionName, enrollmentDate, graduationDate, degree);
                        GradedEducation gradedEducation = (GradedEducation) education;
                        gradedEducation.gotGraduated(grade);
                        result.add(gradedEducation);
                    } else {
                        Education education = createEducation(institutionName, enrollmentDate, graduationDate, degree);
                        result.add(education);
                    }
                }
            }
        } catch (SQLException ex) {
            throw new DALException("Education can cot be retreived from storrage. Citizen id = " + citizenId);
        }
        return result;

    }

    public static Education createEducation(String institutionName, LocalDate enrollmentDate,
            LocalDate graduationDate, String degree) {

        Education result = null;
        switch (degree) {
            case "Primary":
            case "P":
                PrimaryEducation eduPrimary = new PrimaryEducation(institutionName, enrollmentDate, graduationDate);
                result = eduPrimary;
                break;
            case "Secondary":
            case "S":
                SecondaryEducation eduSecondary = new SecondaryEducation(institutionName, enrollmentDate, graduationDate);
                result = eduSecondary;
                break;
            case "Bachelor":
            case "B":
                HigherEducation eduBachelor = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Bachelor);
                result = eduBachelor;
                break;
            case "Master":
            case "M":
                HigherEducation eduMaster = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Master);
                result = eduMaster;
                break;
            case "Doctorate":
            case "D":
                HigherEducation eduDoctorate = new HigherEducation(institutionName, enrollmentDate, graduationDate, EducationDegree.Doctorate);
                result = eduDoctorate;
                break;
        }
        return result;
    }


}
