package com.example.users.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Postuler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postulerid;
	
	
	@ManyToOne	
	
	private Job job;
	
	@ManyToOne	
	@JsonIgnoreProperties("user")
	private User user;
	
	@Column(nullable = true)
	@CreationTimestamp
	private Date dateCreated;
	
	@Column(nullable=true)
	private boolean selected;
	
	@Lob
	private String description;
	
	private int etat;

	
	
	public Long getPostulerid() {
		return postulerid;
	}

	public void setPostulerid(Long postulerid) {
		this.postulerid = postulerid;
	}
	 @JsonBackReference
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
