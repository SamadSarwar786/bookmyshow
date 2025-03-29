package com.example.BMS.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "movies")
@Setter
@Getter
public class Movie extends BaseModel{

    private String name;
    private String poster;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<Show> showList;

}
