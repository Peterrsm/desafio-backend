package com.peterrsm.desafio.service;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.enumerator.UsersTypeEnum;
import com.peterrsm.desafio.repository.UsersRepository;
import com.peterrsm.desafio.service.exceptions.MerchantSenderException;
import com.peterrsm.desafio.service.exceptions.NoFundException;
import com.peterrsm.desafio.service.exceptions.ResourceNotFoundException;
import com.peterrsm.desafio.stubs.UsersStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @Mock
    UsersRepository repo;

    @Autowired
    @InjectMocks
    com.peterrsm.desafio.service.UsersService user_service;

    UsersStub stub = new UsersStub();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldThroMerchantSenderException() throws Exception {
        Users sender = stub.createMerchantUser();
        Assertions.assertNotNull(sender);
        Assertions.assertEquals(UsersTypeEnum.MERCHANT, sender.getType());

        Assertions.assertThrows(MerchantSenderException.class, () -> user_service.validateSenderUserType(java.util.Optional.of(sender)));
    }

    @Test
    void shouldThroNoFundException() throws Exception {
        Users sender = stub.createMerchantUser();
        sender.setPortfolio(0.00);

        Assertions.assertNotNull(sender);
        Assertions.assertThrows(NoFundException.class, () -> user_service.validateSenderAmmount(java.util.Optional.of(sender), 1F));
    }

    @Test
    void shouldThroResourceNotFoundException() throws Exception {
        Users sender = stub.createMerchantUser();

        when(repo.findUserById(100L))
                .thenReturn(Optional.empty());

        Assertions.assertNotNull(sender);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> user_service.getUserById(100L));
    }

}
