package lps2ima.contact.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import lps2ima.contact.dao.ContactDao;
import lps2ima.contact.dao.IContactDao;
import lps2ima.contact.exceptions.ContactExistException;
import lps2ima.contact.exceptions.ContactInexistException;

/**
 * Classe de service de contact
 * 
 * @author athorel
 *
 */
public class ContactService {

	IContactDao dao = new ContactDao();

	/**
	 * Méthode permettant de créer un contact a partir de son nom
	 * 
	 * @param nom
	 *            le nom du contact doit-être inclu entre 3 et 40 caractères
	 * @throws ContactExistException
	 *             Exception levée dans le cas d'un doublon
	 */
	public void creerContact(String nom) throws ContactExistException {
		if (nom == null || nom.length() < 3 || nom.length() > 40) {
			throw new IllegalArgumentException("Le nom doit être compris entre 3 et 40 caractères");
		}
		if (!dao.addContact(nom)) {
			throw new ContactExistException(nom);
		}
	}

	public void supprimerContact(String nom) throws ContactInexistException {
		if(!dao.delete(nom)){
			throw new ContactInexistException();
		}
	}

	public List<String> listerContacts() throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newScheduledThreadPool(1);
		
		return executor.submit(new Callable<List<String>>(){

			@Override
			public List<String> call() throws Exception {
				return dao.list();
			}}).get(5000, TimeUnit.MILLISECONDS);
	}
}
