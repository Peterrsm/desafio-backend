package com.peterrsm.desafio.controller.interfaces;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public interface ITransferController {

    @PostMapping("/{sender_id}/{receiver_id}/{ammount}")
    String efetuaTransferencia(final @Valid @PathVariable("sender_id") Long sender_id,
                               final @Valid @PathVariable("receiver_id") Long receiver_id,
                               final @Valid @PathVariable("ammount") Float ammount)
            throws Exception;
}