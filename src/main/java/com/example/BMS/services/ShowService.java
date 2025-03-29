package com.example.BMS.services;

import com.example.BMS.models.Show;

import java.util.List;
import java.util.Optional;

public interface ShowService {

    Optional<Show> createShow();

    List<Show> getAllShows();

    Optional<Show> getShowById(long id);
}
