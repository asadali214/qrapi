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

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add")
	public String addNewAccount(Account account) {
		return "{Added Account at id: " + service.addNewAccount(account) + "}";
	}

	@PUT
	@Path("/update/{id}")
	public Account updateAccount(@PathParam("id") int id, Account account) {
		return service.updateAccount(id, account);
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public String deleteAccount(@PathParam("id") int id) {
		return "{Deleted Account at id: " + service.deleteAccount(id) + "}";
	}

	@POST
	@Path("/check")
	public Account checkLogin(Account account) {
		return service.checkLogin(account.getUserName(), account.getPassword());
	}

}
