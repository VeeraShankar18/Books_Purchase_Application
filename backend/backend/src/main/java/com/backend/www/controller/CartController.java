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

import com.backend.www.model.Cart;
import com.backend.www.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController 
{
	@Autowired
	CartService cartService;
	
	@PostMapping("/add")
	public String addBookToCart(@RequestBody Cart book)
	{
		return cartService.addBookToCart(book);
	}
	
	@GetMapping("/getAll")
	public List<Cart> getAllCartBooks()
	{
		return cartService.getAllCartBooks();
	}
	
	@GetMapping("/get/{bookId}")
	public Object getCartBookById(@PathVariable long bookId)
	{
		return cartService.getCartBookById(bookId);
	}
	
	@DeleteMapping("/delete/{bookId}")
	public String deleteCartBook(@PathVariable long bookId)
	{
		return cartService.deleteCartBook(bookId);
	}
	
}
