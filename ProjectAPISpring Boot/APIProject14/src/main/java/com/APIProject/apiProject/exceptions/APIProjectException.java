package com.APIProject.apiProject.exceptions;

public class APIProjectException extends RuntimeException {
    private ErrorDetailsClientAPI details;

    public APIProjectException(ErrorDetailsClientAPI details) {
        this.details = details;
    }

    public ErrorDetailsClientAPI getDetails() {
        return details;
    }

    public void setDetails(ErrorDetailsClientAPI details) {
        this.details = details;
    }
}
