package com.example.thecoffeehouse.domain.common.valueobject;

import com.example.thecoffeehouse.domain.common.model.ValueObject;

public class Phone extends ValueObject {
    private String phoneNumber;
    final static String regionCode = "+84";
    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String getRegionCode() {
        return regionCode;
    }

}
