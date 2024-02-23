package com.backend.www.controller;

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

import com.backend.www.model.Wishlist;
import com.backend.www.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin("*")
public class WishlistController 
{
	@Autowired
	WishlistService wishlistService;
	
	@PostMapping("/add")
	public String addWishlistBook(@RequestBody Wishlist book)
	{
		return wishlistService.addWishlistBook(book);
	}
	
	@GetMapping("/getAll")
	public List<Wishlist> getAllWishlistBooks()
	{
		return wishlistService.getAllWishlistBooks();
	}
	
	@GetMapping("/get/{bookId}")
	public Object getWishlistBookById(@PathVariable long bookId)
	{
		return wishlistService.getWishlistBookById(bookId);
	}
	
	@DeleteMapping("/delete/{bookId}")
	public String deleteWishlistBook(@PathVariable long bookId)
	{
		return wishlistService.deleteWishlistBook(bookId);
	}
}
