package com.example.thecoffeehouse.domain.common.exception;

public class NotFoundException extends BaseException{
    private int errorCode;

    public NotFoundException(int errorCode) {
        this.errorCode = errorCode;
    }

    public NotFoundException(String message) {
        this.setDevMess(message);
    }

    public NotFoundException(String message, int errorCode) {
        this.setDevMess(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
