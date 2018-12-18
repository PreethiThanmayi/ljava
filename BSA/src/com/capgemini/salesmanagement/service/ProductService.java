package com.capgemini.salesmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.Exception.ProductException;
import com.capgemini.salesmanagement.dao.IProductDAO;
import com.capgemini.salesmanagement.dao.ProductDAO;

public class ProductService implements IProductService{
	IProductDAO dao=new ProductDAO();

	@Override
	public boolean validateDetails(ProductBean product)throws ProductException {
		
		List<String> list = new ArrayList<>();
		boolean result = false;
		if (!isCodeValid(product.getProduct_code())) {
			list.add("code must be 4 digits");
		}
		if (!isQuantityvalid(product.getQuantity())){
			list.add("quantity should not lesser than or equals to 0");
		}
		
		return false;
	}

	private boolean isQuantityvalid(String quantity) {
		String quantityRegEx = "[1-9]{1,2}";
		Pattern pattern = Pattern.compile(quantityRegEx);
		Matcher matcher = pattern.matcher(quantity);
		return matcher.matches();
	}

	private boolean isCodeValid(int product_code) {
		String codeRegEx = "[1][0-9]{3}";
		Pattern pattern = Pattern.compile(codeRegEx);
		
		Matcher matcher = pattern.matcher(String.valueOf(product_code));
		return matcher.matches();
		
	}

	
	@Override
	public ProductBean getProduct(int code) throws ProductException {
		
		return dao.getProduct(code);
	}

	@Override
	public List<ProductBean> getAllProducts() throws ProductException {
		return dao.getAllProducts();
	}

	@Override
	public Integer buyProducts(SalesBean bean) throws ProductException {
		// TODO Auto-generated method stub
		return dao.buyProducts(bean);
	}

	
	}
	
	

