package com.project2.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.www.Store.WishListBooks;

public interface WishListRepository extends JpaRepository<WishListBooks,Long>
{

}
