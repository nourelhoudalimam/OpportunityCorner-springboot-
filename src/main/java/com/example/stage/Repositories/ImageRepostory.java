package com.example.stage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.Entities.Image;

@Repository
public interface ImageRepostory extends CrudRepository<Image,Long> {

}
