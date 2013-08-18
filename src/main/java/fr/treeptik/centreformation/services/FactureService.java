package fr.treeptik.centreformation.services;

import java.util.List;

import fr.treeptik.centreformation.domain.Facture;
import fr.treeptik.centreformation.exceptions.ServiceException;

public interface FactureService {
	
	Facture save(Facture facture) throws ServiceException;
	Facture findById(Integer Id) throws ServiceException;
	void remove(Facture facture) throws ServiceException;
	List<Facture> findAll() throws ServiceException;

}
