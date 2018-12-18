package com.capgemini.truckbooking.util;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.capgemini.truckbooking.exception.BookingException;

public class DBConnectionTest {

	@Test
	public void testGetConnection() throws BookingException, SQLException {
		assertNotNull(DBConnection.getConnection());
	}

}
