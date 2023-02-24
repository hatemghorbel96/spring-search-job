package com.example.users.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.users.entities.Cv;
import com.example.users.entities.Job;
import com.example.users.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserDTO {
	

	private Long userid;


	private String username;
	

	private String email;
   
	private String password;
	
	private Integer type;

	private String photo;
		
 
	private Set<JobDTO> jobs = new HashSet<>();

    

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


	public Set<JobDTO> getJobs() {
		return jobs;
	}

	public void setJobs(Set<JobDTO> jobs) {
		this.jobs = jobs;
	}

	public UserDTO(User user) {
		this.userid = user.getUserid();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.photo = user.getPhoto();
		/*
		 * this.jobs = user.getJobs().stream() .map(JobDTO::new)
		 * .collect(Collectors.toSet());
		 */
	}

	public UserDTO(Long userid, String username, String email, String password, Integer type, String photo,
			Set<JobDTO> jobs) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.type = type;
		this.photo = photo;
		this.jobs = jobs;
	}
	
    



}
