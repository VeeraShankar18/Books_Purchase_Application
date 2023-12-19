package com.project2.www.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.www.Repository.UserDetailsRepository;
import com.project2.www.Store.UserDetails;

@Service
public class UserDetailsService 
{
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	public String addUserDetails(UserDetails userDetails)
	{
		userDetailsRepository.save(userDetails);
		return "User Details Inserted Successfully";
	}
	
	public UserDetails getUserDetailsByUserName(String userName)
	{
		return userDetailsRepository.getByUserName(userName);
	}
}
