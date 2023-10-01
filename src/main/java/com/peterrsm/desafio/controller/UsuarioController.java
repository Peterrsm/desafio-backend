package com.peterrsm.desafio.controller;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Users getUserById(@PathVariable(value = "id") Long id) {
        try {
            return service.getUserById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/")
    public Users cadastraUser(@RequestBody Users user) {
        try {
            service.saveUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    @GetMapping("/")
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }

    public Boolean validateSenderAmmount(Users sender) throws Exception {
        return service.validateSenderAmmount(Optional.ofNullable(sender));
    }

    public Boolean validateSenderUserType(Users sender) throws Exception {
        return service.validateSenderUserType(Optional.ofNullable(sender));
    }
}
