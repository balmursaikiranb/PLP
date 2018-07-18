

package com.cg.paymentwallet.ui;

import java.math.BigDecimal;
import java.util.Scanner;



import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.IPaymentWalletException;
import com.cg.paymentwallet.exception.PaymentWalletException;
import com.cg.paymentwallet.service.IPaymentsWalletService;
import com.cg.paymentwallet.service.PaymentWalletService;

public class MyMainApplication {
    public static void main(String args[])
    {
    	details();
  
}
    private static void details()
    {  	IPaymentsWalletService paymentwalletservice=new PaymentWalletService();
	int choice = 0;
	boolean error = false;
	String money;
	String ch;
	String number;
do{
System.out.println("1. register");
System.out.println("2.login");
System.out.println("3.exit");
Scanner sc1 = new Scanner(System.in);
System.out.println("enter the choice:");
choice = sc1.nextInt();
switch (choice) {
case 1:
	Scanner scanner =new Scanner(System.in);
    
	 try{      
		 Wallet wallet =new Wallet();
		 System.out.println("enter phone number");
		 String phone=scanner.next();
		 error=paymentwalletservice.validatePhone(phone);
		 if(error)
		 {
		 wallet.setPhoneNumber(phone);
		 System.out.println("enter name");
		 String name=scanner.next();
		 error=paymentwalletservice.validateName(name);
		 if(error)
		 {
		 wallet.setName(name);
		 System.out.println("enter age");
		 int  age=scanner.nextInt();
		 error=paymentwalletservice.validateAge(age);
		 if(error)
		 {
		 wallet.setAge(age);
		 System.out.println("enter gender");
		 String gender=scanner.next();
		 error=paymentwalletservice.validateGender(gender);
		 if(error)
		 {
		 wallet.setGender(gender);
		 System.out.println("enter email");
		 String email=scanner.next();
		 error=paymentwalletservice.validateEmail(email);
		 if(error)
		 {
			 wallet.setEmailId(email);
			 System.out.println("enter password");
				String password=sc1.next();
				error=paymentwalletservice.validatePassword(password);
				 if(error)
				 {
					
		 wallet.setPassword(password);
		 wallet.setBalance(new BigDecimal(0));
		 Wallet wall = paymentwalletservice.registerCustomer(wallet);
		System.out.println("welcome");
	     System.out.println("Name: "+wall.getName());
	     System.out.println("Balance:"+wall.getBalance());
		 }
		 }
		 }
		 }
		 }
		 }
		 }catch(PaymentWalletException paymentwalletexception)
		 {
		 	System.out.println(paymentwalletexception.getMessage());
		 }
  
	break;
case 2:
	try{
	System.out.println("enter phone number");
	number=sc1.next();
	error=paymentwalletservice.validatePhone(number);
	 if(error)
	 {
	System.out.println("enter password");
	String password=sc1.next();
	error=paymentwalletservice.validatePassword(password);
	 if(error)
	 {
		 error=paymentwalletservice.checkLogin(number,password);
	// if(number.equals("0123456789")&&password.equals("saikiran123")){
	 if(error)
	 {
	
	do {
		
		//System.out.println("1.register customer");
		System.out.println("1. withdraw amount");
		System.out.println("2.deposit amount");
		System.out.println("3.fund transfer");
		System.out.println("4. show balance");
		System.out.println("5.print transactions");
		System.out.println("6.logout");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the choice:");
		choice = sc.nextInt();
		switch (choice) {
	/*	case 1:
			Scanner scanner1 =new Scanner(System.in);
	        
			 try{      
				 Wallet wallet =new Wallet();
				 System.out.println("enter phone number");
				 String phone=scanner1.next();
				 error=paymentwalletservice.validatePhone(phone);
				 if(error)
				 {
				 wallet.setPhoneNumber(phone);
				 System.out.println("enter name");
				 String name=scanner1.next();
				 error=paymentwalletservice.validateName(name);
				 if(error)
				 {
				 wallet.setName(name);
				 System.out.println("enter age");
				 int  age=scanner1.nextInt();
				 error=paymentwalletservice.validateAge(age);
				 if(error)
				 {
				 wallet.setAge(age);
				 System.out.println("enter gender");
				 String gender=scanner1.next();
				 error=paymentwalletservice.validateGender(gender);
				 if(error)
				 {
				 wallet.setGender(gender);
				 System.out.println("enter email");
				 String email=scanner1.next();
				 error=paymentwalletservice.validateEmail(email);
				 if(error)
				 {
				 wallet.setEmailId(email);
				 wallet.setBalance(new BigDecimal(0));
				 Wallet wall = paymentwalletservice.registerCustomer(wallet);
				 System.out.println(wall.getEmailId());
			     System.out.println(wall.getGender());
			     System.out.println(wall.getName());
			     System.out.println(wall.getBalance());
				 }
				 }
				 }
				 }
				 }
				 }catch(PaymentWalletException paymentwalletexception)
				 {
				 	System.out.println(paymentwalletexception.getMessage());
				 }
	       
	       
			break;
			*/
		case 1:
			
			try {
	//			 System.out.println("enter phone number");
		//	        String phone1=sc.next();
			//        error=paymentwalletservice.validatePhone(phone1);
				//	if(error)
					//{
			        System.out.println("enter balance");
			        BigDecimal balance1=sc.nextBigDecimal();
			        error=paymentwalletservice.validateMoney(balance1);
					if(error)
					{
			       	 Wallet wall5;
			       	 wall5 = paymentwalletservice.withdrawMoney(number, balance1);
			       	 System.out.println("Updated balance is"+wall5.getBalance());
					}
					//}
				} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		     
			break;
		case 2:
			
			try {
			/*	System.out.println("enter phone number");
		        String phone2=sc.next();
		        error=paymentwalletservice.validatePhone(phone2);
				if(error)
				{*/
		        System.out.println("enter balance");
		        BigDecimal balance2=sc.nextBigDecimal();
		        error=paymentwalletservice.validateMoney(balance2);
				if(error)
				{
		        Wallet wall3;		
				wall3 = paymentwalletservice.depositMoney(number, balance2);
			       System.out.println("Updated balance is"+wall3.getBalance());
						}
				//	}
			} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		      
			break;
		case 3:
			
			try {
		/*		System.out.println("enter phone number");
		        String phone3=sc.next();
		        error=paymentwalletservice.validatePhone(phone3);
				if(error)
				{*/
		        System.out.println("enter targer phone number");
		        String phone4=sc.next();
		        error=paymentwalletservice.validatePhone(phone4);
				if(error)
				{
		        System.out.println("enter balance");
		        BigDecimal balance3=sc.nextBigDecimal();
		        error=paymentwalletservice.validateMoney(balance3);
				if(error)
				{
				  Wallet wall4;		
				  wall4 = paymentwalletservice.fundTransfer(number, phone4, balance3);
			       System.out.println("Updated balance is"+wall4.getBalance());
				}
				}
				//}
			} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		      
			break;
		case 4:
			try {
		/*	System.out.println("enter phone number");
	        String phone5=sc.next();
	        error=paymentwalletservice.validatePhone(phone5);
			if(error)
			{*/
			  Wallet wall1;
			  wall1 = paymentwalletservice.showBalance(number);
				 
			       System.out.println(wall1.getName());
			       System.out.println("Your balance is"+wall1.getBalance());
			//}
			} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 
			break;
		case 5:
			try {
			/*System.out.println("enter phone number");
	        String phone6=sc.next();
	        error=paymentwalletservice.validatePhone(phone6);
			if(error)
			{*/
			 String result; 
				result = paymentwalletservice.printTransaction(number);
				//System.out.println(result);
				//Set<Entry<String,String>> set = result.entrySet();
				//Iterator<Entry<String, String>> it = set.iterator();
				//while (it.hasNext()) {
					//Entry<String, String> entry = it.next();
					//if((entry.getKey())==phone6)
					//{
					
					//String id11 = entry.getKey();
				//	String dto = entry.getValue();
				 System.out.println("Your Transactions Are:\n");
				Scanner	scanner2=new Scanner(result).useDelimiter("zzz");
				while(scanner2.hasNext())
				{
					String str=scanner2.next();
					System.out.println(str);
				}
					
				//	break;
				//}
				//}
				//}
			} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}	
			break;
		case 6:
			System.out.println(" you are logged out thankyou for using");
			//System.exit(0);
			details();
			break;
		default:
			System.out.println("enter correct value");
		}
		System.out.println("enter y or yes to continue and n or no to exit");
		ch = sc.next();
	} while ((ch.equalsIgnoreCase("y")) || ch.equalsIgnoreCase("yes"));
	 }
	 
	 else
	 {
		 System.out.println("please enter correct details");
	 }
	 
	 }
	 }
	 
	 }catch(PaymentWalletException paymentwalletexception)
	 {
	 	System.out.println(paymentwalletexception.getMessage());
	 }
	 
break;
case 3:
	System.out.println("thankyou for using");
	System.exit(0);
	break;
}
System.out.println("enter y or yes to continue and n or no to exit");
ch = sc1.next();
} while ((ch.equalsIgnoreCase("y")) || ch.equalsIgnoreCase("yes"));
    	
    }
}

    	/*Scanner scanner =new Scanner(System.in);
        
        System.out.println("enter phone number");
        String phone=scanner.next();
        System.out.println("enter email");
        String email=scanner.next();
        System.out.println("enter gender");
        String gender=scanner.next();
        System.out.println("enter name");
        String name=scanner.next();
        System.out.println("enter age");
        int age=scanner.nextInt();
        System.out.println("enter balance");
        BigDecimal balance=scanner.nextBigDecimal();
        Wallet wallet =new Wallet();
        wallet.setAge(age);
        wallet.setBalance(balance);
        wallet.setGender(gender);
        wallet.setName(name);
        wallet.setPhoneNumber(phone);
        wallet.setEmailId(email);
        Wallet wall=paymentwalletservice.registerCustomer(wallet);
        System.out.println(wall.getEmailId());
        System.out.println(wall.getGender());
        System.out.println(wall.getName());
        
        
        
        System.out.println("enter phone number");
        String phone1=scanner.next();
        System.out.println("enter email");
        String email1=scanner.next();
        System.out.println("enter gender");
        String gender1=scanner.next();
        System.out.println("enter name");
        String name1=scanner.next();
        System.out.println("enter age");
        int age1=scanner.nextInt();
        System.out.println("enter balance");
        BigDecimal balance1=scanner.nextBigDecimal();
        Wallet wallet1 =new Wallet();
        wallet1.setAge(age1);
        wallet1.setBalance(balance1);
        wallet1.setGender(gender1);
        wallet1.setName(name1);
        wallet1.setPhoneNumber(phone1);
        wallet1.setEmailId(email1);
        Wallet wall2=paymentwalletservice.registerCustomer(wallet1);
        System.out.println(wall2.getEmailId());
        System.out.println(wall2.getGender());
        System.out.println(wall2.getName());
        
        
        
       Wallet wall1=paymentwalletservice.showBalance(phone);
       System.out.println(wall1.getEmailId());
       System.out.println(wall1.getGender());
       System.out.println(wall1.getName());
       System.out.println(wall1.getBalance());
       
       
       Wallet wall3=paymentwalletservice.depositMoney(phone, balance);
       System.out.println(wall3.getEmailId());
       System.out.println(wall3.getGender());
       System.out.println(wall3.getName());
       System.out.println(wall3.getBalance());
       
     
       Wallet wall4=paymentwalletservice.fundTransfer(phone, phone1, balance);
       System.out.println(wall4.getEmailId());
       System.out.println(wall4.getGender());
       System.out.println(wall4.getName());
       System.out.println(wall4.getBalance());
       
       
       Wallet wall5=paymentwalletservice.withdrawMoney(phone, balance);
       System.out.println(wall5.getEmailId());
       System.out.println(wall5.getGender());
       System.out.println(wall5.getName());
       System.out.println(wall5.getBalance());
       
       HashMap<String,String> result = paymentwalletservice.printTransaction(phone);
		Set<Entry<String,String>> set = result.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			String id11 = entry.getKey();
			String dto = entry.getValue();
		Scanner	scanner2=new Scanner(dto).useDelimiter("*");
		while(scanner2.hasNext())
		{
			System.out.println(scanner.next());
		}
		}	
       */
       
    


