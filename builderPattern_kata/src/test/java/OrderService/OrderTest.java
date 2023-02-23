package OrderService;

import Builder.OrderBuilder;
import Exceptions.InvalidOrderException;
import Models.Customer;
import Models.Order;
import Services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private OrderService orderService = new OrderService();
    private Order validOrder;

    @BeforeEach
    public void init(){
        OrderBuilder orderBuilder = new OrderBuilder();
        orderBuilder.setId(0);
        orderBuilder.setTotalAmount(BigDecimal.valueOf(1));
        orderBuilder.addCustomer(new Customer());
        orderBuilder.isExpedited(false);

        this.validOrder = orderBuilder.build();
    }

    @Test
    public void OrderIdMustBe0(){

        this.validOrder.setId(1);
        assertThrows(InvalidOrderException.class,()->{orderService.validateOrder(this.validOrder);});
    }

    @Test
    public void OrderAmountMustBeGreaterThan0(){
        this.validOrder.setTotalAmount(BigDecimal.valueOf(0));

        assertThrows(InvalidOrderException.class,()->{orderService.validateOrder(this.validOrder);});
    }

    @Test
    public void OrderConsumerCantBeNull(){
        this.validOrder.setCustomer(null);
        assertThrows(InvalidOrderException.class,()->{orderService.validateOrder(this.validOrder);});
    }

    @Test
    public void validOrderDoesntThrowError(){
        assertDoesNotThrow(()->{orderService.validateOrder(this.validOrder);});
    }
}
