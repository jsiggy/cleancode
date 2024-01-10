package com.siggy.training.code.smells.user;

public class UserService {
    public UserDetails createUser(String first, String last) {
        UserDetails userDetails = new UserDetails(first, last);
        return userDetails;
    }

    public boolean isValidUser(UserDetails userDetails) {
        if (userDetails.hasErrors() == true)
            return false;
        else
            return true;
    }
}
