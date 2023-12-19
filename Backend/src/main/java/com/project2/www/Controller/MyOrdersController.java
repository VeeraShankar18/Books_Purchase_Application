package com.project2.www.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.www.Service.MyOrdersService;
import com.project2.www.Store.MyOrders;

@RestController
@RequestMapping("/MyOrders")
@CrossOrigin(origins="*")
public class MyOrdersController 
{
	@Autowired
	MyOrdersService myOrdersService;
	
	@PostMapping("/add")
	public String addOrderDetails(@RequestBody MyOrders orderedBook)
	{
		return myOrdersService.addOrderDetails(orderedBook);
	}
	
	@GetMapping("/getAll")
	public List<MyOrders> getAllOrders()
	{
		return myOrdersService.getAllOrders();
	}
	
	@DeleteMapping("/delete/{bookNum}")
	public String deleteOrderDetails(@PathVariable long bookNum)
	{
		return myOrdersService.deleteOrderDetails(bookNum);
	}
}
