package com.example.stage.Entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Roleuser {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idRole;
@Enumerated(EnumType.STRING)
private Role role;
@JsonIgnore
@OneToMany(mappedBy="roleusers")
private Set<User> users;
@JsonIgnore
@OneToMany(mappedBy="rolecomp")
private Set<Company> Companies;



public Roleuser(Long idRole, Role role, Set<User> users, Set<Company> compRole) {
	super();
	this.idRole = idRole;
	this.role = role;
	this.users = users;
	Companies = compRole;
}
public Set<User> getUsers() {
	return users;
}
public void setUsers(Set<User> users) {
	this.users = users;
}
public Set<Company> getCompanies() {
	return Companies;
}
public void setCompanies(Set<Company> compRole) {
	Companies = compRole;
}
public Roleuser() {
	super();
	// TODO Auto-generated constructor stub
}
public Roleuser(Long idRole, Role role) {
	super();
	this.idRole = idRole;
	this.role = role;
}
public Long getIdRole() {
	return idRole;
}
public void setIdRole(Long idRole) {
	this.idRole = idRole;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
@Override
public String toString() {
	return "Roleuser [idRole=" + idRole + ", role=" + role + "]";
}

}
