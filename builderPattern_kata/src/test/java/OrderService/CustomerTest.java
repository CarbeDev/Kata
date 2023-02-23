package OrderService;

import Builder.CustomerBuilder;
import Exceptions.InsufficientCreditException;
import Exceptions.InvalidCustomerException;
import Models.Address;
import Models.Customer;
import Services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    Customer validCustomer;

    OrderService orderService = new OrderService();

    @BeforeEach
    public void init(){
        CustomerBuilder customerBuilder = new CustomerBuilder().setId(1).setHomeAddress(new Address()).setFirstName("Test").setLastName("Test").setCreditRating(201).setTotalPurchase(new BigDecimal(0));
        this.validCustomer = customerBuilder.build();
    }
    @Test
    public void customerIdMustBeGreaterThan0(){
        validCustomer.setId(0);
        assertThrows(InvalidCustomerException.class,()->{this.orderService.validateCustomer(validCustomer);});
    }

    @Test
    public void customerHomeAddressCantBeNull(){
        this.validCustomer.setHomeAddress(null);
        assertThrows(InvalidCustomerException.class, () -> {this.orderService.validateCustomer(validCustomer);});
    }

    @Test
    public void customerMustHaveAFirstName(){
        this.validCustomer.setFirstName(null);
        assertThrows(InvalidCustomerException.class,()->{this.orderService.validateCustomer(validCustomer);});
    }


    @Test
    public void customerMustHaveALastName(){
        this.validCustomer.setLastName(null);
        assertThrows(InvalidCustomerException.class,()->{this.orderService.validateCustomer(validCustomer);});
    }

    @Test
    public void customerMustHaveMoreThan200Credit(){
        this.validCustomer.setCreditRating(200);
        assertThrows(InsufficientCreditException.class,()->{this.orderService.validateCustomer(validCustomer);});
    }

    @Test
    public void  customerTotalPurchaseCantBeNegative(){
        this.validCustomer.setTotalPurchase(new BigDecimal(-1));
        assertThrows(InvalidCustomerException.class,()->{this.orderService.validateCustomer(validCustomer);});
    }

    @Test
    public void validCustomerDoesntThrowException(){assertDoesNotThrow(()->{this.orderService.validateCustomer(validCustomer);});}
}
