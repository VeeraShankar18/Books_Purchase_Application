package com.project2.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.www.Store.MyOrders;

public interface MyOrdersRepository extends JpaRepository<MyOrders,Long>{

}
