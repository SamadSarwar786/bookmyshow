package com.example.BMS.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "auditoriums")
public class Auditorium extends BaseModel{

    private String name;

    private int capacity;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "auditorium")
    @JsonIgnore
    private List<Show> showList;

    @OneToMany(mappedBy = "auditorium")
    @JsonIgnore
    private List<Seat> seatList;




}
