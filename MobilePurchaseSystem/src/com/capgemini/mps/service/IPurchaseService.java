package com.capgemini.mps.service;

import com.capgemini.mps.exception.MobilePurchaseException;

public interface IPurchaseService {
	public Integer addPurchaseDetails(String name,String emailId,Long phoneNumber,Integer mobileId) throws MobilePurchaseException;
}