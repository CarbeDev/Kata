package Services;

import Exceptions.InsufficientCreditException;
import Exceptions.InvalidAddressException;
import Exceptions.InvalidCustomerException;
import Exceptions.InvalidOrderException;
import Models.Address;
import Models.Customer;
import Models.Order;

import java.math.BigDecimal;

public class OrderService {

    public OrderService() {
    }

    public void placeOrder(Order order) throws InvalidOrderException, InvalidCustomerException, InsufficientCreditException, InvalidAddressException {

        validate(order);
        expediteOrder(order);

    }

    private void validate(Order order) throws InvalidOrderException, InvalidCustomerException, InsufficientCreditException, InvalidAddressException {
        validateOrder(order);
        validateCustomer(order.getCustomer());
        validateAddress(order.getCustomer().getHomeAddress());
    }

    public void validateOrder(Order order) throws InvalidOrderException {
        // TODO: order ID must be zero (it's a new order)
        // TODO: order amount must be greater than zero
        // TODO: order must have a customer (customer is not null)
        if (isOrderIdDifferentOfZero(order)) throw new InvalidOrderException("order ID must be zero");
        if (isTotalAmountUnderOrEqualTo0(order)) throw new InvalidOrderException("order amount must be greater than zero");
        if (isOrderCustomerNotNull(order)) throw new InvalidOrderException("order must have a customer");
    }

    public void validateCustomer(Customer customer) throws InvalidCustomerException, InsufficientCreditException {
        // TODO: customer must have an ID > 0
        // TODO: customer must have an address (it is not null)
        // TODO: customer must have a first and last name
        // TODO: customer must have credit rating > 200 (otherwise throw InsufficientCreditException)
        // TODO: customer must have total purchases >= 0
        if (isIdNotHigherThan0(customer)) throw new InvalidCustomerException("customer must have an ID > 0");
        if (isAddressNull(customer)) throw new InvalidCustomerException("customer must have an address");
        if (isFirstOrLastNameNull(customer)) throw new InvalidCustomerException("customer must have a first and last name");
        if (HasntSufficientCredit(customer)) throw new InsufficientCreditException("customer must have credit rating > 200");
        if (isTotalPurchasesNegative(customer)) throw new InvalidCustomerException("customer must have total purchases >= 0");
    }

    public void validateAddress(Address homeAddress) throws InvalidAddressException {
        // TODO: street1 is required (not null or empty)
        // TODO: city is required (not null or empty)
        // TODO: state is required (not null or empty)
        // TODO: postalcode is required (not null or empty)
        // TODO: country is required (not null or empty)
        if (isStreet1NullOrEmpty(homeAddress)) throw new InvalidAddressException("street1 is required");
        if (isCityNullOrEmpty(homeAddress)) throw new InvalidAddressException("city is required");
        if (isStateNullOrEmpty(homeAddress)) throw new InvalidAddressException("state is required");
        if (isPostalCodeNullOrEmpty(homeAddress)) throw new InvalidAddressException("postal code is required");
        if (isCountryNullOrEmpty(homeAddress)) throw new InvalidAddressException("country is required");
    }

    public void expediteOrder(Order order) {
        // TODO if customer's total purchases > 5000 and credit rating > 500 set IsExpedited to true
        if (isCustomerTotalPurchaseBiggerThan5000(order) && isCustomerCreditRatingBiggerThan500(order)){
            order.setExpedited(true);
        }
    }

    public void addOrderToCustomerHistory(Order order) {
        order.getCustomer().addOrder(order);
        order.getCustomer().addTotalAmount(order.getTotalAmount());
    }

    private boolean isOrderIdDifferentOfZero(Order order) {
        return order.getId() != 0;
    }

    private boolean isTotalAmountUnderOrEqualTo0(Order order) {
        return order.getTotalAmount().compareTo(BigDecimal.valueOf(0)) <= 0;
    }

    private boolean isOrderCustomerNotNull(Order order) {
        return order.getCustomer() == null;
    }

    private static boolean isIdNotHigherThan0(Customer customer) {
        return customer.getId() <= 0;
    }

    private static boolean isAddressNull(Customer customer) {
        return customer.getHomeAddress() == null;
    }

    private static boolean isFirstOrLastNameNull(Customer customer) {
        return customer.getFirstName() == null || customer.getLastName() == null;
    }

    private static boolean HasntSufficientCredit(Customer customer) {
        return customer.getCreditRating() <= 200;
    }

    private static boolean isTotalPurchasesNegative(Customer customer) {
        return customer.getTotalPurchase().compareTo(BigDecimal.valueOf(0)) < 0;
    }

    private static boolean isStreet1NullOrEmpty(Address homeAddress) {
        return homeAddress.getStreet1() == null || homeAddress.getStreet1().equals("");
    }

    private static boolean isCityNullOrEmpty(Address homeAddress) {
        return homeAddress.getCity() == null || homeAddress.getCity().equals("");
    }

    private static boolean isStateNullOrEmpty(Address homeAddress) {
        return homeAddress.getState() == null || homeAddress.getState().equals("");
    }

    private static boolean isPostalCodeNullOrEmpty(Address homeAddress) {
        return homeAddress.getPostalCode() == null || homeAddress.getPostalCode().equals("");
    }

    private static boolean isCountryNullOrEmpty(Address homeAddress) {
        return homeAddress.getCountry() == null || homeAddress.getCountry().equals("");
    }

    private static boolean isCustomerCreditRatingBiggerThan500(Order order) {
        return order.getCustomer().getCreditRating() > 500;
    }

    private static boolean isCustomerTotalPurchaseBiggerThan5000(Order order) {
        return order.getCustomer().getTotalPurchase().compareTo(BigDecimal.valueOf(5000)) > 0;
    }
}
