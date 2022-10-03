package com.example.stage.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stage.Entities.Role;
import com.example.stage.Entities.Roleuser;
@Repository
public interface RoleRepository extends CrudRepository<Roleuser,Long>{
	Boolean existsByRole(Role role);
}
