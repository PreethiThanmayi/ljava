package com.capgemini.client;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.bean.FlatRegistration;
import com.capgemini.exception.FlatException;

import com.capgemini.service.FlatRegServImpl;
import com.capgemini.service.IFlatRegestrationService;

public class Client {
private static IFlatRegestrationService ifregSERV= 	new FlatRegServImpl() ;

private static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) throws FlatException {
		
		while(true){
			 System.out.println("FLAT REGISTRATION SYSTEM");
			 System.out.println("");
			System.out.println("Please choose the below options"); 
			 System.out.println("1.Register Flat");
			 System.out.println("2. Exit");
			 int n= sc.nextInt();
			 switch(n){
			 
			 case 1:
				 System.out.println("Existing Owner ID'S are..  ");
					List<Integer> idList=ifregSERV.getOwnerid();
				 Iterator<Integer> iterator= idList.iterator();
					while(iterator.hasNext()){
						System.out.print(iterator.next()+" ");
					}
					System.out.println();
						System.out.println("Enter any of the ownr id's displayed above");
					int oid=sc.nextInt();
					System.out.println("Select flat type (1-1BHK , 2- 2BHK)");
				int type= sc.nextInt();
				System.out.println("Enter Flat Area");
				int farea= sc.nextInt();
				System.out.println("Enter Desired Rent Amont");
                  Double frent=sc.nextDouble();
                  System.out.println("Enter Desired Deposit Amont");
                  Double fdeposit=sc.nextDouble();
                  FlatRegistration flatRegistration=new FlatRegistration(oid,type,farea,frent,fdeposit);
                  Integer b=	ifregSERV.registerFlat(flatRegistration);
                  System.out.println("Broo..your Booking ID is"+b);
                  
                  
			 
			 }
				
			 break;
			  
			
			
			
		}



	}

}
