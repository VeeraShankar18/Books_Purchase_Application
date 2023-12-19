package com.project2.www.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.www.Exception.ResourceNotFoundException;
import com.project2.www.Repository.WishListRepository;
import com.project2.www.Store.WishListBooks;

@Service
public class WishListService 
{
	@Autowired
	WishListRepository booksRepository;
	
	public List<WishListBooks> getAllBooksDetails()
	{
		return booksRepository.findAll();
	}
	
	public Object getBookDetailsByBookNum(long bookNum)
	{
		return booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
	}
	
	public String addBookDetails(WishListBooks wishListBooks)
	{
		booksRepository.save(wishListBooks);
		return "Biography Books Record Inserted Successfully";
	}
	
	public String deleteBookDetails(long bookNum)
	{
		WishListBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		booksRepository.delete(details);
		return "Removed From Cart Successfully";
	}
}
