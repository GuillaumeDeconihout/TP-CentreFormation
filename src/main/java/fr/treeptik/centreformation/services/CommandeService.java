package fr.treeptik.centreformation.services;

import java.util.List;

import fr.treeptik.centreformation.domain.Commande;
import fr.treeptik.centreformation.exceptions.ServiceException;

public interface CommandeService {
	
	Commande save(Commande commande) throws ServiceException;
	Commande findById(Integer Id) throws ServiceException;
	void remove(Commande commande) throws ServiceException;
	List<Commande> findAll() throws ServiceException;

}
