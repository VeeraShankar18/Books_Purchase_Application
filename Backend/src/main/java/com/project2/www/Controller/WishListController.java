package com.project2.www.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.www.Service.WishListService;
import com.project2.www.Store.WishListBooks;

@RestController
@RequestMapping("/WishListBooks")
@CrossOrigin(origins="*")
public class WishListController 
{
	@Autowired
	WishListService booksService;
	
	@GetMapping("/getAll")
	public List<WishListBooks> getAllBooksDetails()
	{
		return booksService.getAllBooksDetails();
	}
	
	@GetMapping("/get/{bookNum}")
	public Object getBookDetailsByBookNum(@PathVariable long bookNum)
	{
		return booksService.getBookDetailsByBookNum(bookNum);
	}
	
	@PostMapping("/add")
	public String addBookDetails(@RequestBody WishListBooks wishListBooks)
	{
		return booksService.addBookDetails(wishListBooks);
	}
	
	@DeleteMapping("/delete/{bookNum}")
	public String deleteBookDetails(@PathVariable long bookNum)
	{
		return booksService.deleteBookDetails(bookNum);
	}
}
