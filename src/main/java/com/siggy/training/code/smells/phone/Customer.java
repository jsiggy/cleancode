package com.siggy.training.code.smells.phone;

public class Customer {
    private Phone mobilePhone;
    public String getMobilePhoneNumber() {
        return "(" +
                mobilePhone.getAreaCode() + ") " +
                mobilePhone.getPrefix() + "-" +
                mobilePhone.getNumber();
    }
}