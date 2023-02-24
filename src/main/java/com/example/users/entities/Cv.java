package com.example.users.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cvid;

	private String nom;
	private String prenom;
	private String email;
	private String phone;
	private String address;
	@Column(nullable = true)
	private String linkedin;
	@Column(nullable = true)
	private String github;
	
	@Column(nullable = true)
	private String website;
	
	private Date birthday;

	private Integer salairemin;
	
	private String poste;
	
	private String ville;
	
	@Column(nullable = true)
	private Integer publiccv;
	

	@ManyToOne 
	@JsonIgnoreProperties("user")
	private User user;
	
	@Lob
	private String description;
	
	@Lob
	private String skills;
	
	@Lob
	private String langues;
	
	@Lob
	private String interest;
	
	

	
	 @OneToMany(mappedBy="cv", fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})	 
	 @JsonIgnoreProperties("cv") 
	 private Set<Experience> experiences = new HashSet<>();
	 
	 @OneToMany(mappedBy="cv", fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})	 
	 @JsonIgnoreProperties("cv") 
	 private Set<Education> educations = new HashSet<>();
	 
	 public void add(Experience item) {

	        if (item != null) {
	            if (experiences == null) {
	            	experiences= new HashSet<>();
	            }

	            experiences.add(item);
	            item.setCv(this);
	        }
	    }
	 
	 public void addEdu(Education item) {

	        if (item != null) {
	            if (educations == null) {
	            	educations= new HashSet<>();
	            }

	            educations.add(item);
	            item.setCv(this);
	        }
	    }
	
	public Long getCvid() {
		return cvid;
	}
	public void setCvid(Long cvid) {
		this.cvid = cvid;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
	public Set<Experience> getExperiences() {
		return experiences;
	}
	
	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Set<Education> getEducations() {
		return educations;
	}

	public void setEducations(Set<Education> educations) {
		this.educations = educations;
	} 

	public Integer getSalairemin() {
		return salairemin;
	}

	public void setSalairemin(Integer salairemin) {
		this.salairemin = salairemin;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Integer getPubliccv() {
		return publiccv;
	}

	public void setPubliccv(Integer publiccv) {
		this.publiccv = publiccv;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLangues() {
		return langues;
	}

	public void setLangues(String langues) {
		this.langues = langues;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	
	
	
}
