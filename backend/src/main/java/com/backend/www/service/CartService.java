package com.backend.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.www.model.Cart;
import com.backend.www.repo.CartRepo;

@Service
public class CartService 
{
	@Autowired
	CartRepo cartRepo;
	
	public String addBookToCart(Cart book)
	{
		cartRepo.save(book);
		return "book added to cart";
	}
	
	public List<Cart> getAllCartBooks()
	{
		return cartRepo.findAll();
	}
	
	public Object getCartBookById(long bookId)
	{
		return cartRepo.findById(bookId);
	}
	
	public String deleteCartBook(long bookId)
	{
		cartRepo.deleteById(bookId);
		return "cart book deleted";
	}
}
