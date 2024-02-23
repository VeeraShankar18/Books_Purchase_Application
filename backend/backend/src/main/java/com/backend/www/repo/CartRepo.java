package com.backend.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.www.model.Cart;

public interface CartRepo extends JpaRepository<Cart,Long>{

}
