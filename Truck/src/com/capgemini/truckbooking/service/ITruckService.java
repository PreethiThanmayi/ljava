package com.capgemini.truckbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.BookingException;

public interface ITruckService {
	public abstract List<TruckBean> retrieveTruckDetails()throws BookingException ;
	public Boolean isValidTruckId(Integer truckId) throws BookingException;
	public abstract Integer bookTrucks(String custId, long custMobile, int truckId, int noOfTrucks,LocalDate dateOfTransport)throws BookingException ;	
	public String deleteTruck(Integer truckId) throws BookingException;
	public Integer isValidAvailableNos(Integer truckId, Integer availableNos)throws BookingException;
}
 