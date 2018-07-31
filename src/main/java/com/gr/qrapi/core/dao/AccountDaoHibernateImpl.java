package com.gr.qrapi.core.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.gr.common.dao.AbstractHibernateDao;
import com.gr.common.dao.DaoException;
import com.gr.common.dao.DaoManager;
import com.gr.qrapi.core.model.Account;

/**
 * @author ufarooq
 */
public class AccountDaoHibernateImpl extends AbstractHibernateDao<Account, Integer> implements AccountDao {

	public static AccountDao getDao() {
		return DaoManager.getInstance().getDao(AccountDao.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Account> viewAllAccounts() {
		Session session=null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Account.class);
			criteria.setMaxResults(100);
			
			ArrayList<Account> accounts = (ArrayList<Account>) criteria.list();
			
			return accounts;
		} catch (Exception aex) {
			throw new DaoException(aex);
		} finally {
			closeSession(session);
			
		}
	}

	@Override
	public int addNewAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account updateAccount(int id, Account accountNew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account getAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
