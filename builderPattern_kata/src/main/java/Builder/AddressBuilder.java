package Builder;

import Models.Address;

public class AddressBuilder {

    Address address;

    public AddressBuilder() {
        this.address = new Address();
    }

    public AddressBuilder setStreet1(String street){
        this.address.setStreet1(street);
        return this;
    }
    public AddressBuilder setStreet2(String street){
        this.address.setStreet2(street);
        return this;
    }

    public AddressBuilder setStreet3(String street){
        this.address.setStreet3(street);
        return this;
    }

    public AddressBuilder setCity(String city){
        this.address.setCity(city);
        return this;
    }

    public AddressBuilder setState(String state){
        this.address.setState(state);
        return this;
    }

    public AddressBuilder setPostalCode(String postalCode){
        this.address.setPostalCode(postalCode);
        return this;
    }

    public AddressBuilder setCountry(String country){
        this.address.setCountry(country);
        return this;
    }


    public Address build() {
        return this.address;
    }
}
