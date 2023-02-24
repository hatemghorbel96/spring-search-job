package com.example.users.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String email;
   
	private String password;
	@Column(nullable = true)
	private String thesize;
	
	@Column(nullable = true)
	private String category;
	
	@Column(nullable = true)
	private String firstname;
	
	@Column(nullable = true)
	private String lastname;
	
	@Column(nullable = true)
	private String facebooklink;
	
	@Column(nullable = true)
	private String linkedinlink;
	
	private Integer type;
	@Column(nullable = true)
	private String photo;
	
	@Lob
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = true)
	private String cv;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user") 
    private Set<Cv> cvs = new HashSet<>();
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)	
	@JsonIgnoreProperties("user") 	
	@Column(nullable = true)
	private Set<Job> jobs = new HashSet<>();
	
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)	 
	@JsonIgnoreProperties("user") 
	private Set<Postuler> postules = new HashSet<>();
	
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 @JsonIgnore
	  private List<Favorit> favorits= new ArrayList<>();
	
	public Long getUserid() {
		return userid;
	}

	

	public void setUserid(Long userid) {
		this.userid = userid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}

	

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Integer getType() {
		return type;
	}



	public void setType(Integer type) {
		this.type = type;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	public Set<Job> getJobs() {
		return jobs;
	}



	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}


	
	



	public Set<Cv> getCvs() {
		return cvs;
	}


	
	public void setCvs(Set<Cv> cvs) {
		this.cvs = cvs;
	}







	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCv() {
		return cv;
	}



	public void setCv(String cv) {
		this.cv = cv;
	}



	public Set<Postuler> getPostules() {
		return postules;
	}



	public void setPostules(Set<Postuler> postules) {
		this.postules = postules;
	}







	public List<Favorit> getFavorits() {
		return favorits;
	}



	public void setFavorits(List<Favorit> favorits) {
		this.favorits = favorits;
	}







	public String getThesize() {
		return thesize;
	}



	public void setThesize(String thesize) {
		this.thesize = thesize;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}







	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getFacebooklink() {
		return facebooklink;
	}



	public void setFacebooklink(String facebooklink) {
		this.facebooklink = facebooklink;
	}



	public String getLinkedinlink() {
		return linkedinlink;
	}



	public void setLinkedinlink(String linkedinlink) {
		this.linkedinlink = linkedinlink;
	}







	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}
