package com.modip.spring_API_REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacieService {
	
	@Autowired
	private PharmacieRepository repo;
	
	public List<Pharmacie> listAll(){
		return repo.findAll();
		
		}
	
	public void save (Pharmacie pharmacie) {
		repo.save(pharmacie);
	}
	
	public Pharmacie get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
