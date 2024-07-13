package helpers.dao;

import entities.order.OrderData;

public interface OrderStoreDAO {
    public int create(OrderData data);

    public boolean update(OrderData data);
}
