package com.project2.www.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.www.Repository.MyOrdersRepository;
import com.project2.www.Store.MyOrders;

@Service
public class MyOrdersService 
{
	@Autowired 
	MyOrdersRepository myOrdersRepository;
	
	public String addOrderDetails(MyOrders orderedBook)
	{
		myOrdersRepository.save(orderedBook);
		return "Orderd Book Details Saved Successfully";
	}
	
	public List<MyOrders> getAllOrders()
	{
		return myOrdersRepository.findAll();
	}
	
	public String deleteOrderDetails(long bookNum)
	{
		myOrdersRepository.deleteById(bookNum);
		return "Order Details Deleted";
	}
}
