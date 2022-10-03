package com.example.stage.Services;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;


import com.example.stage.Entities.Roleuser;
import com.example.stage.Entities.Sexeuser;
import com.example.stage.Entities.User;

public interface InterfaceUserService {
public User AddUser(User u,Long idRole,Long idSex);
public List<User> AddEnsUser(List <User> lu);
public String addUserWithPW(User u);
public String addUserWithTestUsername(	User  user,Long idRole,Long idSex);
public User UpdateUser(User u,Long id);
public void DeleteUser(Long id);
public List<User> getAllUsers();
public User getUserById(Long id);
public User addSavedTipUser(Long idUser,Long idTip);
public User addParticipateEvent(Long idUser,Long idev);
public List<Long> ListUserByIdTip();
public List<Long> ListUserByIdEvent();
public List<Long> ListUserByIdTipSaisi(Long idTip);
public List<Long> ListUserByIdEventSaisi(Long idev);


public Set<User> findUsersByIdTip(Long idtip);
public Set<User> findUsersByIdEvent(Long idev);
public User addCVUser(Long idUser,MultipartFile cv) ;
public List<Long> ListUserByIdOffer();
public List<Long> ListUserByIdOfferSaisi(Long idoff);
public Set<User> findUsersByIdOffer(Long idoff);
User addOfferUser(Long idUser, Long idOff);
public List<User> ListUsersByIdRole(Long idrole);
public Roleuser getRoleByIdUser(Long iduser);
public List<User> ListUsersByIdSex(Long idsex);
public Sexeuser getGenderByIdUser(Long idsex);

}

