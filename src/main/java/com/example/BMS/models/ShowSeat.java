package com.example.BMS.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "show_seats")
public class ShowSeat extends BaseModel{

    @ManyToOne
    @JsonIgnore
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(value = EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;

    @ManyToOne
    @JsonIgnore
    private Ticket ticket;
}
