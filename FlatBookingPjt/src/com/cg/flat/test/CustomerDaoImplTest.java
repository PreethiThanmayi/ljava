package com.cg.flat.test;
import com.cg.flat.entity.CustomerEntity;
import com.cg.flat.entity.FlatEntity;
import com.cg.flat.dao.CustomerDaoImpl;
import com.cg.flat.exception.CustomerException;
import com.cg.flat.service.CustomerServiceImpl;
import com.cg.flat.service.CustomerService;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class CustomerDaoImplTest {
	static CustomerDaoImpl cdi;
	static CustomerEntity ce;
	static FlatEntity fe;
	static String num;


	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		cdi = new CustomerDaoImpl();
		ce = new CustomerEntity();
	}
	
	
	
	@Test
	void testAddCustomer() throws ClassNotFoundException, CustomerException {
		assertNotNull(cdi.addCustomer(ce));
	}
	
	
	@Test
	public void testAddCustomer1() throws CustomerException {

		ce.setCusName("manasa");
		ce.setCusNum("9876543210");
		ce.setCusEmail("jklgdj@gmail.com");
		ce.setCusAadhar("876785764765");
		ce.setCusAddress("vgghsfgj");
		ce.setCusFlatId("100");
		assertEquals("manasa", ce.getCusName());
		assertEquals("9876543210", ce.getCusNum());
		assertEquals("jklgdj@gmail.com", ce.getCusEmail());
		assertEquals("876785764765", ce.getCusAadhar());
		assertEquals("vgghsfgj", ce.getCusAddress());
		assertEquals("100", ce.getCusFlatId());

	}
	

	@Test
	void testViewFlatDetails() throws ClassNotFoundException, FileNotFoundException, SQLException, CustomerException
	{
		assertNotNull(cdi.viewFlatDetails(fe));	
		}

	@Test
	void testViewCustomerDetails() throws ClassNotFoundException, FileNotFoundException, CustomerException, SQLException {
		assertNotNull(cdi.viewCustomerDetails(num));	
	}

	@Test
	void testViewFlatDetailsId() throws ClassNotFoundException, FileNotFoundException, SQLException {
		assertNotNull(cdi.viewFlatDetailsId("1010", null));
	}

}
