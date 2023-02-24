package com.example.users.dto;

import java.util.Date;


import com.example.users.entities.Postuler;



public class PostulerDTO {
	
	private Long postulerid;
	
	private JobDTO job;
	
	
	private UserDTO user;
	
	
	private Date dateCreated;
	

	private String description;
	
	private int etat;

	public Long getPostulerid() {
		return postulerid;
	}

	public void setPostulerid(Long postulerid) {
		this.postulerid = postulerid;
	}


	public JobDTO getJob() {
		return job;
	}

	public void setJob(JobDTO job) {
		this.job = job;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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
	
	public PostulerDTO(Postuler postuler) {
		this.postulerid = postuler.getPostulerid();
		this.job = new JobDTO(postuler.getJob());
		this.user = new UserDTO(postuler.getUser());
		this.dateCreated = postuler.getDateCreated();	
		this.description = postuler.getDescription();
		this.etat = postuler.getEtat();
	}



	public PostulerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PostulerDTO [postulerid=" + postulerid + ", job=" + job + ", user=" + user + ", dateCreated="
				+ dateCreated + ", description=" + description + ", etat=" + etat + "]";
	}

	

}
