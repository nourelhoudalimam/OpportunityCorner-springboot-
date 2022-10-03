package com.example.stage.Services;
import java.io.IOException;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.CV;
import com.example.stage.Entities.Event;
import com.example.stage.Entities.Offre;
import com.example.stage.Entities.Roleuser;
import com.example.stage.Entities.Sexeuser;
import com.example.stage.Entities.Tips;

import com.example.stage.Entities.User;
import com.example.stage.Repositories.EventRepository;
import com.example.stage.Repositories.OffreRepository;
import com.example.stage.Repositories.RoleRepository;
import com.example.stage.Repositories.SexeuserRepository;
import com.example.stage.Repositories.TipsRepository;
import com.example.stage.Repositories.UserRepository;

@Service
public class UserService implements InterfaceUserService {
	@Autowired
	UserRepository usrRep;
	@Autowired
	TipsRepository Trep;
	@Autowired
	EventRepository evrep;
	@Autowired
	RoleRepository rolerep;
	@Autowired
	OffreRepository offrep;
	@Autowired
	CvService cvsrv;
	@Autowired
	SexeuserRepository sexrep;
	@Override
	public User AddUser(User u,Long idRole,Long idSex) {
		// TODO Auto-generated method stub
		Roleuser ru=rolerep.findById(idRole).get();
		u.setRoleusers(ru);
		
		Sexeuser su=sexrep.findById(idSex).get();
		u.setSexuser(su);
		return usrRep.save(u);
	}
	@Override
	public List<User> AddEnsUser(List<User> lu) {
		// TODO Auto-generated method stub
		return (List<User>) usrRep.saveAll(lu);
	}
	@Override
	public String addUserWithPW(User u) {
		// TODO Auto-generated method stub
		String ch="";
		if(u.getPassword().equals(u.getConfpassword())) {usrRep.save(u);
		ch="user create";}
		else {ch="confirmed password is wrong !!";}
		return ch;
	}
	@Override
	public String addUserWithTestUsername(User user,Long idRole,Long idSex) {
		// TODO Auto-generated method stub
		String ch="";
		if( usrRep.existsByUsername(user.getUsername())) {ch="username exist";}
		else {Roleuser ru=rolerep.findById(idRole).get();
		user.setRoleusers(ru);
		
		Sexeuser su=sexrep.findById(idSex).get();
		user.setSexuser(su);usrRep.save(user);ch="user created";}
	return ch;}
	@Override
	public User UpdateUser(User u, Long id) {
		User us=usrRep.findById(id).get();
		us.setFullname(u.getFullname());
		us.setPassword(u.getPassword());
		us.setRoleusers(u.getRoleusers());
		us.setSexuser(us.getSexuser());
		usrRep.save(us);
		return us;
	}
	@Override
	public void DeleteUser(Long id) {
		// TODO Auto-generated method stub
		usrRep.deleteById(id);
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) usrRep.findAll();
	}
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return usrRep.findById(id).orElse(null);
	}
	@Override
	public User addSavedTipUser(Long idUser, Long idTip) {
		// TODO Auto-generated method stub
		User us=usrRep.findById(idUser).get();
		Tips t=Trep.findById(idTip).get();
		us.addSavedTip(t);
		return usrRep.save(us);
	}
	@Override
	public User addParticipateEvent(Long idUser, Long idev) {
		// TODO Auto-generated method stub
		User us=usrRep.findById(idUser).get();
		Event e=evrep.findById(idev).get();
		us.addParticipatedEvent(e);
		return usrRep.save(us);
	}
	@Override
	public List<Long> ListUserByIdTip() {
		// TODO Auto-generated method stub
		return  usrRep.getUserByIdTip();
	}
	@Override
	public List<Long> ListUserByIdEvent() {
		// TODO Auto-generated method stub
		return usrRep.getUserByIdEvent();
	}
	@Override
	public List<Long> ListUserByIdTipSaisi(Long idTip) {
		// TODO Auto-generated method stub
		return usrRep.getUserByIdTipSaisi(idTip);
	}
	@Override
	public List<Long> ListUserByIdEventSaisi(Long idev) {
		// TODO Auto-generated method stub
		return usrRep.getUserByIdEventSaisi(idev);
	}

	

	@Override
	public Set<User> findUsersByIdTip(Long idtip) {
		// TODO Auto-generated method stub
		Tips t=Trep.findById(idtip).get();
		return t.getListUserSave();
	}
	@Override
	public 	Set<User> findUsersByIdEvent(Long idev) {
		// TODO Auto-generated method stub
		Event e=evrep.findById(idev).get();
		return e.getListUserParticipate();
	}
	
	public User addCVUser(Long idUser,MultipartFile cv) {
		User u =usrRep.findById(idUser).get();
		try {
			CV c=cvsrv.uploadCv(cv);
			u.setCv(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usrRep.save(u);
	}
	@Override
	public List<Long> ListUserByIdOffer() {
		// TODO Auto-generated method stub
		return usrRep.getUserByIdOffre();
	}
	@Override
	public List<Long> ListUserByIdOfferSaisi(Long idoff) {
		// TODO Auto-generated method stub
		return usrRep.getUserByIdEventSaisi(idoff);
	}
	@Override
	public Set<User> findUsersByIdOffer(Long idoff) {
		// TODO Auto-generated method stub
		Offre o=offrep.findById(idoff).get();
		return o.getListCandPostul(); 

	}
	@Override
	public User addOfferUser(Long idUser, Long idOff) {
		// TODO Auto-generated method stub
		User us=usrRep.findById(idUser).get();
		Offre o=offrep.findById(idOff).get();
		us.addOffre(o);
		return usrRep.save(us);
	}
	@Override
	public List<User> ListUsersByIdRole(Long idrole) {
		// TODO Auto-generated method stub

		Roleuser ru=rolerep.findById(idrole).get();
		return usrRep.findByRoleusers(ru);
	}
	@Override
	public Roleuser getRoleByIdUser(Long iduser) {
		// TODO Auto-generated method stub
		User u=usrRep.findById(iduser).get();
		return u.getRoleusers();
	}
	@Override
	public List<User> ListUsersByIdSex(Long idsex) {
		// TODO Auto-generated method stub
		Sexeuser su=sexrep.findById(idsex).get();
		return usrRep.findBySexuser(su);
	}
	@Override
	public Sexeuser getGenderByIdUser(Long idsex) {
		// TODO Auto-generated method stub
		User u=usrRep.findById(idsex).get();
		return u.getSexuser();
	}
	
	
	
	
	
	

}


