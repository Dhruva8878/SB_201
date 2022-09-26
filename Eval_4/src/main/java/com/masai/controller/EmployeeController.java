package com.masai.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.EmployeeDTO;
import com.masai.service.EmployeeDAO;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeDAO emd;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> registerHandler(@RequestBody Employee emp) throws EmployeeException{
		
	 Employee employee=emd.registerEmployee(emp);
	 
	 return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getByIdHandler(@PathVariable("id") Integer id) throws EmployeeException{
		
		Employee emp= emd.getEmployeeById(id);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	@GetMapping("/Employees")
	public ResponseEntity<List<Employee>> getAllHandler() throws EmployeeException{
        
		List<Employee> list=emd.getAllEmployeeDetails();
		
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/delEmployee")
	public ResponseEntity<Employee> deleteHandler(@PathVariable("id") Integer id) throws EmployeeException{
	   
		Employee emp=emd.deleteEmployeeById(id);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeAddr")
	public ResponseEntity<List<Employee>> byAddressHandler(@PathParam(value = "adr") String Address) throws EmployeeException{
		
		List<Employee> emps= emd.getEmployeeDetailsByAddress(Address);
		
		return new ResponseEntity<List<Employee>>(emps,HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateHandler(@RequestBody Employee emps) throws EmployeeException{
		
		Employee em=emd.updateEmployee(emps);
		
		return new ResponseEntity<Employee>(em,HttpStatus.OK); 
	}
	
	@GetMapping("/getspecs")
	public ResponseEntity<String[]> nameAndAddressHandler(Integer id) throws EmployeeException{
		
		String[] str=emd.getNameAndAddressOfEmplyeeById(id);
		
		return new ResponseEntity<String[]>(str,HttpStatus.OK);
		
	}
	
	@GetMapping("/getDTO")
	public ResponseEntity<List<EmployeeDTO>> DTOHandler() throws EmployeeException{
		
		List<EmployeeDTO> dto=emd.getNameAddressSalaryOfAllEmployee();
		
		return new ResponseEntity<List<EmployeeDTO>>(dto,HttpStatus.OK);
	}
	
	

}
