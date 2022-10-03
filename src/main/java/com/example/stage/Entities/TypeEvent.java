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
public class TypeEvent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idTypeEv;
	@Enumerated(EnumType.STRING)
private Typeev type;
	@JsonIgnore
	@OneToMany(mappedBy="typeev")
	private Set<Event> Events;
public TypeEvent() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getIdTypeEv() {
	return idTypeEv;
}
public void setIdTypeEv(Long idTypeEv) {
	this.idTypeEv = idTypeEv;
}
public Typeev getType() {
	return type;
}
public void setType(Typeev type) {
	this.type = type;
}
public TypeEvent(Long idTypeEv, Typeev type) {
	super();
	this.idTypeEv = idTypeEv;
	this.type = type;
}
@Override
public String toString() {
	return "TypeEvent [idTypeEv=" + idTypeEv + ", type=" + type + "]";
} 

}
