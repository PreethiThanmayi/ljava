package com.capgemini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.bean.FlatOwners;
import com.capgemini.bean.FlatRegistration;
import com.capgemini.exception.FlatException;

import com.capgemini.util.DBConnection;

public class FlatRegDaoImpl  implements IFlatRegistrationDao{
	/* 
	 *(non-Javadoc)
	 * @see com.capgemini.dao.IFlatRegistrationDao#registerFlat(com.capgemini.bean.FlatRegistration)
	 */
	@Override
	public int  registerFlat(FlatRegistration flatBean)
			throws FlatException {
String sql="insert into flat_registration(flat_reg_no,owner_id,flat_type,flat_area,rent_amount,deposit_amount) values(flat_seq.NEXTVAL,?,?,?,?,?)";
String sql1="select flat_seq.CURRVAL  from dual";
try(

		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		 Statement statement =connection.createStatement();
		
		){
	
	preparedStatement.setInt(1,flatBean.getOwner_id());
	preparedStatement.setInt(2, flatBean.getFlat_type());
	preparedStatement.setInt(3, flatBean.getFlat_area());
	preparedStatement.setDouble(4, flatBean.getRent_amount());
	preparedStatement.setDouble(5, flatBean.getDeposit_amount());
	int n= preparedStatement.executeUpdate();
	
	if(n>0){
		 ResultSet rs=statement.executeQuery(sql1);
		 if(rs.next()){
		 int flat_reg_no=rs.getInt(1);
		 return flat_reg_no;
		 }
	}

}catch(SQLException e){
	e.printStackTrace();
	
}
		return 0;
	}

	@Override
	public List<Integer> getOwnerid() throws FlatException {
		String sql="select owner_id from flat_owners ";
		int id=0;
		try(

				Connection connection=DBConnection.getConnection();
				 Statement statement =connection.createStatement();
				){
			ResultSet resultSet= statement.executeQuery(sql);
			List<Integer>idList= new ArrayList<>();
			while(resultSet.next()){
				id++;
		idList.add(	resultSet.getInt(1));
		
			
			}
			return idList;
			
			
		}catch(SQLException e){
			e.printStackTrace();
		
		}
		return null;
	}

}
