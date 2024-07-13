package entities.order;

public class OrderData {
    public int id;
    public int route_id;
    public int amount;
    public int total;
    public int status = 0;

    public final int NOT_PAID = 0;
    public final int PAID = 1;

    protected int cust_id;

    /**
     * Constructor for Default Order Insert
     * 
     * @param route_id route_id provide for the route that bought for the ticket
     * @param cust_id  cust_id is id of the customer that returned from the customer
     * @param amount   amount of the ticket that bought by the customer
     */
    public OrderData(int route_id, int cust_id, int amount) {
        this.route_id = route_id;
        this.cust_id = cust_id;
        this.amount = amount;
    }

    /**
     * Constructor for Order Update Status
     * 
     * @param id     int id of order to be updated
     * @param status string status of the order to be updated PAID or NOT_PAID
     */
    public OrderData(int id, String status) {
        this.id = id;
        setStatus(status);
    }

    /**
     * Constructor for Show Data
     * @param id
     * @param amount
     * @param total
     * @param status
     */
    public OrderData(int id, int amount, int total, int status) {
        this.id = id;
        this.amount = amount;
        this.total = total;
        this.status = status;
    }
    
    
    /**
     * Constructor for Show Data
     * @param id
     * @param route_id
     * @param cust_id
     * @param amount
     * @param total
     * @param status
     */
    public OrderData(int id, int route_id, int cust_id, int amount, int total, int status) {
        this.id = id;
        this.route_id = route_id;
        this.cust_id = cust_id;
        this.amount = amount;
        this.total = total;
        this.status = status;
    }

    protected void setStatus(String status) {
        if (status == "PAID")
            this.status = PAID;
        if (status == "NOT_PAID")
            this.status = NOT_PAID;
    }

    public int getTotal(int price) {
        return this.amount * price;
    }

    public int getCustomer() {
        return this.cust_id;
    }

    public void setPrice(int price) {
        this.total = getTotal(price);
    }
}
