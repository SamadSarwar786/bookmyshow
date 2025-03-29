package com.example.BMS.services;

import com.example.BMS.models.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    boolean blockSeat(List<Long> seatIds, long userId);

    Optional<Ticket> bookTicket(List<Long> showSeatIds, long showId, long userId);

    void clearAllSeatLocks();

}
