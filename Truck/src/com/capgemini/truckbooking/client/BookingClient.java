package com.capgemini.truckbooking.client;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.BookingException;
import com.capgemini.truckbooking.service.CustomerValidator;
import com.capgemini.truckbooking.service.ITruckService;
import com.capgemini.truckbooking.service.TruckService;

public class BookingClient {
private static Logger myUILogger=Logger.getLogger(BookingClient.class);
	private static Scanner scanner=new Scanner(System.in);
	private static TruckBean truckDetails=new TruckBean();
	private static ITruckService truckService=new TruckService();
	private static CustomerValidator validator=new CustomerValidator();
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("resource/log4j.properties");
		int option;
		while(true) {
			
			System.out.println();
			System.out.println("Truck Booking System");
			System.out.println("------------");
			System.out.println("1.Book Truck");
			System.out.println("2.Delete TRUCK");
			System.out.println("3.Exit");
			System.out.println();
			System.out.println("Enter option: ");
			
			option=scanner.nextInt();
			
			try {
				switch(option) {
				
				case 1:
					System.out.println("Enter customer id: ");
					scanner.nextLine();
					String custId=scanner.nextLine();
					//**************************************************************
					if(validator.isValidCustomerId(custId)) 
					{
						List<TruckBean> truckDetails=truckService.retrieveTruckDetails();
						Iterator<TruckBean> iterator=truckDetails.iterator();
						while(iterator.hasNext()) 
						{
							System.out.println(iterator.next());
						}
						//**************************************************************
						
						System.out.println("");
						System.out.println("---------------------------");
						
						System.out.println("Please enter truckId to book truck: ");
						int truckId=scanner.nextInt();
						
						if(truckService.isValidTruckId(truckId)) 
						{
							System.out.println("Enter number of truck to be booked(only numeric value): ");
							int noOfTrucks=scanner.nextInt();
							if(truckService.isValidAvailableNos(truckId, noOfTrucks)==1) 
							{
								System.out.println("Enter Customer Mobile:");
								long custMobile=scanner.nextLong();
								if(validator.isValidPhoneNumber(custMobile)) 
								{
									System.out.println("Enter date of transportation(YYYY-MM-DD): ");
									scanner.nextLine();
									CharSequence date=scanner.nextLine();
									if(validator.isValidDate(date)) 
									{
										LocalDate dateOfTransport=LocalDate.parse(date);
										Integer BookingId=truckService.bookTrucks(custId, custMobile, truckId, noOfTrucks,dateOfTransport);	
										System.out.println("Your booking ID is: "+BookingId);
									}
									else
									{
										System.out.println("Enter valid Date!!!!!!!!");
									}
								}
								else 
								{
									System.out.println("Enter valid Phone Number!!!!!!!!");
								}
							}
							else 
							{
								System.out.println("Sorry No More Trucks available!!!!!!!");
							}														
						}
						else
						{
							System.out.println("Enter valid Truck ID!!!!!!!!");
						}
					}
					else 
					{
						System.out.println("Enter valid customer ID!!!!!!!!!");
					}										
					break;
					
				case 2:
					System.out.println("Enter truckId: ");
					int truckId=scanner.nextInt();
					System.out.println(truckId);
					String status=truckService.deleteTruck(truckId);
					System.out.println(status);
					break;
				case 3:
					System.exit(0);
				}				
			}
			
			catch(Exception e) {
				myUILogger.error(e);
				scanner.nextLine();
				System.err.println("Please enter valid users");
			}
			
		}
		

	}

/*
	public static String deleteTruck(int truckId) {
		try{
			String status=truckService.deleteTruck(truckId);
			if(status.equals(null)){
			return "fail";	
			
			}
		}catch(BookingException e){
			myUILogger.error(e.getMessage());
		}
		return "success";
	}*/
}
