package com.gr.qrapi.ws.v1;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gr.qrapi.core.model.Address;
import com.gr.qrapi.core.model.Contact;
import com.gr.qrapi.core.service.ContactService;
import com.gr.qrapi.core.service.ContactServiceLocal;

@Path("/v1/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {

	ContactServiceLocal service = ContactService.getService();

	@GET
	@Path("/getAllOf/{id}")
	public List<Contact> getAllContacts(@PathParam("id") int AccountId) {
		System.out.println("called getAll");
		return service.viewAllContactsOfAccount(AccountId);
	}

	@GET
	@Path("/get/{id}")
	public Contact getContact(@PathParam("id") int id) {
		System.out.println("called get");
		return service.getContact(id);
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add/{accountId}/{firstName}/{lastName}/{email}/{gender}/{phone}/{status}")
	public String addNewContact(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName,
			@PathParam("email") String email, @PathParam("gender") String gender, @PathParam("phone") String phone,
			@PathParam("status") int status, @PathParam("accountId") int accountId) {
		boolean statusBool;
		if (status == 0)
			statusBool = false;
		else
			statusBool = true;
		Contact contact = new Contact(firstName, lastName, email, gender, phone, statusBool);
		System.out.println("called add");
		return "{Added Contact at id: " + service.addContactinAccount(contact, accountId) + "}";
	}

	@PUT
	@Path("/update/{id}/{firstName}/{lastName}/{email}/{gender}/{phone}/{status}")
	public Contact updateContactOfAccount(@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName, @PathParam("email") String email,
			@PathParam("gender") String gender, @PathParam("phone") String phone, @PathParam("status") int status,
			@PathParam("id") int id) {
		boolean statusBool;
		if (status == 0)
			statusBool = false;
		else
			statusBool = true;
		Contact contact = new Contact(firstName, lastName, email, gender, phone, statusBool);
		System.out.println("called update");
		return service.updateContactOfAccount(id, contact);
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/deleteAllOf/{Accountid}")
	public String deleteAllContacts(@PathParam("Accountid") int AccountId) {
		System.out.println("called deleteAll");
		service.deleteAllContactsOfAccount(AccountId);
		return "{Deleted all contacts}";
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public String deleteContact(@PathParam("id") int ContactId) {
		System.out.println("called delete");
		return "{Deleted Contact at id: " + service.deleteContactOfAccount(ContactId) + "}";
	}

	@GET
	@Path("/getAllAddressesOf/{id}")
	public List<Address> getAllAddresses(@PathParam("id") int contactId) {
		System.out.println("called getAllAddress");
		return service.viewAllAddressesOfContact(contactId);
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addAddressIn/{contactId}/{street}/{city}/{state}/{country}")
	public String addAddressInContact(@PathParam("contactId") int contactId, @PathParam("street") String street,
			@PathParam("city") String city, @PathParam("state") String state, @PathParam("country") String country) {
		Address address = new Address(street, city, state, country);
		System.out.println("called addAddress");
		return "{Added new address in contactId: " + service.addAddressinContact(address, contactId) + "}";
	}

	@PUT
	@Path("/updateAddress/{addressId}/{street}/{city}/{state}/{country}/{current}")
	public Address updateAddress(@PathParam("addressId") int addressId, @PathParam("street") String street,
			@PathParam("city") String city, @PathParam("state") String state, @PathParam("country") String country,
			@PathParam("current") int current) {
		boolean currentBool;
		if (current == 0)
			currentBool = false;
		else
			currentBool = true;
		Address address = new Address(street, city, state, country);
		address.setCurrent(currentBool);
		System.out.println("called updateAddress");
		return service.updateAddress(addressId, address);
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/deleteAddress/{addressId}")
	public String deleteAddress(@PathParam("addressId") int addressId) {
		System.out.println("called deleteAddress");
		return "{Deleted address at id: "+service.deleteAddressOfContact(addressId)+"}";
	}

}
