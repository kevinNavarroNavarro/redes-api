package com.APIProject.apiProject.exceptions;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    private ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
    public static ErrorDetailsBuilder newBuilder(){
        return new ErrorDetailsBuilder();
    }

    public static class ErrorDetailsBuilder {
        private Date timestamp;
        private String message;
        private String details;

        private ErrorDetailsBuilder() {

        }

        public ErrorDetailsBuilder withTimestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorDetailsBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorDetailsBuilder withDetails(String details) {
            this.details = details;
            return this;
        }

        public ErrorDetails build() {
            return new ErrorDetails(timestamp, message, details);
        }
    }
}