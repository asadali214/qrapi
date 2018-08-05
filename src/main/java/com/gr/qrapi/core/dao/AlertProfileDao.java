package com.gr.qrapi.core.dao;

import java.util.List;

import com.gr.common.dao.GenericDao;
import com.gr.qrapi.core.model.AlertLocation;
import com.gr.qrapi.core.model.AlertProfile;

public interface AlertProfileDao extends GenericDao<AlertProfile, Integer> {
	public List<AlertProfile> getAllAlerts();

	public int addNewAlert(AlertProfile alert);

	public AlertProfile updateAlert(int id, AlertProfile alert);

	public int deleteAlert(int id);

	public AlertProfile getAlert(int id);

	public List<AlertLocation> viewAllLocationsOfAlerts(int alertId);

	public int addLocationinAlert(AlertLocation location, int alertId);

	public AlertLocation updateLocation(int locationId, AlertLocation locationNew);

	public int deleteLocationOfAlert(int locationId);

}
