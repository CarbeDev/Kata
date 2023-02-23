package Builder;

import Models.Customer;
import Models.Order;

import java.math.BigDecimal;

public class OrderBuilder {

    private Order order;

    public OrderBuilder() {
        this.order = new Order();
    }

    public OrderBuilder setId(int id){
        order.setId(id);
        return this;
    }

    public OrderBuilder addCustomer(Customer customer){
        order.setCustomer(customer);
        return this;
    }

    public OrderBuilder setTotalAmount(BigDecimal totalAmount){
        order.setTotalAmount(totalAmount);
        return this;
    }

    public OrderBuilder isExpedited(boolean b){
        order.setExpedited(b);
        return this;
    }

    public Order build(){
        return this.order;
    }
}
