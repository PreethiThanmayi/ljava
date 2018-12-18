package com.capgemini.truckbooking.bean;

public class TruckBean {
	private int truckID;
	private String truckType;
	private String origin;
	private String destination;
	private float charges;
	private int avilableNos;
	
	public TruckBean() {
		
	}

	public TruckBean(int truckID, String truckType, String origin, String destination, float charges, int avilableNos) {
		super();
		this.truckID = truckID;
		this.truckType = truckType;
		this.origin = origin;
		this.destination = destination;
		this.charges = charges;
		this.avilableNos = avilableNos;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getCharges() {
		return charges;
	}

	public void setCharges(float charges) {
		this.charges = charges;
	}

	public int getAvilableNos() {
		return avilableNos;
	}

	public void setAvilableNos(int avilableNos) {
		this.avilableNos = avilableNos;
	}

	@Override
	public String toString() {
		return "TruckBean [truckID=" + truckID + ", truckType=" + truckType + ", origin=" + origin + ", destination="
				+ destination + ", charges=" + charges + ", avilableNos=" + avilableNos + "]";
	}		
	
}
