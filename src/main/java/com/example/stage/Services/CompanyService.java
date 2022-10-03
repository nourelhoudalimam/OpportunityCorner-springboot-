package com.example.stage.Services;

import java.io.IOException;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.Company;

import com.example.stage.Entities.Image;

import com.example.stage.Entities.Roleuser;

import com.example.stage.Repositories.CompanyRepository;

import com.example.stage.Repositories.RoleRepository;
@Service
public class CompanyService implements InterfaceCompanyService {
@Autowired 
CompanyRepository comprep;
@Autowired
RoleRepository rolerep;
@Autowired
ImageService imgsrv;


	@Override
	public List<Company> AddCompanies(List<Company> lc) {
		// TODO Auto-generated method stub
		return (List<Company>) comprep.saveAll(lc);
	}

	

	@Override
	public String addCompanyWithTestExist(Company c,Long id) {
		// TODO Auto-generated method stub
		String ch="";
		
		 if((comprep.existsByNom(c.getNom()))  &&(comprep.existsByDomaine(c.getDomaine()))&&(comprep.existsByLocalisation(c.getLocalisation()))) {ch="company exist";}
		
		else {Roleuser r=rolerep.findById(id).get();
		
c.setRolecomp(r);comprep.save(c);ch="company created";}
		 return ch;
	}

	@Override
	public Company UpdateCompany(Company c, Long id) {
		// TODO Auto-generated method stub
		Company comp=comprep.findById(id).get();
		comp.setLocalisation(c.getLocalisation());
	comp.setApropos(c.getApropos());
		comprep.save(comp);
		return comp;
	}

	@Override
	public void DeleteCompany(Long id) {
		// TODO Auto-generated method stub
		comprep.deleteById(id);
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return (List<Company>) comprep.findAll();
	}

	

	public Company getCompanyById(Long id) {
		// TODO Auto-generated method stub
		return comprep.findById(id).orElse(null);
	}

	@Override
	public List<Company> findByNom(String nom) {
		// TODO Auto-generated method stub
		return (List<Company>) comprep.findByNom(nom);
	}

	@Override
	public List<Company> findByDomaine(String domaine) {
		// TODO Auto-generated method stub
		return (List<Company>) comprep.findByDomaine(domaine);
	}

	@Override
	public List<Company> findByLocalisation(String localisation) {
		// TODO Auto-generated method stub
		return (List<Company>) comprep.findByLocalisation(localisation);
	}

	@Override
	public Company addImgCompany(Long idcomp, MultipartFile img) {
		// TODO Auto-generated method stub
		Company c =comprep.findById(idcomp).get();
		try {
		Image i=imgsrv.uploadImage(img);
			c.setImg(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comprep.save(c);
	}

	@Override
	public List<Company> ListCompanyByIdRole(Long idrole) {
		// TODO Auto-generated method stub
		Roleuser ru=rolerep.findById(idrole).get();
		return comprep.findByRolecomp(ru);}

	@Override
	public Roleuser getRoleByIdCompany(Long idcomp) {
		// TODO Auto-generated method stub
		Company c=comprep.findById(idcomp).get();
		return c.getRolecomp();
	}

	@Override
	public Company AddCompany(Company comp) {
		return comprep.save(comp);
	}



}

