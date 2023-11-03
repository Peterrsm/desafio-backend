package com.peterrsm.desafio.controller.impl;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.entity.dto.UsersDTO;
import com.peterrsm.desafio.service.UsersService;
import com.peterrsm.desafio.stubs.UsersStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerImplTest {

    @Mock
    UsersService service;

    @InjectMocks
    UsuarioControllerImpl controller;

    UsersStub stub = new UsersStub();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserById() throws Exception {
        when(service.getUserById(anyLong()))
                .thenReturn(Users.builder().build());

        Assertions.assertNotNull(controller.getUserById(100L));
    }

    @Test
    void createUser() {
        when(service.saveUser(any(UsersDTO.class)))
                .thenReturn(Users.builder().build());

        Assertions.assertNotNull(controller.createUser(UsersDTO.builder().build()));
    }

    @Test
    void updateUser() {
        when(service.updateUser(any(Users.class)))
                .thenReturn(Users.builder().build());

        Assertions.assertNotNull(controller.updateUser(Users.builder().build()));
    }

    @Test
    void getAllUsers() {
        List<Users> lista = new ArrayList<>();
        lista.add(Users.builder().build());
        lista.add(Users.builder().build());
        lista.add(Users.builder().build());

        when(service.getAllUsers())
                .thenReturn(lista);

        List<Users> retorno = controller.getAllUsers();

        Assertions.assertNotNull(retorno);
        Assertions.assertTrue(retorno.size() == 3);
    }

    @Test
    void validateSenderAmmount() throws Exception {
        Users sender = stub.createCommonUser();

        when(service.validateSenderAmmount(any(), anyFloat()))
                .thenReturn(Boolean.TRUE);

        Assertions.assertTrue(controller.validateSenderAmmount(sender, 10F));
    }

    @Test
    void validateSenderUserType() throws Exception {
        Users sender = stub.createCommonUser();

        when(service.validateSenderUserType(Optional.ofNullable(sender)))
                .thenReturn(Boolean.TRUE);

        Assertions.assertTrue(controller.validateSenderUserType(sender));
    }
}