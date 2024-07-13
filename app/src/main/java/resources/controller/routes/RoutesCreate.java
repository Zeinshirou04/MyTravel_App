package resources.controller.routes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.route.RouteData;
import helpers.ConnectionDB;
import helpers.dao.RoutesStoreDAO;
import resources.model.Router;

public class RoutesCreate extends Router implements RoutesStoreDAO {

    @Override
    public boolean create(RouteData data) {
        String query = "INSERT INTO " + getTable() + " (vid, dept, dest, dept_date, price, stock) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println(getTable());
            // stmt.setString(1, getTable());
            stmt.setString(1, data.vid);
            stmt.setString(2, data.departure);
            stmt.setString(3, data.destination);
            stmt.setString(4, data.dept_date);
            stmt.setInt(5, data.price);
            stmt.setInt(6, data.getStock());

            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("Insertion successful");
                return true;
            } else {
                System.out.println("Insertion failed");
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(RouteData data) {
        System.out.println(data.id);
        if (data.destination == null)
            return updateStock(data);
        else {
            String query = " UPDATE " + getTable() + " SET vid = ?, dept = ?, dest = ?, dept_date = ?, price = ?, stock = ? WHERE id = ?;";
            try (Connection conn = ConnectionDB.connect();
                    PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, data.vid);
                stmt.setString(2, data.departure);
                stmt.setString(3, data.destination);
                stmt.setString(4, data.dept_date);
                stmt.setInt(5, data.getStock());
                stmt.setInt(6, data.price);
                stmt.setInt(7, data.id);

                int result = stmt.executeUpdate();

                if (result > 0) {
                    System.out.println("Insertion successful");
                    return true;
                } else {
                    System.out.println("Insertion failed");
                    return false;
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM " + getTable() + " WHERE id = ?;";
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            // stmt.setString(1, getTable());
            stmt.setInt(1, id);

            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("Insertion successful");
                return true;
            } else {
                System.out.println("Insertion failed");
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStock(RouteData data) {
        String query = "UPDATE `" + getTable() + "` SET `stock` = ? WHERE `id` = ?;";
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            // stmt.setString(1, getTable());
            stmt.setInt(1, data.getStock());
            stmt.setInt(2, data.id);

            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("Insertion successful");
                return true;
            } else {
                System.out.println("Insertion failed");
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
