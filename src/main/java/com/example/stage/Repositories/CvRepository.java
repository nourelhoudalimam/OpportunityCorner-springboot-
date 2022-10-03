package com.example.stage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.Entities.CV;
@Repository
public interface CvRepository extends CrudRepository<CV,Long> {

}
