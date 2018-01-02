package com.example.demo.classe;

public class Distance {

	private String idShop;
	private double distanceShop;
	
	public Distance(String idShop, double distanceShop) {
		super();
		this.idShop = idShop;
		this.distanceShop = distanceShop;
	}
	public String getIdShop(){
		return idShop;
	}
	public void setIdShop(String idShop){
		this.idShop = idShop;
	}
	public double getDistanceShop() {
		return distanceShop;
	}
	public void setDistanceShop(double distanceShop) {
		this.distanceShop = distanceShop;
	}
	@Override
	public String toString() {
		return "Distance [idShop=" + idShop + ", distanceShop=" + distanceShop + "]";
	}
	
}
