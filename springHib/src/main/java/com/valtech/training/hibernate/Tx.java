package com.valtech.training.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "discriminator") // Should be string to easily understandable)
//@DiscriminatorValue("Tx")

//Not changing table structure so in parent table we make it all transactions
@Table(name = "allTx")

@NamedQueries({
	@NamedQuery(name="Tx.findAll",query="Select tx from Tx tx"), 
	@NamedQuery(name="Tx.findAllByCityandAmountGreaterThan",query="Select t from Tx t join t.account.customers c where c.address.city = ? and t.amount > ?"),
})
public class Tx {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float amount;
	@ManyToOne(targetEntity = Account.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;

	public Tx() {
	}

	public Tx(float amt) {
		this.amount = amt;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmt() {
		return amount;
	}

	public void setAmt(float amt) {
		this.amount = amt;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
