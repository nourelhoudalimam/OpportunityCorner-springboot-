package com.example.stage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.Entities.Gender;
import com.example.stage.Entities.Sexeuser;

@Repository
public interface SexeuserRepository extends CrudRepository<Sexeuser,Long> {
	Boolean existsByGender(Gender gender);}