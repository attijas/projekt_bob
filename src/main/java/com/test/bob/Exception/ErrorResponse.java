package com.test.bob.Exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final String message;
    private final int status;

    private final LocalDateTime timestamp;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }




}
