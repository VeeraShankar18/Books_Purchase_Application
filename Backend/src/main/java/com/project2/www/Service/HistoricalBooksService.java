package com.project2.www.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.www.Exception.ResourceNotFoundException;
import com.project2.www.Repository.HistoricalBooksRepository;
import com.project2.www.Store.HistoricalBooks;

@Service
public class HistoricalBooksService 
{
	@Autowired
	HistoricalBooksRepository booksRepository;
	
	public List<HistoricalBooks> getAllBooksDetails()
	{
		return booksRepository.findAll();
	}
	
	public Object getBookDetailsByBookNum(long bookNum)
	{
		return booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
	}
	
	public String addBookDetails(HistoricalBooks historicalBooks)
	{
		booksRepository.save(historicalBooks);
		return "Historical Books Record Inserted Successfully";
	}
	
	public String updateBookDetails(long bookNum,HistoricalBooks bookDetails)
	{
		HistoricalBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		details.setBookName(bookDetails.getBookName());
		details.setBookCost(bookDetails.getBookCost());
		booksRepository.save(details);
		return "Historical Book Record Updated Successfully";
	}
	
	public String deleteBookDetails(long bookNum)
	{
		HistoricalBooks details=booksRepository.findById(bookNum).orElseThrow(()->new ResourceNotFoundException("BookNumber Not Found"));
		booksRepository.delete(details);
		return "Historical Book Record Deleted Successfully";
	}
}
