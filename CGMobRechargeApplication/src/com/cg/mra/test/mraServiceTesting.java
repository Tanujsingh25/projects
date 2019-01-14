package com.cg.mra.test;

import static org.junit.BeforeClass.*;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.exceptions.AccountDetailsNotFoundException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;
public class mraServiceTesting {
	private static AccountDao mockAccountDao;
	private static AccountService accountService;
	HashMap<String, Account> hashMap= new HashMap<>();
	@BeforeClass
	public static void setUpTestEnv() {
		accountService = new AccountServiceImpl();
	}
	@Before
	public void setUpTestData() {
		String mobile1 = "9911016184";
		String mobile2 = "9823920123";
		String mobile3 = "9010210131";
		Account account1 = new Account("Prepaid", "Tanuj", 200);
		Account account2 = new Account("Prepaid", "Anuj", 236);
		Account account3 = new Account("Prepaid", "Prajwal", 400);
		HashMap<String, Account> accountEntry= new HashMap<>();
		hashMap.put(mobile1, account1);
		hashMap.put(mobile2, account2);
		hashMap.put(mobile3, account3);
	}
	@Test(expected=AccountDetailsNotFoundException.class)
	public void testGetAccountDetailsForInvalidMobileNo() throws AccountDetailsNotFoundException {
		Account actualDetails = accountService.getAccountDetails("123");		
	}
	@Test
	public void testGetAccountDetailsForValidMobileNo() {
		Account expectedAccount =new Account("Prepaid", "Anuj", 236);
		Account actualDetails;
		try {
			actualDetails = accountService.getAccountDetails("9823920123");
			Assert.assertEquals(expectedAccount, actualDetails);
		} catch (AccountDetailsNotFoundException e) {
			e.printStackTrace();
		}
	}
	@After
	public void tearUpTestData() {
		hashMap.clear();
	}
	@AfterClass
	public void tearUpTestEnv() {
		accountService=null;
	}
}
