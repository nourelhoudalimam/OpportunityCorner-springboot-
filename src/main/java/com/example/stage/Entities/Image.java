package com.example.stage.Entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Image {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idImage;
private String typeImage;
private String titleImage;
@Column(length= 42000000)
private byte[] tailleImage;

@OneToOne(mappedBy="img")
private Tips tip;
@OneToOne(mappedBy="img")
private Event event;
@OneToOne(mappedBy="img")
private Company comp;
public Image() {
	super();
	// TODO Auto-generated constructor stub
}
public Image(Long idImage, String typeImage, String titleImage, byte[] tailleImage, Tips tip, Event event,
		Company comp) {
	super();
	this.idImage = idImage;
	this.typeImage = typeImage;
	this.titleImage = titleImage;
	this.tailleImage = tailleImage;
	this.tip = tip;
	this.event = event;
	this.comp = comp;
}
public Image(String typeImage, String titleImage, byte[] tailleImage) {
	super();
	this.typeImage = typeImage;
	this.titleImage = titleImage;
	this.tailleImage = tailleImage;
}
public Long getIdImage() {
	return idImage;
}
public void setIdImage(Long idImage) {
	this.idImage = idImage;
}
public String getTypeImage() {
	return typeImage;
}
public void setTypeImage(String typeImage) {
	this.typeImage = typeImage;
}
public String getTitleImage() {
	return titleImage;
}
public void setTitleImage(String titleImage) {
	this.titleImage = titleImage;
}
public byte[] getTailleImage() {
	return tailleImage;
}
public void setTailleImage(byte[] tailleImage) {
	this.tailleImage = tailleImage;
}
public Tips getTip() {
	return tip;
}
public void setTip(Tips tip) {
	this.tip = tip;
}
public Event getEvent() {
	return event;
}
public void setEvent(Event event) {
	this.event = event;
}
public Company getComp() {
	return comp;
}
public void setComp(Company comp) {
	this.comp = comp;
}
@Override
public String toString() {
	return "Image [idImage=" + idImage + ", typeImage=" + typeImage + ", titleImage=" + titleImage + ", tailleImage="
			+ Arrays.toString(tailleImage) + ", tip=" + tip + ", event=" + event + ", comp=" + comp + "]";
}

}
