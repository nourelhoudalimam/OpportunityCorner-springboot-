package com.example.stage.Controller;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.Roleuser;
import com.example.stage.Entities.Sexeuser;
import com.example.stage.Entities.User;
import com.example.stage.Services.UserService;
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
@Autowired
UserService usrserv;
@PostMapping("/AddUser/{idRole}/{idSex}")
@ResponseBody
public User AddUser(@RequestBody User u,@PathVariable("idRole") Long idRole,@PathVariable("idSex") Long idSex ) {return usrserv.AddUser(u, idRole, idSex);}
@PostMapping("/addListUser")
@ResponseBody
public List<User> addListUsers(@RequestBody List<User> li) {return usrserv.AddEnsUser(li);}
@PostMapping("/addUserWithPassword")
@ResponseBody
public String addUserWpw(@RequestBody User u) {return usrserv.addUserWithPW(u);}
@PostMapping("/addUserWithUsername/{idRole}/{idg}")
@ResponseBody
public String addUserWithUsername(@RequestBody User u,@PathVariable("idRole") Long idRole,@PathVariable("idg") Long idg) {return usrserv.addUserWithTestUsername(u, idRole, idg);}
@PostMapping("/UpdateUser/{idUser}")
@ResponseBody
public 	User UpdateUser(@RequestBody User u ,@PathVariable("idUser") Long idUser) {return usrserv.UpdateUser(u, idUser);}
@DeleteMapping("/deleteUser/{id}")
@ResponseBody
public void DeleteUser(@PathVariable("id") Long id) {usrserv.DeleteUser(id);}
@GetMapping("/getAllUsers")
@ResponseBody
public List<User> getAllUsers() {
	// TODO Auto-generated method stub
	return usrserv.getAllUsers();
}

@GetMapping("/getUser/{idUser}")
@ResponseBody
public User getUserById(@PathVariable("idUser") Long id) {
	// TODO Auto-generated method stub
	return usrserv.getUserById(id);
}
@GetMapping("/getIdUserByIdTip")
@ResponseBody
public List<Long> getIdUserByIdTip() {
	// TODO Auto-generated method stub
	return usrserv.ListUserByIdTip();
}
@GetMapping("/IdUserByIdTipSaisi/{idtip}")
@ResponseBody
public List<Long> getIdUserByIdTipSaisi(@PathVariable("idtip") Long idtip) {
	// TODO Auto-generated method stub
	return usrserv.ListUserByIdTipSaisi(idtip);
}
@GetMapping("/IdUserByIdEventSaisi/{idev}")
@ResponseBody
public List<Long> getIdUserByIdEventSaisi(@PathVariable("idev") Long idev) {
	// TODO Auto-generated method stub
	return usrserv.ListUserByIdTipSaisi(idev);
}
@GetMapping("/getIdUserByIdEvent")
@ResponseBody
public List<Long> getIdUserByIdEvent() {
	// TODO Auto-generated method stub
	return usrserv.ListUserByIdEvent();
}
@PostMapping("/AddSavedTipUser/{idUser}/{idTip}")
@ResponseBody
public User AddSavedTipUser(@PathVariable("idUser") Long idUser,@PathVariable("idTip") Long idTip) {return usrserv.addSavedTipUser(idUser, idTip);}
@PostMapping("/AddParticipateEventUser/{idUser}/{idev}")
@ResponseBody
public User AddParticipateEventUser(@PathVariable("idUser") Long idUser,@PathVariable("idev") Long idev) {return usrserv.addParticipateEvent(idUser, idev);}


@GetMapping("/ListUsersByIdSex/{idSex}")
@ResponseBody
public List<User> ListUsersByIdSex(@PathVariable("idSex") Long idSex) {
	// TODO Auto-generated method stub
	return usrserv.ListUsersByIdSex( idSex);
}
@GetMapping("/getGenderIdUser/{idSex}")
@ResponseBody
public Sexeuser getGenderByIdUser(@PathVariable("idSex") Long idSex) {
	// TODO Auto-generated method stub
	return usrserv.getGenderByIdUser(idSex);
}
@GetMapping("/UsersByIdRole/{idRole}")
@ResponseBody
public List<User> ListUsersByIdRole(@PathVariable("idRole") Long idRole) {
	// TODO Auto-generated method stub
	return usrserv.ListUsersByIdRole(idRole);
}

@GetMapping("/getRoleByIdUser/{idUser}")
@ResponseBody
public Roleuser getRoleByIdUser(@PathVariable("idUser") Long idUser) {
	// TODO Auto-generated method stub
	return usrserv.getRoleByIdUser(idUser);
}
@GetMapping("/UsersByIdTip/{idtip}")
@ResponseBody
public Set<User> getUserByIdTip(@PathVariable("idtip") Long id) {
	// TODO Auto-generated method stub
	return usrserv.findUsersByIdTip(id);
}
@GetMapping("/UsersByIdEvent/{idev}")
@ResponseBody
public Set<User> getUserByIdEvent(@PathVariable("idev") Long id) {
	// TODO Auto-generated method stub
	return usrserv.findUsersByIdEvent(id);
}
@PostMapping("/addCVUser/{idUser}")
@ResponseBody
public User addCVUser(@PathVariable("idUser") Long idUser,@RequestParam("cv") MultipartFile cv) {return usrserv.addCVUser(idUser, cv);}
@PostMapping("/AddSavedOfferUser/{idUser}/{idoff}")
@ResponseBody
public User AddOfferUser(@PathVariable("idUser") Long idUser,@PathVariable("idoff") Long idoff) {return usrserv.addOfferUser(idUser, idoff);}
@GetMapping("/UsersByIdOffre/{idoff}")
@ResponseBody
public Set<User> getUserByIdOffer(@PathVariable("idoff") Long idoff) {
	// TODO Auto-generated method stub
	return usrserv.findUsersByIdOffer(idoff);
}
@GetMapping("/IdUserByIdOfferSaisi/{idoff}")
@ResponseBody
public List<Long> getIdUserByIdOfferSaisi(@PathVariable("idoff") Long idoff) {
	// TODO Auto-generated method stub
	return usrserv.ListUserByIdOfferSaisi(idoff);
}
@GetMapping("/getIdUserByIdOffre")
@ResponseBody
public List<Long> getIdUserByIdOffre() {
	// TODO Auto-generated method stub
	return usrserv.ListUserByIdOffer();
}
}
