package fr.treeptik.centreformation.services;

import java.util.List;

import fr.treeptik.centreformation.domain.Societe;
import fr.treeptik.centreformation.exceptions.ServiceException;

public interface SocieteService {
	
	Societe save(Societe societe) throws ServiceException;
	Societe findById(Integer Id) throws ServiceException;
	void remove(Societe societe) throws ServiceException;
	List<Societe> findAll() throws ServiceException;
	List<Societe> findAllWithCommande() throws ServiceException;
	List<Societe> findAllWithoutCommande() throws ServiceException;
	List<Object[]> findIncomeBySociete() throws ServiceException;
}
