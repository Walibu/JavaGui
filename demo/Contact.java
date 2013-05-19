package demo;

import java.util.Observable;

public class Contact extends Observable  { // is Observable  and not Observer

	String name="";
	String firstName="";
	String eMail="";
	String telOffice="";
	String telMobil="";
	String birthDay="";
	

	public String getName() {
		return name;
	}
	public void setName(String newName) {
		if (newName!=null && !newName.equals(name)){
			this.name = newName;
			forceNotify();
		}
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String newFirstName) {
		if (newFirstName!=null && !newFirstName.equals(firstName)){
			this.firstName = newFirstName;
			forceNotify();
		}
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String newEMail) {
		if (newEMail!=null && !newEMail.equals(eMail)){
			this.eMail = newEMail;
			forceNotify();
		}
	}
	public String getTelOffice() {
		return telOffice;
	}
	public void setTelOffice(String newTelOffice) {
		if (newTelOffice!=null && !newTelOffice.equals(telOffice)){
			this.telOffice = newTelOffice;
			forceNotify();
		}
	}
	public void forceNotify() {
		System.out.println("Notify");
		setChanged();
		notifyObservers();
	}
	
}