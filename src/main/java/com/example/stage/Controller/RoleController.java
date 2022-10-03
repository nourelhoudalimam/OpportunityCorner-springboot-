package com.example.stage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.stage.Entities.Roleuser;
import com.example.stage.Services.RoleService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RoleController {
@Autowired 
RoleService rolesrv;
@PostMapping("/AddRole")
@ResponseBody
public Roleuser addRole(@RequestBody Roleuser r) {return rolesrv.AddRole(r);}
@DeleteMapping("/DeleteRole/{id}")
@ResponseBody
public void deleterole(@PathVariable("id") Long id) {rolesrv.DeleteRole(id);}
@GetMapping("/getAllRoles")
@ResponseBody
public List<Roleuser> getAllroles() {
	// TODO Auto-generated method stub
	return rolesrv.getAllRoles();
}
@PostMapping("/UpdateRole/{idRole}")
@ResponseBody
public 	Roleuser Updaterole(@RequestBody Roleuser r ,@PathVariable ("idRole") Long id) {return rolesrv.UpdateRole(r, id);}
@PostMapping("/addRoleWithTestExistence")
@ResponseBody
public String addRoleWithtest(@RequestBody Roleuser r) {return rolesrv.addRoleWithTestExist(r);}
@GetMapping("/getRoleById/{id}")
@ResponseBody
public Roleuser getrolebyId(@PathVariable("id") Long id) {return rolesrv.getRoleById(id);}
@PostMapping("/AddMultipleRoles")
@ResponseBody
public List<Roleuser> addensRoles(@RequestBody List<Roleuser> lr) {return  rolesrv.AddEnsRoles(lr);}
}
