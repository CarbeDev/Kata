package Builder;

import Models.Address;
import Models.Customer;
import Models.Order;

import java.math.BigDecimal;

public class CustomerBuilder {

    Customer customer;

    public CustomerBuilder(){
        this.customer = new Customer();
    }

    public CustomerBuilder setId(int id){
        this.customer.setId(id);
        return this;
    }

    public CustomerBuilder setHomeAddress(Address address) {
        this.customer.setHomeAddress(address);
        return this;
    }

    public CustomerBuilder setFirstName(String firstName){
        this.customer.setFirstName(firstName);
        return this;
    }

    public CustomerBuilder setLastName(String lastName){
        this.customer.setLastName(lastName);
        return this;
    }
    public CustomerBuilder setCreditRating(int creditRating) {
        this.customer.setCreditRating(creditRating);
        return this;
    }

    public CustomerBuilder setTotalPurchase(BigDecimal totalPurchase) {
        this.customer.setTotalPurchase(totalPurchase);
        return this;
    }

    public CustomerBuilder addOrder(Order order){
        this.customer.addOrder(order);
        return this;
    }

    public Customer build(){
        return this.customer;
    }
}
