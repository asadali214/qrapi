package com.gr.qrapi.core.service;

import java.util.ArrayList;

import javax.ejb.Stateless;

import com.gr.common.service.ServiceManager;
import com.gr.qrapi.core.dao.ContactDaoHibernateImpl;
import com.gr.qrapi.core.model.Contact;

/**
 * @author ufarooq
 */
@Stateless
public class ContactService implements ContactServiceLocal {

	public static ContactServiceLocal getService() {
		return (ContactServiceLocal) ServiceManager.getService(ContactServiceLocal.class);
	}

	@Override
	public ArrayList<Contact> viewAllContactsOfAccount(int AccountId) {
		return ContactDaoHibernateImpl.getDao().viewAllContactsOfAccount(AccountId);
	}

	@Override
	public int addContactinAccount(Contact contact, int AccountID) {
		return ContactDaoHibernateImpl.getDao().addContactinAccount(contact, AccountID);
	}

	@Override
	public Contact updateContactOfAccount(int ContactId, Contact contactNew) {
		return ContactDaoHibernateImpl.getDao().updateContactOfAccount(ContactId, contactNew);
	}

	@Override
	public int deleteContactOfAccount(int contactId) {
		return ContactDaoHibernateImpl.getDao().deleteContactOfAccount(contactId);
	}

	@Override
	public void deleteAllContactsOfAccount(int AccountId) {
		ContactDaoHibernateImpl.getDao().deleteAllContactsOfAccount(AccountId);
	}

	@Override
	public Contact getContact(int id) {
		return ContactDaoHibernateImpl.getDao().getContact(id);
	}

}
