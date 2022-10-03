package com.example.stage.Entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class CV {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idFile;
private String typeFile;
private String title;
@Column(length= 42000000)
private byte[] tailleFile;
@JsonIgnore
@OneToOne(mappedBy="cv")
private User user;
public CV() {
	super();
	// TODO Auto-generated constructor stub
}
public CV(Long idFile, String typeFile, String title, byte[] tailleFile) {
	super();
	this.idFile = idFile;
	this.typeFile = typeFile;
	this.title = title;
	this.tailleFile = tailleFile;
}
public Long getIdFile() {
	return idFile;
}
public void setIdFile(Long idFile) {
	this.idFile = idFile;
}
public String getTypeFile() {
	return typeFile;
}
public void setTypeFile(String typeFile) {
	this.typeFile = typeFile;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public byte[] getTailleFile() {
	return tailleFile;
}
public void setTailleFile(byte[] tailleFile) {
	this.tailleFile = tailleFile;
}
@Override
public String toString() {
	return "CV [idFile=" + idFile + ", typeFile=" + typeFile + ", title=" + title + ", tailleFile="
			+ Arrays.toString(tailleFile) + "]";
}
public CV(String typeFile, String title, byte[] tailleFile) {
	super();
	this.typeFile = typeFile;
	this.title = title;
	this.tailleFile = tailleFile;
}

}
