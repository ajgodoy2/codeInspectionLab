package labcodeinspection;

import java.util.Locale;

public class Email {

	final private transient String firstName;
	final private transient String lastName;
	private transient String password;
	private transient String department;
	final private transient int defaultpassLen = 8;
	private transient String email;

	/**
	* @author Axel Godoy
	* Constructor for the class
	*/
	public Email(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	* @author Axel Godoy
	* Method to show info of the email
	*/
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + firstName + "\nLAST NAME= " + lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}
	
	/**
	* @author Axel Godoy
	* Method to set the type of department 
	*/
	public void setDeparment(final int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			System.out.println("Choose a valid option");
		}
		
	}

	private String randomPassword(final int length) {
		final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			final int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}
	
	/**
	* @author Axel Godoy
	* Method to generate the email with all the required parameters
	*/
	public void generateEmail() {
		this.password = this.randomPassword(this.defaultpassLen);
		this.email = this.firstName.toLowerCase(Locale.getDefault()) + this.lastName.toLowerCase(Locale.getDefault()) + "@" + this.department
				+ ".espol.edu.ec";
	}
}
