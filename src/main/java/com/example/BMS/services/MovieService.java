package com.example.BMS.services;

import com.example.BMS.models.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAllMovie();

    Optional<Movie> findById(long id);
}
