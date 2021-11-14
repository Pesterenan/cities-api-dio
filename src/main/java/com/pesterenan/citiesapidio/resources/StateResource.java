package com.pesterenan.citiesapidio.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pesterenan.citiesapidio.entities.State;
import com.pesterenan.citiesapidio.repositories.StateRepository;

@RestController
@RequestMapping("/states")
public class StateResource {

	@Autowired
	private StateRepository stateRepository;

	// Busca todos os estados num response paginável
	@GetMapping
	public Page<State> getStates(Pageable page) {
		return stateRepository.findAll(page);
	}

	// Busca somente um estado pelo ID informado
	@GetMapping("/{id}")
	public ResponseEntity<State> getState(@PathVariable Long id) {
		Optional<State> optional = stateRepository.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok().body(optional.get());
		else
			return ResponseEntity.notFound().build();
	}

}
