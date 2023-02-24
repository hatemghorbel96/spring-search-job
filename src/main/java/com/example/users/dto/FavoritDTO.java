package com.example.users.dto;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.example.users.entities.Favorit;
import com.example.users.entities.Job;
import com.example.users.entities.Postuler;
import com.example.users.entities.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class FavoritDTO {

	 private long id;
		
	 
	 private UserDTO user;
	 

	 private JobDTO job;
	 
	 public FavoritDTO(Favorit favorit) {
			this.id = favorit.getId();
			this.job = new JobDTO(favorit.getJob());
			this.user = new UserDTO(favorit.getUser());
		
		}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public JobDTO getJob() {
		return job;
	}

	public void setJob(JobDTO job) {
		this.job = job;
	}

	public FavoritDTO(long id, UserDTO user, JobDTO job) {
		super();
		this.id = id;
		this.user = user;
		this.job = job;
	}
	
	

	public FavoritDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FavoritDTO [id=" + id + ", user=" + user + ", job=" + job + "]";
	}
	 
	
	 
}
