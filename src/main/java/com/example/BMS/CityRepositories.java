package com.example.BMS;

import com.example.BMS.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepositories extends JpaRepository<City, Long> {

}
