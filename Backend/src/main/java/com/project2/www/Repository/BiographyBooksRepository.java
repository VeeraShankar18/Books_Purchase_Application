package com.project2.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.www.Store.BiographyBooks;

public interface BiographyBooksRepository extends JpaRepository<BiographyBooks,Long>
{

}
