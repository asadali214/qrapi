package com.gr.qrapi.core.service;

import java.util.List;

import javax.ejb.Local;

import com.gr.qrapi.core.model.Address;
import com.gr.qrapi.core.model.Contact;

@Local
public interface ContactServiceLocal {

	List<Contact> viewAllContactsOfAccount(int AccountId);

	Contact addContactinAccount(Contact contact, int AccountID);

	Contact updateContactOfAccount(int ContactId, Contact contactNew);

	int deleteContactOfAccount(int contactId);

	void deleteAllContactsOfAccount(int AccountId);

	Contact getContact(int id);

	List<Address> viewAllAddressesOfContact(int ContactId);

	int addAddressinContact(Address address, int ContactID);

	Address updateAddress(int AddressId, Address addressNew);

	int deleteAddressOfContact(int addressId);

	Address getCurrentAddress(int contactId);

	List<Address> getAllCurrentAddresses(int Accountid);
}
