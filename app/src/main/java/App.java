import java.util.ArrayList;

import entities.customer.CustomerData;
import entities.route.RouteData;
import entities.order.OrderData;
import helpers.migration.Migration;
import resources.controller.customer.CustomerCreate;
import resources.controller.order.OrderCreate;
import resources.controller.order.OrderShow;
import resources.controller.routes.RoutesCreate;
import resources.controller.routes.RoutesShow;
import resources.views.pages.OrderView;

public class App {
    public static void main(String[] args) {
        new Migration();
        Migration.migrate();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderView().setVisible(true);
            }
        });
    }

        // RoutesCreate rc = new RoutesCreate();

        // rc.create(new RouteData("V0002", "Surabaya", "Malang", "2024-07-21 14:24:30", 345000, 15));
        // rc.update(new RouteData(1, "Surabaya", "Malang", "2024-07-21 14:24:30"));
        // rc.delete(1);

        // RoutesShow rs = new RoutesShow();

        // ArrayList<RouteData> data = rs.show();
        // for(RouteData d: data) {
        //     System.out.println(String.format("Ditemukan rute dengan tujuan: %s dari %s pada %s dengan harga %d", d.destination, d.departure, d.dept_date, d.price));
        // }

        // int price = rs.show(2).price;
        // System.out.println(String.format("Ditemukan harga %d", price));

        // OrderCreate oc = new OrderCreate();

        // oc.create(new OrderStore(11, 1, 5));
        // oc.update(new OrderStore(1, "NOT_PAID"));

        // OrderShow os = new OrderShow();
        // ArrayList<OrderStore> data =  os.show(1);
        // for(OrderStore d: data) {
        //     System.out.println(String.format("Pemesanan ditemukan dengan id %d sebanyak %d tiket dan total Rp.%d", d.id, d.amount, d.total));
        // }

        // CustomerCreate cc = new CustomerCreate();
        // cc.create(new CustomerData("Farras Adhani Zayn", "0895321233687"));
}
