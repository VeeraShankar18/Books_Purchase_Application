package com.backend.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.www.model.Books;
import com.backend.www.repo.BooksRepo;

@Service
public class BooksService 
{
	@Autowired
	BooksRepo repo;
	
	public String addBooks(Books book)
	{
		repo.save(book);
		return "book record inserted";
	}
	
	public List<Books> getAllBooks()
	{
		return repo.findAll();
	}
	
	public Object getBookById(long bookId)
	{
		return repo.findById(bookId);
	}
	
	public String updateBook(long bookId,Books book)
	{
		Books details=repo.findById(bookId).get();
		details.setBookName(book.getBookName());
		details.setBookAuthor(book.getBookAuthor());
		details.setBookPrice(book.getBookPrice());
		details.setBookGenre(book.getBookGenre());
		details.setBookImg(book.getBookImg());
		details.setBookDescription(book.getBookDescription());
		repo.save(details);
		return "book record updated";
	}
	
	public String deleteBook(long bookId)
	{
		repo.deleteById(bookId);
		return "book record deleted";
	}
}
