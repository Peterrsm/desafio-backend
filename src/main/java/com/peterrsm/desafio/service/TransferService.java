package com.peterrsm.desafio.service;

import com.peterrsm.desafio.controller.UsuarioController;
import com.peterrsm.desafio.entity.Transfer;
import com.peterrsm.desafio.entity.Users;
import com.peterrsm.desafio.repository.TransferRepository;
import com.peterrsm.desafio.service.exceptions.InvalidUserException;
import com.peterrsm.desafio.service.exceptions.NoFundException;
import com.peterrsm.desafio.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransferService {

    @Autowired
    TransferRepository repository;

    @Autowired
    UsuarioController user_controller;

    public String transferAmmount(Long sender_id, Long receiver_id, Float ammount) throws Exception {
        Users sender = user_controller.getUserById(sender_id);
        Users receiver = user_controller.getUserById(receiver_id);

        if (sender != null && receiver != null) {
            user_controller.validateSenderUserType(sender);
            user_controller.validateSenderAmmount(sender, ammount);

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

            return "Transferência efetuada";
        }
        else{
            throw new ResourceNotFoundException();
        }
    }

}
