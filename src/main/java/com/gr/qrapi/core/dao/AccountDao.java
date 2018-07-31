package com.gr.qrapi.core.dao;

import java.util.ArrayList;

import com.gr.common.dao.GenericDao;
import com.gr.qrapi.core.model.Account;

public interface AccountDao extends GenericDao<Account, Integer> {

	public ArrayList<Account> viewAllAccounts();

	public int addNewAccount(Account account);

	public Account updateAccount(int id, Account accountNew);

	public void deleteAccount(int id);

	public Account getAccount(int id);

}
