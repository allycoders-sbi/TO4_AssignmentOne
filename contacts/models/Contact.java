package contacts.models;

import contacts.exception.*;

public class Contact {
	String name,email,mobileNumber,addedBy;
	
	public Contact(String addedBy,String name, String email, String mobileNumber) throws InvalidNameException,InvalidEmailException,InvalidMobileException {
		super();
		if(name.matches("^[aA-zZ0-9 ]*$")==false) {
			throw new InvalidNameException("Name must be of proper format!");
		}
		else
		{
			this.name = name;
		}
		/*if(email.matches("^[aA-zZ0-9 ]*$")==false) {
			throw new InvalidEmailException("Email must be of proper format!");
		}
		else
		{
			this.email = email;
		}*/
		
		if(email.matches("^[0-9]{10}$")) {
			throw new InvalidMobileException("Mobile must be of 10 digit!");
		}
		else
		{
			this.mobileNumber = mobileNumber;
		}
		this.addedBy=addedBy;
	}
}
