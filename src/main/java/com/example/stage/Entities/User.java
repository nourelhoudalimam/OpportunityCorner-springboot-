package com.example.stage.Entities;


import java. util. Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity


@Table(name="User")
public  class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
private String username;
private String fullname;
private Long phonenumber;
private String confpassword;
private String password;
private Date date_naiss;

private String email;
@JsonIgnore
@ManyToMany
@JoinTable(name="UserEvents",joinColumns=@JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="idev"))
private Set<Event> participate_events;
@JsonIgnore
@ManyToMany
@JoinTable(name="UserTips",joinColumns=@JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="idtip"))
private Set<Tips> saved_tips;

@ManyToOne
private Roleuser roleusers;
@JsonIgnore
@OneToOne
private CV cv;
@JsonIgnore
@ManyToMany
@JoinTable(name="UserOffre",joinColumns=@JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="idOff"))
private Set<Offre> List_Postul;

@ManyToOne
private Sexeuser sexuser;



public Sexeuser getSexuser() {
	return sexuser;
}
public void setSexuser(Sexeuser sexuser) {
	this.sexuser = sexuser;
}

public User(Long id, String username, String fullname, Long phonenumber, String confpassword, String password,
		Date date_naiss, String email, Set<Event> participate_events, Set<Tips> saved_tips, Roleuser roleusers, CV cv,
		Set<Offre> list_Postul, Sexeuser sexuser) {
	super();
	this.id = id;
	this.username = username;
	this.fullname = fullname;
	this.phonenumber = phonenumber;
	this.confpassword = confpassword;
	this.password = password;
	this.date_naiss = date_naiss;
	this.email = email;
	this.participate_events = participate_events;
	this.saved_tips = saved_tips;
	this.roleusers = roleusers;
	this.cv = cv;
	List_Postul = list_Postul;
	this.sexuser = sexuser;
}
public Set<Offre> getList_Postul() {
	return List_Postul;
}
public void setList_Postul(Set<Offre> list_Postul) {
	List_Postul = list_Postul;
}
public Set<Event> getParticipate_events() {
	return participate_events;
}
public void setParticipate_events(Set<Event> participate_events) {
	this.participate_events = participate_events;
}
public Set<Tips> getSaved_tips() {
	return saved_tips;
}
public void setSaved_tips(Set<Tips> saved_tips) {
	this.saved_tips = saved_tips;
}

public Roleuser getRoleusers() {
	return roleusers;
}
public void setRoleusers(Roleuser roleuser) {
	this.roleusers = roleuser;
}
public CV getCv() {
	return cv;
}
public void setCv(CV cv) {
	this.cv = cv;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public Long getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(Long phonenumber) {
	this.phonenumber = phonenumber;
}
public String getConfpassword() {
	return confpassword;
}
public void setConfpassword(String cONFpassword) {
	confpassword = cONFpassword;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Date getDate_naiss() {
	return date_naiss;
}
public void setDate_naiss(Date date_naiss) {
	this.date_naiss = date_naiss;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}




@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", fullname=" + fullname + ", phonenumber=" + phonenumber
			+ ", confpassword=" + confpassword + ", password=" + password + ", date_naiss=" + date_naiss + ", email="
			+ email + ", participate_events=" + participate_events + ", saved_tips=" + saved_tips + ", roleuser="
			+ roleusers + ", cv=" + cv + ", List_Postul=" + List_Postul + "]";
}
public void addSavedTip(Tips t) {
	// TODO Auto-generated method stub
	this.saved_tips.add(t);
}

public void addParticipatedEvent(Event e) {
	// TODO Auto-generated method stub
	this.participate_events.add(e);		
}

public void addOffre(Offre o) {
	// TODO Auto-generated method stub
	this.List_Postul.add(o);
}

}

