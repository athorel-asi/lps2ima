package lps2ima.contact.service;

import org.junit.Test;

import lps2ima.contact.exceptions.ContactExistException;

public class ContactServiceTest {

	private ContactService service = new ContactService();
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreerContactNull() throws ContactExistException{
		service.creerContact(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreerContactTropCourt() throws ContactExistException{
		service.creerContact("ab");
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreerContactTropLong() throws ContactExistException{
		service.creerContact("ContactAvecUnNomDe41CaractèresEtPasPlus--");
	}
	
	@Test
	public void testCreerContactCasValide() throws ContactExistException{
		service.creerContact("ContactOk");
	}
	
	@Test(expected=ContactExistException.class)
	public void testCreerContactDoublon() throws ContactExistException{
		service.creerContact("ContactValide");
		service.creerContact("ContactValide");
	}
	
	
}
