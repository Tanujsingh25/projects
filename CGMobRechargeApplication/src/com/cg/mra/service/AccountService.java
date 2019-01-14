package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exceptions.AccountDetailsNotFoundException;
public interface AccountService {
	Account getAccountDetails(String mobileNo) throws AccountDetailsNotFoundException;
	int rechargeAccount(String mobileNo,double rechargeAmount) throws AccountDetailsNotFoundException;
}
