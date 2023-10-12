package com.peterrsm.desafio.service.exceptions;

import lombok.Data;

@Data
public class NoFundException extends RuntimeException {

    public NoFundException(String name) {
        super("Usuário com saldo insuficiente para a transação");
    }
}
