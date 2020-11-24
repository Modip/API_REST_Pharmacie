package com.modip.spring_API_REST;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PharmacieController {

	@Autowired

	private PharmacieService service;

	@GetMapping("/api_rest/pharmacies")
	public List<Pharmacie> list() {
		return service.listAll();
	}

	@GetMapping("/api_rest/pharmacies/{id}")
	public ResponseEntity<Pharmacie> get(@PathVariable Integer id) {
		try {
			Pharmacie pharmacie = service.get(id);

		return new ResponseEntity<Pharmacie>(pharmacie, HttpStatus.OK);	
		
		} catch (NoSuchElementException e) {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);		

		}
	}

	@PostMapping("api_rest/pharmacie")
	public void add(@RequestBody Pharmacie pharmacie) {
		service.save(pharmacie);

	}

	@PutMapping("/api_rest/pharmacie/{id}")
	public ResponseEntity<?> update(@RequestBody Pharmacie pharmacie, @PathVariable Integer id) {
		try {
			Pharmacie existPharmacie = service.get(id);
			service.save(pharmacie);
			return new ResponseEntity<>(HttpStatus.OK);		
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		
	}

	@DeleteMapping("/api_rest/pharmacie/{id}")

	public void delete(@PathVariable Integer id) {

		service.delete(id);
	}

}
