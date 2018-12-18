package com.capgemini.mps.dao;

import java.util.List;

import com.capgemini.mps.bean.Mobile;
import com.capgemini.mps.exception.MobilePurchaseException;

public interface IMobileDAO {
public String deleteMobile(Integer mobileId) throws MobilePurchaseException;
public List<Mobile> getAllMobilesDetails() throws MobilePurchaseException;
public List<Mobile> getMobilesPriceRange(Double lowPrice,Double highPrice) throws MobilePurchaseException;
public Boolean isValidMobileId(Integer mobileId) throws MobilePurchaseException;
public Mobile getMobileDetails(Integer mobileId) throws MobilePurchaseException;
public Integer addMobile(Mobile mobile) throws MobilePurchaseException;
public Integer updateMobileQuantity(Integer mobileId,Integer quantity) throws MobilePurchaseException;
}
 