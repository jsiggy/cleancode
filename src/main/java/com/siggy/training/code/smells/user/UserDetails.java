package com.siggy.training.code.smells.user;

public class UserDetails {
    static long IDs = 0;

    long id;
    boolean hasErrors;

    String a;  // first name
    String b;  // last name

    // address
    String street;
    String city;
    String state;
    int zip;

    // create a UserDetails object
    public UserDetails(String first, String last) {
        id = UserDetails.IDs++;
        this.a = first;
        this.b = last;
    }

    public String getFirstName() {
        return a;
    }

    public void setFirstName(String firstname) {
        if (firstname != null && !firstname.equals(""))
            this.b = firstname;
        else
            throw new IllegalArgumentException("First name cannot be empty or null");
    }

    public String getLastname() {
        return b;
    }

    public void setLastname(String lastname) {
        if (lastname != null && !lastname.equals(""))
            this.b = lastname;
        else
            throw new IllegalArgumentException("Last name cannot be empty or null");
    }

    public String getAddress() {
        return street + city + state + zip;
    }

    public void setAddress(String street, String city, String state, int zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public boolean hasErrors() {
        return hasErrors;
    }
}
