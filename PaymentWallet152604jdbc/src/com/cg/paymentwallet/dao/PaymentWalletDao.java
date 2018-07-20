package com.cg.paymentwallet.dao;

import java.math.BigDecimal;


import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.PaymentWalletException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PaymentWalletDao implements IPaymentWalletDao{
  
	Connection con = null;
	public PaymentWalletDao(){
		try {
			con = DBUtil.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Establishing connection
	}
	public Wallet registerCustomer(Wallet wallet) throws PaymentWalletException {
		try {
			
			String sql = "INSERT INTO PaymentWalletCustomers VALUES(?, ?, ?, ?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			String sql1 = "INSERT INTO LoginCustomers VALUES(?, ?)";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt.setString(1, wallet.getPhoneNumber());
			pstmt.setString(2, wallet.getName());
			pstmt.setString(3, wallet.getEmailId());
			pstmt.setString(4, wallet.getGender());
			pstmt.setInt(5, wallet.getAge());
			pstmt.setBigDecimal(5, wallet.getBalance());
			int row = pstmt.executeUpdate();
			pstmt1.setString(1,wallet.getPhoneNumber());
			pstmt1.setString(2,wallet.getPassword());
			int row1=pstmt1.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("error");
		}
		return wallet;

	}
		

	public Wallet depositMoney(String phone, BigDecimal balance) throws PaymentWalletException {
		BigDecimal bal = null; 
		try{
		String sql1="SELECT balance from PaymentWalletCustomers WHERE phoneNumber=?";
		
			PreparedStatement pstmt = con.prepareStatement(sql1);
			 pstmt.setString(1,phone);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				 bal = res.getBigDecimal(1);
			}
		String	sql="UPDATE PaymentWalletCustomers SET balance = ? WHERE phoneNumber = ?";
	PreparedStatement preparedStmt = con.prepareStatement(sql);
    preparedStmt.setBigDecimal(1,(bal.add(balance)));
    preparedStmt.setString(2,phone);
    preparedStmt.executeUpdate();
	}catch(SQLException e)
	{
		System.out.println("error");
	}
		
		return null;
		
	}

	public Wallet withdrawMoney(String phone, BigDecimal balance) throws PaymentWalletException {
		BigDecimal bal = null; 
		try{
		String sql1="SELECT balance from PaymentWalletCustomers WHERE phoneNumber=?";
		
			PreparedStatement pstmt = con.prepareStatement(sql1);
			 pstmt.setString(1,phone);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				 bal = res.getBigDecimal(1);
			}
		String	sql="UPDATE PaymentWalletCustomers SET balance = ? WHERE phoneNumber = ?";
	PreparedStatement preparedStmt = con.prepareStatement(sql);
    preparedStmt.setBigDecimal(1,(bal.subtract(balance)));
    preparedStmt.setString(2,phone);
    preparedStmt.executeUpdate();
	}catch(SQLException e)
	{
		System.out.println("error");
	}
		return null;
		
	}

	public Wallet fundTransfer(String sourcePhone, String targetPhone, BigDecimal balance) throws PaymentWalletException {
		BigDecimal bal = null; 
		try{
			String sql1="SELECT balance from PaymentWalletCustomers WHERE phoneNumber=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql1);
			 pstmt.setString(1,sourcePhone);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				 bal = res.getBigDecimal(1);
			}
		String	sql="UPDATE PaymentWalletCustomers SET balance = ? WHERE phoneNumber = ?";
	PreparedStatement preparedStmt = con.prepareStatement(sql);
    preparedStmt.setBigDecimal(1,(bal.subtract(balance)));
    preparedStmt.setString(2,sourcePhone);
    preparedStmt.executeUpdate();	
			
			
			
			
		String sql2="SELECT balance from PaymentWalletCustomers WHERE phoneNumber=?";
		
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			 pstmt2.setString(1,targetPhone);
			ResultSet res2 = pstmt2.executeQuery();
			if (res2.next()) {
				 bal = res2.getBigDecimal(1);
			}
		String	sql3="UPDATE PaymentWalletCustomers SET balance = ? WHERE phoneNumber = ?";
	PreparedStatement preparedStmt3 = con.prepareStatement(sql3);
    preparedStmt3.setBigDecimal(1,(bal.add(balance)));
    preparedStmt3.setString(2,targetPhone);
    preparedStmt3.executeUpdate();
	}catch(SQLException e)
	{
		System.out.println("error");
	}	
		
		
		return null;
			}

	public Wallet showBalance(String phone) throws PaymentWalletException {
		
		try{
			String sql2="SELECT balance from PaymentWalletCustomers WHERE phoneNumber=?";
		
		
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		 pstmt2.setString(1,phone);
		ResultSet res2 = pstmt2.executeQuery();
		if (res2.next()) {
			BigDecimal bal = res2.getBigDecimal(1);
		}
		}catch(SQLException e){
			System.out.println("error");
		}
		return null;
	}

	public String printTransaction(String phone) throws PaymentWalletException {
		try{
			String sql2="SELECT transactions from PaymentWalletTransactions WHERE phoneNumber=?";
		
		
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		 pstmt2.setString(1,phone);
		ResultSet res2 = pstmt2.executeQuery();
		if (res2.next()) {
			Long str = res2.getLong(1);
		}
		}catch(SQLException e){
			System.out.println("error");
		}
		return null;
		
	}

   

}
