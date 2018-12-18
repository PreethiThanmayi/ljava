package com.capgemini.mps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.capgemini.mps.exception.MobilePurchaseException;
import com.capgemini.mps.util.DBConnection;

public class PurchaseDaoImpl implements IPurchaseDAO{
	private static Logger daoLogger=Logger.getLogger(PurchaseDaoImpl.class);

	@Override
	public Integer addPurchaseDetails(String name, String emailId,
			Long phoneNumber, Integer mobileId) throws MobilePurchaseException {
		try(
				Connection connection=DBConnection.getConnection();
				PreparedStatement PreparedStatement=connection.prepareStatement(QueryMapper.ADD_PURCHASE_DETAILS);
				Statement statement=connection.createStatement();
				){
			PreparedStatement.setString(1, name);
			PreparedStatement.setString(2, emailId);
			PreparedStatement.setLong(3, phoneNumber);
			PreparedStatement.setInt(4, mobileId);
			int n=PreparedStatement.executeUpdate();
			if(n>0){
				daoLogger.info("1 row added to purchase details table");
				new MobileDaoImpl().updateMobileQuantity(mobileId, 1);
				ResultSet resultSet=statement.executeQuery(QueryMapper.RETRIVE_PURCHASEID);
				if(resultSet.next()){
					Integer purchaseId=resultSet.getInt(1);
				return purchaseId;
				}else{
					return null;
				}}else{
					daoLogger.info("Unable to ass purchase details");
				throw new MobilePurchaseException("Technical error. Please refer logs");
			}
		}catch(SQLException e){
			daoLogger.error(e);
			throw new MobilePurchaseException("Technical Error.Refer Logs");
		}
		

	}


}
