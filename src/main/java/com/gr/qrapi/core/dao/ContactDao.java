package com.gr.qrapi.core.dao;

import java.util.List;

import com.gr.common.dao.GenericDao;
import com.gr.qrapi.core.model.Address;
import com.gr.qrapi.core.model.Contact;

public interface ContactDao extends GenericDao<Contact, Integer> {
	public List<Contact> viewAllContactsOfAccount(int AccountId);

	public Contact getContact(int id);

	public Contact addContactinAccount(Contact contact, int AccountID);

	public Contact updateContactOfAccount(int ContactId, Contact contactNew);

	public int deleteContactOfAccount(int contactId);

	public void deleteAllContactsOfAccount(int AccountId);

	public List<Address> viewAllAddressesOfContact(int ContactId);

	public int addAddressinContact(Address address, int ContactID);

	public Address updateAddress(int AddressId, Address addressNew);

	public int deleteAddressOfContact(int addressId);
	
	public Address getCurrentAddress(int contactId);
	
	public List<Address> getAllCurrentAddresses(int Accountid);

}
