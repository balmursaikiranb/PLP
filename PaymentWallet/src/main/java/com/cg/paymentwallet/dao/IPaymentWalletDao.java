package com.cg.paymentwallet.dao;

import java.math.BigDecimal;


import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.PaymentWalletException;


public interface IPaymentWalletDao {
	Wallet registerCustomer(Wallet wallet) throws PaymentWalletException;
	Wallet depositMoney(String phone,BigDecimal balance) throws PaymentWalletException;
	Wallet withdrawMoney(String phone,BigDecimal balance) throws PaymentWalletException;
	Wallet fundTransfer(String sourcePhone,String targetPhone,BigDecimal balance) throws PaymentWalletException;
	Wallet showBalance(String phone) throws PaymentWalletException;
	//HashMap<String,String> printTransaction(String phone) throws PaymentWalletException;
	String printTransaction(String phone) throws PaymentWalletException;
	boolean checkLogin(String number, String password) throws PaymentWalletException;
    
}
