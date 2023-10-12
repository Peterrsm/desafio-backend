package com.peterrsm.desafio.service.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id){
        super("Resource not found - id: " + id);
    }
    public ResourceNotFoundException(){
        super("Resource not found");
    }

}