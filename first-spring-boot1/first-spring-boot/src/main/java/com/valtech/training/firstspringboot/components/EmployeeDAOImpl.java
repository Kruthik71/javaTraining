package com.valtech.training.firstspringboot.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	public class EmployeeRowMapper implements RowMapper<EmployeeD> {

		@Override
		public EmployeeD mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeD e = new EmployeeD();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAge(rs.getInt(3));
			e.setExperience(rs.getInt(4));
			e.setSeniority(rs.getInt(5));
			e.setSalary(rs.getInt(6));
			return e;
		}
	}

	@Autowired
	private DataSource dataSource;

	@Override
	public long countEmployee() {

		// Spring
		String countQry = "SELECT COUNT(ID) FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);

	}

	@Override
	public void deleteEmployee(int id) {
		String deleteQry = "DELETE FROM EMPLOYEE WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	// Update operation (U)
	@Override
	public void updateEmployee(EmployeeD emp) {
		String updateQry = "UPDATE EMPLOYEE SET NAME=?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=?,DEPTID=? WHERE ID=?";
		new JdbcTemplate(dataSource).update(updateQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary(), emp.getDeptId(), emp.getId());

	}

	// Create operation (C)
	@Override
	public void createEmployee(EmployeeD emp) {
		String createQry = "INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID) VALUES(?,?,?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary(), emp.getDeptId());

	}

	@Override
	public List<EmployeeD> getAllEmployees() {
		String selectAllQry = "SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).query(selectAllQry, new EmployeeRowMapper());
	}
	

	@Override
	public EmployeeD getEmployee(int id) {
		String selectQry = "SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID FROM EMPLOYEE WHERE ID=?";
		return new JdbcTemplate(dataSource).queryForObject(selectQry, new EmployeeRowMapper(), id);
	}
	
	@Override
	public void getListOfEmployeeinEachDepartment() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeD> getEmployeeByDeptLocation(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeD> getEmployeeByDeptName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeD> getEmployeeAgeBetween(int min, int max) {
		String ageQry = "SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID FROM EMPLOYEE WHERE AGE BETWEEN ? AND ?";
		return new JdbcTemplate(dataSource).query(ageQry, new EmployeeRowMapper(), min, max);
	}

	public List<EmployeeD> getEmployeeBySeniority(int limitVal) {
	    String seniorQry = "SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID FROM EMPLOYEE ORDER BY SENIORITY DESC LIMIT ?";
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    return jdbcTemplate.query(seniorQry, new EmployeeRowMapper(), limitVal);
	}


	@Override
	public List<EmployeeD> getEmployeeSalaryGreater(int amount) {
		String seniorQry = "SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID FROM EMPLOYEE WHERE SALARY<?";
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    return jdbcTemplate.query(seniorQry, new EmployeeRowMapper(), amount);
	}

	@Override
	public List<EmployeeD> getEmployeeSalaryLesser(int amount) {
		String seniorQry = "SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID FROM EMPLOYEE WHERE SALARY>=?";
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    return jdbcTemplate.query(seniorQry, new EmployeeRowMapper(), amount);
	}

	/*
	 * @Override public void getListOfEmployeeinEachDepartment() throws SQLException
	 * { Connection con=getConnection(); PreparedStatement ps=con.
	 * prepareStatement("UPDATE DEPARTMENT D SET EMPLIST=(SELECT COUNT(*) FROM EMPLOYEE E WHERE E.DEPTID=D.DEPTID)"
	 * ); int rowsUpdated=ps.executeUpdate();
	 * System.out.println("Rows update:"+rowsUpdated); con.close(); }
	 * 
	 * @Override public List<EmployeeD> getEmployeeByDeptLocation(String name)
	 * throws SQLException { Connection con=getConnection(); PreparedStatement
	 * ps=con.
	 * prepareStatement("SELECT * FROM EMPLOYEE WHERE DEPTID IN (SELECT DEPTID FROM DEPARTMENT WHERE DEPTLOC=?)"
	 * ); ps.setString(1, name); ResultSet rs=ps.executeQuery(); List<EmployeeD>
	 * emps1=new ArrayList<>(); while(rs.next()) {
	 * emps1.add(mapRowToEmployeeWithoutID(rs)); } con.close();
	 * System.out.println(emps1.size()); return emps1; }
	 * 
	 * @Override public List<EmployeeD> getEmployeeByDeptName(String name) throws
	 * SQLException { Connection con=getConnection(); PreparedStatement ps=con.
	 * prepareStatement("SELECT * FROM EMPLOYEE WHERE DEPTID IN (SELECT DEPTID FROM DEPARTMENT WHERE DEPTNAME=?)"
	 * ); ps.setString(1, name); ResultSet rs=ps.executeQuery(); List<EmployeeD>
	 * emps1=new ArrayList<>(); while(rs.next()) {
	 * emps1.add(mapRowToEmployeeWithoutID(rs)); } con.close();
	 * System.out.println(emps1.size()); return emps1; }
	 * 
	 * @Override public List<EmployeeD> getEmployeeAgeBetween(int min, int max)
	 * throws SQLException { Connection con=getConnection(); PreparedStatement
	 * ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE AGE BETWEEN ? AND ?");
	 * ps.setInt(1, min); ps.setInt(2, max); ResultSet rs=ps.executeQuery();
	 * List<EmployeeD> emps1=new ArrayList<>(); while(rs.next()) {
	 * emps1.add(mapRowToEmployeeWithoutID(rs)); } con.close(); return emps1; }
	 * 
	 * @Override public List<EmployeeD> getEmployeeBySeniority(int limitVal) throws
	 * SQLException{ Connection con=getConnection(); PreparedStatement ps=con.
	 * prepareStatement("SELECT * FROM EMPLOYEE ORDER BY SENIORITY DESC LIMIT ?");
	 * ps.setInt(1, limitVal); ResultSet rs=ps.executeQuery(); List<EmployeeD>
	 * emps1=new ArrayList<>(); while(rs.next()) {
	 * emps1.add(mapRowToEmployeeWithoutID(rs)); } con.close(); return emps1; }
	 * 
	 * @Override public List<EmployeeD> getEmployeeSalaryLesser(int amount) throws
	 * SQLException { Connection con=getConnection(); PreparedStatement
	 * ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY<?");
	 * ps.setInt(1, amount); ResultSet rs=ps.executeQuery(); List<EmployeeD>
	 * emps1=new ArrayList<>(); while(rs.next()) {
	 * emps1.add(mapRowToEmployeeWithoutID(rs)); } con.close(); return emps1; }
	 * 
	 * @Override public List<EmployeeD> getEmployeeSalaryGreater(int amount) throws
	 * SQLException { Connection con=getConnection(); PreparedStatement
	 * ps=con.prepareStatement("SELECT * FROM EMPLOYEE WHERE SALARY>=?");
	 * ps.setInt(1, amount); ResultSet rs=ps.executeQuery(); List<EmployeeD>
	 * emps1=new ArrayList<>(); while(rs.next()) {
	 * emps1.add(mapRowToEmployeeWithoutID(rs)); } con.close(); return emps1; }
	 * 
	 * //Create operation (C)
	 * 
	 * @Override public void createEmployee(EmployeeD emp) throws SQLException {
	 * Connection con=getConnection(); PreparedStatement ps=con.
	 * prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID) VALUES(?,?,?,?,?,?)"
	 * ); populatePreparedStatmentFromEmployee(emp, ps); int
	 * rowsUpdated=ps.executeUpdate();
	 * System.out.println("Rows update:"+rowsUpdated); con.close(); }
	 * 
	 * //Read Operation (R)
	 * 
	 * @Override public List<EmployeeD> getAllEmployees() throws SQLException{
	 * Connection con=getConnection(); PreparedStatement ps=con.
	 * prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID FROM EMPLOYEE"
	 * ); ResultSet rs=ps.executeQuery(); List<EmployeeD> emps=new ArrayList<>();
	 * while(rs.next()) { emps.add(mapRowToEmployee(rs)); } con.close(); return
	 * emps; }
	 * 
	 * //Update operation (U)
	 * 
	 * @Override public void updateEmployee(EmployeeD emp) throws SQLException {
	 * Connection con=getConnection(); PreparedStatement ps=con.
	 * prepareStatement("UPDATE EMPLOYEE SET NAME=?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=?,DEPTID=? WHERE ID=?"
	 * ); populatePreparedStatmentFromEmployee(emp, ps); ps.setInt(7, emp.getId());
	 * int rowsUpdated=ps.executeUpdate();
	 * System.out.println("Rows update:"+rowsUpdated); con.close(); }
	 * 
	 * //Delete operation (D)
	 * 
	 * @Override public void deleteEmployee(int id) throws SQLException { Connection
	 * con=getConnection(); PreparedStatement
	 * ps=con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?"); ps.setInt(1, id);
	 * int rowsUpdated=ps.executeUpdate();
	 * System.out.println("Rows update:"+rowsUpdated); con.close(); }
	 * 
	 * //Read operation
	 * 
	 * @Override public EmployeeD getEmployee(int id) throws SQLException {
	 * Connection con=getConnection(); PreparedStatement ps=con.
	 * prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID FROM EMPLOYEE WHERE ID=?"
	 * ); ps.setInt(1, id); ResultSet rs=ps.executeQuery(); if(rs.next()) {
	 * EmployeeD e = mapRowToEmployee(rs); con.close(); return e; }else {
	 * System.out.println("No row with Id "+id+" found."); return null; } }
	 * 
	 * private EmployeeD mapRowToEmployee(ResultSet rs) throws SQLException {
	 * EmployeeD e=new EmployeeD(); e.setId(rs.getInt(1));
	 * e.setName(rs.getString(2)); e.setAge(rs.getInt(3));
	 * e.setExperience(rs.getInt(4)); e.setSeniority(rs.getInt(5));
	 * e.setSalary(rs.getInt(6)); e.setDeptId(rs.getInt(7)); return e; }
	 * 
	 * private EmployeeD mapRowToEmployeeWithoutID(ResultSet rs) throws SQLException
	 * { EmployeeD e=new EmployeeD(); e.setId(rs.getInt(6));
	 * e.setName(rs.getString(1)); e.setAge(rs.getInt(2));
	 * e.setExperience(rs.getInt(3)); e.setSeniority(rs.getInt(4));
	 * e.setSalary(rs.getInt(5)); e.setDeptId(rs.getInt(7)); return e; }
	 * 
	 * private void populatePreparedStatmentFromEmployee(EmployeeD emp,
	 * PreparedStatement ps) throws SQLException { ps.setString(1, emp.getName());
	 * ps.setInt(2, emp.getAge()); ps.setInt(3,emp.getExperience()); ps.setInt(4,
	 * emp.getSeniority()); ps.setInt(5, emp.getSalary()); ps.setInt(6,
	 * emp.getDeptId()); }
	 */
}
