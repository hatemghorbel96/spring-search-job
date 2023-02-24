package com.example.users.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.entities.Cv;
import com.example.users.entities.Education;
import com.example.users.entities.Experience;
import com.example.users.entities.Job;
import com.example.users.entities.User;
import com.example.users.repository.CvRepository;
import com.example.users.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cv")
public class CvController {

	@Autowired
    private CvRepository cvrep;
	
	@Autowired
	private UserRepository userRep;

	@RequestMapping(value="add/{username}",method = RequestMethod.POST)
	@ResponseBody
	public String savecv(@PathVariable("username") String username,@RequestBody Cv c) {	
		User u = userRep.findByUsername(username);
		c.setUser(u);
		c.setPubliccv(0);
		Set<Experience> experiences = c.getExperiences();
		experiences.forEach(item -> c.add(item)			
				);	
		Set<Education> educations = c.getEducations();
		educations.forEach(item -> c.addEdu(item)
				 				
				);
		cvrep.save(c);
		return "job added";
	}
	
	
	 @RequestMapping(value="getUser/{id}",method = RequestMethod.GET)
		public Cv getcvById(@PathVariable("id") Long id) {
		return cvrep.findByUserUserid(id);
		}
	 
	 @RequestMapping(value="getUsercv/{username}",method = RequestMethod.GET)
		public Cv getcvByUsername(@PathVariable("username") String username) {
		 int etat=1;
		return cvrep.findpubliccv(etat,username);
		}
	 
	 @RequestMapping(value="getallcv/{username}",method = RequestMethod.GET)
		public List<Cv> getallcvbyuser(@PathVariable("username") String username) {
		
		return cvrep.findByUserUsername(username);
		}
	 
	 @RequestMapping(value="getbyid/{id}",method = RequestMethod.GET)
		public Cv getbyid(@PathVariable("id") Long id) {
		
		return cvrep.findById(id).get();
		}
	 
	 @RequestMapping(value = "editetat/{id}/{username}",method = RequestMethod.PUT)
		public void editetat(@PathVariable("id") Long id,@PathVariable("username") String username) {
		 
		 Cv currentcv = cvrep.findById(id).get();
		 User u = userRep.findByUsername(username);
		 currentcv.setUser(u);
		 if(currentcv.getPubliccv()==0)
		 {
			 currentcv.setPubliccv(1);
		 }
		 else {
			 currentcv.setPubliccv(0);
		 }

		
		 cvrep.save(currentcv);	 
		}
	
	
}
