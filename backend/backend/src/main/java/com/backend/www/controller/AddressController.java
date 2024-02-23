package com.backend.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.www.model.Address;
import com.backend.www.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin("*")
public class AddressController 
{
	@Autowired
	AddressService addressService;
	
	@PostMapping("/add")
	public String addAddressDetails(@RequestBody Address address)
	{
		return addressService.addAddressDetails(address);
	}
	
	@GetMapping("/getAll")
	public List<Address> getAllAddresses()
	{
		return addressService.getAllAddresses();
	}
	
	@DeleteMapping("/delete/{bookId}")
	public String deleteAddress(@PathVariable long bookId)
	{
		return addressService.deleteAddress(bookId);
	}
}
