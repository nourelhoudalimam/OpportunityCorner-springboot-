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

import com.example.stage.Entities.Sexeuser;
import com.example.stage.Services.SexeuserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SexeuserController {
@Autowired
SexeuserService sexsrv;
@PostMapping("/AddGender")
@ResponseBody
public Sexeuser addgender(@RequestBody Sexeuser s) {return sexsrv.AddGender(s);}
@DeleteMapping("/DeleteGender/{id}")
@ResponseBody
public void deleteType(@PathVariable("id") Long id) {sexsrv.DeleteGender(id);}
@GetMapping("/getAllGenders")
@ResponseBody
public List<Sexeuser> getAllGenders() {
	// TODO Auto-generated method stub
	return sexsrv.getAllGenders();
}
@PostMapping("/UpdateGender/{idgender}")
@ResponseBody
public 	Sexeuser UpdateGender(@RequestBody Sexeuser s ,@PathVariable ("idgender") Long id) {return sexsrv.UpdateGender(s, id);}
@PostMapping("/addGenderWithTestExistence")
@ResponseBody
public String addGenderWithtest(@RequestBody Sexeuser s) {return sexsrv.addGenderWithTestExist(s);}
@GetMapping("/getGenderById/{id}")
@ResponseBody
public Sexeuser getGenderbyId(@PathVariable("id") Long id) {return sexsrv.getGenderById(id);}
@PostMapping("/AddMultipleGenders")
@ResponseBody
public List<Sexeuser> addensGenders(@RequestBody List<Sexeuser> lg) {return  sexsrv.AddEnsGenders(lg);}
}




