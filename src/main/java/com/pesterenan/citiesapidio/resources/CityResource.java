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

import com.pesterenan.citiesapidio.entities.City;
import com.pesterenan.citiesapidio.repositories.CityRepository;

@RestController
@RequestMapping("/cities")
public class CityResource {

	@Autowired
	private CityRepository cityRepository;

	// Busca todas as cidades num response paginável
	@GetMapping
	public Page<City> getCities(Pageable page) {
		return cityRepository.findAll(page);
	}

	// Busca somente uma cidade pelo ID informado
	@GetMapping("/{id}")
	public ResponseEntity<City> getCity(@PathVariable Long id) {
		Optional<City> optional = cityRepository.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok().body(optional.get());
		else
			return ResponseEntity.notFound().build();
	}

}
