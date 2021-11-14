package com.pesterenan.citiesapidio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pesterenan.citiesapidio.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
