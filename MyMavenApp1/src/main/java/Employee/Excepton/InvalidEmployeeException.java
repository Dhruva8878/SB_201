package Employee.Excepton;

public class InvalidEmployeeException extends Exception {
   
	public InvalidEmployeeException() {
		
	}
	public InvalidEmployeeException(String msg) {
		super(msg);
	}
	 
}
