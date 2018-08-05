package com.gr.qrapi.ws.v1;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gr.qrapi.core.model.AlertLocation;
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
		System.out.println("called getAllAlertProfiles");
		return service.getAllAlerts();
	}

	@GET
	@Path("/get/{id}")
	public AlertProfile getAlert(@PathParam("id") int id) {
		System.out.println("called getAlertProfile");
		return service.getAlert(id);
	}

	@PUT
	@Path("/add/{name}")
	public String addNewAlert(@PathParam("name") String name) {
		System.out.println("called addAlertProfile");
		AlertProfile alert = new AlertProfile(name);
		return "Added Account at id: " + service.addNewAlert(alert);
	}

	@PUT
	@Path("/update/{id}/{name}")
	public AlertProfile updateAlert(@PathParam("id") int id, @PathParam("name") String name) {
		System.out.println("called updateAlertProfile");
		AlertProfile alert = new AlertProfile(name);
		return service.updateAlert(id, alert);
	}

	@PUT
	@Path("/delete/{id}")
	public String deleteAlert(@PathParam("id") int id) {
		System.out.println("called deleteAlertProfile");
		return "Deleted Alert at id: " + service.deleteAlert(id);
	}

	@GET
	@Path("/getAllLocationsOf/{id}")
	public List<AlertLocation> getAllAddresses(@PathParam("id") int alertId) {
		System.out.println("called getAllLocation");
		return service.viewAllLocationsOfAlerts(alertId);
	}

	@PUT
	@Path("/addLocationIn/{alertId}/{city}/{country}")
	public String addAddressInContact(@PathParam("alertId") int alertId, @PathParam("city") String city,
			@PathParam("country") String country) {
		AlertLocation location = new AlertLocation(city, country);
		System.out.println("called addLocation");
		return "Added new location in alertProfileId: " + service.addLocationinAlert(location, alertId);
	}

	@PUT
	@Path("/updateLocation/{locationId}/{city}/{country}")
	public AlertLocation updateAddress(@PathParam("locationId") int locationId, @PathParam("city") String city,
			@PathParam("country") String country) {
		AlertLocation location = new AlertLocation(city, country);
		System.out.println("called updateLocation");
		return service.updateLocation(locationId, location);
	}

	@PUT
	@Path("/deleteLocation/{locationId}")
	public int deleteAddress(@PathParam("locationId") int locationId) {
		System.out.println("called deleteLocation");
		return service.deleteLocationOfAlert(locationId);
	}

}
