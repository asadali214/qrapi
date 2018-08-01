package com.gr.qrapi.core.dao;

import java.util.List;

import com.gr.common.dao.GenericDao;
import com.gr.qrapi.core.model.AlertProfile;

public interface AlertProfileDao extends GenericDao<AlertProfile, Integer>{
	public List<AlertProfile> getAllAlerts();
	public int addNewAlert(AlertProfile alert);
	public AlertProfile updateAlert(int id, AlertProfile alert);
	public int deleteAlert(int id);
	public AlertProfile getAlert(int id);

}
