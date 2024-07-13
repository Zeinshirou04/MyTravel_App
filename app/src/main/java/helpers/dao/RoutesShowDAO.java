package helpers.dao;

import java.util.ArrayList;

import entities.route.RouteData;

public interface RoutesShowDAO {
    public ArrayList<RouteData> show();
    public ArrayList<RouteData> show(RouteData data);
    public RouteData show(int id);
}
