package demo;

import java.util.Observable;

public class Contact extends Observable  { // is Observable  and not Observer

	String name="";
	String firstName="";
	String eMail="";
	String telOffice="";
	String telMobil="";
	String birthDay="";
	String notes="";
	

	public String getName() {
		return name;
	}
	public void setName(String newName) {
		if (newName!=null && !newName.equals(name)){
			this.name = newName;
			forceNotify("name");
		}
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String newFirstName) {
		if (newFirstName!=null && !newFirstName.equals(firstName)){
			this.firstName = newFirstName;
			forceNotify("firstName");
		}
	}
	
	public String getEMail() {
		return eMail;
	}
	public void setEMail(String newEMail) {
		if (newEMail!=null && !newEMail.equals(eMail)){
			this.eMail = newEMail;
			forceNotify("eMail");
		}
	}
	
	public String getTelOffice() {
		return telOffice;
	}
	public void setTelOffice(String newTelOffice) {
		if (newTelOffice!=null && !newTelOffice.equals(telOffice)){
			this.telOffice = newTelOffice;
			forceNotify("telOffice");
		}
	}
	
	public String getTelMobile() {
		return telMobil;
	}
	public void setTelMobile(String newTelMObile) {
		if (newTelMObile!=null && !newTelMObile.equals(telMobil)){
			this.telMobil = newTelMObile;
			forceNotify("telMobil");
		}
	}
	
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String newBirthDay) {
		if (newBirthDay!=null && !newBirthDay.equals(birthDay)){
			this.birthDay = newBirthDay;
			forceNotify("birthDay");
		}
	}
	
	public void setNotes(String newNotes) {
		if (newNotes!=null && !newNotes.equals(notes)){
			this.notes = newNotes;
			forceNotify("notes");
		}
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void forceNotify(String fieldName) {
		System.out.println("Notify");
		setChanged();
		notifyObservers(fieldName);
	}
	
}