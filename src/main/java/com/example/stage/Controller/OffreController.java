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

import com.example.stage.Entities.Company;

import com.example.stage.Entities.Offre;
import com.example.stage.Services.OffreService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class OffreController {
@Autowired
OffreService offserv;
@PostMapping("/AddOffer/{idcomp}")
@ResponseBody
public Offre addoffer(@RequestBody Offre o,@PathVariable("idcomp") Long idcomp) {return offserv.AddOffre(o, idcomp);}
@PostMapping("/AddMultipleOffers")
@ResponseBody
public List<Offre> addensoffers(@RequestBody List<Offre> lo) {return  offserv.AddEnsOffre(lo);}
@DeleteMapping("/DeleteOffer/{id}")
@ResponseBody
public void deleteoffre(@PathVariable("id") Long id) {offserv.DeleteOffre(id);}
@GetMapping("/getAllOffers")
@ResponseBody
public List<Offre> getAlloffers() {
	// TODO Auto-generated method stub
	return offserv.getAllOffers();
}
@PostMapping("/UpdateOffer/{idOffre}")
@ResponseBody
public 	Offre Updateoffre(@RequestBody Offre o ,@PathVariable ("idOffre") Long id) {return offserv.UpdateOffre(o, id);}
@PostMapping("/addOfferWithTestExistence/{idcomp}")
@ResponseBody
public String addOfferWithtest(@RequestBody Offre o,@PathVariable ("idcomp") Long idcomp) {return offserv.addOffreWithTestExist(o, idcomp);}
@GetMapping("/getOfferById/{id}")
@ResponseBody
public Offre getoffrebyId(@PathVariable("id") Long id) {return offserv.getOfferById(id);}

@GetMapping("/findOfferByPoste/{poste}")
@ResponseBody
public Offre findByPoste(@PathVariable("poste") String poste) {return offserv.findByPoste(poste);}
@GetMapping("/getOffersById/{id}")
@ResponseBody
public List<Offre> ListOffersByIdCompany(@PathVariable("id") Long idcomp) {return offserv.ListOffersByIdCompany(idcomp);}
@GetMapping("/getCompanyByIdOffre/{id}")
@ResponseBody
public Company getCompanyByIdOffre(@PathVariable("id") Long idoffre){return offserv.getCompanyByIdOffre(idoffre);}
}

