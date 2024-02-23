package com.backend.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.www.model.Books;

@Repository
public interface BooksRepo extends JpaRepository<Books,Long>{

}
