package com.backend.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.www.model.Wishlist;
import com.backend.www.repo.WishlistRepo;

@Service
public class WishlistService 
{
	@Autowired
	WishlistRepo wishlistRepo;
	
	public String addWishlistBook(Wishlist book)
	{
		wishlistRepo.save(book);
		return "wishlist book inserted";
	}
	
	public List<Wishlist> getAllWishlistBooks()
	{
		return wishlistRepo.findAll();
	}
	
	public Object getWishlistBookById(long bookId)
	{
		return wishlistRepo.findById(bookId);
	}
	
	public String deleteWishlistBook(long bookId)
	{
		wishlistRepo.deleteById(bookId);
		return "cart book deleted";
	}
}
