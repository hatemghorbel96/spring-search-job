package com.example.users.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long educationid;
	
	private String diplome;
	private String universite;	
	private Date datedebutEtud;
	private Date datefinEtud;
	
	@ManyToOne	
	@JsonIgnoreProperties("cv")
	private Cv cv;

	public Long getEducationid() {
		return educationid;
	}

	public void setEducationid(Long educationid) {
		this.educationid = educationid;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getUniversite() {
		return universite;
	}

	public void setUniversite(String universite) {
		this.universite = universite;
	}

	public Date getDatedebutEtud() {
		return datedebutEtud;
	}

	public void setDatedebutEtud(Date datedebutEtud) {
		this.datedebutEtud = datedebutEtud;
	}

	public Date getDatefinEtud() {
		return datefinEtud;
	}

	public void setDatefinEtud(Date datefinEtud) {
		this.datefinEtud = datefinEtud;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}
	
	

}
