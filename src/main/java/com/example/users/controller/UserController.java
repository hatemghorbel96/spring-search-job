package com.example.users.controller;




import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;




import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import com.example.users.dto.UserDTO;
import com.example.users.entities.User;
import com.example.users.repository.UserRepository;

import com.example.users.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	 @Autowired  ServletContext context;
	 
	 @Autowired
	    private UserRepository userRep;
	 
	 @Autowired
		BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	 @Autowired
	 UserService userservice;
	 
	
	 
	 private static final Logger log = LoggerFactory.getLogger(User.class);
	 
	 public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/img";
	 public static String uploadDirectorycv = System.getProperty("user.dir") + "/src/main/webapp/image";
		
		  @RequestMapping(method = RequestMethod.POST)		  
			@ResponseBody
			public String saveuser(User u, @RequestParam(value ="img", required = false) MultipartFile file,@RequestParam(value="image", required = false) MultipartFile filecv) {
				if (file != null) {
					String filename = u.getUserid() + file.getOriginalFilename();
					Path fileNameAndPath = Paths.get(uploadDirectory, filename);
					try {
						Files.write(fileNameAndPath, file.getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
					u.setPhoto(filename);
				}
				if (filecv != null) {
					String cvname = u.getUserid() + filecv.getOriginalFilename();
					Path fileNameAndPathcv = Paths.get(uploadDirectorycv, cvname);
					try {
						Files.write(fileNameAndPathcv, filecv.getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
					u.setCv(cvname);
				}
				u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
				userRep.save(u);
				return "Save Data Successfully ! ";
			}
		 
	 
		/*
		 * @RequestMapping(method = RequestMethod.POST)
		 * 
		 * @ResponseBody public String saveuser(User u,@RequestParam("img")
		 * MultipartFile file) { if (file != null) { String filename=u.getUserid() +
		 * file.getOriginalFilename(); Path fileNameAndPath
		 * =Paths.get(uploadDirectory,filename); try { Files.write(fileNameAndPath,
		 * file.getBytes()); } catch (IOException e) { e.printStackTrace(); }
		 * u.setPhoto(filename); }
		 * 
		 * u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		 * userRep.save(u); return "Save Data Successfully ! "; }
		 */
	 
	 @RequestMapping(value="getUser/{id}",method = RequestMethod.GET)
		public User getUserById(@PathVariable("id") Long id) {
		return userservice.getUser(id);
		}
	 
	 @RequestMapping(value="getall",method = RequestMethod.GET)
		public List<User> getAll() {
		return userRep.findAll();
		}
	 
	
	 
	 @RequestMapping(value="getUserByName/{username}",method = RequestMethod.GET)
		public User consulterUserbyusername(@PathVariable("username") String username) {
		return userservice.findUserByUsername(username);
		}
	 
	 
	 
	
	 
	 @GetMapping(path="/profilphoto/{id}")
		public byte[] getPhoto(@PathVariable("id")Long id) throws Exception{
			User user = userRep.findById(id).get();
			
			//return Files.readAllBytes(Paths.get(context.getRealPath("/img/")+user.getPhoto()));
			 Path imagePath = Paths.get(context.getRealPath("/img/") + user.getPhoto());
			  
			  if (!Files.exists(imagePath)) {
			    // handle the exception, for example return a default image
			    imagePath = Paths.get(context.getRealPath("/img/") + "user.png");
			  }
			  
			  return Files.readAllBytes(imagePath);
		}
	 
	 @GetMapping(path="/profilcv/{id}")
	 public ResponseEntity<byte[]> getcv(@PathVariable("id")Long id) throws Exception{
	     User user = userRep.findById(id).get();
	     byte[] contents = Files.readAllBytes(Paths.get(context.getRealPath("/image/") + user.getCv()));
	     
	     HttpHeaders headers = new HttpHeaders();
	     headers.setContentType(MediaType.APPLICATION_PDF);
	     //headers.setContentDispositionFormData("attachment", user.getCv());
	     headers.setContentDispositionFormData("inline", user.getCv());
	     return new ResponseEntity<>(contents, headers, HttpStatus.OK);
	 }

	 @GetMapping(path="/profilcvview/{id}")
	 public ResponseEntity<byte[]> getcvview(@PathVariable("id")Long id) throws Exception{
	     User user = userRep.findById(id).get();
	     byte[] contents = Files.readAllBytes(Paths.get(context.getRealPath("/image/") + user.getCv()));
	     
	     HttpHeaders headers = new HttpHeaders();
	     headers.setContentType(MediaType.APPLICATION_PDF);
	    	
	     return new ResponseEntity<>(contents, headers, HttpStatus.OK);
	 }

	 
	 
	 @RequestMapping(value="currentuser/{username}",method = RequestMethod.GET)
	 public ResponseEntity<User> getCurrentUser(@PathVariable("username") String username) {
	    
	     // String email = SecurityContextHolder.getContext().getAuthentication().getName();
	      
	      // User user = userRep.findByEmail(email);
		 	User user = userRep.findByUsername(username);
	      if (user != null) {
	          return new ResponseEntity<User>(user, HttpStatus.OK);
	      } else {
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	  }
	 
	 @RequestMapping(value = "updateinfo/{username}",method = RequestMethod.PUT)
		public void updateinfo(@RequestBody User u,@PathVariable("username") String username) {
		
			User currentUser = userRep.findByUsername(username);
		
	
		currentUser.setPhoto(currentUser.getPhoto());
		currentUser.setCv(currentUser.getCv());
		
		
		currentUser.setFirstname(u.getFirstname());
		
		currentUser.setLastname(u.getLastname());
		currentUser.setEmail(u.getEmail());
		 userRep.save(currentUser);	 
		}
	
	 
	
	 
	 
	
	 
	
	 
		
	

}
