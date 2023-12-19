package com.project2.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.www.Store.HistoricalBooks;

public interface HistoricalBooksRepository extends JpaRepository<HistoricalBooks,Long>
{

}
