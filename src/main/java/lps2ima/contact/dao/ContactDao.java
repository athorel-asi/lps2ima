package lps2ima.contact.dao;

import java.util.ArrayList;
import java.util.List;

public class ContactDao implements IContactDao {

	List<String> contacts = new ArrayList<>();
	
	public boolean addContact(String nom){
		if(contacts.contains(nom)){
			return false;
		}
		contacts.add(nom);
		return true;
	}
	
	public boolean delete(String nom){
		return false;
	}
	
	public List<String> list(){
		return null;
	}
}
