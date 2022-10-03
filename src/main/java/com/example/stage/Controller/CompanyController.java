package com.example.stage.Controller;

import java.util.List;



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

import com.example.stage.Entities.Company;

import com.example.stage.Services.CompanyService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CompanyController {
@Autowired
CompanyService compserv;
@PostMapping("/AddCompany")
@ResponseBody
public Company addcompany(@RequestBody  Company c) {return compserv.AddCompany(c);}
@PostMapping("/AddMultipleCompanies")
@ResponseBody
public List<Company> addcompanies(@RequestBody List<Company> lc) {return  compserv.AddCompanies(lc);}
@PostMapping("/AddCompanyWithTestExistence/{id}")
@ResponseBody
public String addcompanywithtestexistence(@RequestBody Company c,@PathVariable("id") Long id) {return  compserv.addCompanyWithTestExist(c, id);}

@DeleteMapping("/DeleteCompany/{id}")
@ResponseBody
public void deletecompany(@PathVariable("id") Long id) {compserv.DeleteCompany(id);}
@GetMapping("/getAllCompanies")
@ResponseBody
public List<Company> getAllcompany() {return compserv.getAllCompanies();
}
@GetMapping("/getCompanyById/{id}")
@ResponseBody
public Company getcompanybyid(@PathVariable("id") Long id) {return compserv.getCompanyById(id);
}
@PostMapping("/UpdateCompany/{id}")
@ResponseBody
public 	Company Updatecompany(@RequestBody Company c ,@PathVariable ("id") Long id) {return compserv.UpdateCompany(c, id);}


@GetMapping("/findByNom/{nom}")
@ResponseBody
public List<Company> findByNom(@PathVariable("nom") String nom) {return compserv.findByNom(nom);}

@GetMapping("/findByDomaine/{domaine}")
@ResponseBody
public List<Company> findByDomaine(@PathVariable("domaine") String domaine) {return compserv.findByDomaine(domaine);}

@GetMapping("/findByLocalisation/{localisation}")
@ResponseBody
public List<Company> findByLoc(@PathVariable("localisation") String localisation) {return compserv.findByLocalisation(localisation);}
@PostMapping("/addImgCompany/{idcomp}")
@ResponseBody
public Company addImgCompany(@PathVariable("idcomp") Long idcomp,@RequestParam("img") MultipartFile img) {return compserv.addImgCompany(idcomp, img);}
}

