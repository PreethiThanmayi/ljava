package com.cg.flat.client;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.flat.exception.CustomerException;
import com.cg.flat.service.CustomerServiceImpl;
import com.cg.flat.entity.CustomerEntity;
import com.cg.flat.entity.FlatEntity;
import com.cg.flat.exception.CustomerException;
import com.cg.flat.service.CustomerService;
import com.cg.flat.service.CustomerServiceImpl;

public class FlatMain {
	
	static Scanner scanner=new Scanner(System.in);
	static CustomerServiceImpl customerServiceImpl=null;
	static	CustomerService customerService=null;
	
public static void main(String[] args) throws CustomerException, ClassNotFoundException, FileNotFoundException, SQLException {
	
	CustomerEntity customerEntity=null;
	FlatEntity flatEntity=null;
	
	//String cusId=null;
	String cusFlatId=null;
	String cusNum=null;
	
	int opt=0;
	while(true)
	{
		
		System.out.println("Menu");
		System.out.println("1-It Displays available Flats");
		System.out.println("2-Book your flat by entering your details");
		System.out.println("3-view Customer by customer number");
		System.out.println("4-It Displays Flat Details you have booked");
		//System.out.println("5-It Displays available Flats by flat type");

		System.out.println("5-exit");
		System.out.println("select an option");

	try
	{
		opt=scanner.nextInt();
		switch(opt) {
		
		case 1: 
			String type=null;
			
				try
				{
					customerServiceImpl=new CustomerServiceImpl();
					
					List<FlatEntity> li=new ArrayList<FlatEntity>();
					li=customerServiceImpl.viewFlatDetails(flatEntity);
					
					System.out.println("\n"+li+"\n");
				}
				catch(CustomerException ce) {
					
					System.err.println("Error:"+ce.getMessage());
				}
			 
				System.out.println(flatEntity);
			
			break;
	
		
		case 2:
			FlatEntity fe=new FlatEntity();
			
			System.out.println("enter flat id");
			String str = scanner.next();
			fe.setCusFlatId(str);
			
			String custId =null;
			customerEntity = new CustomerEntity();
			customerEntity.setCusFlatId(str);
			
			customerServiceImpl = new CustomerServiceImpl();
			customerService = new CustomerServiceImpl();
			
			System.out.println("enter details of custoemr :");
			
			System.out.println("enter name : ");
			customerEntity.setCusName(scanner.next());
			
			System.out.println(" enter contact :");
			customerEntity.setCusNum(scanner.next());
			
			System.out.println("enter email : ");
			customerEntity.setCusEmail(scanner.next());
			
			System.out.println(" enter aadhaar number : ");
			customerEntity.setCusAadhar(scanner.next());
			
			System.out.println(" enter addresss : ");
			customerEntity.setCusAddress(scanner.next());
			
			/*try
			{
				
				if(customerServiceImpl.validateCustomer(customerEntity)==null)
				{
					custId = customerService.addCustomer(customerEntity);
				}
				//return customerEntity;
			}
			
			catch(CustomerException customerException)
			{
			System.err.println(customerException.getMessage());
				System.exit(0);
				
			}*/
			
			if(customerServiceImpl.validatecusNum(customerEntity.getCusNum()))
			{
				custId = customerService.addCustomer(customerEntity);
				System.out.println("details successfully added");
			}
			
			break;
			
		case 3:
			customerServiceImpl=new CustomerServiceImpl();
			System.out.println("Enter Customer Phone Number:");
			cusNum = scanner.next();
			customerEntity = getCustomerDetails(cusNum);

			if (customerEntity != null)
			{
				System.out.println("Name               :"+ customerEntity.getCusName());
				System.out.println("Phone Number       :"+ customerEntity.getCusNum());
				System.out.println("Email Id           :"+ customerEntity.getCusEmail());
				System.out.println("Address            :"+ customerEntity.getCusAddress());
				System.out.println("Aadhar number      :"+ customerEntity.getCusAadhar());
				break;
			} 
			else
			{
				System.err.println("There are no details associated with your phone number "+ cusNum);
								
			}

			break;
			
		
		case 4:
			flatEntity=new FlatEntity();
			customerEntity=new CustomerEntity();
			
			System.out.println("Enter your flat Id to see your booked flat ");
			 cusFlatId=scanner.next();
			 
			 System.out.println("Enter your phone no");
			 cusNum=scanner.next();
			 
			 customerServiceImpl=new CustomerServiceImpl();
			 while (true) 
				{
				 flatEntity=getFlatDetailsId(cusFlatId,cusNum);
					if ( customerServiceImpl.validatecusFlatId(cusFlatId)&&customerServiceImpl.validatecusNum(cusNum)) 
					{
						
						
						System.out.println("Your flat details are:");
						System.out.println("Flat Id              :"+ flatEntity.getCusFlatId());
						System.out.println("Flat area          :"+ flatEntity.getFlatArea());
						System.out.println("Flat Type          :"+ flatEntity.getFlatType());
						System.out.println("Flatsqft           :"+ flatEntity.getFlatSqft());
						System.out.println("Flat Price         :"+ flatEntity.getFlatPrice());
						
						 break;

					} 
					else
					{
						System.err.println("Please enter correct Flat Id or number");
						
						cusFlatId = scanner.next();
						cusNum=scanner.next();
					}
				
				}
			
			 break;
			
		
		/*case 5:
			
				String type1=null;
				System.out.println("enter flat type (1BHK/2BHK/3BHK");
				type=scanner.next();
				customerServiceImpl=new CustomerServiceImpl();
				while(true)
				{
					if(customerServiceImpl.validateflatType(type1))
					{
						break;
					}
					else
					{
						System.out.println("please enter correct flat type");
						type1=scanner.next();
					}
				}
				if(type1!=null)
				{
					System.out.println("Available flats for "+type1 +"are: ");
					flatEntity=getFlatDetails(type1);
					System.out.println(flatEntity);
				}*/
		case 5: 
			System.out.print("Exit ");
			System.exit(0);
			break;
			
			
		default:System.out.println("enter valid option");	
		}
		}
	catch(InputMismatchException ime)
	{
		System.out.println(ime);
	}
		
 }
	
}


/*private static FlatEntity getFlatDetails(String type1) {
FlatEntity flatEntity=new FlatEntity();
customerService=new CustomerServiceImpl();
flatEntity=customerService.viewFlatDetails(type1);
	return flatEntity;
}*/


private static FlatEntity getFlatDetailsId(String cusFlatId,String cusNum) throws ClassNotFoundException, FileNotFoundException, SQLException, CustomerException {

	
	FlatEntity flatEntity=null;
	customerService = new CustomerServiceImpl();
	flatEntity=customerService.viewFlatDetailsId(cusFlatId,cusNum);
	//System.out.println("get1");
	return flatEntity;
}

private static CustomerEntity getCustomerDetails(String cusId) throws CustomerException, ClassNotFoundException, FileNotFoundException, SQLException {
	CustomerEntity customerEntity = null;
	customerService = new CustomerServiceImpl();

	customerEntity = customerService.viewCustomerDetails(cusId);

	customerService = null;
	return customerEntity;
}

	

private static CustomerEntity retrieveCustomerEntity() {
	
	CustomerEntity customerEntity=new CustomerEntity();
	
		
	System.out.println("enter your Name ");
	customerEntity.setCusName(scanner.next());
	
	System.out.println("enter your Number ");
	customerEntity.setCusNum(scanner.next());
	
	System.out.println("enter your Email ");
	customerEntity.setCusEmail(scanner.next());
	
	System.out.println("enter your Aadhar number ");
	customerEntity.setCusAadhar(scanner.next());
	
	System.out.println("enter your Address ");
	customerEntity.setCusAddress(scanner.next());
	System.out.println(customerEntity.cusAadhar);
	
	/*System.out.println("enter the Flat Id which you wnat to book");
	String cusFlatId=scanner.next();
	customerEntity.setCusFlatId(cusFlatId);*/
	
	customerServiceImpl =new CustomerServiceImpl(); 
	
	/*try
	{
	System.out.println("g");
		if(customerServiceImpl.validateCustomer(customerEntity)==null)
		return customerEntity;
	}
	
	catch(CustomerException customerException)
	{
		System.err.println(customerException.getMessage());
		System.exit(0);
		
	}*/
	
	return customerEntity;
}
}

