package helpers.dao;

import entities.order.OrderData;
import java.util.ArrayList;

public interface OrderShowDAO {
    public OrderData show(int id);
    public ArrayList<OrderData> show();
}
