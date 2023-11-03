package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.RegAddress;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args) throws HibernateException, ParseException {
		DateFormat df=new SimpleDateFormat("dd-mm-yyyy");
		//Loads hibernate.properties file 
		AnnotationConfiguration cfg=new AnnotationConfiguration();
		
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(AtmTx.class);
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Registration.class).addAnnotatedClass(RegAddress.class);
		cfg.addAnnotatedClass(BankAccountId.class).addAnnotatedClass(BankAccount.class);
		
		SessionFactory sesFac=cfg.buildSessionFactory();
		Session ses=sesFac.openSession();
		Transaction tx=ses.beginTransaction();
		
//		ses.persist(new Employee("Kruthik",LocalDate.of(2001, 2, 4),43105,'M',true));
		
		//IDENTITY insert and then print , TABLE and SEQUENCE first print but not insert and hibernate does when needed 
//		int id=(Integer) ses.save(new Employee("Kruthik",df.parse("04-03-2001"),43105,'M',true));
//		System.out.println(id);
//		
//		Employee e=(Employee)ses.get(Employee.class,1);
//		System.out.println(e.getClass().getName());
//		e.setName("Kruthik B");
//		
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000,101,201));
//		ses.save(new TellerTx(3000,301,601));
//		ses.save(new AtmTx(5000,1001));
//		
//		ses.createQuery("From Tx tx").list().forEach(t->System.out.println(t));
		
		//One to One relation
//		Customer cust=new Customer("Kruthik",23);
//		ses.save(cust);
//		Address addr=new Address("Kengeri","Banglore",560059);
//		addr.setCustomer(cust);
//		ses.save(addr);
		
		//One to Many
//		Account acc=new Account(10000,"Savings");
//		
//		Account acc1=new Account(20000,"Savings");
//		
//		Tx tx1=new Tx(1000);
//		Tx tx2=new ChequeTx(102,123123,3456);
//		Tx tx3=new TellerTx(302,123,345);
//		Tx tx4=new AtmTx(2001,789);
//		
//		Tx tx5=new ChequeTx(103,123456,6789);
//		
//		ses.persist(acc);
//		ses.persist(acc1);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		
//		ses.persist(tx5);
//		
//		acc.addTx(tx1);
//		acc.addTx(tx2);
//		acc.addTx(tx3);
//		acc.addTx(tx4);
//		
//		acc1.addTx(tx5);
//		
//		//Many to Many
//		Customer cus1=new Customer("Gagan",24);
//		Address addr1=new Address("JP nagar","Banglore",560070);
//		Customer cus2=new Customer("Kalasa",23);
//		Address addr2=new Address("Naampalli","Hyderabad",500080);
//		
//		ses.persist(cus1);
//		ses.persist(cus2);
//		ses.persist(addr1);
//		ses.persist(addr2);
//		
//		cus1.setAddress(addr1);
//		addr1.setCustomer(cus1);
//		cus2.setAddress(addr2);
//		addr2.setCustomer(cus2);
//		
//		acc1.addCustomers(cus1);
//		acc1.addCustomers(cus2);
//		acc.addCustomers(cus1);
//		acc.addCustomers(cus2);
		
		//Querying in Hibernate
		
//		ses.createQuery("Select tx from Tx tx").list().forEach(t->System.out.println(t));
		
		//Distinct accounts related to a transaction
//		ses.createQuery("Select distinct tx.account from Tx tx").list().forEach(t->System.out.println(t));
		
		//Customers whose transaction amount is more than 3000
//		Query q=ses.createQuery("Select distinct c from Customer c join c.accounts a join a.transactions t where t.amount > ?");
//		q.setFloat(0, 2000);
//		q.list().forEach(t->System.out.println(t));
		
		//Transaction selection from city and amount condition
//		Query q1=ses.createQuery("Select t from Tx t join t.account.customers c where c.address.city =? and t.amount > ?");
//		q1.setString(0,"Banglore");
//		q1.setFloat(1,1000);
//		q1.list().forEach(t->System.out.println(t));
		
		//Named Queries 
		Query q2=ses.getNamedQuery("Tx.findAllByCityandAmountGreaterThan");
		q2.setString(0,"Banglore");
		q2.setFloat(1,1000);
		q2.list().forEach(t->System.out.println(t));
		
		ses.persist(new BankAccount(new BankAccountId("Savings",1),3000));
		BankAccountId id=new BankAccountId("Savings",1);
		BankAccount bank=(BankAccount) ses.load(BankAccount.class, id);
		
		tx.commit();
		ses.close();
		sesFac.close();
	}
}
