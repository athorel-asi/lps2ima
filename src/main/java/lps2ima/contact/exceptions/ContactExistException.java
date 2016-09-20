package lps2ima.contact.exceptions;

public class ContactExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContactExistException(String nom) {
		super("Le nom "+nom+" existe d�j� en base de donn�es");
	}
	
	

}
