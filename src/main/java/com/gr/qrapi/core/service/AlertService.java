package com.gr.qrapi.core.service;

import java.util.List;

import javax.ejb.Stateless;

import com.gr.common.service.ServiceManager;
import com.gr.qrapi.core.dao.AlertProfileDaoHibernateImpl;
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
		return AlertProfileDaoHibernateImpl.getDao().getAllAlerts();
	}

	@Override
	public int addNewAlert(AlertProfile alert) {
		return AlertProfileDaoHibernateImpl.getDao().addNewAlert(alert);
	}

	@Override
	public AlertProfile updateAlert(int id, AlertProfile alert) {
		return AlertProfileDaoHibernateImpl.getDao().updateAlert(id, alert);
	}

	@Override
	public int deleteAlert(int id) {
		return AlertProfileDaoHibernateImpl.getDao().deleteAlert(id);
	}

	@Override
	public AlertProfile getAlert(int id) {
		return AlertProfileDaoHibernateImpl.getDao().getAlert(id);
	}

	

	
}
