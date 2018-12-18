package com.capgemini.salesmanagement.service;

import java.util.List;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.Exception.ProductException;



public interface IProductService {
	boolean validateDetails(ProductBean patient) throws ProductException;
	public ProductBean getProduct(int code) throws ProductException;
	public List<ProductBean> getAllProducts()throws ProductException;
	public Integer buyProducts(SalesBean bean) throws ProductException;
}
