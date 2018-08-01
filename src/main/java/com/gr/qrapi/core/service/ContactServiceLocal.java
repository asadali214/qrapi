package com.gr.qrapi.core.service;

import java.util.ArrayList;

import javax.ejb.Local;

import com.gr.qrapi.core.model.Contact;

/**
 * @author ufarooq
 */
@Local
public interface ContactServiceLocal {
	
	ArrayList<Contact> viewAllContactsOfAccount(int AccountId);
	int addContactinAccount(Contact contact, int AccountID);
	Contact updateContactOfAccount(int ContactId, Contact contactNew);
	int deleteContactOfAccount(int contactId);
	void deleteAllContactsOfAccount(int AccountId);
	Contact getContact(int id);
}
