package com.example.stage.Entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Tips {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idtip;
private String titrecons;
private String contenu;
private Timestamp createDate;
@JsonIgnore
@ManyToMany(mappedBy="saved_tips")
private Set<User> listUserSave;
@OneToOne
private Image img;

public Set<User> getListUserSave() {
	return listUserSave;
}


public void setListUserSave(Set<User> listUserSave) {
	this.listUserSave = listUserSave;
}


public void setIdtip(Long idtip) {
	this.idtip = idtip;
}





public Timestamp getCreateDate() {
	return createDate;
}


public void setCreateDate(Timestamp createDate) {
	this.createDate = createDate;
}


@Override
public String toString() {
	return "Tips [idtip=" + idtip + ", titrecons=" + titrecons + ", contenu=" + contenu + ", createDate=" + createDate
			+ ", listUserSave=" + listUserSave + "]";
}





public Tips(Long idtip, String titrecons, String contenu, Timestamp createDate) {
	super();
	this.idtip = idtip;
	this.titrecons = titrecons;
	this.contenu = contenu;
	this.createDate = createDate;
}


public String getContenu() {
	return contenu;
}


public void setContenu(String contenu) {
	this.contenu = contenu;
}





public Long getIdtip() {
	return idtip;
}
public void setId(Long id) {
	idtip = id;
}
public String getTitrecons() {
	return titrecons;
}
public void setTitrecons(String titrecons) {
	this.titrecons = titrecons;
}


public Tips() {
	super();
	// TODO Auto-generated constructor stub
}


public Image getImg() {
	return img;
}


public void setImg(Image img) {
	this.img = img;
}




}

