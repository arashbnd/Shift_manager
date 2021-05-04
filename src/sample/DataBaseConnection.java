package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection{

    public Connection databaseLink;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String databaseName = "login";
        String databaseUser = "root";
        String databasePassword = "Omidvaramkarkone1";
        String url = "jdbc:mysql://localhost/" + databaseName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        System.out.println("DB connected");

        return databaseLink;
    }
}