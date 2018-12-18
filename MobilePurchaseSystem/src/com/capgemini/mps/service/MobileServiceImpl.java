package com.capgemini.mps.service;

import java.util.List;

import com.capgemini.mps.bean.Mobile;
import com.capgemini.mps.dao.IMobileDAO;
import com.capgemini.mps.dao.MobileDaoImpl;
import com.capgemini.mps.exception.MobilePurchaseException;

public class MobileServiceImpl implements IMobileService {
private IMobileDAO mobileDAO=new MobileDaoImpl();
	@Override
	public String deleteMobile(Integer mobileId) throws MobilePurchaseException {
		return mobileDAO.deleteMobile(mobileId);
	}

	@Override
	public List<Mobile> getAllMobilesDetails() throws MobilePurchaseException {
		List<Mobile> mobileList=mobileDAO.getAllMobilesDetails();
		return mobileList;
	}

	@Override
	public List<Mobile> getMobilesPriceRange(Double lowPrice, Double highPrice) throws MobilePurchaseException {
List<Mobile> mobileList	=mobileDAO.getMobilesPriceRange(lowPrice, highPrice);
return mobileList;
	}

	@Override
	public boolean isValidMobileId(Integer mobileId)
			throws MobilePurchaseException {
		return mobileDAO.isValidMobileId(mobileId);
	}
	
	

}
