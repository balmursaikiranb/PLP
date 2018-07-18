package com.cg.paymentwallet.service;

import com.cg.paymentwallet.dao.IPaymentWalletDao;
import com.cg.paymentwallet.dao.PaymentWalletDao;
import java.math.BigDecimal;


import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.IPaymentWalletException;
import com.cg.paymentwallet.exception.PaymentWalletException;


public class PaymentWalletService implements IPaymentsWalletService{
IPaymentWalletDao dao=new PaymentWalletDao();

public boolean validatePassword(String pass) throws PaymentWalletException {
	if (!((pass.length()) >= 8)) {
		throw new PaymentWalletException(IPaymentWalletException.MESSAGE2);
	}
	return true;
}

public boolean validatePhone(String phone) throws PaymentWalletException {
	String pattern = "\\d{10}";
	if (!(phone.matches(pattern))) {
		throw new PaymentWalletException(IPaymentWalletException.MESSAGE3);
	}
	return true;
}

public boolean validateMoney(BigDecimal amount) throws PaymentWalletException {
	String amou = amount.toString();
	if (!(amou.matches("\\d+"))) {
		throw new PaymentWalletException(IPaymentWalletException.MESSAGE4);
	}
	return true;
}

public boolean validateName(String name) throws PaymentWalletException {
	if (!(name.matches("[a-zA-Z]+"))) {
		throw new PaymentWalletException(IPaymentWalletException.MESSAGE6);
	}
	return true;

}

public boolean validateEmail(String email) throws PaymentWalletException {
	if (!(email.matches("[a-zA-Z0-9.]+@[a-zA-Z]+.[a-zA-Z]{2,}"))) {
		throw new PaymentWalletException(IPaymentWalletException.MESSAGE7);
	}
	return true;
}

public boolean validateAge(Integer age) throws PaymentWalletException {
	String age1 = age.toString();
	if (!(age1.matches("\\d{2}"))) {
		throw new PaymentWalletException(IPaymentWalletException.MESSAGE8);
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
		throw new PaymentWalletException(IPaymentWalletException.MESSAGE9);
	}
}
	public Wallet registerCustomer(Wallet wallet) throws PaymentWalletException {
		
		return  dao.registerCustomer(wallet);
	}

	public Wallet depositMoney(String phone, BigDecimal balance) throws PaymentWalletException {
		try {
			if(!(validatePhone(phone)))
			{
				throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(IPaymentWalletException.MESSAGE5);
		}
		try {
			if(!(validateMoney(balance)))
			{
				throw new PaymentWalletException(IPaymentWalletException.MESSAGE4);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(IPaymentWalletException.MESSAGE4);
		}
               
		return dao.depositMoney(phone,balance);
	}

	public Wallet withdrawMoney(String phone, BigDecimal balance) throws PaymentWalletException {
		try {
			if(!(validatePhone(phone)))
			{
				throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(IPaymentWalletException.MESSAGE5);
		}
		try {
			if(!(validateMoney(balance)))
			{
				throw new PaymentWalletException(IPaymentWalletException.MESSAGE4);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PaymentWalletException(IPaymentWalletException.MESSAGE4);
		}   
		return dao.withdrawMoney(phone,balance);
	}

	public Wallet fundTransfer(String sourcePhone, String targetPhone, BigDecimal balance) throws PaymentWalletException {
		// TODO Auto-generated method stub
		try {
			if(!(validatePhone(sourcePhone)))
			{
				throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
		}
		try {
			if(!(validatePhone(targetPhone)))
			{
				throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
		}
		try {
			if(!(validateMoney(balance)))
			{
				throw new PaymentWalletException(IPaymentWalletException.MESSAGE4);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PaymentWalletException(IPaymentWalletException.MESSAGE4);
		}
                return dao.fundTransfer(sourcePhone,targetPhone,balance);
               
	}

	public Wallet showBalance(String phone) throws PaymentWalletException {
		try {
			if(!(validatePhone(phone)))
			{
				throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
		}
		return dao.showBalance(phone);
	}

	public String printTransaction(String phone) throws PaymentWalletException {
		try {
			if(!(validatePhone(phone)))
			{
				throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new PaymentWalletException(IPaymentWalletException.MESSAGE5);
		}
		return dao.printTransaction(phone);
	}

	public boolean checkLogin(String number, String password) throws PaymentWalletException {
		// TODO Auto-generated method stub
		return dao.checkLogin(number,password);
	}

}
