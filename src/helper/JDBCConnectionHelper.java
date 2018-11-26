package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionHelper {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/reservation_cinema_place";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        return connection;
    }
    //static method, creating Connection
}
