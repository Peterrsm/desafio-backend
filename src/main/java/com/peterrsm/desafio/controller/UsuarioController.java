package com.peterrsm.desafio.controller;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.entity.dto.UsersDTO;
import com.peterrsm.desafio.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    UsersService service;

    @GetMapping("/transfer/{receiverId}/{senderId}")
    public String availableInitialization() {
        return "Está vivo!!!";
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable(value = "id") Long id) throws Exception {
        return service.getUserById(id);
    }

    @PostMapping("/")
    public Users cadastraUser(@Valid @RequestBody UsersDTO user) {
        return service.saveUser(user);
    }

    public Users updateUser(Users user) {
        return service.updateUser(user);
    }

    @GetMapping("/")
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }

    public Boolean validateSenderAmmount(Users sender, Float ammount) throws Exception {
        return service.validateSenderAmmount(Optional.ofNullable(sender), ammount);
    }

    public Boolean validateSenderUserType(Users sender) throws Exception {
        return service.validateSenderUserType(Optional.ofNullable(sender));
    }
}
