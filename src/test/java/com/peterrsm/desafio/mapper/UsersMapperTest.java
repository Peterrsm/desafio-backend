package com.peterrsm.desafio.mapper;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.entity.dto.UsersDTO;
import com.peterrsm.desafio.enumerator.UsersTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UsersMapperTest {

    @InjectMocks
    UsersMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnUsersEntity() {
        UsersDTO users_dto = UsersDTO.builder()
                .document("111111")
                .email("mail@mail.com")
                .full_name("full name")
                .password("pass")
                .portfolio(1000.0)
                .type(UsersTypeEnum.MERCHANT)
                .build();

        Users users = mapper.toUsers(users_dto);

        Assertions.assertNotNull(users);
        Assertions.assertNotNull(users.getType());
        Assertions.assertNotNull(users.getPortfolio());
        Assertions.assertNotNull(users.getFull_name());
        Assertions.assertNotNull(users.getEmail());
        Assertions.assertNotNull(users.getDocument());
        Assertions.assertNull(users.getId());
    }
}