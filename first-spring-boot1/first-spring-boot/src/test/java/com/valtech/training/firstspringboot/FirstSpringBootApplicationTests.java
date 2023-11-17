package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.EmployeeD;
import com.valtech.training.firstspringboot.components.EmployeeDAO;
import com.valtech.training.firstspringboot.components.HelloWorld;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.services.OrderService;

@SpringBootTest
class FirstSpringBootApplicationTests {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private HelloWorld helloworld;
	@Autowired
	private OrderService orderService;
	@Autowired
	private SimpleInterest simpleInterest;
	
//	@Test
//	void testSI() {
//		System.out.println(simpleInterest.ComputeInterest(20000, 3, 2));
//	}
	
	@Test
	void testOrders() {
		//Create
//		Order o=orderService.createOrder(new Order("Nothing Phone 1",25,"For the entire team",LocalDate.of(2023, 04, 8)));
		
		//Read
		Order o1 = orderService.getOrder(1);
		assertEquals(1,o1.getId());
		assertTrue(orderService.getAllOrders().size()>0);
//		System.out.println(o1.getItem()); [Error while using this]
	}
	
	@Test
	void testEmployeeDAO() {
		//Count
		assertEquals(8,employeeDAO.countEmployee());
		assertEquals(8, employeeDAO.getAllEmployees().size());
		
		//Create
//		EmployeeD emp=new EmployeeD("Dhanush",22,1,1,20000,1);
//		employeeDAO.createEmployee(emp);
//		assertEquals(9,employeeDAO.countEmployee());
		
		//Delete
//		employeeDAO.deleteEmployee(16);
//		assertEquals(8,employeeDAO.countEmployee());
		
		//GetAllEmployees
//		List<EmployeeD> emps=employeeDAO.getAllEmployees();
//		System.out.println(emps);
		
		//GetEmployee
//		EmployeeD emp=employeeDAO.getEmployee(1);
//		System.out.println(emp);
		
		//Employee age between
//		List<EmployeeD> emps=employeeDAO.getEmployeeAgeBetween(22, 40);
//		System.out.println(emps);
		
		//Employee by Seniority
//		List<EmployeeD> emps=employeeDAO.getEmployeeBySeniority(4);
//		System.out.println(emps);
		
		//Employee greater and lesser than amount
//		List<EmployeeD> emps1=employeeDAO.getEmployeeSalaryGreater(40000);
//		List<EmployeeD> emps2=employeeDAO.getEmployeeSalaryLesser(40000);
//		System.out.println(emps1);
//		System.out.println(emps2);
	}
	

	@Test
	void contextLoads() {
		assertNotNull(helloworld);
		assertEquals("Hello Spring Boot", helloworld.hello());
	}
	
	

}

