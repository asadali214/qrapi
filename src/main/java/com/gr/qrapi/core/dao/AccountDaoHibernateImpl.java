package com.gr.qrapi.core.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.gr.common.dao.AbstractHibernateDao;
import com.gr.common.dao.DaoException;
import com.gr.common.dao.DaoManager;
import com.gr.qrapi.core.model.Account;

public class AccountDaoHibernateImpl extends AbstractHibernateDao<Account, Integer> implements AccountDao {

	public static AccountDao getDao() {
		return DaoManager.getInstance().getDao(AccountDao.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Account> viewAllAccounts() {
		Session session = null;
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
	public Account getAccount(int id) {
		Session session = null;
		Account account = null;
		try {
			session = getSession();
			session.beginTransaction();

			account = (Account) session.get(Account.class, id);

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
		return account;
	}

	@Override
	public int addNewAccount(Account account) {
		Session session = null;
		int accountID = -1;
		try {
			session = getSession();
			session.beginTransaction();
			accountID = (Integer) session.save(account);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			closeSession(session);
		}
		return accountID;
	}

	@Override
	public Account updateAccount(int id, Account accountNew) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();

			String hql = "UPDATE Account SET USERNAME = :newUserName, PASSWORD = :newPass,"
					+ " NAME = :newName, EMAILDOMAIN = :newEmail, TIMEZONECITY = :newTimeZone WHERE ID = :Id";
			session.createQuery(hql).setString("newUserName", accountNew.getUserName())
					.setString("newPass", accountNew.getPassword()).setString("newName", accountNew.getName())
					.setString("newEmail", accountNew.getEmailDomain())
					.setString("newTimeZone", accountNew.getTimeZoneCity()).setString("Id", "" + id).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
		return accountNew;
	}

	@Override
	public int deleteAccount(int id) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();
			String hql = "DELETE FROM Account WHERE ID = :Id";
			session.createQuery(hql).setString("Id", "" + id).executeUpdate();

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
		return id;
	}

}
