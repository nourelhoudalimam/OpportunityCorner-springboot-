package com.example.stage.Services;

import java.util.List;

import com.example.stage.Entities.Company;

import com.example.stage.Entities.Offre;



public interface InterfaceOffreService {
	public Offre AddOffre(Offre o,Long idcomp);
	public List<Offre> AddEnsOffre(List <Offre> lo);

	public String addOffreWithTestExist(	Offre  offre,Long idcomp);
	public Offre UpdateOffre(Offre o,Long id);
	public void DeleteOffre(Long id);
	public List<Offre> getAllOffers();
	public Offre getOfferById(Long id);
	public Offre findByPoste(String poste);
	public List<Offre> ListOffersByIdCompany(Long idcomp);
	public Company getCompanyByIdOffre(Long idoffre);
}
