package com.example.stage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.stage.Entities.Sexeuser;
import com.example.stage.Repositories.SexeuserRepository;

@Service
public class SexeuserService implements InterfaceSexeuser{
@Autowired
SexeuserRepository sexrep;

@Override
public List<Sexeuser> AddEnsGenders(List<Sexeuser> lg) {
	// TODO Auto-generated method stub
	return (List<Sexeuser>) sexrep.saveAll(lg);
}

@Override
public Sexeuser AddGender(Sexeuser s) {
	// TODO Auto-generated method stub
	return sexrep.save(s);
}

@Override
public String addGenderWithTestExist(Sexeuser s) {
	// TODO Auto-generated method stub
	String ch="";
	if (sexrep.existsByGender(s.getGender())) {ch="this gender exist";}
	else {sexrep.save(s);ch="gender created";}
return ch;
}

@Override
public Sexeuser UpdateGender(Sexeuser s, Long id) {
	// TODO Auto-generated method stub
	Sexeuser su=sexrep.findById(id).get();
	su.setGender(s.getGender());
	
	sexrep.save(su);
	return su;
}

@Override
public void DeleteGender(Long id) {
	// TODO Auto-generated method stub
	sexrep.deleteById(id);
}

@Override
public List<Sexeuser> getAllGenders() {
	// TODO Auto-generated method stub
	return (List<Sexeuser>) sexrep.findAll();
}

@Override
public Sexeuser getGenderById(Long id) {
	// TODO Auto-generated method stub
	return sexrep.findById(id).orElse(null);
}

}
