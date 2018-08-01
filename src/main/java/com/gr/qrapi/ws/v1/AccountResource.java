package com.gr.qrapi.ws.v1;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gr.qrapi.core.model.Account;
import com.gr.qrapi.core.service.AccountService;
import com.gr.qrapi.core.service.AccountServiceLocal;

@Path("/v1/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

	AccountServiceLocal genericService = AccountService.getService();

	@GET
	@Path("/get")
	public List<Account> getAllAccounts() {
		System.out.println("get all method called!!");
		return genericService.getAllAccounts();
	}
	
	@GET
	@Path("/get/{id}")
	public Account getAccount(@PathParam("id") int id) {
		System.out.println("get method called!! "+id);
		return genericService.getAccount(id);
	}

	@PUT
	@Path("/add/{name}/{email}/{timeZone}")
	public String addNewAccount(@PathParam("name") String name, @PathParam("email") String email,
			@PathParam("timeZone") String timeZone) {
		System.out.println("add method called!! " +name+" "+email+" "+timeZone);
		Account account = new Account(name, email, timeZone);
		return "Added Account at id: "+genericService.addNewAccount(account);
	}

	@PUT
	@Path("/update/{id}/{name}/{email}/{timeZone}")
	public Account updateAccount(@PathParam("id") int id, @PathParam("name") String name,
			@PathParam("email") String email, @PathParam("timeZone") String timeZone) {
		System.out.println("update method called!! "+id);
		Account account = new Account(name, email, timeZone);
		return genericService.updateAccount(id,account);
	}
	
	@PUT
	@Path("/delete/{id}")
	public String deleteAccount(@PathParam("id") int id) {
		System.out.println("Delete method called!! "+id);
		return "Deleted Account at id: "+genericService.deleteAccount(id);
	}
	
	

}
