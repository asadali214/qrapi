package com.gr.qrapi.core.dao;

import java.util.List;

import com.gr.common.dao.AbstractHibernateDao;
import com.gr.common.dao.DaoManager;
import com.gr.qrapi.core.model.AlertProfile;

public class AlertProfileDaoHibernateImpl extends AbstractHibernateDao<AlertProfile, Integer> implements AlertProfileDao{
	
	
	public static AlertProfileDao getDao() {
		return DaoManager.getInstance().getDao(AlertProfileDao.class);
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
