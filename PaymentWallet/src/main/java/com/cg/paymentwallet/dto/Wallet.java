package com.cg.paymentwallet.dto;

import java.math.BigDecimal;

public class Wallet extends Customer{
private BigDecimal balance;
private String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
Customer details;
	public Wallet(String phoneNumber, String emailId, String name, Integer age, String gender) {
		super(phoneNumber, emailId, name, age, gender);
		// TODO Auto-generated constructor 
	}
	public Wallet() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Customer getDetails() {
		return details;
	}
	public void setDetails(Customer details) {
		this.details = details;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}

