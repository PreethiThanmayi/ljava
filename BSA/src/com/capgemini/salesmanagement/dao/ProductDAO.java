package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.Exception.ProductException;
import com.capgemini.salesmanagement.ui.DBConnection;

public class ProductDAO implements IProductDAO {
	
	Connection connection = null;
	PreparedStatement statement = null;
	@Override
	public ProductBean getProduct(int code) throws ProductException {
		
          ProductBean productbean;
		try(
				Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from product where product_code=?");)
		{
			
			preparedStatement.setInt(1, code);

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			productbean=new ProductBean();

			productbean.setProduct_name(resultSet.getString(2));
			productbean.setProduct_category(resultSet.getString(3));
			productbean.setProduct_description(resultSet.getString(4));
			productbean.setProduct_price(resultSet.getDouble(5));
		
			return productbean;


		}catch(SQLException e)
		{

		throw new ProductException("statement not created");
		}
	}
	@Override
	public Integer buyProducts(SalesBean bean) throws ProductException {
	
		try(Connection connection=DBConnection.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("insert into sales values(sale_seq.nextval,?,?,?,?)");
			Statement statement=connection.createStatement();
		){	
			preparedStatement.setInt(1, bean.getProduct_code());
			preparedStatement.setInt(2, bean.getQuantity());
			Date d1= Date.valueOf(bean.getSale_date());
			preparedStatement.setDate(3, d1);
			preparedStatement.setDouble(4, bean.getLine_total());
				
			
			int n=preparedStatement.executeUpdate();
			if(n>0){
	    ResultSet resultSet= statement.executeQuery("select max(sales_Id) from sales");
		if(resultSet.next()){
		 Integer sales_Id=resultSet.getInt(1);
		 bean.setSales_Id(sales_Id);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bean.getSales_Id();
	}
	@Override
	public List<ProductBean> getAllProducts() throws ProductException {
		List<ProductBean> list=new ArrayList<ProductBean>();
		try(Connection connection=DBConnection.getConnection();
			Statement statement=connection.createStatement();
					){
			ResultSet resultSet=statement.executeQuery("select * from product");
			while(resultSet.next()){
				ProductBean bean=new ProductBean();
				bean.setProduct_category(resultSet.getString("product_category"));
				bean.setProduct_code(resultSet.getInt("product_code"));
				bean.setProduct_description(resultSet.getString("product_description"));
				bean.setProduct_name(resultSet.getString("product_name"));
				bean.setProduct_price(resultSet.getInt("product_price"));
				
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}




