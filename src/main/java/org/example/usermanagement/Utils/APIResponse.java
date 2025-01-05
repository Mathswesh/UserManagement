package org.example.usermanagement.Utils;

import lombok.Data;

@Data
public class APIResponse<T> {
    private int statusCode;
    private T data;
    private String errorMessage;
    private Boolean isError;

    public APIResponse(String message, int statusCode) {
        this.statusCode = statusCode;
        this.errorMessage = message;
        this.isError = true;
        this.data = null;
    }

    public APIResponse(String message) {
        this.statusCode = 200;
        this.errorMessage = message;
        this.isError = false;
        this.data = null;
    }

    public APIResponse(int statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
        this.isError = false;
        this.errorMessage = null;
    }
}