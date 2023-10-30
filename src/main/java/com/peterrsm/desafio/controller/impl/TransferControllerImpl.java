package com.peterrsm.desafio.controller.impl;

import com.peterrsm.desafio.controller.interfaces.ITransferController;
import com.peterrsm.desafio.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferControllerImpl implements ITransferController {

    @Autowired
    TransferService service;

    @Override
    public String efetuaTransferencia(Long sender_id, Long receiver_id, Float ammount) throws Exception {
        return service.transferAmmount(sender_id, receiver_id, ammount);
    }

}
