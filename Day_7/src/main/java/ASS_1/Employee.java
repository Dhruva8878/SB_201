package ASS_1;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {

	private Address homeAddress;
	private Address officeAddress;
	private int salary;
	
	
	
	
	@Override
	public String toString() {
		return "Employee [homeAddress=" + homeAddress + ", officeAddress=" + officeAddress + ", salary=" + salary + "]";
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
