package com.example.BMS.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "cities")
public class City extends BaseModel {

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theater> theaterList;

}
