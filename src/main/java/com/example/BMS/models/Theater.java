package com.example.BMS.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "theaters")
public class Theater extends  BaseModel {

    private String name;
    private String address;
    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "theater")
    @JsonIgnore
    private List<Auditorium> auditoriumList;


}
