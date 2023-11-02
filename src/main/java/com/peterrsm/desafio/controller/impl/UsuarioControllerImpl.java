package com.peterrsm.desafio.controller.impl;

import com.peterrsm.desafio.controller.interfaces.IUsuarioController;
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
public class UsuarioControllerImpl implements IUsuarioController {

    @Autowired
    UsersService service;

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable(value = "id") Long id) throws Exception {
        return service.getUserById(id);
    }

    @PostMapping("/")
    public Users createUser(@Valid @RequestBody UsersDTO userDTO) {
        return service.saveUser(userDTO);
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
