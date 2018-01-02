package com.example.demo.classe;

public class Location {

String type;
double[] coordinates=new double[2];

public Location(String type, double[] coordinates) {
	super();
	this.type = type;
	this.coordinates=coordinates;
} 
/*
public Location(String type, double abs,double ord){
	super();
	this.type = type;
	this.coordinate[0] = abs;
	this.coordinate[1]=ord;
} 
*/
public double abs() {
	return coordinates[0];
}
public double ord() {
	return coordinates[1];
}
public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public double[] getCoordinates() {
	return coordinates;
}

public void setCoordinates(double[] coordinate) {
	this.coordinates = coordinate;
}

}
