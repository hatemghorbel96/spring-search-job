package com.example.users.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.users.entities.Job;
import com.example.users.entities.User;

public class JobDTO {
	

	private Long jobid;

	private String jobtype;
	
	private String title;
	
	private Integer minsalary;
	private Integer maxsalary;
	
	
	private Date dateCreated;
	
	private String experience;
	 
	private String langue;
	
	
	private String description;
	

	private String requirements;
	
	private String localisation;
	
	private String website;
	
	private Date expire;
	
	private UserDTO user;
	

	private Set<FavoritDTO> favorits = new HashSet<>();

	// Getter and setter for favorits
	public Set<FavoritDTO> getFavorits() {
		return favorits;
	}

	public void setFavorits(Set<FavoritDTO> favorits) {
		this.favorits = favorits;
	}



	public UserDTO getUser() {
		return user;
	}



	public void setUser(UserDTO user) {
		this.user = user;
	}



	public JobDTO(Job job) {
		this.jobid = job.getJobid();
		this.jobtype = job.getJobtype();
		this.title = job.getTitle();
		this.minsalary = job.getMinsalary();
		this.maxsalary = job.getMaxsalary();
		this.dateCreated = job.getDateCreated();
		this.experience = job.getExperience();
		this.langue = job.getLangue();
		this.description = job.getDescription();
		this.requirements = job.getRequirements();
		this.localisation = job.getLocalisation();
		this.website = job.getWebsite();
		this.expire = job.getExpire();
		this.user = new UserDTO(job.getUser());
		//this.favorits = job.getFavorits().stream().map(f -> new FavoritDTO(f)).collect(Collectors.toSet());
	}



	public Long getJobid() {
		return jobid;
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



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
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



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public Date getExpire() {
		return expire;
	}



	public void setExpire(Date expire) {
		this.expire = expire;
	}





}
