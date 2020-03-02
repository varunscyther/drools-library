package facts;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    private String lastName;
    private String houseNumber;
    private String streetNumber;

    private List<Address> addressList;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public List<Address> getSubModelAddressList() {
        List subModelAddressList = new ArrayList();
        addressList = new ArrayList();
        Address address = new Address(getHouseNumber(), getStreetNumber());
        subModelAddressList.add(address);
        addressList.add(address);
        return addressList;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
