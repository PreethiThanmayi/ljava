package com.capgemini.truckbooking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.BookingException;
import com.capgemini.truckbooking.util.DBConnection;

public class TruckDao implements ITruckDao {
	private static Logger myUILogger=Logger.getLogger(TruckDao.class);
	Scanner scanner=new Scanner(System.in);
	@Override
	public List<TruckBean> retrieveTruckDetails() throws BookingException {

		int Count=0;
		try(Connection connection=DBConnection.getConnection();
				Statement statement=connection.createStatement();
				){

			ResultSet resultSet=statement.executeQuery(QueryMapper.DISPLAY_TRUCK);
			List<TruckBean> truckList=new ArrayList<>();
			while(resultSet.next()) {
				Count++;
				TruckBean details=new TruckBean();
				populate(details,resultSet);
				truckList.add(details);
			}
			if(Count!=0) {
				return truckList;
			}
			else {
				return null;
			}
		}
		catch(SQLException e) {
			myUILogger.error(e);
			scanner.nextLine();
			System.err.println("Please enter valid users");
		}
		return null;

	}

	private void populate(TruckBean details, ResultSet resultSet) throws SQLException {

		details.setTruckID(resultSet.getInt("truckId"));
		details.setTruckType(resultSet.getString("truckType"));
		details.setOrigin(resultSet.getString("origin"));
		details.setDestination(resultSet.getString("destination"));
		details.setCharges(resultSet.getFloat("charges"));
		details.setAvilableNos(resultSet.getInt("availableNos"));

	}

	@Override
	public Integer bookTrucks(String custId, long custMobile, int truckId, int noOfTrucks, LocalDate dateOfTransport)
			throws BookingException {
		try(
				Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.BOOKING_INSERT);
				Statement statement=connection.createStatement();
			)
			{
			Date sqldate=Date.valueOf(dateOfTransport);
			preparedStatement.setString(1, custId);
			preparedStatement.setLong(2, custMobile);
			preparedStatement.setInt(3, truckId);
			preparedStatement.setInt(4, noOfTrucks);
			preparedStatement.setDate(5, sqldate);

			int n=preparedStatement.executeUpdate();
			System.out.println("Booking Successfull");
			if(n>0) {
				PreparedStatement pstUpdate=connection.prepareStatement(QueryMapper.UPDATE_AVAILABLE_TRUCK);
				pstUpdate.setInt(1, noOfTrucks);
				pstUpdate.setInt(2, truckId);
				pstUpdate.executeUpdate();
				ResultSet resultSet=statement.executeQuery(QueryMapper.BOOKING_NO);
				if(resultSet.next()) {
					Integer BookingId=resultSet.getInt(1);
					return BookingId;
				}
				
			}
			}catch(SQLException e) {
			myUILogger.error(e);
			scanner.nextLine();
			System.err.println("Please enter valid users");
		}
		return null;

	}

	@Override
	public Boolean isValidTruckId(Integer truckId) throws BookingException {
		try(
				Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.TRUCK_CHECK);
				){
			preparedStatement.setInt(1, truckId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			myUILogger.error(e);
			scanner.nextLine();
			System.err.println("Please enter valid users");
		}
		return null;
	}

	@Override
	public Integer isValidAvailableNos(Integer truckId, Integer availableNos)
			throws BookingException {
		try(
				Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.AVAILABLE_TRUCK);
				){
			preparedStatement.setInt(1, truckId);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()){	 
				int avlno=rs.getInt(1);
				if(avlno>=availableNos){
					return 1;
				}
			}
		}  catch(SQLException e){
			myUILogger.error(e);
			scanner.nextLine();
			System.err.println("Please check the loggers");
		}
		return 0;
	}

	@Override
	public String deleteTruck(Integer truckId){
		try(
				Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.DELETE_TRUCK);
		){
			preparedStatement.setInt(1,truckId);
			int n = preparedStatement.executeUpdate();
			if(n>0){
				return "Success";	
			}
		}catch(SQLException e){
			
			e.printStackTrace();
		} catch (BookingException e1) {
		
			e1.printStackTrace();
		}
		return "fail";
	} 

}