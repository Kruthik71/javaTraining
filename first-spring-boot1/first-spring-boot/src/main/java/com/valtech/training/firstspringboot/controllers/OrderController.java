package com.valtech.training.firstspringboot.controllers;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.firstspringboot.models.OrderModel;
import com.valtech.training.firstspringboot.services.OrderService;

@Controller
@RequestMapping(path="/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/edit")
	public String deleteOrder(@RequestParam("id") long id,Model model) {
		model.addAttribute("order",new OrderModel(orderService.getOrder(id)));
		return "orders/edit";
	}
	
//	@GetMapping("/delete")
//	public String deleteOrder(@RequestParam("id") long id,Model model) {
//		// orderService.delete (first create the method and do the things)
//		model.addAttribute("orders",orderService.getAllOrders().stream().map(o->new OrderModel(o)).collect(Collectors.toList()));
//		return "orders/list";
//	}
	
	@PostMapping(path="/save",params="Cancel")
	public String cancelEditOrder(Model model) {
		model.addAttribute("orders",orderService.getAllOrders().stream().map(o->new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
	}
	
	@PostMapping(path="/save",params="submit")
	public String saveOrder(@ModelAttribute OrderModel orderModel,Model model) {
		orderService.createOrder(orderModel.getOrder());
		model.addAttribute("orders",orderService.getAllOrders().stream().map(o->new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
	}
	
	@GetMapping("/new")
	public String newOrder(Model model) {
		model.addAttribute("order",new OrderModel());
		return "orders/edit";
	}
	
	@GetMapping("/list")
	public String listOrders(Model model) {
		model.addAttribute("orders",orderService.getAllOrders().stream().map(o->new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
	}
}
