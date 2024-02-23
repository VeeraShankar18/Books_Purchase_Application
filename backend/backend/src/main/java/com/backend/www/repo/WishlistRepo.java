package com.backend.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.www.model.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist,Long>{

}
