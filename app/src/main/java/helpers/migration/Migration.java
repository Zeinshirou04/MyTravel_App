package helpers.migration;

import java.util.HashMap;
import java.util.Map;

import java.sql.Statement;
import java.sql.Connection;

import helpers.ConnectionDB;
import helpers.migration.scheme.CustomerTableScheme;
import helpers.migration.scheme.OrderTableScheme;
import helpers.migration.scheme.RouteTableScheme;
import helpers.migration.scheme.VehiclesTableScheme;

public class Migration {
    protected static Map<String, String> tables = new HashMap<>();

    public Migration() {
        tables.put("Routes", new RouteTableScheme().getQuery());
        tables.put("Customer", new CustomerTableScheme().getQuery());
        tables.put("Order", new OrderTableScheme().getQuery());
        tables.put("Vehicles", new VehiclesTableScheme().getQuery());
    }

    public static void migrate() {
        System.out.println("Processing Migration...");
        try (Connection conn = ConnectionDB.connect();
        Statement stmt = conn.createStatement()) {
            System.out.println("Migration Start!");
            conn.setAutoCommit(false);
            try {
                for (Map.Entry<String, String> entry : tables.entrySet()) {
                    stmt.addBatch(entry.getValue());
                    // System.out.println(entry.getValue());
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            stmt.executeBatch();
            conn.commit();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("Migration Finished!");
        }
    }
}
