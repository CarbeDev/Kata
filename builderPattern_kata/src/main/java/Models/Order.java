package Models;

import java.math.BigDecimal;

public class Order {

    private int id;
    private Customer customer;
    private BigDecimal totalAmount;
    private boolean isExpedited;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isExpedited() {
        return isExpedited;
    }

    public void setExpedited(boolean expedited) {
        isExpedited = expedited;
    }
}
