package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String jdbcURL = "jdbc:postgresql://localhost:5432/TransfermarktDB";
    private static final String username = "postgres";
    private static final String password = "dixi";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexiunea la baza de date PostgreSQL a fost închisă cu succes.");
            } catch (SQLException e) {
                System.out.println("Eroare la închiderea conexiunii la baza de date PostgreSQL!");
                e.printStackTrace();
            }
        }
    }
}
