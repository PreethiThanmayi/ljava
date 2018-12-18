package com.capgemini.mps.service;

import java.util.List;

import com.capgemini.mps.bean.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;

public interface IMobileService {
	public String deleteMobile(Integer mobileId) throws MobilePurchaseException;
	public List<Mobile> getAllMobilesDetails() throws MobilePurchaseException;
	public List<Mobile> getMobilesPriceRange(Double lowPrice,Double highPrice) throws MobilePurchaseException;
	public boolean isValidMobileId(Integer mobileId) throws MobilePurchaseException;
}
