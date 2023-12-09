package com.esn.adapters.rest.exceptions;

public class GeneralResponse {
    private StatusResponse status;

    public GeneralResponse status(StatusResponse status) {
        this.status = status;
        return this;
    }

    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }
}
