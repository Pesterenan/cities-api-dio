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

import com.pesterenan.citiesapidio.entities.Country;
import com.pesterenan.citiesapidio.repositories.CountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryResource {

	@Autowired
	private CountryRepository countryRepository;

	// Busca todos os países num response paginável
	@GetMapping
	public Page<Country> getCountries(Pageable page) {
		return countryRepository.findAll(page);
	}

	// Busca somente um país pelo ID informado
	@GetMapping("/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable Long id) {
		Optional<Country> optional = countryRepository.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok().body(optional.get());
		else
			return ResponseEntity.notFound().build();
	}

}
