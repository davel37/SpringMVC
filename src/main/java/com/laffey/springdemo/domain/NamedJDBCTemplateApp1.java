package com.laffey.springdemo.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.Driver;
import com.laffey.springdemo.dao.DaoUtils;
import com.laffey.springdemo.dao.OrganizationDao;
import com.laffey.springdemo.daoimpl.OrgsnizationDoaImpl;

@Component
public class NamedJDBCTemplateApp1 {
	
	@Autowired
	private OrganizationDao dao;
	@Autowired
	private DaoUtils daoUtils;
	
	public void actionMethod() {

		//Create seed data
		daoUtils.createSeedData(dao);
		
		//List organizations
		List<Organization> orgs = dao.getAllOrganizations();
		daoUtils.printOrganizations(orgs, daoUtils.readOperation);
		
		//Create a new organization record
		Organization org = new Organization("General Electric", 1223, "9999", 5665,"You are a cunt");
		boolean isCreated = dao.create(org);
		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.readOperation);
	
		
		//get a single organization 
		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, "getOrganizationcunt");
		
		 //Updating a slogan for organization
	    Organization org3 = dao.getOrganization(2);
	    org3.setSlogan("We build Feliz Reyez");
	    boolean isUpdated = dao.update(org3);
	    daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
	    daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);
		
		//Delete an organization
	    boolean isDeleted = dao.delete(dao.getOrganization(3));
	    daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
	    daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.deleteOperation);
		
	
		//Cleanup
	    dao.cleanup();
	    daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.cleanupOperation);
		
		
	}
	public static void main(String[] args) {
		
		
		
		
		//Create the application context
		ApplicationContext cxt = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		NamedJDBCTemplateApp1 mainApp = cxt.getBean(NamedJDBCTemplateApp1.class);
		
		mainApp.actionMethod();
		
		
		//Create the bean
	//	OrganizationDao dao = (OrgsnizationDoaImpl) cxt.getBean("orgDao");
		
		//Create seed data
		
		
		//Close the application context
		
		((ClassPathXmlApplicationContext)cxt).close();

	}

}
