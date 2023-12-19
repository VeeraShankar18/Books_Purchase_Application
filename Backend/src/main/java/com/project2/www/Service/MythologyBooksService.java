package com.project2.www.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.www.Exception.ResourceNotFoundException;
import com.project2.www.Repository.MythologyBooksRepository;
import com.project2.www.Store.MythologyBooks;

@Service
public class MythologyBooksService 
{
	@Autowired
	MythologyBooksRepository booksRepository;
	
	public List<MythologyBooks> getAllBooksDetails()
	{
		return booksRepository.findAll();
	}
	
	public Object getBookDetailsByBookNum(long bookNum)
	{
		return booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
	}
	
	public String addBookDetails(MythologyBooks mythologyBooks)
	{
		booksRepository.save(mythologyBooks);
		return "Mythology Books Record Inserted Successfully";
	}
	
	public String updateBookDetails(long bookNum,MythologyBooks bookDetails)
	{
		MythologyBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		details.setBookName(bookDetails.getBookName());
		details.setBookCost(bookDetails.getBookCost());
		booksRepository.save(details);
		return "Mythology Book Record Updated Successfully";
	}
	
	public String deleteBookDetails(long bookNum)
	{
		MythologyBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		booksRepository.delete(details);
		return "Mythology Book Record Deleted Successfully";
	}
}
