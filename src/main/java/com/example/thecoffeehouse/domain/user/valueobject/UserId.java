package com.example.thecoffeehouse.domain.user.valueobject;

import com.example.thecoffeehouse.domain.common.model.ValueObject;

import java.util.UUID;

public class UserId extends ValueObject {
    private String valueUserId;
    private String barCode;


    public UserId() {
    }

    public UserId create(String valueUserId, String barCode) {
        this.valueUserId = valueUserId;
        this.barCode = barCode;
        return this;
    }

    public String getValueUserId() {
        return valueUserId;
    }

    private void setValueUserId(String valueUserId) {
        this.valueUserId = valueUserId;
    }
    public String getBarCode() {
        return barCode;
    }

    private void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
