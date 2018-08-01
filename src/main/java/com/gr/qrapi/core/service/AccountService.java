package com.gr.qrapi.core.service;

import java.util.List;

import javax.ejb.Stateless;

import com.gr.common.service.ServiceManager;
import com.gr.qrapi.core.dao.AccountDaoHibernateImpl;
import com.gr.qrapi.core.model.Account;

/**
 * @author ufarooq
 */
@Stateless
public class AccountService implements AccountServiceLocal {

	public static AccountServiceLocal getService() {
		return (AccountServiceLocal) ServiceManager.getService(AccountServiceLocal.class);
	}

	@Override
	public List<Account> getAllAccounts() {
		return AccountDaoHibernateImpl.getDao().viewAllAccounts();
	}

	@Override
	public int addNewAccount(Account account) {
		return AccountDaoHibernateImpl.getDao().addNewAccount(account);

	}

	@Override
	public Account updateAccount(int id, Account account) {
		return AccountDaoHibernateImpl.getDao().updateAccount(id, account);
	}

	@Override
	public int deleteAccount(int id) {
		return AccountDaoHibernateImpl.getDao().deleteAccount(id);
	}

	@Override
	public Account getAccount(int id) {
		return AccountDaoHibernateImpl.getDao().getAccount(id);
	}
}