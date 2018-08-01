package com.gr.qrapi.core.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.gr.common.dao.AbstractHibernateDao;
import com.gr.common.dao.DaoException;
import com.gr.common.dao.DaoManager;
import com.gr.qrapi.core.model.Account;
import com.gr.qrapi.core.model.Address;
import com.gr.qrapi.core.model.Contact;

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
			session.close();
		}
		return accountID;
	}

	@Override
	public Account updateAccount(int id, Account accountNew) {
		Session session = null;
		Account account = null;
		try {
			session = getSession();
			session.beginTransaction();

			account = (Account) session.get(Account.class, id);
			if (accountNew.getName() != null)
				account.setName(accountNew.getName());
			if (accountNew.getEmailDomain() != null)
				account.setEmailDomain(accountNew.getEmailDomain());
			if (accountNew.getTimeZoneCity() != null)
				account.setTimeZoneCity(accountNew.getTimeZoneCity());
			session.update(account);

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			session.close();
		}
		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int deleteAccount(int id) {
		Session session = null;
		Account account = null;
		try {
			session = getSession();
			session.beginTransaction();

			account = (Account) session.get(Account.class, id);
			String hql = "FROM Contact WHERE account = " + id;
			ArrayList<Contact> contacts = (ArrayList<Contact>) session.createQuery(hql).list();
			for (Contact contact : contacts) {
				ArrayList<Address> addresses = (ArrayList<Address>) contact.getAddresses();
				session.delete(contact);
				for (Address address : addresses) {
					session.delete(address);
				}
			}
			session.delete(account);

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			session.close();
		}
		return id;
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
			session.close();
		}
		return account;
	}

}
