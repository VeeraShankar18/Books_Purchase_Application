package com.project2.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.www.Store.ClassicBooks;

public interface ClassicBooksRepository extends JpaRepository<ClassicBooks,Long>
{

}
