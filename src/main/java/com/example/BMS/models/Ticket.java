package com.example.BMS.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tickets")
@Setter
@Getter
public class Ticket extends  BaseModel{

    private int amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @Enumerated(value = EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    @OneToMany(mappedBy = "ticket")
    private List<ShowSeat> showSeatList;
}
