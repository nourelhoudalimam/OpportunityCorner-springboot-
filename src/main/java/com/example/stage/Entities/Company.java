package com.example.stage.Entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idComp;
	private String nom;
	private String localisation;
	private String domaine;
	private String apropos;
	private String lien;
	@JsonIgnore
	@OneToMany(mappedBy="company")
	private Set<Offre> offres;
	@JsonIgnore
	@OneToOne
	private Image img;
	@JsonIgnore
	@ManyToOne
	private  Roleuser rolecomp;
	
	public Roleuser getRolecomp() {
		rolecomp.setRole(Role.Recruiter);
		return rolecomp;
		
	}

	

	



	public void setRolecomp(Roleuser rolecomp) {
		rolecomp.setRole(Role.Recruiter);
	rolecomp.setIdRole((long) 2);
	this.rolecomp=rolecomp;
	}







	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	
	public Set<Offre> getOffres() {
		return offres;
	}
	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}
	
	
	



	public Company(Long idComp, String nom, String localisation, String domaine, String apropos, String lien,
			Set<Offre> offres, Image img) {
		super();
		this.idComp = idComp;
		this.nom = nom;
		this.localisation = localisation;
		this.domaine = domaine;
		this.apropos = apropos;
		this.lien = lien;
		this.offres = offres;
		this.img = img;
		
	}



	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdComp() {
		return idComp;
	}
	public void setIdComp(Long idComp) {
		this.idComp = idComp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getApropos() {
		return apropos;
	}
	public void setApropos(String apropos) {
		this.apropos = apropos;
	}

	@Override
	public String toString() {
		return "Company [idComp=" + idComp + ", nom=" + nom + ", localisation=" + localisation + ", domaine=" + domaine
				+ ", apropos=" + apropos + ", lien=" + lien + ", offres=" + offres ;
	}
	
	
	
}

