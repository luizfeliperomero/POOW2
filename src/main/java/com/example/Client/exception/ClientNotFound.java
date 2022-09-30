package com.example.Client.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ClientNotFound extends RuntimeException{
    public ClientNotFound(String message) {
        super(message);
    }
}
