package com.peterrsm.desafio.service.exceptions;

import lombok.Data;

@Data
public class InvalidUserException extends RuntimeException {

    public InvalidUserException() {
        super("Invalid sender. Only MERCHANT users can transfer an amount.");
    }
}
