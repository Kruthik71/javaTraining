package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.HelloWorld;
import com.valtech.training.spring.Line;
import com.valtech.training.spring.SimpleInterest;
import com.valtech.training.spring.UtilsBean;

class IOCTest {

	ApplicationContext appCtx;
	ApplicationContext childAppCtx;
	
	@BeforeEach
	void intitialized() {
		appCtx=new ClassPathXmlApplicationContext("ioc.xml");
		childAppCtx=new ClassPathXmlApplicationContext(new String[]{"ioc-child.xml"},appCtx);
	}
	
	@Test
	void testChildAppCtx() {
		Line line=(Line) childAppCtx.getBean("l1");
		System.out.println(line);
	}
	
	@Test
	void test() {
		//Running XML 
		HelloWorld hw=(HelloWorld) appCtx.getBean("hw");
		assertEquals("Hello World",hw.hello("World"));
		assertEquals(appCtx.getBean("hw"), appCtx.getBean("abc"));
		//Normal JUnit 
		HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.hello("John");
        assertEquals("Hello John", result);
	}
	
	@Test
	void testPoint() {
		System.out.println(appCtx.getBean("p1"));
		assertEquals(appCtx.getBean("p1"), appCtx.getBean("p1"));
	}
	
	@Test 
	void testPointSetterInjection(){
		System.out.println(appCtx.getBean("p2"));
	}
	
	@Test
	void testLine() {
		System.out.println(appCtx.getBean("l1"));
	}
	
	@Test
	void testLine1() {
		System.out.println(appCtx.getBean("l2"));
	}
	
	@Test
	void testSimpleInterest() {
		SimpleInterest si=(SimpleInterest) appCtx.getBean(SimpleInterest.class);
		System.out.println(si.ComputeInterest(10000, 4, 12));
	}
	
	@Test
	void testUtils() {
		UtilsBean ub=(UtilsBean) appCtx.getBean(UtilsBean.class);
		System.out.println(ub.getNames());
		System.out.println(ub.getSettings());
		System.out.println(ub.getPoints());
	}
}
