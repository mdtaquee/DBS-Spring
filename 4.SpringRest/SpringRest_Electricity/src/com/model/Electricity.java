package com.model;

public class Electricity {

	
	private int meterno;
	private String areaname;
	private int currentreading;
	private int initialreading;
	private int consumedunits;
	private int costperunit;
	private String lastdate;
	//private int final_deductions;
	private int total_amount;

public Electricity(int meterno, String areaname, int currentreading, int initialreading, int costperunit, String lastdate) {
	
	this.meterno=meterno;
	this.areaname=areaname;
	this.currentreading=currentreading;
	this.initialreading=initialreading;
	this.costperunit=costperunit;
	this.lastdate=lastdate;

}
public int getmeterno() {
	return meterno;
}
public void setmeterno(int meterno) {
	this.meterno=meterno;
}
public String getareaname() {
	return areaname;
}
public void setareaname(String areaname) {
	this.areaname=areaname;
}
public int getcurrentreading() {
	return currentreading;
}
public void setcurrentreading(int currentreading) {
	this.currentreading=currentreading;
}
public int getinitialreading() {
	return initialreading;
}
public void setinitialreading(int initialreading) {
	this.initialreading=initialreading;
}
public int getconsumedunits() {
	return consumedunits;
}
public void setconsumedunits(int consumedunits) {
	this.consumedunits=consumedunits;
}
public int getcostperunit() {
	return costperunit;
}
public void setcostperunit(int costperunit) {
	this.costperunit=costperunit;
}


public String getlastdate() {
	return lastdate;
}
public void setlastdate(String lastdate) {
	this.lastdate=lastdate;
}
public int gettotal_amount() {
	return total_amount;
}
public void settotal_amount(int total_amount) {
	this.total_amount=total_amount;
}

public String toString() {
	String Bill_details;
	Bill_details="\n meterno: "+meterno  +"\n Areaname: "+areaname  + "\n Current Reading: "+currentreading  +  "\n Initial Reading: "+initialreading  + "\n Cost_Per_Unit: " +costperunit  +  "\n LastDate to pay the Bill: " +lastdate +
			"\n Consumed Units :" +consumedunits  +"\n Total Amount to be paid: " +total_amount;
	return Bill_details;
}
}