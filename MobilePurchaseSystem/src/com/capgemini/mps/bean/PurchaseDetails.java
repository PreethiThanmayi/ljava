package com.capgemini.mps.bean;

import java.time.LocalDate;

public class PurchaseDetails {
	private Integer purchaseId;
	private String customerName;
	private String emailId;
	private Long phoneNumber;
	private LocalDate purchaseDate;
	private Integer mobileId;
	
	public PurchaseDetails(){
		
	}

	public PurchaseDetails(Integer purchaseId, String customerName,
			String emailId, Long phoneNumber, LocalDate purchaseDate,
			Integer mobileId) {
		super();
		this.purchaseId = purchaseId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.purchaseDate = purchaseDate;
		this.mobileId = mobileId;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	@Override
	public String toString() {
		return "PurchaseDetails [purchaseId=" + purchaseId + ", customerName="
				+ customerName + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", purchaseDate=" + purchaseDate
				+ ", mobileId=" + mobileId + "]";
	}
	
	
	
	
}
