package com.cg.paymentwallet.dto;

public class Customer {
private String phoneNumber;
private String emailId;
private String name;
public Customer(String phoneNumber, String emailId, String name, Integer age, String gender) {
	super();
	this.phoneNumber = phoneNumber;
	this.emailId = emailId;
	this.name = name;
	this.age = age;
	this.gender = gender;
}
public Customer() {
	// TODO Auto-generated constructor stub
}
private Integer age;
private String gender;
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
}

