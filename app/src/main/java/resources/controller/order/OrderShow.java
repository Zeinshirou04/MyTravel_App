package resources.controller.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.order.OrderData;
import helpers.ConnectionDB;
import helpers.dao.OrderShowDAO;
import resources.model.Order;

public class OrderShow extends Order implements OrderShowDAO {

    @Override
    public OrderData show(int id) {
        OrderData temp = null;
        String query = "SELECT * FROM `" + getTable() + "` WHERE id = ?;";
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if (result.next()) { // Move to the first row, if it exists
                int oid = result.getInt("id");
                int amount = result.getInt("amount");
                int total = result.getInt("total");
                int status = result.getInt("status");
                temp = new OrderData(oid, amount, total, status);
            }
            return temp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public ArrayList<OrderData> show() {
        ArrayList<OrderData> temp = new ArrayList<>();
        String query = "SELECT * FROM `" + getTable() + "`;";
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet result = stmt.executeQuery();

            if (!result.isAfterLast()) {
                while(result.next()) { // Move to the first row, if it exists
                    int oid = result.getInt("id");
                    int route_id = result.getInt("rid");
                    int cust_id = result.getInt("cid");
                    int amount = result.getInt("amount");
                    int total = result.getInt("total");
                    int status = result.getInt("status");
                    temp.add(new OrderData(oid, route_id, cust_id, amount, total, status));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
