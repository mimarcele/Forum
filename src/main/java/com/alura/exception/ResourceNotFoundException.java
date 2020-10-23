package com.alura.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException {
    private int status;
    private String details;
    private long timestamp;


    public static final class ResourceNotFoundExceptionBuilder {
        private int status;
        private String details;
        private long timestamp;

        private ResourceNotFoundExceptionBuilder() {
        }

        public static ResourceNotFoundExceptionBuilder newBuilder() {
            return new ResourceNotFoundExceptionBuilder();
        }

        public ResourceNotFoundExceptionBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ResourceNotFoundExceptionBuilder details(String details) {
            this.details = details;
            return this;
        }

        public ResourceNotFoundExceptionBuilder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ResourceNotFoundException build() {
            ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException();
            resourceNotFoundException.setStatus(status);
            resourceNotFoundException.setDetails(details);
            resourceNotFoundException.setTimestamp(timestamp);
            return resourceNotFoundException;
        }
    }
}
