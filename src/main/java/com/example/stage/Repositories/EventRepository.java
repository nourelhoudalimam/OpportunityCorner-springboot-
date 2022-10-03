package com.example.stage.Repositories;



import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.Entities.Event;
import com.example.stage.Entities.TypeEvent;
@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
    Boolean existsByDevent(Date devent);
	Boolean existsByLieu(String Lieu);
	Set<Event> findByTitre(String titre);
	
	List<Event> findByLieu(String lieu);
	List<Event> findByOrga(String orga);
	
	List<Event> findByTypeev(TypeEvent te);
	
}
