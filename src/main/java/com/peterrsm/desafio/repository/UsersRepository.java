package com.peterrsm.desafio.repository;

import com.peterrsm.desafio.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUserByDocument(String document);

    Users findUserById(Long id);
}
