package contacts.models;

import java.util.LinkedList;
import contacts.exception.*;
import logs.model.LogWriter;

public class ContactService {
	LinkedList<Contact> ll = new LinkedList<Contact>();
	LogWriter lw = new LogWriter();
	
	public void addContact(String adderName,String name,String email, String mobile) {
		
		try {
			
			lw.log(adderName+":::Trying to create a new Contact", 1511, "Info");
			Contact newContact = new Contact(adderName,name,email,mobile);
			lw.log(adderName+":::Crated a new Contact", 1511, "Info");
			lw.log(adderName+":::Trying to add it into LinkedList", 1511, "Info");
			ll.add(newContact);
			lw.log(adderName+":::Added to LinkedList", 1511, "Info");
		}
		catch(InvalidNameException e) {
			lw.log(adderName+":::Failed to create contact due to invalid name", 1511, "Error");
		}
		catch(InvalidEmailException e) {
			lw.log(adderName+":::Failed to create contact due to invalid email", 1511, "Error");
		}
		catch(InvalidMobileException e) {
			lw.log(adderName+":::Failed to create contact due to invalid Mobile", 1511, "Error");
		}
	}



	public void listContact()
	{
		for (Contact contact : ll) {
			System.out.println("Email:"+contact.email);
			System.out.println("Mobile:"+contact.mobileNumber);
			System.out.println("Name:"+contact.name);
			System.out.println("AddedBy:"+contact.addedBy);
			System.out.println("----------------------");
		}
	}
	
	public void dumpLog() {
		lw.dumpLog();
	}
}