package lps2ima.contact.service;

import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;

import lps2ima.contact.MockTest;
import lps2ima.contact.dao.IContactDao;
import lps2ima.contact.exceptions.ContactExistException;
import lps2ima.contact.exceptions.ContactInexistException;

import static org.easymock.EasyMock.expect;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class MockFailTest extends MockTest{
	
	@TestSubject
	private ContactService service = new ContactService();
	
	@Mock
	private IContactDao dao;

	@Test
	public void testCreerContactErr() throws ContactExistException{
		
		//Phase d'enregistrement des comportements 
		String nom = "ContactOk";
		EasyMock.expect(dao.addContact(nom)).andReturn(true);
		// Fin de l'enregistrement 
		replayAll();
		
		//Appel de la méthode 
		service.creerContact(nom);
		
		//Vérification
		verifyAll();
	}
}
