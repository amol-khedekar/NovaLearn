package com.novalearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.novalearn.model.Professor;
import com.novalearn.model.User;
import com.novalearn.services.ProfessorService;
import com.novalearn.services.UserService;

@RestController
public class LoginController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/")
    public String welcomeMessage()
    {
    	return "Welcome to NovaLearn - LMS";
    }
	
	@PostMapping("/loginuser")
	@CrossOrigin(origins = "http://localhost:3000")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String currEmail = user.getEmail();
		String currPassword = user.getPassword();
		
		User userObj = null;
		if(currEmail != null && currPassword != null)
		{
			userObj = userService.fetchUserByEmailAndPassword(currEmail, currPassword);
		}
		if(userObj == null)
		{
			throw new Exception("Invalid username/password !");
		}		
		return userObj;
	}
	
	@PostMapping("/loginprofessor")
	@CrossOrigin(origins = "http://localhost:3000")
	public Professor loginDoctor(@RequestBody Professor professor) throws Exception
	{
		String currEmail = professor.getEmail();
		String currPassword = professor.getPassword();
		
		Professor professorObj = null;
		if(currEmail != null && currPassword != null)
		{
			professorObj = professorService.fetchProfessorByEmailAndPassword(currEmail, currPassword);
		}
		if(professorObj == null)
		{
			throw new Exception("Invalid username/password !");
		}		
		return professorObj;
	}
}