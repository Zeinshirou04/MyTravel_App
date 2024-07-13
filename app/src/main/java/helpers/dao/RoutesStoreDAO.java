package helpers.dao;

import entities.route.RouteData;

public interface RoutesStoreDAO {
    public boolean create(RouteData data);

    public boolean update(RouteData data);

    public boolean delete(int id);
}
