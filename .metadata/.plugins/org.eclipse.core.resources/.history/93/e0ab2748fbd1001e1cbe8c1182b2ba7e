package com.backend.www.controller;

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

import com.backend.www.model.Books;
import com.backend.www.service.BooksService;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BooksController 
{
	@Autowired
	BooksService service;
	
	@PostMapping("/add")
	public String addBooks(@RequestBody Books book)
	{
		return service.addBooks(book);
	}
	
	@GetMapping("/getAll")
	public List<Books> getAllBooks()
	{
		return service.getAllBooks();
	}
	
	@GetMapping("/get/{bookId}")
	public Object getBookById(@PathVariable long bookId)
	{
		return service.getBookById(bookId);
	}
	
	@PutMapping("/update/{bookId}")
	public String updateBook(@PathVariable long bookId,@RequestBody Books book)
	{
		return service.updateBook(bookId,book);
	}
	
	@DeleteMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable long bookId)
	{
		return service.deleteBook(bookId);
	}
}
