package OrderService;

import Builder.CustomerBuilder;
import Builder.OrderBuilder;
import Models.Customer;
import Models.Order;
import Services.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {


    OrderService orderService = new OrderService();
    @Test
    public void ifCustomerCreditIsLeastThan500TheOrderMustStayUnexpetided(){
        Customer customer = new CustomerBuilder().setCreditRating(150).setTotalPurchase(BigDecimal.valueOf(9000)).build();
        Order order = new OrderBuilder().addCustomer(customer).build();

        orderService.expediteOrder(order);

        assertFalse(order.isExpedited());
    }

    @Test
    public void ifCustomerTotalAmountIsLessThan5000TheOrderMustStayUnexpedited(){
        Customer customer = new CustomerBuilder().setCreditRating(900).setTotalPurchase(BigDecimal.valueOf(2)).build();
        Order order = new OrderBuilder().addCustomer(customer).build();

        assertFalse(order.isExpedited());
    }

    @Test
    public void IfCustomerTotalAmountIsBiggerThan5000AndCreditIsBiggerThan500TheOrderIsExpedited(){
        Customer customer = new CustomerBuilder().setCreditRating(900).setTotalPurchase(BigDecimal.valueOf(10000)).build();
        Order order = new OrderBuilder().addCustomer(customer).build();

        assertFalse(order.isExpedited());
    }

    @Test
    public void AddOrderToCustomer(){
        BigDecimal amount = new BigDecimal(5030);
        Customer customer = new CustomerBuilder().setTotalPurchase(BigDecimal.valueOf(0)).build();
        Order order = new OrderBuilder().addCustomer(customer).setTotalAmount(amount).build();

        orderService.addOrderToCustomerHistory(order);

        assertEquals(1,customer.getOrderHistory().size());
        assertEquals(amount, customer.getTotalPurchase());
    }
}
