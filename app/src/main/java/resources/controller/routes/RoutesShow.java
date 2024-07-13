package resources.controller.routes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.route.RouteData;
import helpers.ConnectionDB;
import helpers.dao.RoutesShowDAO;
import resources.model.Router;

public class RoutesShow extends Router implements RoutesShowDAO {

    @Override
    public ArrayList<RouteData> show() {
        ArrayList<RouteData> temp = new ArrayList<>();
        String query = "SELECT * FROM " + getTable() + ";";
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet result = stmt.executeQuery();
            if (!result.isAfterLast()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String vid = result.getString("vid");
                    String dept = result.getString("dept");
                    String dest = result.getString("dest");
                    String dept_date = result.getString("dept_date");
                    int price = result.getInt("price");
                    int stock = result.getInt("stock");
                    temp.add(new RouteData(id, vid, dept, dest, dept_date, price, stock));
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public ArrayList<RouteData> show(RouteData data) {
        ArrayList<RouteData> temp = new ArrayList<>();
        String query = "SELECT * FROM `" + getTable() + "` WHERE dept = ? AND dest = ?;";
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, data.departure);
            stmt.setString(2, data.destination);
            ResultSet result = stmt.executeQuery();
            if (!result.isAfterLast()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String vid = result.getString("vid");
                    String dept = result.getString("dept");
                    String dest = result.getString("dest");
                    String dept_date = result.getString("dept_date");
                    int price = result.getInt("price");
                    int stock = result.getInt("stock");
                    temp.add(new RouteData(id, vid, dept, dest, dept_date, price, stock));
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public RouteData show(int id) {
        RouteData temp = null;
        String query = "SELECT * FROM " + getTable() + " WHERE id = ?;";
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if (result.next()) { // Move to the first row, if it exists
                int rid = result.getInt("id");
                String vid = result.getString("vid");
                String dept = result.getString("dept");
                String dest = result.getString("dest");
                String dept_date = result.getString("dept_date");
                int price = result.getInt("price");
                int stock = result.getInt("stock");
                temp = new RouteData(rid, vid, dept, dest, dept_date, price, stock);
                // System.out.println(rid);
                return temp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

}
