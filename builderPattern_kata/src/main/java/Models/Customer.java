package Models;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Customer {

    private int id;

    private String firstName;

    private String lastName;
    private Address homeAddress;
    private int creditRating;
    private BigDecimal totalPurchase;
    private ArrayList<Order> orderHistory;

    public Customer() {
        this.orderHistory = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public BigDecimal getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(BigDecimal totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addOrder(Order order){ this.orderHistory.add(order); }

    public void addTotalAmount(BigDecimal totalAmount) {
        this.totalPurchase = this.totalPurchase.add(totalAmount);
    }
}
