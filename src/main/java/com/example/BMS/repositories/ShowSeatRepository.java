package com.example.BMS.repositories;

import com.example.BMS.models.ShowSeat;
import com.example.BMS.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    List<ShowSeat> findAllByShowIdAndSeatIdIn(Long showId , List<Long> seatIds);

    List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);
    @Modifying   // required for update query
    @Query("UPDATE ShowSeat s SET s.ticket = :ticket, s.showSeatStatus = 1 where s.id IN :showSeatIds")
    void bookShowSeatsBulk(@Param("showSeatIds") List<Long> showSeatIds, @Param("ticket") Ticket ticket);

}
