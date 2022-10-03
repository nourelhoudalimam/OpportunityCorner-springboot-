package com.example.stage.Services;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stage.Entities.Company;

import com.example.stage.Entities.Offre;

import com.example.stage.Repositories.CompanyRepository;
import com.example.stage.Repositories.OffreRepository;
@Service
public class OffreService implements InterfaceOffreService {
@Autowired
OffreRepository offRep;
@Autowired
CompanyRepository compRep;
	@Override
	public Offre AddOffre(Offre o,Long idcomp) {
		// TODO Auto-generated method stub
		Company c=compRep.findById(idcomp).get();
		o.setCompany(c);
		Timestamp updateEvent= new Timestamp(System.currentTimeMillis());
		o.setCreateDate(updateEvent);
		
		return offRep.save(o);
	}

	@Override
	public List<Offre> AddEnsOffre(List<Offre> lo) {
		// TODO Auto-generated method stub
		return (List<Offre>) offRep.saveAll(lo);
	}

	@Override
	public String addOffreWithTestExist(Offre offre,Long idcomp) {
		// TODO Auto-generated method stub
		String ch="";
		if( (offRep.existsByPoste(offre.getPoste())) && offRep.existsByDescription(offre.getDescription()) ) {ch="this offer exist";}
		else {Company c=compRep.findById(idcomp).get();
		offre.setCompany(c);
		Timestamp updateEvent= new Timestamp(System.currentTimeMillis());
		offre.setCreateDate(updateEvent);offRep.save(offre);ch="offer created";}
	return ch;
	}

	@Override
	public Offre UpdateOffre(Offre o, Long id) {
		// TODO Auto-generated method stub
		Offre offr=offRep.findById(id).get();
		offr.setPoste(o.getPoste());
		offr.setDescription(o.getDescription());
		offRep.save(offr);
		return offr;
	}

	@Override
	public void DeleteOffre(Long id) {
		// TODO Auto-generated method stub
		offRep.deleteById(id);
	}

	@Override
	public List<Offre> getAllOffers() {
		// TODO Auto-generated method stub
		return (List<Offre>) offRep.findAll();
	}

	@Override
	public Offre getOfferById(Long id) {
		// TODO Auto-generated method stub
		return offRep.findById(id).orElse(null);
	}

	@Override
	public Offre findByPoste(String poste) {
		// TODO Auto-generated method stub
		return offRep.findByPoste(poste);
	}

	@Override
	public List<Offre> ListOffersByIdCompany(Long idcomp) {
		// TODO Auto-generated method stub
		Company c=compRep.findById(idcomp).get();
		return offRep.findByCompany(c);
	}

	@Override
	public Company getCompanyByIdOffre(Long idoffre) {
		// TODO Auto-generated method stub
		Offre o=offRep.findById(idoffre).get();
		return o.getCompany();
	}

	

}


