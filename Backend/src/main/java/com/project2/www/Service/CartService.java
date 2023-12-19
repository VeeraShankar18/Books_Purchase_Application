package com.project2.www.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.www.Exception.ResourceNotFoundException;
import com.project2.www.Repository.CartRepository;
import com.project2.www.Store.CartBooks;

@Service
public class CartService 
{
	@Autowired
	CartRepository booksRepository;
	
	public List<CartBooks> getAllBooksDetails()
	{
		return booksRepository.findAll();
	}
	
	public Object getBookDetailsByBookNum(long bookNum)
	{
		return booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
	}
	
	public String addBookDetails(CartBooks cartBooks)
	{
		booksRepository.save(cartBooks);
		return "Biography Books Record Inserted Successfully";
	}
	
	public String deleteBookDetails(long bookNum)
	{
		CartBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		booksRepository.delete(details);
		return "Removed From Cart Successfully";
	}
}
