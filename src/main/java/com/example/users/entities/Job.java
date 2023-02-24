package com.example.users.entities;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobid;

	private String jobtype;
	
	private String title;
	
	private Integer minsalary;
	private Integer maxsalary;
	
	@Column(nullable = true)
	@CreationTimestamp
	private Date dateCreated;
	
	private String experience;
	 
	private String langue;
	
	@Lob
	private String description;
	
	@Lob
	private String requirements;
	
	private String localisation;
	
	private String website;
	
	private Date expire;
	
	@OneToMany(mappedBy="job", fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})	 
	
	public Set<Postuler> postules = new HashSet<>();
	
	@ManyToOne
	
	private User user;
	
	@OneToMany(mappedBy = "job",  fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	
	private Set<Favorit> favorits= new HashSet<>();
	
	
	
	

	public Long getJobid() {
		return jobid;
	}
	@JsonManagedReference
	public Set<Favorit> getFavorits() {
		return favorits;
	}

	public void setFavorits(Set<Favorit> favorits) {
		this.favorits = favorits;
	}

	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	

	public Integer getMinsalary() {
		return minsalary;
	}

	public void setMinsalary(Integer minsalary) {
		this.minsalary = minsalary;
	}

	public Integer getMaxsalary() {
		return maxsalary;
	}

	public void setMaxsalary(Integer maxsalary) {
		this.maxsalary = maxsalary;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonManagedReference
	public Set<Postuler> getPostules() {
		return postules;
	}

	public void setPostules(Set<Postuler> postules) {
		this.postules = postules;
	}
	public Job(Long jobid, String jobtype, String title, Integer minsalary, Integer maxsalary, Date dateCreated,
			String experience, String langue, String description, String requirements, String localisation,
			String website, Date expire, Set<Postuler> postules, User user, Set<Favorit> favorits) {
		super();
		this.jobid = jobid;
		this.jobtype = jobtype;
		this.title = title;
		this.minsalary = minsalary;
		this.maxsalary = maxsalary;
		this.dateCreated = dateCreated;
		this.experience = experience;
		this.langue = langue;
		this.description = description;
		this.requirements = requirements;
		this.localisation = localisation;
		this.website = website;
		this.expire = expire;
		this.postules = postules;
		this.user = user;
		this.favorits = favorits;
	}
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Job [jobid=" + jobid + ", jobtype=" + jobtype + ", title=" + title + ", minsalary=" + minsalary
				+ ", maxsalary=" + maxsalary + ", dateCreated=" + dateCreated + ", experience=" + experience
				+ ", langue=" + langue + ", description=" + description + ", requirements=" + requirements
				+ ", localisation=" + localisation + ", website=" + website + ", expire=" + expire + ", postules="
				+ postules + ", user=" + user + ", favorits=" + favorits + "]";
	}

	
	
	
	
	
}
