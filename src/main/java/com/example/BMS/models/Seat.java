package com.example.BMS.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "seats")
public class Seat extends  BaseModel{

    private String seatNumber;

    private int rowValue;
    private int colValue;

    @Enumerated(value = EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne
    @JsonIgnore
    private Auditorium auditorium;

}
