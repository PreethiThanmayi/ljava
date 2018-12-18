package com.capgemini.bean;

public class FlatOwners {
	private int owner_id;
	private String owner_name;
	private  Long mobile;
	
	
	
	public FlatOwners() {
		super();
	}
	public FlatOwners(int owner_id, String owner_name, Long mobile) {
		super();
		this.owner_id = owner_id;
		this.owner_name = owner_name;
		this.mobile = mobile;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "FlatOwners [owner_id=" + owner_id + ", owner_name="
				+ owner_name + ", mobile=" + mobile + "]";
	}
	
	
	
	
	

}
