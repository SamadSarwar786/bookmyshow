package com.example.BMS.services;

import com.example.BMS.models.*;
import com.example.BMS.repositories.ShowRepository;
import com.example.BMS.repositories.ShowSeatRepository;
import com.example.BMS.repositories.TicketRepository;
import com.example.BMS.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RedisBookingService implements BookingService {

    private final CacheService cacheService;
    private final ShowSeatRepository showSeatRepository;
    private final TicketRepository ticketRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    RedisBookingService(CacheService cacheService, ShowSeatRepository showSeatRepository, TicketRepository ticketRepository, ShowRepository showRepository, UserRepository userRepository, EntityManager entityManager){
        this.cacheService = cacheService;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @Override
    public boolean blockSeat(List<Long> showSeatIds, long userId) {
        //1. check if the seats is already booked or not in main db

          //1.1 get all the showSeats along with that show
//        List<ShowSeat> showSeats = showSeatRepository.findAllByShowIdAndSeatIdIn(showId,showSeatIds);
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        for(ShowSeat showSeat : showSeats){
           if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.BOOKED))
               return false;
        }


        //2, if not then check the seats is locked or not in redis
        for(ShowSeat showSeat : showSeats){
         String status = cacheService.get(showSeat.getId().toString());
         if(status != null){
             return false;
         }
        }

        // 3. if not then locked the seats in redis
        for(ShowSeat showSeat : showSeats) {
            cacheService.set(showSeat.getId().toString(),String.valueOf(userId));
            // key - showSeatId , value - usedId
        }

        return true;
    }

    @Override
    @Transactional
    public Optional<Ticket> bookTicket(List<Long> showSeatIds, long showId , long userId) {
         // 1. check all seat are not booked
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);
        for(ShowSeat showSeat : showSeats){
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.BOOKED)){
                return Optional.empty();
            }
        }

        //2. if not booked then check all seat are locked and have key in redis with the value of userId
        for(ShowSeat showSeat : showSeats){
           String value = cacheService.get(showSeat.getId().toString());
           if(value == null || !value.equals(String.valueOf(userId))){
               return Optional.empty();
           }
        }


        //3. if locked and booking by the same user , then booked the ticket
        User user = userRepository.findById(userId).get();
        Show show = showRepository.findById(showId).get();

        Ticket ticket = createTicketAndBookSeat(showSeatIds, show, user);
        return Optional.of(ticket);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    Ticket createTicketAndBookSeat(List<Long> showSeatIds, Show show , User user){
        Ticket ticket = new Ticket();
        ticket.setShow(show);
        ticket.setUser(user);
        ticket.setAmount(100);
        ticket.setTicketStatus(TicketStatus.BOOKED);

        ticket  = ticketRepository.save(ticket);
        showSeatRepository.bookShowSeatsBulk(showSeatIds, ticket);
//        List<ShowSeat> showSeatList = showSeatRepository.findAllByIdIn(showSeatIds);
//        ticket.setShowSeatList(showSeatList);
//        ticketRepository.save(ticket      );
        entityManager.refresh(ticket);
        return ticket;
    }

    @Override
    public void clearAllSeatLocks() {
        cacheService.deleteAll();
    }
}
