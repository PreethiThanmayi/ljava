package com.capgemini.mps.dao;

import com.capgemini.mps.exception.MobilePurchaseException;

public interface IPurchaseDAO {
public  Integer addPurchaseDetails(String name,String emailId,Long phoneNumber,Integer mobileId) throws MobilePurchaseException;

}
