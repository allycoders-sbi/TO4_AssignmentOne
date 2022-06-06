package contacts.driver;

import contacts.models.ContactService;

public class ContactsDriver {
	public static void main(String[] args) {
		CDriver t1 = new CDriver("Papa");
		CDriver t2 = new CDriver("Jayant");
		CDriver t3 = new CDriver("Mummy");
		
		t1.start();
		t2.start();
		t3.start();
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class CDriver extends Thread{
	
	String adderName;
	
	
	
	public CDriver(String adderName) {
		super();
		this.adderName = adderName;
	}



	public void run() {
		ContactService cs = new ContactService();
		for(int k=0;k<500;k++) {
			String Name = "Person " + k;
			String email = "person"+k+"@gmail.com";
			String mobile = "9898984455";
			
			
			cs.addContact(adderName,Name, email, mobile);
			//cs.dumpLog();
		}
		System.out.println("FinalOutput");
		cs.listContact();
	}
	
}
