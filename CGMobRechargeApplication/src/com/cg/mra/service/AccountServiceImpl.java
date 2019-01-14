package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exceptions.AccountDetailsNotFoundException;

public class AccountServiceImpl implements AccountService{
	private AccountDao accountDao = new AccountDaoImpl();
	@Override
	public Account getAccountDetails(String mobileNo) throws AccountDetailsNotFoundException {
        Account account= accountDao.getAccountDetails(mobileNo);
        if(account== null) throw new AccountDetailsNotFoundException("Error: Given Account id does not Exist.");//throw error if number not found
        else
            return account;
	}
	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) throws AccountDetailsNotFoundException {
		if(mobileNo.length() == 0 || mobileNo.length()<10) throw new AccountDetailsNotFoundException("Error: Cannot Recharge Account as Given Mobile No Does Not Exist.");//Check Mobile length
		else
			return accountDao.rechargeAccount(mobileNo, rechargeAmount);
	}

}
