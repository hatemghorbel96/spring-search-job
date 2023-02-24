package com.example.users.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dto.PostulerDTO;
import com.example.users.entities.Job;
import com.example.users.entities.Postuler;
import com.example.users.entities.User;
import com.example.users.repository.JobRepository;
import com.example.users.repository.PostulerRepository;
import com.example.users.repository.UserRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/postuler")
public class PostulerController {
	
	@Autowired
	PostulerRepository postrep;
	
	@Autowired
    private UserRepository userRep;
	
	@Autowired
	JobRepository jobrep;
	
	@RequestMapping(value="add/{username}/{id}",method = RequestMethod.POST)
	@ResponseBody
	public String postuler(@RequestBody Postuler p, @PathVariable("username") String username,@PathVariable("id") Long id) {
		//Postuler p = new Postuler();
		User u = userRep.findByUsername(username);
		Job j =jobrep.findById(id).get();
		p.setEtat(0);
		p.setUser(u);
		p.setJob(j);
		postrep.save(p);
		return "postuler with success ! ";
	}
	
	@RequestMapping(value="getbyjobid/{id}",method=RequestMethod.GET)
	public List<Postuler> getbyjobid(@PathVariable("id") Long id)
	{
		return postrep.findByJobJobid(id);
	}
	
	@RequestMapping(value="getbyid/{id}",method=RequestMethod.GET)
	public Postuler getbyid(@PathVariable("id") Long id)
	{
		return postrep.findById(id).get();
	}
	
	@RequestMapping(value="getbyusername/{username}",method=RequestMethod.GET)
	public List<PostulerDTO> getbyusername(@PathVariable("username") String username)
	{
		return postrep.findByUserUsername(username);
	}
	
	/*
	 * @PutMapping("edit") public ResponseEntity<String> editEtat(@RequestBody
	 * List<Postuler> postulers) { postulers.forEach(postuler -> { if
	 * (postuler.isSelected()) { postuler.setEtat(1); postrep.save(postuler); } });
	 * return ResponseEntity.ok("Successfully edited etat."); }
	 */
	
	@PutMapping("edit")
	public ResponseEntity<Void> updateEtat(@RequestBody Map<String, List<Long>> idsMap) {
	    List<Long> ids = idsMap.get("ids");
	    List<Postuler> postulers = postrep.findAllById(ids);
	    postulers.forEach(postuler -> postuler.setEtat(1));
	    postrep.saveAll(postulers);
	    return ResponseEntity.noContent().build();
	}
/*	 public ResponseEntity<Void> updateEtat(@RequestBody List<Long> ids) {
        List<Postuler> postulers = postrep.findAllById(ids);
        postulers.forEach(postuler -> postuler.setEtat(1));
        postrep.saveAll(postulers);
        return ResponseEntity.noContent().build();
    }*/

}
