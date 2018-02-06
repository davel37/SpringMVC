package com.laffey.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.laffey.springdemo.domain.Organization;

@Service
public class DaoUtils {

	public  final String createOperation = "CREATE";
	public  final String readOperation = "READ";
	public  final String updateOperation = "UPDATE";
	public  final String deleteOperation = "DELETE";
	public  final String cleanupOperation = "TRUNCATE";
	
	public void printOrganizations(List<Organization> orgs, String operation) {
		System.out.println("\n******* printing organizations after  " + operation + " operation *******");
		for(Organization org : orgs) {
	     System.out.println(org);
		}	
	}
	
	public  void printOrganization(Organization org, String operation) {
		System.out.println("\n**********printing organization after invokinng " +operation +" operation *********\n" +org);
	}
	
	public  void printSuccessFailure(String operation, boolean param) {
		if(param)
			System.out.println("\nOperation " + operation +" successful");
		else
			System.out.println("\nOperation " + operation + " failed");
	}
	
	public  void createSeedData(OrganizationDao dao) {
		Organization org1 = new Organization("Amazon", 1994, "665544", 8765, "Work hard you fucking cunt");
		Organization org2 = new Organization("BMW", 1980, "66511", 554433, "We Build the best fucking cars");
		Organization org3 = new Organization("Google", 1970, "111111", 212121, "Android is the best");
		
		
		List<Organization> orgs = new ArrayList<Organization>();
		
		orgs.add(0, org1);orgs.add(1, org2);orgs.add(2, org3);
		
		//int orgCount = orgs.size();
		
		int createCount = 0;
		for (Organization org : orgs) {
			boolean isCreated = dao.create(org);
			
			if(isCreated)
				
				createCount +=1;
		}
		System.out.println("Created" + createCount + " organizations");
	}
	
	public  void printOrganizationCount(List<Organization> orgs, String operation) {
		System.out.println("\n************Currently we have " + orgs.size() + " organizations after " + operation + " operation " + " ");
	}
}
