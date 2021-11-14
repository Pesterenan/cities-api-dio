package com.pesterenan.citiesapidio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pesterenan.citiesapidio.entities.Country;

public interface CountryRepository extends JpaRepository<Country,Long>{

}
