package com.gr.qrapi.core.service;

import java.util.List;

import javax.ejb.Local;

import com.gr.qrapi.core.model.Account;

/**
 * @author ufarooq
 */
@Local
public interface AccountServiceLocal {

	List<Account> getAllAccounts();
	int addNewAccount(Account account);
	Account updateAccount(int id, Account account);
	int deleteAccount(int id);
	Account getAccount(int id);
}
