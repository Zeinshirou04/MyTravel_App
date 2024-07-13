package resources.controller.order;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.route.RouteData;
import entities.order.OrderData;
import helpers.ConnectionDB;
import helpers.dao.OrderStoreDAO;
import resources.controller.routes.RoutesCreate;
import resources.controller.routes.RoutesShow;
import resources.model.Order;

public class OrderCreate extends Order implements OrderStoreDAO {

    @Override
    public int create(OrderData data) {
        String query = "INSERT INTO `" + getTable() + "` (cid, rid, amount, total, status) "
                + "VALUES (?, ?, ?, ?, ?)";
        // System.out.println(query);
        RouteData temp = new RoutesShow().show(data.route_id);

        boolean res = new RoutesCreate().update(new RouteData(temp.id, (temp.getStock() - data.amount)));
        
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            // System.out.println(price);
            // stmt.setString(1, getTable());
            stmt.setInt(1, data.getCustomer());
            stmt.setInt(2, data.route_id);
            stmt.setInt(3, data.amount);
            stmt.setInt(4, data.getTotal(temp.price));
            stmt.setInt(5, data.status);
            stmt.executeUpdate();
            
            int id = stmt.getGeneratedKeys().getInt(1);
            return id;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean update(OrderData data) {
        String query = " UPDATE `" + getTable() + "` SET status = ? WHERE id = ?;";
        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            // stmt.setString(1, getTable());
            stmt.setInt(1, data.status);
            stmt.setInt(2, data.id);

            int result = stmt.executeUpdate();

            if (result > 0) {
                System.out.println("Update successful");
                return true;
            } else {
                System.out.println("Update failed");
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

}
