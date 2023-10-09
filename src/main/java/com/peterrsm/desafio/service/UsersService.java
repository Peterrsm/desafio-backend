package com.peterrsm.desafio.service;

import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.enumerator.UsersTypeEnum;
import com.peterrsm.desafio.repository.UsersRepository;
import com.peterrsm.desafio.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository repo;

    public Boolean validateSenderAmmount(Optional<Users> user) throws Exception {
        if (user.get().getPortfolio() > 0)
            return true;
        throw new Exception("Saldo insuficiente.");
    }

    public Boolean validateSenderUserType(Optional<Users> user) throws Exception {
        if (!user.get().getType().equals(UsersTypeEnum.MERCHANT))
            return true;
        else {
            throw new Exception("Sender inválido.");
        }
    }

    public Users saveUser(Users user) {
        System.out.println("Inserindo novo user...");
        return repo.save(user);
    }

    public List<Users> getAllUsers() {
        return repo.findAll();
    }

    public Users getUserById(Long id) throws Exception {
        Optional<Users> usuario = repo.findUserById(id);
        return usuario
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}