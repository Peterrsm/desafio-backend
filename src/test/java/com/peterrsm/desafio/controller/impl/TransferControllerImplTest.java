package com.peterrsm.desafio.controller.impl;

import com.peterrsm.desafio.service.TransferService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransferControllerImplTest {

    @Mock
    TransferService service;

    @InjectMocks
    TransferControllerImpl controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void efetuaTransferencia() throws Exception {

        when(service.transferAmmount(anyLong(), anyLong(), anyFloat()))
                .thenReturn("Transferência efetuada");

        Assertions.assertEquals("Transferência efetuada", controller.efetuaTransferencia(1L, 2L, 10F));
    }
}