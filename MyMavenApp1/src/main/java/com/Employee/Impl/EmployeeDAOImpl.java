package com.Employee.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Employee.DAO.EmployeeDAO;
import com.Employee.detail.Employee;
import com.masai.Demo;

import Employee.Excepton.InvalidEmployeeException;


public class EmployeeDAOImpl  implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<>();
		
		try(Connection conn=Demo.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from employee");
			
			 ResultSet rs=ps.executeQuery();
			 
			 while(rs.next()) {
				 int id=rs.getInt("empId");
				 String name=rs.getString("name");
				 String add=rs.getString("address");
				 int sal=rs.getInt("salary");
				 
				list.add(new Employee(id,name,add,sal));
				
			 }
			
		}
		     catch(SQLException e) {
			       System.out.println(e.getMessage());
		      }
		return list;
	}

	@Override
	public String getAddressOfEmployee(int empId) throws InvalidEmployeeException {
		
		String address="Not found";
		
		try(Connection conn=Demo.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select address from employee where empid=?");
			ps.setInt(1, empId);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				address=rs.getString("address");
			}
			else {
				throw new InvalidEmployeeException("Invalid format");
			}
			
			
		}
		catch (SQLException e) {
			throw  new InvalidEmployeeException("Invalid format"); 
		}
		
		return address;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) throws InvalidEmployeeException {
		String ans="Not Updated";
		
		try(Connection conn=Demo.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("Update employee set salary=salary+? where empId=?");
			ps.setInt(1, bonus);
			ps.setInt(2,empId);
			
			
			int n=ps.executeUpdate();
			if(n>0) {
				ans="Updated Successfully";
			}
			else {
				throw new InvalidEmployeeException("Invalid Input");
			}
			
			
		}
		catch (SQLException e) {
			throw new InvalidEmployeeException("Inavalid Input");
		}
		return ans;
	}

	@Override
	public boolean deleteEmployee(int empId) throws InvalidEmployeeException {
		boolean value=false;
		
		try(Connection conn=Demo.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from employee where empId=?");
			ps.setInt(1, empId);
			
			int res=ps.executeUpdate();
			if(res>0) {
				value =true;
			}
			else {
				throw new InvalidEmployeeException("Employee Doesn't Exist");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new InvalidEmployeeException("Employee Doesn't Exist");
		}
		
		
		
		return value;
	}

	@Override
	public String[] getNameAndAddress(int empId) throws InvalidEmployeeException {
		String [] emp= {null,null};
		
		try(Connection conn=Demo.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from employee where empId=?");
			ps.setInt(1, empId);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				String name=rs.getString("name");
				String add=rs.getString("address");
				
				emp[0]=name;
				emp[1]=add;
				
			}
			else {
				throw new InvalidEmployeeException("Employee Doesn't Exist");
				
			}
			
		} catch (SQLException e) {
			throw new InvalidEmployeeException("Employee Doesn't Exist");
		}
		
		
		
		return emp;
	}

}
