package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection conn;

    public static Connection connect() throws SQLException {
        try {
            if(conn == null || conn.isClosed()) conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database/db_travel.db");
        } catch (Exception e) {
            // TODO: handle exception
            if(conn == null || conn.isClosed()) conn = DriverManager.getConnection("jdbc:sqlite:app/src/main/resources/database/db_travel.db");
        }

        return conn;
    }
}
