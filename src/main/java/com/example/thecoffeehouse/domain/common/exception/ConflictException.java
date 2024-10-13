package com.example.thecoffeehouse.domain.common.exception;

public class ConflictException extends BaseException{
    private int errorCode;

    public ConflictException() {
    }

    public ConflictException(int errorCode) {
        this.errorCode = errorCode;
    }

    public ConflictException(String message) {
        this.setUserMess(message);
    }

    public ConflictException(String message, int errorCode) {
        this.setUserMess(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
