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

import com.example.stage.Entities.TypeEvent;
import com.example.stage.Services.TypeEventService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TypeEventController {
@Autowired
TypeEventService Tesrv;

@PostMapping("/AddType")
@ResponseBody
public TypeEvent addType(@RequestBody TypeEvent t) {return Tesrv.AddType(t);}
@DeleteMapping("/DeleteType/{id}")
@ResponseBody
public void deleteType(@PathVariable("id") Long id) {Tesrv.DeleteType(id);}
@GetMapping("/getAllTypes")
@ResponseBody
public List<TypeEvent> getAllTypes() {
	// TODO Auto-generated method stub
	return Tesrv.getAllTypes();
}
@PostMapping("/UpdateType/{idType}")
@ResponseBody
public 	TypeEvent Updatetype(@RequestBody TypeEvent t ,@PathVariable ("idType") Long id) {return Tesrv.UpdateType(t, id);}
@PostMapping("/addTypeWithTestExistence")
@ResponseBody
public String addTypeWithtest(@RequestBody TypeEvent t) {return Tesrv.addTypeWithTestExist(t);}
@GetMapping("/getTypeById/{id}")
@ResponseBody
public TypeEvent getTypebyId(@PathVariable("id") Long id) {return Tesrv.getTypeById(id);}
@PostMapping("/AddMultipleTypes")
@ResponseBody
public List<TypeEvent> addensTypes(@RequestBody List<TypeEvent> lte) {return Tesrv.AddEnsTypes(lte);}
}

