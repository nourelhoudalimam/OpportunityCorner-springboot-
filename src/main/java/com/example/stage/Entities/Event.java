package com.example.stage.Entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idev;
private String titre;
private Date devent;

private String lieu;
private String orga;
private String descripton1;
private Timestamp createDate;
@JsonIgnore
@ManyToMany(mappedBy="participate_events")
private Set<User> listUserParticipate;
@JsonIgnore
@ManyToOne
private TypeEvent typeev;
@JsonIgnore
@OneToOne
private Image img;

public Image getImg() {
	return img;
}
public void setImg(Image img) {
	this.img = img;
}
public Timestamp getCreateDate() {
	return createDate;
}
public void setCreateDate(Timestamp createDate) {
	this.createDate = createDate;
}
public TypeEvent getTypeev() {
	return typeev;
}
public void setTypeev(TypeEvent typeev) {
	this.typeev = typeev;
}
public Set<User> getListUserParticipate() {
	return listUserParticipate;
}
public void setListUserParticipate(Set<User> listUserParticipate) {
	this.listUserParticipate = listUserParticipate;
}
public Event() {
	super();
	// TODO Auto-generated constructor stub
}


public Event(Long idev, String titre, Date devent, String lieu, String orga, String descripton1, Timestamp createDate,
		Set<User> listUserParticipate, TypeEvent typeev) {
	super();
	this.idev = idev;
	this.titre = titre;
	this.devent = devent;
	this.lieu = lieu;
	this.orga = orga;
	this.descripton1 = descripton1;
	this.createDate = createDate;
	this.listUserParticipate = listUserParticipate;
	this.typeev = typeev;
}

public Event(Long idev) {
	super();
	this.idev = idev;
}
@Override
public String toString() {
	return "Event [idev=" + idev + ", titre=" + titre + ", devent=" + devent + ", lieu=" + lieu + ", orga=" + orga
			+ ", Descripton1=" + descripton1 + ", createDate=" + createDate + ", listUserParticipate="
			+ listUserParticipate + ", typeev=" + typeev + "]";
}
public Long getIdev() {
	return idev;
}
public void setIdev(Long id) {
	this.idev = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public Date getDevent() {
	return devent;
}
public void setDevent(Date devent) {
	this.devent = devent;
}

public String getLieu() {
	return lieu;
}
public void setLieu(String lieu) {
	this.lieu = lieu;
}
public String getOrga() {
	return orga;
}
public void setOrga(String orga) {
	this.orga = orga;
}
public String getDescripton1() {
	return descripton1;
}
public void setDescripton1(String descripton1) {
	this.descripton1 = descripton1;
}

}