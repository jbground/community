package com.jbground.community.model.common;

public class ResponseStatus {

    private int status;
    private String message = "";

    public ResponseStatus(int status) {
        this.status = status;
    }

    public ResponseStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
