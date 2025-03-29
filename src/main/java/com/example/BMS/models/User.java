package com.example.BMS.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User extends  BaseModel{
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Ticket> ticketList;

}
