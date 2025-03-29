package com.example.BMS.controllers;

import com.example.BMS.models.Seat;
import com.example.BMS.models.ShowSeat;
import com.example.BMS.repositories.SeatRepository;
import com.example.BMS.repositories.ShowSeatRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowSeatController {

    private final ShowSeatRepository showSeatRepository;

    public ShowSeatController(ShowSeatRepository showSeatRepository){
        this.showSeatRepository = showSeatRepository;
    }

    @GetMapping("/api/v1/getAllSeats")
    public List<ShowSeat> getAllSeats(){
        return showSeatRepository.findAll();
    }



}
