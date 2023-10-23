package com.peterrsm.desafio.service;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.enumerator.UsersTypeEnum;
import com.peterrsm.desafio.service.exceptions.MerchantSenderException;
import com.peterrsm.desafio.service.exceptions.NoFundException;
import com.peterrsm.desafio.stubs.UsersStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;


class UsersServiceTest {

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

}
