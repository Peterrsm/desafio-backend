package com.peterrsm.desafio.service.exceptions;

import lombok.Data;

@Data
public class MerchantSenderException extends RuntimeException {

    public MerchantSenderException() {
        super("Invalid sender. Only MERCHANT users can transfer an amount.");
    }
}
