package com.gr.qrapi.ws.v1;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

	@POST
	@Path("/add/{accountId}")
	public Contact addNewContact(Contact contact, @PathParam("accountId") int accountId) {
		System.out.println("called add");
		return service.addContactinAccount(contact, accountId);
	}

	@PUT
	@Path("/update/{id}")
	public Contact updateContactOfAccount(Contact contact, @PathParam("id") int id) {
		System.out.println("called update");
		return service.updateContactOfAccount(id, contact);
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/deleteAllOf/{Accountid}")
	public String deleteAllContacts(@PathParam("Accountid") int AccountId) {
		System.out.println("called deleteAll");
		service.deleteAllContactsOfAccount(AccountId);
		return "{Deleted all contacts}";
	}

	@DELETE
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

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addAddressIn/{contactId}")
	public String addAddressInContact(@PathParam("contactId") int contactId,Address address) {
		System.out.println("called addAddress");
		return "{Added new address in contactId: " + service.addAddressinContact(address, contactId) + "}";
	}

	@PUT
	@Path("/updateAddress/{addressId}")
	public Address updateAddress(@PathParam("addressId") int addressId,Address address) {
		System.out.println("called updateAddress");
		return service.updateAddress(addressId, address);
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/deleteAddress/{addressId}")
	public String deleteAddress(@PathParam("addressId") int addressId) {
		System.out.println("called deleteAddress");
		return "{Deleted address at id: " + service.deleteAddressOfContact(addressId) + "}";
	}
	
	@GET
	@Path("/getCurrentAdd/{contactId}")
	public Address getCurrent(@PathParam("contactId") int contactId) {
		System.out.println("called getCurrent");
		return service.getCurrentAddress(contactId);
	}
	
	@GET
	@Path("/getAllCurrentAdd/{accountId}")
	public List<Address> getAllCurrent(@PathParam("accountId") int accountId) {
		System.out.println("called getAllCurrent");
		return service.getAllCurrentAddresses(accountId);
	}

}
