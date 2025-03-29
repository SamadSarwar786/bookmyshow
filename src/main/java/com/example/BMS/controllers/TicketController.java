package com.example.BMS.controllers;

import com.example.BMS.models.Ticket;
import com.example.BMS.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/{id}")
    public Optional<Ticket> getTicketById(@PathVariable Long id){
       return ticketRepository.findById(id);
    }
}

