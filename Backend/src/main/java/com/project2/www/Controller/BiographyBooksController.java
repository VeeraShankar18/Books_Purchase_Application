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

import com.project2.www.Service.BiographyBooksService;
import com.project2.www.Store.BiographyBooks;

@RestController
@RequestMapping("/BiographyBooks")
@CrossOrigin(origins="*")
public class BiographyBooksController 
{
	@Autowired
	BiographyBooksService booksService;
	
	@GetMapping("/getAll")
	public List<BiographyBooks> getAllBooksDetails()
	{
		return booksService.getAllBooksDetails();
	}
	
	@GetMapping("/get/{bookNum}")
	public Object getBookDetailsByBookNum(@PathVariable long bookNum)
	{
		return booksService.getBookDetailsByBookNum(bookNum);
	}
	
	@PostMapping("/add")
	public String addBookDetails(@RequestBody BiographyBooks biographyBooks)
	{
		return booksService.addBookDetails(biographyBooks);
	}
	
	@PutMapping("/update/{bookNum}")
	public String updateBookDetails(@PathVariable long bookNum,@RequestBody BiographyBooks bookDetails)
	{
		return booksService.updateBookDetails(bookNum,bookDetails);
	}
	
	@DeleteMapping("/delete/{bookNum}")
	public String deleteBookDetails(@PathVariable long bookNum)
	{
		return booksService.deleteBookDetails(bookNum);
	}
}
