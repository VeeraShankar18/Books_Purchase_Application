package com.project2.www.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.www.Exception.ResourceNotFoundException;
import com.project2.www.Repository.BiographyBooksRepository;
import com.project2.www.Store.BiographyBooks;

@Service
public class BiographyBooksService 
{
	@Autowired
	BiographyBooksRepository booksRepository;
	
	public List<BiographyBooks> getAllBooksDetails()
	{
		return booksRepository.findAll();
	}
	
	public Object getBookDetailsByBookNum(long bookNum)
	{
		return booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
	}
	
	public String addBookDetails(BiographyBooks biographyBooks)
	{
		booksRepository.save(biographyBooks);
		return "Biography Books Record Inserted Successfully";
	}
	
	public String updateBookDetails(long bookNum,BiographyBooks bookDetails)
	{
		BiographyBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		details.setBookName(bookDetails.getBookName());
		details.setBookCost(bookDetails.getBookCost());
		booksRepository.save(details);
		return "Biography Book Record Updated Successfully";
	}
	
	public String deleteBookDetails(long bookNum)
	{
		BiographyBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		booksRepository.delete(details);
		return "Biography Book Record Deleted Successfully";
	}
}
