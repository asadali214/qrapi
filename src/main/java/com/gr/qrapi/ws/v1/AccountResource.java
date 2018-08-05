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

	AccountServiceLocal service = AccountService.getService();

	@GET
	@Path("/get")
	public List<Account> getAllAccounts() {
		return service.getAllAccounts();
	}

	@GET
	@Path("/get/{id}")
	public Account getAccount(@PathParam("id") int id) {
		return service.getAccount(id);
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add/{userName}/{pass}/{name}/{email}/{timeZone}")
	public String addNewAccount(@PathParam("userName") String username, @PathParam("pass") String pass,
			@PathParam("name") String name, @PathParam("email") String email, @PathParam("timeZone") String timeZone) {
		Account account = new Account(name, email, timeZone, username, pass);
		return "{Added Account at id: " + service.addNewAccount(account) + "}";
	}

	@PUT
	@Path("/update/{id}/{userName}/{pass}/{name}/{email}/{timeZone}")
	public Account updateAccount(@PathParam("userName") String username, @PathParam("pass") String pass,
			@PathParam("id") int id, @PathParam("name") String name, @PathParam("email") String email,
			@PathParam("timeZone") String timeZone) {
		Account account = new Account(name, email, timeZone, username, pass);
		return service.updateAccount(id, account);
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public String deleteAccount(@PathParam("id") int id) {
		return "{Deleted Account at id: " + service.deleteAccount(id) + "}";
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/check/{user}/{pass}")
	public String deleteAccount(@PathParam("user") String user, @PathParam("pass") String pass) {
		return "Login is: " + service.checkLogin(user, pass);
	}

}
