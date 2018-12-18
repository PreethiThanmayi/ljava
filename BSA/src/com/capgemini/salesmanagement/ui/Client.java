package com.capgemini.salesmanagement.ui;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.Exception.ProductException;
import com.capgemini.salesmanagement.service.IProductService;
import com.capgemini.salesmanagement.service.ProductService;




public class Client {

	static Logger logger = Logger.getLogger(Client.class);

	public static void main(String[] args) throws ProductException {

		PropertyConfigurator.configure("resources/log4j.properties");
		logger.info("log4j file loaded...");
		IProductService service = new ProductService();
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("welcome to  Billing software Applicatuion");
System.out.println("********************");
			System.out.println("1.Buy a Product");
			System.out.println("2.Exit");
			System.out.println("Select ur choice");
			int request = scanner.nextInt();
			switch(request){

			case 1:
				List<ProductBean> list=service.getAllProducts();
				for(ProductBean bean:list){
					System.out.println(bean);
				}
				System.out.println("Select Product code:");
				int code=scanner.nextInt();
				System.out.println("Enter Quantity:");
				int quantity=scanner.nextInt();


					ProductBean p = service.getProduct(code);
					System.out.println("---------------------");
					System.out.println("Product Name:  " + p.getProduct_name());
					System.out.println("Product Category: " + p.getProduct_category());
					System.out.println("Product Description:" + p.getProduct_description());
					System.out.println("Product Price (Rs): " + p.getProduct_price());
					System.out.println("Quantity: " + quantity);
					System.out.println("Line Total (Rs):  " + (quantity*p.getProduct_price()));
				SalesBean bean=new SalesBean();
				bean.setProduct_code(code);
				bean.setQuantity(quantity);
				bean.setSale_date(LocalDate.now());
				bean.setLine_total(quantity*p.getProduct_price());
				System.out.println("Sale Id :"+service.buyProducts(bean));
				break;
			case 2: System.exit(0);
			}
		}
	}
}