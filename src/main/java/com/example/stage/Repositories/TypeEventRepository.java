package com.example.stage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.Entities.TypeEvent;
import com.example.stage.Entities.Typeev;
@Repository
public interface TypeEventRepository extends CrudRepository<TypeEvent,Long> {
	Boolean existsByType(Typeev type);
}
