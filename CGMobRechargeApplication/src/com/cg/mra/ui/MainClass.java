package com.cg.mra.ui;

import java.util.Scanner;
import com.cg.mra.beans.Account;
import com.cg.mra.exceptions.AccountDetailsNotFoundException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainClass {
	public static void main(String[] args) {
		int choice,balance;
		double rechargeAmount;
		String mobileNo;
		Account account ;
		Scanner scanner = new Scanner(System.in);
		AccountService accountService = new AccountServiceImpl(); 
		do {
			System.out.println("\n\n1. Account Balance Enquiry ");
			System.out.println("2. Recharge Account");
			System.out.println("3. Exit");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1: /*Enter new detail for account creation*/
				System.out.print("Enter Mobile No : ");
				mobileNo = scanner.nextLine();
				try {
					account = accountService.getAccountDetails(mobileNo);
					System.out.println("Your Current Balance is Rs. "+account.getAccountBalance());
				} catch (AccountDetailsNotFoundException e) {}			
			break;
			case 2:System.out.println("Enter Mobile No : ");
			mobileNo = scanner.nextLine();
			System.out.println("Enter Recharge Amount : ");
			rechargeAmount = scanner.nextDouble();
			try {
				account = accountService.getAccountDetails(mobileNo);
				balance = accountService.rechargeAccount(mobileNo,rechargeAmount);
				System.out.println("Your Account Recharged Successfully");
				System.out.println("Hello "+account.getCustomerName()+",Available Balance is "+account.getAccountBalance());
			} catch (AccountDetailsNotFoundException e) {}
			break;
			case 3:
				System.exit(0);
			}
		}while(choice != 3); //end of do-while loop
	}
}