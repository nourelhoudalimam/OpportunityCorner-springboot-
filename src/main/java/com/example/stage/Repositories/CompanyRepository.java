package com.example.stage.Repositories;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.Entities.Company;

import com.example.stage.Entities.Roleuser;


@Repository
public interface CompanyRepository extends CrudRepository<Company,Long>{
	Boolean existsByNom(String nom);
	Boolean existsByDomaine(String domaine);
	Boolean existsByLocalisation(String localisation);
	
	List<Company> findByNom(String nom);
	List<Company> findByDomaine(String domaine);
	List<Company> findByLocalisation(String localisation);
	List<Company> findByRolecomp(Roleuser ru);
}
