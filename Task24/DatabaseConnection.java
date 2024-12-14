package Task24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/kek_lol";
    private static final String USER = "veronika_steklo";
    private static final String PASSWORD = "ssu_java";
    private static Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
