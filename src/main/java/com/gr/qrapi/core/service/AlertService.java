package com.gr.qrapi.core.service;

import java.util.List;

import javax.ejb.Stateless;

import com.gr.common.service.ServiceManager;
import com.gr.qrapi.core.model.AlertProfile;

/**
 * @author ufarooq
 */
@Stateless
public class AlertService implements AlertServiceLocal {

	public static AlertServiceLocal getService() {
		return (AlertServiceLocal) ServiceManager.getService(AlertServiceLocal.class);
	}

	@Override
	public List<AlertProfile> getAllAlerts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addNewAlert(AlertProfile alert) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AlertProfile updateAlert(int id, AlertProfile alert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAlert(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AlertProfile getAlert(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
