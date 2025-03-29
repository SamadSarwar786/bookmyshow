package com.example.BMS.controllers;

import com.example.BMS.dto.BlockSeatsRequestDTO;
import com.example.BMS.dto.BookSeatsRequestDTO;
import com.example.BMS.models.Ticket;
import com.example.BMS.services.RedisBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {

    private final RedisBookingService redisBookingService;

    BookingController(RedisBookingService redisBookingService){
        this.redisBookingService = redisBookingService;
    }

    @DeleteMapping("/delete")
    public void deleteEntries(){
        redisBookingService.clearAllSeatLocks();
    }


    @PostMapping("/block")
    public boolean blockSeat(@RequestBody BlockSeatsRequestDTO blockSeatsRequestDTO){
        return redisBookingService.blockSeat(blockSeatsRequestDTO.getShowSeatIds(), blockSeatsRequestDTO.getUserId());
    }

    @PostMapping("/book")
    public Optional<Ticket> bookTicket(@RequestBody BookSeatsRequestDTO bookSeatsRequestDTO){
        return redisBookingService.bookTicket(bookSeatsRequestDTO.getShowSeatIds(), bookSeatsRequestDTO.getShowId(), bookSeatsRequestDTO.getUserId());
    }

}
