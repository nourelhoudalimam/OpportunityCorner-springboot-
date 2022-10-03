package com.example.stage.Services;

import java.util.List;

import com.example.stage.Entities.Sexeuser;



public interface InterfaceSexeuser {
	public List<Sexeuser> AddEnsGenders(List <Sexeuser> lg);
	public Sexeuser AddGender(Sexeuser s );
	public String addGenderWithTestExist(Sexeuser s);
	public Sexeuser UpdateGender(Sexeuser s,Long id);
	public void DeleteGender(Long id);
	public List<Sexeuser> getAllGenders();
	public Sexeuser getGenderById(Long id);
}
