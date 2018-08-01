package com.gr.qrapi.core.service;

import java.util.ArrayList;

import javax.ejb.Stateless;

import com.gr.common.service.ServiceManager;
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
