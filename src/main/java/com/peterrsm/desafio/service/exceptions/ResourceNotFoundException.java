package com.peterrsm.desafio.service.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

    private static final Long id = 1L;

    public ResourceNotFoundException(Long id){
        super("Resource not found - id: " + id);
    }
}