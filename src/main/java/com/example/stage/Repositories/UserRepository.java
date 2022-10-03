package com.example.stage.Repositories;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.stage.Entities.Roleuser;
import com.example.stage.Entities.Sexeuser;
import com.example.stage.Entities.User;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

	
Boolean existsByUsername(String username);
@Query(value ="select id from user_tips  where idtip=1",nativeQuery=true)
List<Long> getUserByIdTip();
@Query(value ="select id from user_events  where idev=1",nativeQuery=true)
List<Long> getUserByIdEvent();

@Query(value ="select id from user_events  where idev=?1",nativeQuery=true)
List<Long> getUserByIdEventSaisi(Long idev);
@Query(value ="select id from user_tips  where idtip=?1",nativeQuery=true)
List<Long> getUserByIdTipSaisi(Long idTip);
@Query(value ="select id from user_offre  where id_off=?1",nativeQuery=true)
List<Long> getUserByIdOffreSaisi(Long idRole);
@Query(value ="select id from user_offre  where id_off=1",nativeQuery=true)
List<Long> getUserByIdOffre();
List<User> findByRoleusers(Roleuser ru);
List<User> findBySexuser(Sexeuser su);
User findByUsername(String username);



}
