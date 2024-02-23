package com.backend.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.www.model.Address;
import com.backend.www.repo.AddressRepo;

@Service
public class AddressService 
{
	@Autowired
	AddressRepo addressRepo;
	
	public String addAddressDetails(Address address)
	{
		addressRepo.save(address);
		return "address uploaded";
	}
	
	public List<Address> getAllAddresses()
	{
		return addressRepo.findAll();
	}
	
	public String deleteAddress(long bookId)
	{
		addressRepo.deleteById(bookId);
		return "address deleted";
	}
}
