package com.capgemini.truckbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.dao.ITruckDao;
import com.capgemini.truckbooking.dao.TruckDao;
import com.capgemini.truckbooking.exception.BookingException;

public class TruckService implements ITruckService{
	
	ITruckDao truckDAO=new TruckDao();
	
	@Override
	public List<TruckBean> retrieveTruckDetails() throws BookingException {
		
		List<TruckBean> truckDetails=truckDAO.retrieveTruckDetails();
		return truckDetails;
	}

	@Override
	public Integer bookTrucks(String custId, long custMobile, int truckId, int noOfTrucks,LocalDate dateOfTransport)
			throws BookingException {
		
		
		try {
			Integer BookingId=truckDAO.bookTrucks(custId,custMobile,truckId,noOfTrucks,dateOfTransport);
			if(BookingId>0) {
				return BookingId;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean isValidTruckId(Integer truckId) throws BookingException {
		return truckDAO.isValidTruckId(truckId);
	}

	@Override
	public Integer isValidAvailableNos(Integer truckId, Integer noOfTrucks)
			throws BookingException {
		try {
			Integer bool=truckDAO.isValidAvailableNos(truckId,noOfTrucks);
			return truckDAO.isValidAvailableNos(truckId,noOfTrucks);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteTruck(Integer truckId) throws BookingException {
		
		String s = truckDAO.deleteTruck(truckId);
		System.out.println("service layer:"+s);
		
		return s; 
		
	}
}
