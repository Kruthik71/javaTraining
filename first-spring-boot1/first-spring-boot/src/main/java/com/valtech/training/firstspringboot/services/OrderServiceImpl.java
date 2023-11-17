package com.valtech.training.firstspringboot.services;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.repositories.OrderRepo;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private OrderRepo orderRepo;
	
	@PostConstruct
	public void populateOrders() {
		Order obj=new Order("Macbook Air M3", 24, "For the Team", LocalDate.of(2023, 11, 8));
		orderRepo.save(obj);
		orderRepo.save(new Order("IPhone 15 pro max", 24, "For the Company", LocalDate.of(2023, 11, 8)));
	}
	
	@Override
	public Order createOrder(Order order) {
		System.out.println(orderRepo.getClass().getName());
		return orderRepo.save(order);
	}
	
	@Override
	public Order updateOrder(Order order) {
		return orderRepo.save(order);
	}
	
	@Override
	public Order getOrder(long orderId) {
		return orderRepo.getReferenceById(orderId);
	}
	
	@Override
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}
}
