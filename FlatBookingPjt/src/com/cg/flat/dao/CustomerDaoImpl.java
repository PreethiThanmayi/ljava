package com.cg.flat.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.flat.entity.CustomerEntity;
import com.cg.flat.entity.FlatEntity;
import com.cg.flat.exception.CustomerException;
import com.cg.flat.util.DBConnection;

public class CustomerDaoImpl implements ICustomerDao {
	static PreparedStatement preparedStatement;
	static Connection connection;
	Logger logger=Logger.getRootLogger();
	public CustomerDaoImpl()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	
	
	public String addCustomer(CustomerEntity customerEntity)throws CustomerException, ClassNotFoundException{
		int queryResult=0;
		//String fType=null;
		try {
			Connection connection=DBConnection.getConnection();
			PreparedStatement preparedStatement=null;
			PreparedStatement pst1=null;
			ResultSet rs = null;
			Statement statement=connection.createStatement();
			String flatId=null;
			//preparedStatement=connection.prepareStatement("insert into customer values(cust_seq.nextval,?,?,?,?,?,sysdate,?,null)");
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);
			preparedStatement.setString(1,customerEntity.getCusName());			
			preparedStatement.setString(2,customerEntity.getCusNum());
			preparedStatement.setString(3,customerEntity.getCusEmail());
			preparedStatement.setString(4,customerEntity.getCusAadhar());
			preparedStatement.setString(5,customerEntity.getCusAddress());
			preparedStatement.setString(6,customerEntity.getCusFlatId());
			
			queryResult=preparedStatement.executeUpdate();
		     
			pst1=connection.prepareStatement("update flat set flatavty=(select flatavty from flat where cusflatid='"+customerEntity.getCusFlatId()+"')-1 where cusflatid='"+customerEntity.getCusFlatId()+"'");
			
			
					pst1.executeUpdate();
					if(queryResult==0)
					{
						logger.error("Insertion failed ");
						throw new CustomerException("Inserting donor details failed ");

					}
					else
					{
						logger.info("Donor details added successfully:");
						
					}
			return customerEntity.cusId;
			
		}
		
			catch(Exception e) 
			{
				
				e.printStackTrace();
			}
	
		return null;
			
	}
		
	

	public List viewFlatDetails(FlatEntity flatEntity) throws ClassNotFoundException, FileNotFoundException, SQLException, CustomerException 
	{

		Connection connection=DBConnection.getConnection();
		Statement st=connection.createStatement();
		ResultSet resultset = null;
		List<FlatEntity> li=new ArrayList<FlatEntity>();
		try
		{
			
	          //resultset=st.executeQuery("select * from flat ");
		
			resultset=st.executeQuery(QueryMapper.SELECT_QUERY );
			while(resultset.next())
			{
				FlatEntity flatEntity1=new FlatEntity();
				flatEntity1.setCusFlatId(resultset.getString(1));
				flatEntity1.setFlatArea(resultset.getString(2));
				flatEntity1.setFlatType(resultset.getString(3));
				flatEntity1.setFlatSqft(resultset.getString(4));
				flatEntity1.setFlatPrice(resultset.getString(5));
				flatEntity1.setFlatAvty(resultset.getInt(6));
				li.add(flatEntity1);
				
			}
			if( flatEntity != null)
			{
				logger.info("Record Found Successfully");
				
			}
			else
			{
				logger.info("Record Not Found Successfully");
				
			}
			
		}
		catch(Exception e)
		{
			
			throw new CustomerException(e.getMessage());
		}
		
		return li;
	}
	
				
	public CustomerEntity viewCustomerDetails(String cusNum) throws CustomerException, ClassNotFoundException, FileNotFoundException, SQLException
	{
		Connection connection=DBConnection.getConnection();
		
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		CustomerEntity customerEntity=null;
		
		try
		{
			//preparedStatement=connection.prepareStatement("select * from customer where cusNum=?");
			preparedStatement=connection.prepareStatement(QueryMapper.SELECT_QUERY_CUST);
			preparedStatement.setString(1,cusNum);
			resultset=preparedStatement.executeQuery();
			
			if(resultset.next())
			{
				customerEntity = new CustomerEntity();
				
				customerEntity.setCusName(resultset.getString(2));
				customerEntity.setCusNum(resultset.getString(3));
				customerEntity.setCusEmail(resultset.getString(4));
				customerEntity.setCusAddress(resultset.getString(5));
				customerEntity.setCusAadhar(resultset.getString(6));
				
			}
			if( customerEntity != null)
			{
				logger.info("Record Found Successfully");
				
			}
			else
			{
				logger.info("Record Not Found Successfully");
				
			}
		}
		catch(Exception e)
		{
			
			throw new CustomerException(e.getMessage());
		}
		finally
		{
			try 
			{
				resultset.close();
				preparedStatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				
				throw new CustomerException("Error in closing db connection");

			}
		}
		return customerEntity;
		
	}

	
	public FlatEntity viewFlatDetailsId(String cusFlatId,String cusNum) throws ClassNotFoundException, FileNotFoundException, SQLException  {
		Connection connection=DBConnection.getConnection();
		
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		FlatEntity flatEntity=null;
		CustomerEntity customerEntity=null;
		
		try
		{
			//preparedStatement=connection.prepareStatement("select f.cusflatid,f.flatarea ,f.flattype , f.flatsqft ,f.flatprice ,f.flatavty from flat f,customer c where f.cusflatid=? and c.cusnum=? and f.cusflatid=c.cusflatid");
			preparedStatement=connection.prepareStatement(QueryMapper.SELECT_QUERY_FLAT);
			preparedStatement.setString(1,cusFlatId);
			preparedStatement.setString(2,cusNum);
			resultset=preparedStatement.executeQuery();
			while(resultset.next())
			{
			    flatEntity=new FlatEntity();
			    customerEntity = new CustomerEntity();
			    
			   flatEntity.setCusFlatId(resultset.getString(1));
			    flatEntity.setFlatArea(resultset.getString(2));
				flatEntity.setFlatType(resultset.getString(3));
				flatEntity.setFlatSqft(resultset.getString(4));
				flatEntity.setFlatPrice(resultset.getString(5));
				//flatEntity.setCusFlatId(resultset.getString(5));
				/*customerEntity.setCusName(resultset.getString(2));
				customerEntity.setCusNum(resultset.getString(3));
				customerEntity.setCusBookedDate(resultset.getDate(7));*/
				//System.out.println(resultset.getString(1) +  resultset.getString(2)+ resultset.getString(3)+  resultset.getString(4)+  resultset.getString(5)+  resultset.getString(6)+  resultset.getString(7)+  resultset.getString(8));
			}
			
			if( flatEntity != null)
			{
				logger.info("Record Found Successfully");
				
			}
			else
			{
				logger.info("Record Not Found Successfully");
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		return flatEntity;
	}



	
	
	
	
}
		
