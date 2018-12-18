package com.capgemini.truckbooking.dao;

public class QueryMapper {

	public static final String DISPLAY_TRUCK="SELECT * from TruckDetails";
	public static final String BOOKING_INSERT="INSERT into BookingDetails values(booking_id_seq.NEXTVAL,?,?,?,?,?)";
	public static final String TRUCK_CHECK="SELECT truckId from TruckDetails where truckId=?";
	public static final String BOOKING_NO="SELECT booking_id_seq.CURRVAL from dual";
	public static final String UPDATE_AVAILABLE_TRUCK="update Truckdetails set availablenos = availablenos-? where truckid=?";
	public static final String AVAILABLE_TRUCK="SELECT availablenos from TruckDetails where truckId=?";
	public static String DELETE_TRUCK = "DELETE from TruckDetails where truckId=?";
}
