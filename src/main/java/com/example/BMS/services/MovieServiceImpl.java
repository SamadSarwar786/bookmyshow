package com.example.BMS.services;

import com.example.BMS.models.Movie;
import com.example.BMS.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    @Override
    public List<Movie> findAllMovie(){
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(long id){
        return movieRepository.findById(id);
    }


}
