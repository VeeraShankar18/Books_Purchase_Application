package com.project2.www.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.www.Service.UserDetailsService;
import com.project2.www.Store.UserDetails;

@RestController
@RequestMapping("/UserDetails")
@CrossOrigin(origins="*")
public class UserDetailsController 
{
	@Autowired
	UserDetailsService userDetailsService;
	
	@PostMapping("/add")
	public String addUserDetails(@RequestBody UserDetails userDetails)
	{
		return userDetailsService.addUserDetails(userDetails);
	}
	
	@GetMapping("/get/{userName}")
	public UserDetails getUserDetailsByUserName(@PathVariable String userName)
	{
		return userDetailsService.getUserDetailsByUserName(userName);
	}
}
