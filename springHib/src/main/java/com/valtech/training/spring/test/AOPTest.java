package com.valtech.training.spring.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.Airthemetic;
import com.valtech.training.spring.AirthemeticImpl;

class AOPTest {
	
	ApplicationContext appCtx;
	
	@BeforeEach
	void intitialized() {
		appCtx=new ClassPathXmlApplicationContext("aop.xml");
	}

	@AfterEach
	void closeall() {
		((AbstractApplicationContext) appCtx).close();
	}
	
	@Test
	void test() {
		Airthemetic air=(Airthemetic) appCtx.getBean(Airthemetic.class);
		System.out.println(air.getClass().getName());
		assertEquals(7,air.add(-4, -3));
		try {
			air.div(5, 0);
			fail("No exception occured");
		}
		catch(Exception e) {
		}
	}

}
