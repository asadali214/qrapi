package com.gr.qrapi.core.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.gr.common.dao.AbstractHibernateDao;
import com.gr.common.dao.DaoException;
import com.gr.common.dao.DaoManager;
import com.gr.qrapi.core.model.Account;
import com.gr.qrapi.core.model.Address;
import com.gr.qrapi.core.model.Contact;

public class ContactDaoHibernateImpl extends AbstractHibernateDao<Contact, Integer> implements ContactDao {

	public static ContactDao getDao() {
		return DaoManager.getInstance().getDao(ContactDao.class);
	}

	@Override
	public List<Contact> viewAllContactsOfAccount(int AccountId) {
		Session session = null;
		try {
			session = getSession();
			Account account = (Account) session.get(Account.class, AccountId);
			List<Contact> contacts = new ArrayList<>();
			if (account.getContacts() != null) {
				contacts = account.getContacts();
			}
			return contacts;
		} catch (Exception aex) {
			throw new DaoException(aex);
		} finally {
			closeSession(session);
		}
	}

	@Override
	public Contact getContact(int id) {
		Session session = null;
		Contact contact = null;
		try {
			session = getSession();
			session.beginTransaction();

			contact = (Contact) session.get(Contact.class, id);

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
		return contact;
	}

	@Override
	public int addContactinAccount(Contact contact, int AccountID) {
		Session session = null;
		int contactID = -1;
		try {
			session = getSession();
			session.beginTransaction();

			contact.setAccountId(AccountID);
			contactID = (Integer) session.save(contact);

			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			closeSession(session);
		}
		return contactID;
	}

	@Override
	public Contact updateContactOfAccount(int ContactId, Contact contactNew) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();

			boolean statusBool = contactNew.getStatus();
			int status = 0;
			if (statusBool)
				status = 1;
			String hql = "UPDATE Contact SET FIRSTNAME = :first, LASTNAME = :last,"
					+ " EMAILADDRESS = :email, GENDER = :gender, PHONENUMBER = :phone," + " STATUS = :status"
					+ " WHERE ID = :Id";
			session.createQuery(hql).setString("first", contactNew.getFirstName())
					.setString("last", contactNew.getLastName()).setString("email", contactNew.getEmailAddress())
					.setString("gender", contactNew.getGender()).setString("phone", contactNew.getPhoneNumber())
					.setString("status", "" + status).setString("Id", "" + ContactId).executeUpdate();

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
		return contactNew;
	}

	@Override
	public int deleteContactOfAccount(int contactId) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();

			String hql = "DELETE FROM Contact WHERE ID = :Id";
			session.createQuery(hql).setString("Id", "" + contactId).executeUpdate();

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
		return contactId;
	}

	@Override
	public void deleteAllContactsOfAccount(int AccountId) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();

			String hql = "DELETE FROM Contact WHERE ACCOUNT = :Id";
			session.createQuery(hql).setString("Id", "" + AccountId).executeUpdate();

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
	}

	@Override
	public List<Address> viewAllAddressesOfContact(int ContactId) {
		Session session = null;
		try {
			session = getSession();
			Contact contact = (Contact) session.get(Contact.class, ContactId);
			List<Address> addresses = new ArrayList<>();
			if (contact.getAddresses() != null) {
				addresses = contact.getAddresses();
			}
			return addresses;
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
	}

	@Override
	public int addAddressinContact(Address address, int ContactID) {
		Session session = null;
		int addressID = -1;
		try {
			session = getSession();
			session.beginTransaction();

			Contact contact = (Contact) session.get(Contact.class, ContactID);

			List<Address> adresses = contact.getAddresses();
			boolean current = true;
			for (Address adress : adresses) {
				if (adress.getCurrent()) {
					current = false;
					break;
				}
			}
			address.setCurrent(current);
			address.setContactId(ContactID);

			addressID = (Integer) session.save(address);

			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			closeSession(session);
		}
		return addressID;
	}

	@Override
	public Address updateAddress(int AddressId, Address addressNew) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();
			
			boolean currentBool = addressNew.getCurrent();
			int current = 0;
			if (currentBool) {
				//if updated address is currentAddress
				//then remove the current status of current address
				String hql = "UPDATE Address SET CURRENT = :currentNew" + " WHERE CURRENT = :current";
				session.createQuery(hql).setString("currentNew", "" + 0)
						.setString("current", "" + 1).executeUpdate();
				current = 1;
			}
			String hqlUpdatethis = "UPDATE Address SET STREETADDRESS = :street, CITY = :city,"
					+ " STATE = :state, COUNTRY = :country, CURRENT = :current" + " WHERE ID = :Id";
			session.createQuery(hqlUpdatethis).setString("street", addressNew.getStreetAddress())
					.setString("city", addressNew.getCity()).setString("state", addressNew.getState())
					.setString("country", addressNew.getCountry()).setString("current", "" + current)
					.setString("Id", "" + AddressId).executeUpdate();

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
		return addressNew;
	}

	@Override
	public int deleteAddressOfContact(int addressId) {
		Session session = null;
		try {
			session = getSession();
			session.beginTransaction();

			String hql = "DELETE FROM Address WHERE ID = :Id";
			session.createQuery(hql).setString("Id", "" + addressId).executeUpdate();

			session.getTransaction().commit();
		} catch (Exception ex) {
			throw new DaoException(ex);
		} finally {
			closeSession(session);
		}
		return addressId;
	}

}
