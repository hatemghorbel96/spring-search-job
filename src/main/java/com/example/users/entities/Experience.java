package com.example.users.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expid;
	
	private String postTitle;
	private String enterpriseTitle;
	
	private Date datedebutExp;
	private Date datefinExp;
	@Lob
	private String description;
	

	@ManyToOne	
	@JsonIgnoreProperties("cv")
	private Cv cv;

	public Long getExpid() {
		return expid;
	}

	public void setExpid(Long expid) {
		this.expid = expid;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getEnterpriseTitle() {
		return enterpriseTitle;
	}

	public void setEnterpriseTitle(String enterpriseTitle) {
		this.enterpriseTitle = enterpriseTitle;
	}

	public Date getDatedebutExp() {
		return datedebutExp;
	}

	public void setDatedebutExp(Date datedebutExp) {
		this.datedebutExp = datedebutExp;
	}

	public Date getDatefinExp() {
		return datefinExp;
	}

	public void setDatefinExp(Date datefinExp) {
		this.datefinExp = datefinExp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Cv getCv() {
		return cv;
	}
	
	public void setCv(Cv cv) {
		this.cv = cv;
	}
	
	
	
	
}
