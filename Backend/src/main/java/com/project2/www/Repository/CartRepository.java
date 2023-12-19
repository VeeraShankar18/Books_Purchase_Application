package com.project2.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.www.Store.CartBooks;

public interface CartRepository extends JpaRepository<CartBooks,Long>
{

}
