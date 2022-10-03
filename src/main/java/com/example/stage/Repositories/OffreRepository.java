package com.example.stage.Repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.Entities.Company;

import com.example.stage.Entities.Offre;


@Repository
public interface OffreRepository  extends CrudRepository<Offre,Long> {
	Boolean existsByPoste(String poste);
	Boolean existsByDescription(String description);
	Offre findByPoste(String poste);
	List<Offre> findByCompany(Company comp);
}
