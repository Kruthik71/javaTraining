package com.valtech.training.firstspringboot.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.firstspringboot.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{
	//Methods to retrieve custom orders
	
	@Query(value="SELECT o FROM Order o where o.itemCount = ?1")
	List<Order> findAllByItemCount(int itemCount);
	
	List<Order> findAllByItemCountGreaterThan(int itemCount);
	
	List<Order> findAllByItemAndItemCount(String item,int itemCount);
	
	int countByItem(String item);
}
