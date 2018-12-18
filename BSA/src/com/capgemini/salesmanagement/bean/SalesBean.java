package com.capgemini.salesmanagement.bean;

import java.time.LocalDate;

public class SalesBean {
	
	private Integer sales_Id;
	private Integer product_code;
	private Integer quantity;
	private LocalDate sale_date;
	private Double line_total;
	
	public SalesBean(){
		
	}
	
	public SalesBean(Integer sales_Id, Integer product_code, Integer quantity,
			LocalDate sale_date, Double line_total) {
		super();
		this.sales_Id = sales_Id;
		this.product_code = product_code;
		this.quantity = quantity;
		this.sale_date = sale_date;
		this.line_total = line_total;
	}

	public Integer getSales_Id() {
		return sales_Id;
	}

	public void setSales_Id(Integer sales_Id) {
		this.sales_Id = sales_Id;
	}

	public Integer getProduct_code() {
		return product_code;
	}

	public void setProduct_code(Integer product_code) {
		this.product_code = product_code;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getSale_date() {
		return sale_date;
	}

	public void setSale_date(LocalDate sale_date) {
		this.sale_date = sale_date;
	}

	public Double getLine_total() {
		return line_total;
	}

	public void setLine_total(double d) {
		this.line_total = d;
	}

	@Override
	public String toString() {
		return "SalesBean [sales_Id=" + sales_Id + ", product_code="
				+ product_code + ", quantity=" + quantity + ", sale_date="
				+ sale_date + ", line_total=" + line_total + "]";
	}
	
	

}
