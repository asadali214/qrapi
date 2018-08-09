package com.gr.qrapi.core.service;

import java.util.List;

import javax.ejb.Stateless;

import com.gr.common.service.ServiceManager;
import com.gr.qrapi.core.dao.ContactDaoHibernateImpl;
import com.gr.qrapi.core.model.Address;
import com.gr.qrapi.core.model.Contact;

@Stateless
public class ContactService implements ContactServiceLocal {

	public static ContactServiceLocal getService() {
		return (ContactServiceLocal) ServiceManager.getService(ContactServiceLocal.class);
	}

	@Override
	public List<Contact> viewAllContactsOfAccount(int AccountId) {
		return ContactDaoHibernateImpl.getDao().viewAllContactsOfAccount(AccountId);
	}

	@Override
	public Contact addContactinAccount(Contact contact, int AccountID) {
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

	@Override
	public List<Address> viewAllAddressesOfContact(int ContactId) {
		return ContactDaoHibernateImpl.getDao().viewAllAddressesOfContact(ContactId);
	}
	
	@Override
	public int addAddressinContact(Address address, int ContactID) {
		return ContactDaoHibernateImpl.getDao().addAddressinContact(address, ContactID);
	}

	@Override
	public Address updateAddress(int AddressId, Address addressNew) {
		return ContactDaoHibernateImpl.getDao().updateAddress(AddressId, addressNew);
	}

	@Override
	public int deleteAddressOfContact(int addressId) {
		return ContactDaoHibernateImpl.getDao().deleteAddressOfContact(addressId);
	}

	@Override
	public Address getCurrentAddress(int contactId) {
		return ContactDaoHibernateImpl.getDao().getCurrentAddress(contactId);
	}

	@Override
	public List<Address> getAllCurrentAddresses(int Accountid) {
		return ContactDaoHibernateImpl.getDao().getAllCurrentAddresses(Accountid);
	}

	

}
