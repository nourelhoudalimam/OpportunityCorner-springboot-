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
public class Sexeuser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idgender;
@Enumerated(EnumType.STRING)
private Gender gender;
@JsonIgnore
@OneToMany(mappedBy="sexuser")
private Set<User> users;
public Sexeuser() {
	super();
	// TODO Auto-generated constructor stub
}
public Sexeuser(Long idgender, Gender gender) {
	super();
	this.idgender = idgender;
	this.gender = gender;
}
public Long getIdgender() {
	return idgender;
}
public void setIdgender(Long idgender) {
	this.idgender = idgender;
}
public Gender getGender() {
	return gender;
}
public void setGender(Gender gender) {
	this.gender = gender;
}
@Override
public String toString() {
	return "Sexeuser [idgender=" + idgender + ", gender=" + gender + "]";
}

}
