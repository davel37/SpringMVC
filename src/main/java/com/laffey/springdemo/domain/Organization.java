package com.laffey.springdemo.domain;

public class Organization {
	
	private int id;
	private String companyName;
	private int yearOfIncorporation;
	private String postalcode;
	private int employeeCount;
	private String slogan;
	
	public Organization () {}
	public Organization( String companyName, int yearOfIncorporation, String postalcode, int employeeCount,
			String slogan) {
		super();
		
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		this.postalcode = postalcode;
		this.employeeCount = employeeCount;
		this.slogan = slogan;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getYearOfIncorporation() {
		return yearOfIncorporation;
	}
	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postcode) {
		this.postalcode = postcode;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", companyName=" + companyName + ", yearOfIncorporation="
				+ yearOfIncorporation + ", postalcode=" + postalcode + ", employeeCount=" + employeeCount + ", slogan="
				+ slogan + "]";
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	
	

}
