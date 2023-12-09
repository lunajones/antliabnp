package com.esn.adapters.rest.exceptions;

public class StatusResponse {

    private String code;

    private String message;

    public StatusResponse code(String code) {
        this.code = code;
        return this;
    }

    public StatusResponse message(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
