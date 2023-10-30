package com.peterrsm.desafio.controller.interfaces;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.entity.dto.UsersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IUsuarioController {

    @GetMapping("/transfer/{receiverId}/{senderId}")
    String availableInitialization();

    @GetMapping("/{id}")
    Users getUserById(@PathVariable(value = "id") Long id) throws Exception;

    @PostMapping("/")
    Users cadastraUser(@Valid @RequestBody UsersDTO user);

    Users updateUser(Users user);

    @GetMapping("/")
    List<Users> getAllUsers();

    Boolean validateSenderAmmount(Users sender, Float ammount) throws Exception;

    Boolean validateSenderUserType(Users sender) throws Exception;
}
