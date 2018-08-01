package com.gr.qrapi.core.service;

import java.util.List;

import javax.ejb.Local;

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
}
