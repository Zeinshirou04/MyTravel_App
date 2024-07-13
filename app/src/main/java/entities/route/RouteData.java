package entities.route;

public class RouteData {
    public int id;
    public String vid;
    public String departure;
    public String destination;
    public String dept_date;
    public int price;

    protected int stock;

    /**
     * Constructor for Show or Update Route
     * 
     * @param id          the id of route
     * @param vid         the id of vehicle
     * @param departure   the departure of the route
     * @param destination destination of the route
     * @param date        date of the departure
     * @param price       price of the route
     * @param stock       number of the stock for the route
     */
    public RouteData(int id, String vid, String departure, String destination, String date, int price, int stock) {
        this.id = id;
        this.vid = vid;
        this.departure = departure;
        this.destination = destination;
        this.dept_date = date;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Constructor for Insert new Route
     * 
     * @param vid         the id of vehicle
     * @param departure   the departure of the route
     * @param destination destination of the route
     * @param date        date of the departure
     * @param price       price of the route
     * @param stock       number of the stock for the route
     */
    public RouteData(String vid, String departure, String destination, String date, int price, int stock) {
        this.vid = vid;
        this.departure = departure;
        this.destination = destination;
        this.dept_date = date;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Constructor for Update Route Stock
     * 
     * @param id    id for route to be updated
     * @param stock amount of stock for the route
     */
    public RouteData(int id, int stock) {
        this.id = id;
        this.stock = stock;
    }

    /**
     * Constructor for Update Route Data
     * 
     * @param id          id for route to be updated
     * @param departure   the new departure for the route
     * @param destination the new destination for the route
     * @param date        the new date for the route, format of 'YYYY-MM-DD
     *                    HH::MM:SS'
     */
    public RouteData(int id, String vid, String departure, String destination, String date, int stock) {
        this.id = id;
        this.vid = vid;
        this.departure = departure;
        this.destination = destination;
        this.dept_date = date;
        this.stock = stock;
    }
    
    public RouteData(int id, String departure, String destination, String date, int stock, int price) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.dept_date = date;
        this.stock = stock;
        this.price = price;
    }

    /**
     * Constructor for Delete Route Data
     * 
     * @param id
     */
    public RouteData(int id) {
        this.id = id;
    }

    /**
     * Constructor for Search Route Data by Departure and Destination
     * 
     * @param departure   the new departure for the route
     * @param destination the new destination for the route
     */
    public RouteData(String departure, String destination) {
        this.departure = departure;
        this.destination = destination;
    }

    /**
     * Function to get stock value
     * 
     * @return return int of the value from the stock
     */
    public int getStock() {
        return this.stock;
    }
}
