package com.project2.www.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.www.Service.HistoricalBooksService;
import com.project2.www.Store.HistoricalBooks;

@RestController
@RequestMapping("/HistoricalBooks")
@CrossOrigin(origins="*")
public class HistoricalBooksController 
{
	@Autowired
	HistoricalBooksService booksService;
	
	@GetMapping("/getAll")
	public List<HistoricalBooks> getAllBooksDetails()
	{
		return booksService.getAllBooksDetails();
	}
	
	@GetMapping("/get/{bookNum}")
	public Object getBookDetailsByBookNum(@PathVariable long bookNum)
	{
		return booksService.getBookDetailsByBookNum(bookNum);
	}
	
	@PostMapping("/add")
	public String addBookDetails(@RequestBody HistoricalBooks historicalBooks)
	{
		return booksService.addBookDetails(historicalBooks);
	}
	
	@PutMapping("/update/{bookNum}")
	public String updateBookDetails(@PathVariable long bookNum,@RequestBody HistoricalBooks bookDetails)
	{
		return booksService.updateBookDetails(bookNum,bookDetails);
	}
	
	@DeleteMapping("/delete/{bookNum}")
	public String deleteBookDetails(@PathVariable long bookNum)
	{
		return booksService.deleteBookDetails(bookNum);
	}
}
