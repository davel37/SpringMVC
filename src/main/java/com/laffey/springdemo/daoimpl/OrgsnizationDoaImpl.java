package com.laffey.springdemo.daoimpl;

import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.laffey.springdemo.dao.OrganizationDao;
import com.laffey.springdemo.domain.Organization;

@Repository
public class OrgsnizationDoaImpl implements OrganizationDao {
	
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
  @Autowired
	public void setDataSource(DataSource datasource) {
		
		
		namedParamJdbcTemplate =  new NamedParameterJdbcTemplate(datasource);
	}

	public boolean create(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code,employee_count, slogan)" + "VALUES( :companyName,:yearOfIncorporation,:postalcode,:employeeCount,:slogan)";
		
		//Object[] args = new Object[] {org.getCompanyName(), org.getYearOfIncorporation(),org.getPostcode(),
		//org.getEmployeeCount(), org.getSlogan()};
		//return jdbcTemplate.update(sqlQuery, args) ==1;
		return namedParamJdbcTemplate.update(sqlQuery, beanParams)==1;
		}
	

	public Organization getOrganization(Integer id) {
		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String  sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan " + "FROM organization WHERE id = :ID";
		//Object [] args = new Object[] {id};
		
		Organization org = namedParamJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganizations() {
		
		
		String sqlQuery = "Select * FROM organization";
		
		List<Organization> orglist = namedParamJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orglist;
	}

	public boolean delete(Organization org) {
		SqlParameterSource beansParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "DELETE FROM organization WHERE id = :id";
		//Object[] args = new Object[] {org.getId()};
		return namedParamJdbcTemplate.update(sqlQuery, beansParams)==1;
		
	}

	public boolean update(Organization org) {
		SqlParameterSource beansParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
	//	Object [] args = new Object[] {org.getSlogan(),org.getId()};
		return namedParamJdbcTemplate.update(sqlQuery, beansParams) == 1;
	}

	public void cleanup() {
		
		String sqlQuery = "TRUNCATE TABLE organization ";
		namedParamJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	

	}

}
