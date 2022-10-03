package com.example.stage.Services;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.Company;

import com.example.stage.Entities.Roleuser;

public interface InterfaceCompanyService {
	public Company AddCompany(Company comp);
	public List<Company> AddCompanies(List <Company> lc);
	

	public Company UpdateCompany(Company u,Long id);
	public void DeleteCompany(Long id);
	public List<Company> getAllCompanies();
	public Company getCompanyById(Long id);
	public List<Company> findByNom(String nom);
	public List<Company> findByDomaine(String domaine);
	public List<Company> findByLocalisation(String localisation);
	public Company addImgCompany(Long idcomp,MultipartFile img); 
	public List<Company> ListCompanyByIdRole(Long idrole);
	public Roleuser getRoleByIdCompany(Long idcomp);
	String addCompanyWithTestExist(Company c,Long id);
	
}
