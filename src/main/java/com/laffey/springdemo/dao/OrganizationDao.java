package com.laffey.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.laffey.springdemo.domain.Organization;

public interface OrganizationDao {
	// Set the data source that will be required to create a connection to a database.
	public void setDataSource(DataSource ds);
	
	//Create a record in the organization table.
	public boolean create(Organization org);
	
	//Retrieve  single organization
	public Organization getOrganization(Integer id);
	
	  //Retrieve all organizations from the table
	public List<Organization>  getAllOrganizations();
	
	//Delete a specific organization
	public boolean delete(Organization org);
	
	//Update an existing organization
	public boolean update(Organization org);
	
	//Cleanup the organization
	public void cleanup();
	

}
