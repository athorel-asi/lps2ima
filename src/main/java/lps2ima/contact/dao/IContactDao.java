package lps2ima.contact.dao;

import java.util.List;

/**
 * Interface de DAO pour la gestion des contacts 
 * @author athorel
 *
 */
public interface IContactDao {
	/**
	 * Méthode permettant l'ajout d'un contact
	 * Dans le cas ou le contact existe déjà on retourne false
	 * @param nom nom du contact 
	 * @return <code>true</code> si le contact est ajouté sinon <code>false</code>
	 */
	boolean addContact(String nom);
	/**
	 * Méthode permettant de supprimer un contact de la liste
	 * @param nom nom du contact
	 * @return <code>true</code> si le contact a été correctement supprimé sinon <code>false</code>
	 */
	boolean delete(String nom);
	
	/**
	 * Méthode permettant de récupérer l'annuaire complet
	 * @return liste des contacts
	 */
	List<String> list();
}
