package com.capgemini.salesmanagement.bean;

public class ProductBean {
	
	private int Product_code;
	private String Product_name;
	private String Product_category;
	private String product_description;
	private double Product_price;
	private String quantity;
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getProduct_code() {
		return Product_code;
	}
	public void setProduct_code(int product_code) {
		Product_code = product_code;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getProduct_category() {
		return Product_category;
	}
	public void setProduct_category(String product_category) {
		Product_category = product_category;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public double getProduct_price() {
		return Product_price;
	}
	public void setProduct_price(double product_price) {
		Product_price = product_price;
	}
	@Override
	public String toString() {
		return "ProductBean [Product_code=" + Product_code + ", Product_name="
				+ Product_name + ", Product_category=" + Product_category
				+ ", product_description=" + product_description
				+ ", Product_price=" + Product_price + "]";
	}
	
	
}
