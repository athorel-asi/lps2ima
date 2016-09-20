package lps2ima.contact.dao;

import java.util.List;

/**
 * Interface de DAO pour la gestion des contacts 
 * @author athorel
 *
 */
public interface IContactDao {
	/**
	 * M�thode permettant l'ajout d'un contact
	 * Dans le cas ou le contact existe d�j� on retourne false
	 * @param nom nom du contact 
	 * @return <code>true</code> si le contact est ajout� sinon <code>false</code>
	 */
	boolean addContact(String nom);
	/**
	 * M�thode permettant de supprimer un contact de la liste
	 * @param nom nom du contact
	 * @return <code>true</code> si le contact a �t� correctement supprim� sinon <code>false</code>
	 */
	boolean delete(String nom);
	
	/**
	 * M�thode permettant de r�cup�rer l'annuaire complet
	 * @return liste des contacts
	 */
	List<String> list();
}
