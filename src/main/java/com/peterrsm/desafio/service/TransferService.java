package com.peterrsm.desafio.service;

import com.peterrsm.desafio.controller.UsuarioController;
import com.peterrsm.desafio.entity.Transfer;
import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransferService {

    @Autowired
    TransferRepository repository;

    @Autowired
    UsuarioController user_controller;

    public void transferAmmount(Long senderId, Long receiverId, Float ammount) throws Exception {
        Users sender = user_controller.getUserById(senderId);
        Users receiver = user_controller.getUserById(receiverId);

        if (sender != null) {
            user_controller.validateSenderUserType(sender);
            user_controller.validateSenderAmmount(sender);

            System.out.println("Efetuando transferencia de " + sender.getFull_name() + " para " + receiver.getFull_name() +
                    " no valor de " + ammount);

            Transfer transfer = new Transfer();
            transfer.setAmmount(ammount);
            transfer.setReceiver(receiver);
            transfer.setSender(sender);
            transfer.setTimestamp(LocalDateTime.now());
            repository.save(transfer);

            sender.setPortfolio(sender.getPortfolio() - ammount);
            receiver.setPortfolio(receiver.getPortfolio() + ammount);

            user_controller.cadastraUser(sender);
            user_controller.cadastraUser(receiver);
        }
    }

}
