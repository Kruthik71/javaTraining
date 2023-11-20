package com.valtech.training.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double balance;
	private String accType;
	
	//Fetch always lazy for a collection
	@OneToMany(targetEntity = Tx.class,cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY,
			mappedBy="account")
	private Set<Tx> transactions;
	
	//Many to Many (Accounts->Customers)
	@ManyToMany(targetEntity = Customer.class,fetch = FetchType.LAZY)
	@JoinTable(name = "customer_account",
		joinColumns = @JoinColumn(name = "account_id",referencedColumnName = "id"), //Account->Customer
		inverseJoinColumns = @JoinColumn(name="customer_id",referencedColumnName = "id") //Customer->Account
	)
	private Set<Customer> customers;

	public Account() {
	}

	public Account(double balance, String accType) {
		this.balance = balance;
		this.accType = accType;
	}
	
	public void addCustomers(Customer cust) {
		if(getCustomers()==null) {
			setCustomers(new HashSet<Customer>());
		}
		getCustomers().add(cust);
		if(cust.getAccounts()==null) {
			cust.setAccounts(new HashSet<Account>());
		}
		cust.getAccounts().add(this);
	}
	
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	public Set<Customer> getCustomers() {
		return customers;
	}
	
	public void addTx(Tx tx) {
		if(getTransactions()==null) {
			setTransactions(new HashSet<Tx>());
		}
		getTransactions().add(tx);
		tx.setAccount(this);
	}
	
	public void setTransactions(Set<Tx> transactions) {
		this.transactions = transactions;
	}
	
	public Set<Tx> getTransactions() {
		return transactions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

}
