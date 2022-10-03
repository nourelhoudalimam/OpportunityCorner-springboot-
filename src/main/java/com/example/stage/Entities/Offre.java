package com.example.stage.Entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Offre  {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idOffre;


private String poste;

private String description;
private Timestamp createDate;
@JsonIgnore
@ManyToOne
private Company company;
@JsonIgnore
@ManyToMany(mappedBy="List_Postul")
private Set<User>listCandPostul;
public Offre() {
	super();
	// TODO Auto-generated constructor stub
}
public Offre(Long idOffre, String poste, String description, Timestamp createDate, Company company,
		Set<User> listCandPostul) {
	super();
	this.idOffre = idOffre;
	this.poste = poste;
	this.description = description;
	this.createDate = createDate;
	this.company = company;
	this.listCandPostul = listCandPostul;
}
public Long getIdOffre() {
	return idOffre;
}
public void setIdOffre(Long idOffre) {
	this.idOffre = idOffre;
}
public String getPoste() {
	return poste;
}
public void setPoste(String poste) {
	this.poste = poste;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Timestamp getCreateDate() {
	return createDate;
}
public void setCreateDate(Timestamp createDate) {
	this.createDate = createDate;
}
public Company getCompany() {
	return company;
}
public void setCompany(Company company) {
	this.company = company;
}
public Set<User> getListCandPostul() {
	return listCandPostul;
}
public void setListCandPostul(Set<User> listCandPostul) {
	this.listCandPostul = listCandPostul;
}
@Override
public String toString() {
	return "Offre [idOffre=" + idOffre + ", poste=" + poste + ", description=" + description + ", createDate="
			+ createDate + ", company=" + company + ", listCandPostul=" + listCandPostul + "]";
}

}