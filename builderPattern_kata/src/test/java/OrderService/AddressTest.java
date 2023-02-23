package OrderService;

import Builder.AddressBuilder;
import Exceptions.InvalidAddressException;
import Models.Address;
import Services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    OrderService orderService = new OrderService();
    Address validAddress;

    @BeforeEach
    public void init(){
        AddressBuilder addressBuilder = new AddressBuilder();
        addressBuilder.setStreet1("a");
        addressBuilder.setCity("a");
        addressBuilder.setState("a");
        addressBuilder.setCountry("a");
        addressBuilder.setPostalCode("a");

        this.validAddress = addressBuilder.build();
    }
    @Test
    public void street1CantBeNull(){
        this.validAddress.setStreet1(null);

        assertThrows(InvalidAddressException.class,()->{orderService.validateAddress(this.validAddress);});
    }

    @Test
    public void cityCantBeNull(){
        this.validAddress.setCity(null);

        assertThrows(InvalidAddressException.class,()->{orderService.validateAddress(this.validAddress);});
    }

    @Test
    public void stateCantBeNull(){
        this.validAddress.setState(null);

        assertThrows(InvalidAddressException.class,()->{orderService.validateAddress(this.validAddress);});
    }

    @Test
    public void postalCodeCantBeNull(){
        this.validAddress.setPostalCode(null);

        assertThrows(InvalidAddressException.class,()->{orderService.validateAddress(this.validAddress);});
    }

    @Test
    public void countryCantBeNull(){
        this.validAddress.setCountry(null);

        assertThrows(InvalidAddressException.class,()->{orderService.validateAddress(this.validAddress);});
    }
}
