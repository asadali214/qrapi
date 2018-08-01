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

import com.gr.qrapi.core.model.AlertProfile;
import com.gr.qrapi.core.service.AlertService;
import com.gr.qrapi.core.service.AlertServiceLocal;

@Path("/v1/alerts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlertResource {

	AlertServiceLocal service = AlertService.getService();

	@GET
	@Path("/get")
	public List<AlertProfile> getAllAlerts() {
		return service.getAllAlerts();
	}
	
	@GET
	@Path("/get/{id}")
	public AlertProfile getAlert(@PathParam("id") int id) {
		return service.getAlert(id);
	}

	@POST
	@Path("/add/{name}")
	public String addNewAlert(@PathParam("name") String name) {
		AlertProfile alert = new AlertProfile(name);
		return "Added Account at id: "+service.addNewAlert(alert);
	}

	@PUT
	@Path("/update/{id}/{name}")
	public AlertProfile updateAlert(@PathParam("id") int id, @PathParam("name") String name) {
		AlertProfile alert = new AlertProfile(name);
		return service.updateAlert(id,alert);
	}
	
	@DELETE
	@Path("/delete/{id}")
	public String deleteAlert(@PathParam("id") int id) {
		return "Deleted Account at id: "+service.deleteAlert(id);
	}
	
	

}
