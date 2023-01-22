package hw2.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private final static String url = "jdbc:postgresql://localhost:5433/jdbc2";
    private final static String user = "postgres";
    private final static String password = "postgres";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
