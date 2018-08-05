package com.gr.qrapi.core.service;

import java.util.List;

import javax.ejb.Local;

import com.gr.qrapi.core.model.AlertLocation;
import com.gr.qrapi.core.model.AlertProfile;

/**
 * @author ufarooq
 */
@Local
public interface AlertServiceLocal {

	List<AlertProfile> getAllAlerts();

	int addNewAlert(AlertProfile alert);

	AlertProfile updateAlert(int id, AlertProfile alert);

	int deleteAlert(int id);

	AlertProfile getAlert(int id);

	List<AlertLocation> viewAllLocationsOfAlerts(int alertId);

	int addLocationinAlert(AlertLocation location, int alertId);

	AlertLocation updateLocation(int locationId, AlertLocation locationNew);

	int deleteLocationOfAlert(int locationId);
}
