package io.github.varunscyther.drools.facts;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstName;

    private String lastName;
    private String houseNumber;
    private String streetNumber;
    private Company cmp;

    private List<Address> addressList;

    private Person oldData;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Person(String firstName, String lastName, Person oldData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.oldData = oldData;

    }

    private Person(Company cmp) {
        this.cmp = cmp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Person getOldData() {
        return oldData;
    }

    public void setOldData(Person oldData) {
        this.oldData = oldData;
    }

    public Company getCmp() {
        return cmp;
    }

    public void setCmp(Company cmp) {
        this.cmp = cmp;
    }
}
