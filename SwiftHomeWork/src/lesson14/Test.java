package lesson14;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by aizeeck on 21.05.17.
 */
public class Test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/School";
        String username = "root";
        String password = new Scanner(System.in).nextLine();

        getAllCities(url, username, password);

//        insertIntoDisciplines(url, username, password);

//        getAllCities(url, username, password);
    }

    public static void insertIntoDisciplines(String url, String username, String password) {
        String sqlStatement = "INSERT INTO disciplines (Name) Values (?);";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(sqlStatement)) {
            String discName = new Scanner(System.in).nextLine();
            statement.setString(1, discName);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllCities(String url, String username, String password) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM disciplines;");
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Id") + ";" + resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
