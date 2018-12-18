package com.capgemini.mps.service;

import org.apache.log4j.Logger;

import com.capgemini.mps.bean.Mobile;
import com.capgemini.mps.dao.IPurchaseDAO;
import com.capgemini.mps.dao.MobileDaoImpl;
import com.capgemini.mps.dao.PurchaseDaoImpl;
import com.capgemini.mps.exception.MobilePurchaseException;

public class PurchaseServiceImpl implements IPurchaseService {
	IPurchaseDAO purchaseDAO=new PurchaseDaoImpl();
 private static Logger serviceLogger=Logger.getLogger(PurchaseServiceImpl.class);

	@Override
	public Integer addPurchaseDetails(String name, String emailId,Long phoneNumber, Integer mobileId) throws MobilePurchaseException {
		try{
			Mobile mobile=new MobileDaoImpl().getMobileDetails(mobileId);
		
		if(mobile.getQuantity()>0){
			Integer purchaseId=purchaseDAO.addPurchaseDetails(name, emailId, phoneNumber, mobileId);
		return purchaseId;
			}else{
				throw new MobilePurchaseException("No stock");
			}
	}catch(MobilePurchaseException e){
		serviceLogger.error(e);
		throw new MobilePurchaseException("Technical Error.Refer logs");
	}

   }
}
