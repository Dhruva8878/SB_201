package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;
import com.masai.repo.EmployeeRepo;

@Service
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	public EmployeeRepo serv;

	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
		
	    Employee res= serv.save(emp);
	    if(res!=null) {
	        return res;	
	    }
	    else {
	    	throw new EmployeeException("Not Able To Register the Employee");
	    }
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
		
		 Optional<Employee> res= serv.findById(empId);
		 
		 if(res.isPresent()) {
			 return res.get();
		 }
		 else {
			 throw new EmployeeException("No Results Found By this Id :"+empId);
		 }
		
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		
		List<Employee> list= serv.findAll();
		if(list.size()>0) {
			return list;
		}
		else {
			throw new EmployeeException("No Employee Found");
		}
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
		
		Optional<Employee> emp=serv.findById(empId);
		
		if(emp.isPresent()) {
			
			Employee res=emp.get();
			
		    serv.delete(emp.get());
			
		    return res;
		}
		else {
			throw new EmployeeException("Employee Not Found By This Id :"+empId);
		}
	}

	@Override
	public List<Employee> getEmployeeDetailsByAddress(String address) throws EmployeeException {
		
		List<Employee> list=serv.findByAddress(address);
		
		if(list.size()>0) {
			return list;
		}
		else {
			throw new EmployeeException("No Employee Found By This Address :"+ address);
		}
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		
		Optional<Employee> res=serv.findById(emp.getEmpId());
		
		if(res.isPresent()) {
			
			return serv.save(emp);
			
		}
		else {
			throw new EmployeeException("wrong Credentials");
		}
	}

	@Override
	public String[] getNameAndAddressOfEmplyeeById(Integer empId) throws EmployeeException {
		
		Optional<Employee> emp=serv.findById(empId);
		
		if(emp.isPresent()) {
			Employee res=emp.get();
			String[] str= {res.getEmpName(),res.getAddress()};
			return str;
		}
		else {
			throw new EmployeeException("Employee Not Found By Id :"+empId);
		}
		
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee() throws EmployeeException {
		
		List<EmployeeDTO> emps=new ArrayList<>();
		
		List<Employee> list=serv.findAll();
		
		for(Employee em:list) {
			
			EmployeeDTO e=new EmployeeDTO(em.getEmpName(), em.getAddress(), em.getSalary());
			
			emps.add(e);
		}
		
		if(emps.size()>0) {
			return emps;
		}
		else {
			throw new EmployeeException("No Employee Found");
		}
	}
	
	
	

}
