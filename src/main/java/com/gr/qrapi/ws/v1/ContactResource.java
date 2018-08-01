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

import com.gr.qrapi.core.model.Contact;
import com.gr.qrapi.core.service.ContactService;
import com.gr.qrapi.core.service.ContactServiceLocal;

/**
 * @author ufarooq
 */
@Path("/v1/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactResource {

	ContactServiceLocal service = ContactService.getService();

	@GET
	@Path("/getAllOf/{id}")
	public List<Contact> getAllContacts(@PathParam("id") int AccountId) {
		return service.viewAllContactsOfAccount(AccountId);
	}

	@GET
	@Path("/get/{id}")
	public Contact getContact(@PathParam("id") int id) {
		return service.getContact(id);
	}

	@POST
	@Path("/add/{accountId}/{firstName}/{lastName}/{email}/{gender}/{phone}/{status}")
	public String addNewContact(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName,
			@PathParam("email") String email, @PathParam("gender") String gender, @PathParam("phone") String phone, 
			@PathParam("status") boolean status, @PathParam("accountId") int accountId) {
		Contact contact = new Contact(firstName, lastName, email, gender, phone, status);
		return "Added Contact at id: " + service.addContactinAccount(contact, accountId);
	}

	@PUT
	@Path("/update/{id}/{firstName}/{lastName}/{email}/{gender}/{phone}/{status}")
	public Contact updateContactOfAccount(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName,
			@PathParam("email") String email, @PathParam("gender") String gender, @PathParam("phone") String phone, 
			@PathParam("status") boolean status, @PathParam("id") int id) {
		Contact contact = new Contact(firstName, lastName, email, gender, phone, status);
		return service.updateContactOfAccount(id, contact);
	}
	
	@DELETE
	@Path("/deleteAllOf/{Accountid}")
	public String deleteAllContacts(@PathParam("Accountid") int AccountId) {
		service.deleteAllContactsOfAccount(AccountId);
		return "maybe Deleted all contacts";
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteContact(@PathParam("id") int ContactId) {
		return "Deleted Contact at id: " + service.deleteContactOfAccount(ContactId);
	}
	
	
	

}
