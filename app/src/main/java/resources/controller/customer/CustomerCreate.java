package resources.controller.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.customer.CustomerData;
import entities.route.RouteData;
import helpers.ConnectionDB;
import helpers.dao.CustomerCreateDAO;
import resources.controller.routes.RoutesCreate;
import resources.controller.routes.RoutesShow;
import resources.model.Customer;

public class CustomerCreate extends Customer implements CustomerCreateDAO {

    @Override
    public int create(CustomerData data) {
        String query = "INSERT OR REPLACE INTO `" + getTable() + "` (nama, contact) "
                + "VALUES (?, ?)";

        try (Connection conn = ConnectionDB.connect();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            // System.out.println(price);
            // stmt.setString(1, getTable());
            stmt.setString(1, data.nama);
            stmt.setString(2, data.getContact());
            stmt.executeUpdate();
            int id = stmt.getGeneratedKeys().getInt(1);
            return id;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return 0;
        }
    }
}
