package com.example.BMS.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Getter
@Setter
public class Show extends  BaseModel {

    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Auditorium auditorium;

    @OneToMany(mappedBy = "show")
    @JsonIgnore
    private List<ShowSeat> showSeatList;

}
