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

public class ContactServiceMockTest extends MockTest{
	
	@TestSubject
	private ContactService service = new ContactService();
	
	@Mock
	private IContactDao dao;

	@Test
	public void testCreerContactCasValide() throws ContactExistException{
		
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
	
	@Test
	public void testSupprimerContactOk() throws ContactInexistException{
		String nom = "Toto";
		EasyMock.expect(dao.delete(nom)).andReturn(true);
		replayAll();
		
		service.supprimerContact(nom);
		
		verifyAll();
	}
	
	@Test(expected=ContactInexistException.class)
	public void testSupprimerContactKo() throws ContactInexistException{
		String nom = "Toto";
		EasyMock.expect(dao.delete(nom)).andReturn(false);
		replayAll();
		
		service.supprimerContact(nom);
		
		verifyAll();
	}
	
	@Test(expected=ContactExistException.class)
	public void testCreerContactDoublon() throws ContactExistException{
		String nom = "ContactKo";
		expect(dao.addContact(nom)).andReturn(false);
		replayAll();
		service.creerContact(nom);
		verifyAll();
	}
	
	@Test(expected=TimeoutException.class)
	public void testListContactTimeout() throws InterruptedException, ExecutionException, TimeoutException{
		expect(dao.list()).andAnswer(new IAnswer<List<String>>() {

			@Override
			public List<String> answer() throws Throwable {
				// TODO Auto-generated method stub
				Thread.sleep(5000);
				return null;
			}
			
		
		});
		replayAll();
		service.listerContacts();
		verifyAll();
	}
	
}
