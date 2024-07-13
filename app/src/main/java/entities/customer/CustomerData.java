package entities.customer;

public class CustomerData {
    public int id;
    public String nama;
    protected String contact;

    /**
     * Constructor for Insert Customer Data
     * @param nama name for customer to be stored
     * @param contact contact for customer to be stored maximum length 13 digits
     */
    public CustomerData(String nama, String contact) {
        this.nama = nama;
        this.contact = contact;
    }

    public String getContact() {
        return this.contact;
    }
}
