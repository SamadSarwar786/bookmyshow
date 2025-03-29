package com.example.BMS.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookSeatsRequestDTO {
    Long showId;
    Long userId;
    List<Long> showSeatIds;

}
