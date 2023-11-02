package com.peterrsm.desafio.service;

import com.peterrsm.desafio.controller.impl.TransferControllerImpl;
import com.peterrsm.desafio.controller.impl.UsuarioControllerImpl;
import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.enumerator.UsersTypeEnum;
import com.peterrsm.desafio.repository.TransferRepository;
import com.peterrsm.desafio.service.exceptions.MerchantSenderException;
import com.peterrsm.desafio.service.exceptions.NoFundException;
import com.peterrsm.desafio.stubs.UsersStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;

class TransferServiceTest {

    @Mock
    TransferRepository repository;

    @Mock
    UsersService user_service;

    @Mock
    TransferControllerImpl controller;

    @Mock
    UsuarioControllerImpl usuario_controller;

    @Autowired
    @InjectMocks
    TransferService service;

    UsersStub stub = new UsersStub();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void concludeTransferWithSuccess() throws Exception {
        Users sender = stub.createCommonUser();
        Users receiver = stub.createMerchantUser();
        Float ammount = 10F;

        when(usuario_controller.getUserById(1L)).thenReturn(sender);
        when(usuario_controller.getUserById(2L)).thenReturn(receiver);
        when(usuario_controller.validateSenderAmmount(sender, ammount))
                .thenReturn(Boolean.TRUE);
        when(usuario_controller.validateSenderAmmount(receiver, ammount))
                .thenThrow(NoFundException.class);

        Assertions.assertNotNull(sender);
        Assertions.assertNotNull(receiver);
        Assertions.assertEquals(sender.getType(), UsersTypeEnum.COMMON);
        Assertions.assertEquals(sender.getPortfolio(), 500);
        Assertions.assertEquals(receiver.getPortfolio(), 500);
        Assertions.assertEquals("Transferência efetuada", service.transferAmmount(1L, 2L, ammount));
        Assertions.assertEquals(sender.getPortfolio(), 490);
        Assertions.assertEquals(receiver.getPortfolio(), 510);
    }

    @Test
    void shouldThrowMerchantSenderException() throws Exception {
        Users userOne = stub.createCommonUser();
        Users userTwo = stub.createMerchantUser();
        Float ammount = 10F;

        when(usuario_controller.getUserById(2L)).thenReturn(userOne);
        when(usuario_controller.getUserById(1L)).thenReturn(userTwo);
        when(usuario_controller.validateSenderUserType(userTwo))
                .thenThrow(MerchantSenderException.class);

        Assertions.assertNotNull(userOne);
        Assertions.assertNotNull(userTwo);
        Assertions.assertThrows(MerchantSenderException.class, () -> service.transferAmmount(1L, 2L, ammount));
    }

}
