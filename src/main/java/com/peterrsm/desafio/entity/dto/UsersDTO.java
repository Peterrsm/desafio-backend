package com.peterrsm.desafio.entity.dto;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.enumerator.UsersTypeEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UsersDTO {
    private Double portfolio;
    private String full_name;
    private String document;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UsersTypeEnum type;

    public Users toUsers(){
        Users user = Users.builder()
                .email(this.email)
                .document(this.document)
                .full_name(this.full_name)
                .password(this.password)
                .portfolio(this.portfolio)
                .type(this.type)
                .build();

        return  user;
    }
}
