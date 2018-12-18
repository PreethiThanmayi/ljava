package com.capgemini.mps.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.capgemini.mps.exception.MobilePurchaseException;
import com.capgemini.mps.util.DBConnection;

public class MobileDaoImplTest {
	@BeforeClass
	public static void testDBConnection() {
		try{
			System.out.println("Before class method");
			Connection connection=DBConnection.getConnection();
			assertNotNull(connection);
		}catch(MobilePurchaseException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();			
		}
	}
	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
