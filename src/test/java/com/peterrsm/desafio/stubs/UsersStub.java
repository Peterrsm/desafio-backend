package com.peterrsm.desafio.stubs;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.enumerator.UsersTypeEnum;

public class UsersStub {
    public Users createMerchantUser() {
        return Users.builder()
                .type(UsersTypeEnum.MERCHANT)
                .portfolio(500.00)
                .password("1234")
                .full_name("Merchant User")
                .document("5678")
                .email("merchant@user.com")
                .id(1L)
                .build();
    }

    public Users createCommonUser() {
        return Users.builder()
                .type(UsersTypeEnum.COMMON)
                .portfolio(500.00)
                .password("4321")
                .full_name("Common User")
                .document("8765")
                .email("common@user.com")
                .id(2L)
                .build();
    }
}
