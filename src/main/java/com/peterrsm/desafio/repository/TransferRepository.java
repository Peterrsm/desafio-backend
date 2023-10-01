package com.peterrsm.desafio.repository;

import com.peterrsm.desafio.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
