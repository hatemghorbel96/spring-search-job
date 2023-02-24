package com.example.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dto.FavoritDTO;
import com.example.users.entities.Favorit;
import com.example.users.entities.Job;
import com.example.users.entities.User;
import com.example.users.repository.Favoritrepository;
import com.example.users.repository.JobRepository;
import com.example.users.repository.UserRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/favorit")
public class FavoritController {

	
	@Autowired
	Favoritrepository favRep;
	
	@Autowired
     UserRepository userRep;
	
	@Autowired
	JobRepository jobrep;
	
	@RequestMapping(value = "addfavorit/{username}/{id}",method = RequestMethod.POST)
	@ResponseBody
	public void addfavorit(@PathVariable("id") long id,@PathVariable("username") String username) {
		
		Favorit f = new Favorit();
		User getuser= userRep.findByUsername(username);
		Job getJob = jobrep.findById(id).get();
		f.setUser(getuser);
		f.setJob(getJob);
	
		favRep.save(f);
		
	}

	
	@RequestMapping(value = "annule/{username}/{id}",method = RequestMethod.DELETE)	
	public void annule(@PathVariable("id") long id,@PathVariable("username") String username) {
		FavoritDTO f = favRep.finduserjob(username,id); 
		  Long getidfavorit=f.getId();
		  favRep.deleteById(getidfavorit);
	
	}
	
	@RequestMapping(value="getall",method=RequestMethod.GET)
	public List<FavoritDTO> getFavall()
	{
		return favRep.findAlldto();
	}
	
	@RequestMapping(value="getfavorit/{username}",method=RequestMethod.GET)
	public List<FavoritDTO> getmyfavorits(@PathVariable("username") String username)
	{
		return favRep.findByUserUsername(username);
	}
	
}
