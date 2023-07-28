package com.library.exception;

public class ResourceDBException extends Exception {

	private String errorMsg;

    public ResourceDBException(String errorMsg) {
        // providing exception message to extended Exception class
        super(errorMsg);
        this.errorMsg = errorMsg;
    }


    // getter setter methods
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}