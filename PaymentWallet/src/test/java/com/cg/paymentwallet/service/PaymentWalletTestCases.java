package com.cg.paymentwallet.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.PaymentWalletException;

public class PaymentWalletTestCases {
	private static IPaymentsWalletService paymentwalletservice = null;

	@BeforeClass
	public static void setUpBeforeClass() throws PaymentWalletException {
		paymentwalletservice = new PaymentWalletService();

	}

	@Test(expected=PaymentWalletException.class)
	public void customerPassRegistrationtest() throws PaymentWalletException {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(21);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNotNull(customer);
	}

	@Test(expected=PaymentWalletException.class)
	public void customerFailRegistrationtestWithPhoneNumber() throws PaymentWalletException {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(21);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test(expected=PaymentWalletException.class)
	public void customerSecondFailRegistrationtestwithEmailId() throws PaymentWalletException {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur");
		wallet.setAge(21);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test(expected=PaymentWalletException.class)
	public void customerSecondFailRegistrationtestwithName() throws PaymentWalletException {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("sai");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(21);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test(expected=PaymentWalletException.class)
	public void customerSecondFailRegistrationtestwithAge() throws PaymentWalletException {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(200);
		wallet.setGender("male");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test(expected=PaymentWalletException.class)
	public void customerSecondFailRegistrationtestwithGender() throws PaymentWalletException {
		Wallet wallet = new Wallet();
		wallet.setPhoneNumber("9703806992");
		wallet.setName("saikiran");
		wallet.setEmailId("balmur@saikiran@gmail.com");
		wallet.setAge(21);
		wallet.setGender("hai");
		wallet.setBalance(new BigDecimal(2000));
		Wallet customer = paymentwalletservice.registerCustomer(wallet);
		assertNull(customer);
	}

	@Test(expected=PaymentWalletException.class)
	public void depositMoneyFailWithPhone() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.depositMoney("9703", new BigDecimal(2000));
		assertNull(customer);
	}

	@Test(expected=PaymentWalletException.class)
	public void depositMoneyPassWithPhone() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.depositMoney("9703806992", new BigDecimal(2000));
		assertNotNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void withdrawMoneyFailWithPhone() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.withdrawMoney("9703806", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void withdrawMoneyPassWithMoney() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.withdrawMoney("9703806806992", new BigDecimal(2000));
		assertNotNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void fundTransferFailWithsourcePhone() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.fundTransfer("9703806","8341219705", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void fundTransferFailWithsourcePhoneMaxNumbers() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.fundTransfer("9703806992456","8341219705", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void fundTransferFailWithTargetPhoneMaxNumbers() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.fundTransfer("9703806992","8341219705123", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void fundTransferFailWithTargetPhone() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.fundTransfer("9703806992","834121", new BigDecimal(2000));
		assertNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void fundTransferPassWithAllCorrect() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.fundTransfer("9703806992","8341219705", new BigDecimal(2000));
		assertNotNull(customer);
	}

	@Test(expected=PaymentWalletException.class)
	public void showBalanceFailWithPhone() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.showBalance("9703806");
		assertNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void showBalancePassWithPhone() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.showBalance("9703806992");
		assertNotNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void printStatementFailWithPhone() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.showBalance("9703806");
		assertNull(customer);
	}
	@Test(expected=PaymentWalletException.class)
	public void printStatementPassWithPhone() throws PaymentWalletException {
		Wallet customer = paymentwalletservice.showBalance("9703806992");
		assertNotNull(customer);
	}
}
