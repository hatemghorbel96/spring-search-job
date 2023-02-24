package com.example.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dto.JobDTO;
import com.example.users.entities.Job;
import com.example.users.entities.User;

import com.example.users.repository.JobRepository;
import com.example.users.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jobapi")
public class JobController {
	@Autowired
	JobRepository jobrep;
	@Autowired
    private UserRepository userRep;
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Job> getAllJobs()
	{
		return jobrep.findAll();
	}
	
	@RequestMapping(path="alldto",method=RequestMethod.GET)
	public List<JobDTO> getAllJobsdto()
	{
		return jobrep.findAlldto();
	}
	
	@RequestMapping(value="getjob/{id}",method=RequestMethod.GET)
	public Job getJobById(@PathVariable("id") Long id)
	{
		return jobrep.findById(id).get();
	}
	
	@RequestMapping(value="add/{username}",method = RequestMethod.POST)
	@ResponseBody
	public String saveJob(@PathVariable("username") String username,@RequestBody Job j) {
		User u = userRep.findByUsername(username);
		j.setUser(u);
		jobrep.save(j);
		return "job added Successfully ! ";
	}
	
	@RequestMapping(value="jobByPrix/{maxvol}/{minvol}",method = RequestMethod.GET)
	public List<Job> findByPrixMaxMin(@PathVariable("maxvol") Integer maxprod,@PathVariable("minvol") Integer minprod) {
	return jobrep.findMaxPrix(maxprod, minprod);
	}
	
	@RequestMapping(value="getjobbyusername/{username}",method=RequestMethod.GET)
	public List<Job> getJobsByusername(@PathVariable("username") String username)
	{
		return jobrep.findByUserUsername(username);
	}
	
}
