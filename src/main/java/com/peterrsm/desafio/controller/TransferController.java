package com.peterrsm.desafio.controller;

import com.peterrsm.desafio.entity.Transfer;
import com.peterrsm.desafio.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    TransferService service;

    @PostMapping("/{sender_id}/{receiver_id}/{ammount}")
    public void efetuaTransferencia(@PathVariable("receiver_id") Long receiver_id, @PathVariable("sender_id") Long sender_id, @PathVariable("ammount") Float ammount) {
        try {
            service.transferAmmount(sender_id, receiver_id, ammount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
