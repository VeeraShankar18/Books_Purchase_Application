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

import com.project2.www.Service.ClassicBooksService;
import com.project2.www.Store.ClassicBooks;

@RestController
@RequestMapping("/ClassicBooks")
@CrossOrigin(origins="*")
public class ClassicBooksController 
{
	@Autowired
	ClassicBooksService booksService;
	
	@GetMapping("/getAll")
	public List<ClassicBooks> getAllBooksDetails()
	{
		return booksService.getAllBooksDetails();
	}
	
	@GetMapping("/get/{bookNum}")
	public Object getBookDetailsByBookNum(@PathVariable long bookNum)
	{
		return booksService.getBookDetailsByBookNum(bookNum);
	}
	
	@PostMapping("/add")
	public String addBookDetails(@RequestBody ClassicBooks classicBooks)
	{
		return booksService.addBookDetails(classicBooks);
	}
	
	@PutMapping("/update/{bookNum}")
	public String updateBookDetails(@PathVariable long bookNum,@RequestBody ClassicBooks bookDetails)
	{
		return booksService.updateBookDetails(bookNum,bookDetails);
	}
	
	@DeleteMapping("/delete/{bookNum}")
	public String deleteBookDetails(@PathVariable long bookNum)
	{
		return booksService.deleteBookDetails(bookNum);
	}
}
