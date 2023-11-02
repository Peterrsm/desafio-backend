package com.peterrsm.desafio.mapper;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.entity.dto.UsersDTO;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {
    public Users toUsers(UsersDTO usersDTO) {
        Users user = Users.builder()
                .email(usersDTO.getEmail())
                .document(usersDTO.getDocument())
                .full_name(usersDTO.getFull_name())
                .password(usersDTO.getPassword())
                .portfolio(usersDTO.getPortfolio())
                .type(usersDTO.getType())
                .build();

        return user;
    }

}
