package com.example.BMS.services;

import com.example.BMS.models.Show;
import com.example.BMS.repositories.ShowRepository;

import java.util.List;
import java.util.Optional;

public class ShowServiceImpl implements ShowService{

    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository){
        this.showRepository = showRepository;
    }

    @Override
    public Optional<Show> createShow() {
        return Optional.empty();
    }

    @Override
    public List<Show> getAllShows() {
        return this.showRepository.findAll();
    }

    @Override
    public Optional<Show> getShowById(long id) {
        return this.showRepository.findById(id);
    }
}
