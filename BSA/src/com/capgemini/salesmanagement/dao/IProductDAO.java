package com.capgemini.salesmanagement.dao;

import java.util.List;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.Exception.ProductException;

public interface IProductDAO {
	
	ProductBean getProduct(int code) throws ProductException;
	Integer buyProducts(SalesBean bean) throws ProductException;
	public List<ProductBean> getAllProducts()throws ProductException;

	}

