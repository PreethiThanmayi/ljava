package com.capgemini.bean;

public class FlatRegistration {
	private int flat_reg_no;
	private int  owner_id;
	private int flat_type;
	private int flat_area;
	private Double rent_amount;
	private Double deposit_amount;
	
	
	
	public FlatRegistration(int owner_id, int flat_type, int flat_area,
			Double rent_amount, Double deposit_amount) {
		super();
		this.owner_id = owner_id;
		this.flat_type = flat_type;
		this.flat_area = flat_area;
		this.rent_amount = rent_amount;
		this.deposit_amount = deposit_amount;
	}
	public FlatRegistration(int flat_reg_no, int owner_id, int flat_type,
			int flat_area, Double rent_amount, Double deposit_amount) {
		super();
		this.flat_reg_no = flat_reg_no;
		this.owner_id = owner_id;
		this.flat_type = flat_type;
		this.flat_area = flat_area;
		this.rent_amount = rent_amount;
		this.deposit_amount = deposit_amount;
	}
	public FlatRegistration() {
		super();
	}
	public int getFlat_reg_no() {
		return flat_reg_no;
	}
	public void setFlat_reg_no(int flat_reg_no) {
		this.flat_reg_no = flat_reg_no;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public int getFlat_type() {
		return flat_type;
	}
	public void setFlat_type(int flat_type) {
		this.flat_type = flat_type;
	}
	public int getFlat_area() {
		return flat_area;
	}
	public void setFlat_area(int flat_area) {
		this.flat_area = flat_area;
	}
	public Double getRent_amount() {
		return rent_amount;
	}
	public void setRent_amount(Double rent_amount) {
		this.rent_amount = rent_amount;
	}
	public Double getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_amount(Double deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
	@Override
	public String toString() {
		return "FlatRegistration [flat_reg_no=" + flat_reg_no + ", owner_id="
				+ owner_id + ", flat_type=" + flat_type + ", flat_area="
				+ flat_area + ", rent_amount=" + rent_amount
				+ ", deposit_amount=" + deposit_amount + "]";
	}
	
	
	

}
