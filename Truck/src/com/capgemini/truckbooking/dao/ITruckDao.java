package com.capgemini.truckbooking.dao;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.BookingException;

public interface ITruckDao {
	public List<TruckBean> retrieveTruckDetails()throws BookingException ;
	public String deleteTruck(Integer truckId) throws BookingException;
	public Integer bookTrucks(String custId, long custMobile, int truckId, int noOfTrucks,LocalDate dateOfTransport)throws BookingException;
	public Boolean isValidTruckId(Integer truckId)throws BookingException;
	public Integer isValidAvailableNos(Integer truckId, Integer availableNos)throws BookingException;
	
}
