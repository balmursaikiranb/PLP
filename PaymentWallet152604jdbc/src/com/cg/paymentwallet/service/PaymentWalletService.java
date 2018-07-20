package com.cg.paymentwallet.service;

import com.cg.paymentwallet.dao.IPaymentWalletDao;
import com.cg.paymentwallet.dao.PaymentWalletDao;
import java.math.BigDecimal;


import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.PaymentWalletException;


public class PaymentWalletService extends PaymentWalletDao implements IPaymentsWalletService{
IPaymentWalletDao dao=new PaymentWalletDao();

public boolean validatePassword(String pass) throws PaymentWalletException {
	if (!((pass.length()) >= 8)) {
		throw new PaymentWalletException("enter correct password");
	}
	return true;
}

public boolean validatePhone(String phone) throws PaymentWalletException {
	String pattern = "\\d{10}";
	if (!(phone.matches(pattern))) {
		throw new PaymentWalletException("enter valid phone number");
	}
	return true;
}

public boolean validateMoney(BigDecimal amount) throws PaymentWalletException {
	String amou = amount.toString();
	if (!(amou.matches("\\d+"))) {
		throw new PaymentWalletException("enter valid money");
	}
	return true;
}

public boolean validateName(String name) throws PaymentWalletException {
	if (!(name.matches("[a-zA-Z]+"))) {
		throw new PaymentWalletException("enter valid name");
	}
	return true;

}

public boolean validateEmail(String email) throws PaymentWalletException {
	if (!(email.matches("[a-zA-Z0-9.]+@[a-zA-Z]+.[a-zA-Z]{2,}"))) {
		throw new PaymentWalletException("enter valid email");
	}
	return true;
}

public boolean validateAge(Integer age) throws PaymentWalletException {
	String age1 = age.toString();
	if (!(age1.matches("\\d{2}"))) {
		throw new PaymentWalletException("enter valid age");
	}
	return true;
}

public boolean validateGender(String gender) throws PaymentWalletException {
	if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
		return true;
	} else if (gender.equalsIgnoreCase("female")
			|| gender.equalsIgnoreCase("f")) {
		return true;
	} else {
		throw new PaymentWalletException("enter valid gender");
	}
}
	public Wallet registerCustomer(Wallet wallet) throws PaymentWalletException {
		
		return  dao.registerCustomer(wallet);
	}

	public Wallet depositMoney(String phone, BigDecimal balance) throws PaymentWalletException {
		try {
			if(!(validatePhone(phone)))
			{
				throw new PaymentWalletException("enter correct number");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("enter correct number");
		}
		try {
			if(!(validateMoney(balance)))
			{
				throw new PaymentWalletException("enter balance correctly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("enter correct money");
		}
               
		return dao.depositMoney(phone,balance);
	}

	public Wallet withdrawMoney(String phone, BigDecimal balance) throws PaymentWalletException {
		try {
			if(!(validatePhone(phone)))
			{
				throw new PaymentWalletException("enter correct number");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("enter correct number");
		}
		try {
			if(!(validateMoney(balance)))
			{
				throw new PaymentWalletException("enter balance correctly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("enter correct money");
		}   
		return dao.withdrawMoney(phone,balance);
	}

	public Wallet fundTransfer(String sourcePhone, String targetPhone, BigDecimal balance) throws PaymentWalletException {
		// TODO Auto-generated method stub
		try {
			if(!(validatePhone(sourcePhone)))
			{
				throw new PaymentWalletException("enter correct number");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("enter correct number");
		}
		try {
			if(!(validatePhone(targetPhone)))
			{
				throw new PaymentWalletException("enter correct number");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("enter correct number");
		}
		try {
			if(!(validateMoney(balance)))
			{
				throw new PaymentWalletException("enter balance correctly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("enter correct money");
		}
                return dao.fundTransfer(sourcePhone,targetPhone,balance);
               
	}

	public Wallet showBalance(String phone) throws PaymentWalletException {
		try {
			if(!(validatePhone(phone)))
			{
				throw new PaymentWalletException("enter correct number");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("enter correct number");
		}
		return dao.showBalance(phone);
	}

	public String printTransaction(String phone) throws PaymentWalletException {
		try {
			if(!(validatePhone(phone)))
			{
				throw new PaymentWalletException("enter correct number");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("enter correct number");
		}
		return dao.printTransaction(phone);
	}

}
