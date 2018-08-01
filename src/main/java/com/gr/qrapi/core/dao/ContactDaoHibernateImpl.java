package com.gr.qrapi.core.dao;

import java.util.ArrayList;

import com.gr.common.dao.AbstractHibernateDao;
import com.gr.common.dao.DaoManager;
import com.gr.qrapi.core.model.Contact;

public class ContactDaoHibernateImpl extends AbstractHibernateDao<Contact, Integer> implements ContactDao{
	
	
	public static ContactDao getDao() {
		return DaoManager.getInstance().getDao(ContactDao.class);
	}

	@Override
	public ArrayList<Contact> viewAllContactsOfAccount(int AccountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addContactinAccount(Contact contact, int AccountID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact updateContactOfAccount(int ContactId, Contact contactNew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteContactOfAccount(int contactId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAllContactsOfAccount(int AccountId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contact getContact(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
