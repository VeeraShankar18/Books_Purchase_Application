package com.project2.www.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.www.Exception.ResourceNotFoundException;
import com.project2.www.Repository.ClassicBooksRepository;
import com.project2.www.Store.ClassicBooks;

@Service
public class ClassicBooksService 
{
	@Autowired
	ClassicBooksRepository booksRepository;
	
	public List<ClassicBooks> getAllBooksDetails()
	{
		return booksRepository.findAll();
	}
	
	public Object getBookDetailsByBookNum(long bookNum)
	{
		return booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
	}
	
	public String addBookDetails(ClassicBooks classicBooks)
	{
		booksRepository.save(classicBooks);
		return "Classic Books Record Inserted Successfully";
	}
	
	public String updateBookDetails(long bookNum,ClassicBooks bookDetails)
	{
		ClassicBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		details.setBookName(bookDetails.getBookName());
		details.setBookCost(bookDetails.getBookCost());
		booksRepository.save(details);
		return "Classic Book Record Updated Successfully";
	}
	
	public String deleteBookDetails(long bookNum)
	{
		ClassicBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		booksRepository.delete(details);
		return "Classic Book Record Deleted Successfully";
	}
}
