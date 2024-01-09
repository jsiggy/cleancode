package com.siggy.training.code.refactor.phone;

public class Customer {
    private Phone mobilePhone;
    public String getMobilePhoneNumber() {
        return mobilePhone.toFormattedString();
    }
}
