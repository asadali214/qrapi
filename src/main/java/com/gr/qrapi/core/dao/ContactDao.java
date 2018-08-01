package com.gr.qrapi.core.dao;

import java.util.ArrayList;

import com.gr.common.dao.GenericDao;
import com.gr.qrapi.core.model.Contact;

public interface ContactDao extends GenericDao<Contact, Integer>{
	public ArrayList<Contact> viewAllContactsOfAccount(int AccountId);
	public int addContactinAccount(Contact contact, int AccountID);
	public Contact updateContactOfAccount(int ContactId, Contact contactNew);
	public int deleteContactOfAccount(int contactId);
	public void deleteAllContactsOfAccount(int AccountId);
	public Contact getContact(int id);
}
