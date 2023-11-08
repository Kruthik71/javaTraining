package com.valtech.training.spring.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.service.EmployeeService;

class EmployeeServiceTest {

	private ApplicationContext appCtx;
	private DateFormat dateFormat;
	
	@BeforeEach
	void setUp() {
		appCtx=new ClassPathXmlApplicationContext("tx2.xml");
		dateFormat=new SimpleDateFormat("dd-MM-yyyy");
	}
	
	@AfterEach
	void tearDown() {
		((AbstractApplicationContext) appCtx).close();
	}

	
	@Test
	void test() throws ParseException {
		Employee e=new Employee("Puneeth",dateFormat.parse("03-03-2000") ,5000,'M',false);
		EmployeeService empSer=(EmployeeService) appCtx.getBean("empSer");
		empSer.createEmployee(e);
		System.out.println(e);
		e=empSer.incrementSalary(e, 20000);
		System.out.println(e);
	}
}

//org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.orm.hibernate3.HibernateTransactionManager#0' defined in class path resource [tx.xml]: Unsatisfied dependency expressed through bean property 'dataSource': : Error creating bean with name 'org.apache.tomcat.dbcp.dbcp2.BasicDataSource#0' defined in class path resource [tx.xml]: Instantiation of bean failed; nested exception is java.lang.NoClassDefFoundError: org/apache/juli/logging/LogFactory; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.apache.tomcat.dbcp.dbcp2.BasicDataSource#0' defined in class path resource [tx.xml]: Instantiation of bean failed; nested exception is java.lang.NoClassDefFoundError: org/apache/juli/logging/LogFactory

// org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.orm.hibernate3.HibernateTransactionManager#0' defined in class path resource [tx.xml]: Cannot resolve reference to bean 'sessionFactory' while setting bean property 'sessionFactory'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'sessionFactory' defined in class path resource [tx.xml]: Unsatisfied dependency expressed through bean property 'cacheProvider': : Cannot find class [com.mysql.cj.jdbc.MySqlDataSource] for bean with name 'com.mysql.cj.jdbc.MySqlDataSource#0' defined in class path resource [tx.xml]; nested exception is java.lang.ClassNotFoundException: com.mysql.cj.jdbc.MySqlDataSource; nested exception is org.springframework.beans.factory.CannotLoadBeanClassException: Cannot find class [com.mysql.cj.jdbc.MySqlDataSource] for bean with name 'com.mysql.cj.jdbc.MySqlDataSource#0' defined in class path resource [tx.xml]; nested exception is java.lang.ClassNotFoundException: com.mysql.cj.jdbc.MySqlDataSource

// org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.orm.hibernate3.HibernateTransactionManager#0' defined in class path resource [tx.xml]: Cannot resolve reference to bean 'sessionFactory' while setting bean property 'sessionFactory'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sessionFactory' defined in class path resource [tx.xml]: Cannot resolve reference to bean 'dataSource' while setting bean property 'dataSource'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSource' defined in class path resource [tx.xml]: Error setting property values; nested exception is org.springframework.beans.NotWritablePropertyException: Invalid property 'user' of bean class [org.springframework.jdbc.datasource.SingleConnectionDataSource]: Bean property 'user' is not writable or has an invalid setter method. Does the parameter type of the setter match the return type of the getter?

//org.springframework.transaction.CannotCreateTransactionException: Could not open Hibernate Session for transaction; nested exception is org.hibernate.exception.JDBCConnectionException: Cannot open connection



