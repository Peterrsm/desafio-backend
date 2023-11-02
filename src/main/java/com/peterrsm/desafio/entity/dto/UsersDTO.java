package com.peterrsm.desafio.entity.dto;

import com.peterrsm.desafio.enumerator.UsersTypeEnum;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UsersDTO implements Serializable {
    private Double portfolio;
    private String full_name;
    private String document;
    private String email;
    private String password;
    private UsersTypeEnum type;

    @Override
    public String toString() {
        return "UsersDTO{" +
                "portfolio=" + portfolio +
                ", full_name='" + full_name + '\'' +
                ", document='" + document + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
