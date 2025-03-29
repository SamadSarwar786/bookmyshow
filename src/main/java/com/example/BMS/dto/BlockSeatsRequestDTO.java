package com.example.BMS.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BlockSeatsRequestDTO {
    Long userId;
    List<Long> showSeatIds;
}
