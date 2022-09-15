package ASS_1;

public class AddDepart {
	
	public static void main(String[] args) {
		
		EmployeeDAO emp=new EmployeeDaoImpl();
		
		Department dp=new Department();
		
		Employee em=new  Employee();
		em.setAddress(new Address("Indore","MP", "456788"));
		em.setEmpName("Ram");
		em.setSalary(25000);
		em.setDep(dp);
		
		dp.setDeptName("HR");
		dp.setLocation("Indore");
		dp.getEmplo().add(em);
		
		emp.addDepartment(dp);
		
	}

}
