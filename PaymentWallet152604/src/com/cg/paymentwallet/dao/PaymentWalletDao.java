package com.cg.paymentwallet.dao;

import java.math.BigDecimal;


import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.PaymentWalletException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PaymentWalletDao implements IPaymentWalletDao{
  
        public static Map<String,Wallet> accounts=new HashMap<String, Wallet>();
        public static Map<String,String> transactions=new HashMap<String, String>();
        
	public Wallet registerCustomer(Wallet wallet) throws PaymentWalletException {
		accounts.put(wallet.getPhoneNumber(),wallet);
		String str=(wallet.getName().concat(" ").concat("your transactions are "));
		transactions.put(wallet.getPhoneNumber(),str);
		return wallet;
	}

	public Wallet depositMoney(String phone, BigDecimal balance) throws PaymentWalletException {
		Wallet wallet=accounts.get(phone);
                    if(wallet!=null)
                    {
                        BigDecimal updateBalance=((wallet.getBalance()).add(balance));
                        wallet.setBalance(updateBalance);
                        LocalDateTime now=LocalDateTime.now();
                        String str1=transactions.get(phone);
                        StringBuilder builder1=new StringBuilder(str1);
                        builder1.append("*");
                        builder1.append(("you have deposited money: ").concat(balance.toString().concat(" ").concat(now.toString())));
                        transactions.put(phone,builder1.toString());
                       
                        return wallet;
                    }
                    else
                    {
                    	throw new PaymentWalletException("phone not available");
                    }
	}

	public Wallet withdrawMoney(String phone, BigDecimal balance) throws PaymentWalletException {
		Wallet wallet=accounts.get(phone);
		if(wallet!=null){
        	BigDecimal big=wallet.getBalance().max(new BigDecimal(1000));
        if(wallet.getBalance()==big){
                    BigDecimal updateBalance=((wallet.getBalance()).subtract(balance));
					wallet.setBalance(updateBalance);
					LocalDateTime now=LocalDateTime.now();
					String str1=transactions.get(phone);
					StringBuilder builder1=new StringBuilder(str1);
					builder1.append("*");
					builder1.append(("you have withdrawed money: ").concat(balance.toString().concat(" ").concat(now.toString())));
					transactions.put(phone,builder1.toString());
					return wallet;
        }
        else
        {
        	throw new PaymentWalletException("phone not available");
        }
		}
		 else
         {
         	throw new PaymentWalletException("phone not available");
         }
	}

	public Wallet fundTransfer(String sourcePhone, String targetPhone, BigDecimal balance) throws PaymentWalletException {
		Wallet wallet =accounts.get(sourcePhone);
                Wallet wallet1=accounts.get(targetPhone);
                if((wallet!=null)&&(wallet1!=null))
                {
                	 if((wallet!=null)&&(wallet1!=null)){
                     	BigDecimal big=(wallet.getBalance()).max(balance);
                     if(wallet.getBalance()==big){
                	
                      BigDecimal updateBalance=((wallet.getBalance()).subtract(balance));
                        wallet.setBalance(updateBalance);
                        BigDecimal updateBalance1=((wallet1.getBalance()).add(balance));
                        wallet1.setBalance(updateBalance1);
                        LocalDateTime now=LocalDateTime.now();
                        String str1=transactions.get(sourcePhone);
                        StringBuilder builder1=new StringBuilder(str1);
                        builder1.append("*");
                        builder1.append(("you have made fund transfer to: ").concat(targetPhone));
                        builder1.append((" of amount: ").concat(balance.toString()).concat(" ").concat(now.toString()));
                        transactions.put(targetPhone,builder1.toString());
                       
                       
                        String str=transactions.get(targetPhone);
                        StringBuilder builder=new StringBuilder(str);
                        builder.append("*");
                        builder.append(("you have received fund transfer from: ").concat(sourcePhone));
                        builder.append((" of amount: ").concat(balance.toString()).concat(" ").concat(now.toString()));
                        transactions.put(targetPhone,builder.toString());
                        return wallet;
                }
                     else
                     {
                     	throw new PaymentWalletException("phone not available");
                     }
                }
                	 else
                     {
                     	throw new PaymentWalletException("phone not available");
                     }
                }
                else
                {
                	throw new PaymentWalletException("phone not available");
                }
                
				
	}

	public Wallet showBalance(String phone) throws PaymentWalletException {
		Wallet wallet=accounts.get(phone);
                if(wallet!=null)
                {
                    return wallet;
                }
                else
                {
                	throw new PaymentWalletException("phone not available");
                }
	}

	public String printTransaction(String phone) throws PaymentWalletException {
		Wallet wallet=accounts.get(phone);
                if(wallet!=null)
                {
                    //return (HashMap<String, String>) transactions;
                	return transactions.get(phone);
                }
                else
                {
                	throw new PaymentWalletException("phone not available");
                }
	}

   

}
