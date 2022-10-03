package com.example.stage.Repositories;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.Entities.Tips;
@Repository
public interface TipsRepository extends CrudRepository <Tips,Long>  {
	Boolean existsByContenu(String contenu);
	Boolean existsByTitrecons(String titrecons);
	List<Tips> findByTitrecons(String titrecons);
}