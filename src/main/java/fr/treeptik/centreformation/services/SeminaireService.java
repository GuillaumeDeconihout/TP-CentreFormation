package fr.treeptik.centreformation.services;

import java.util.List;

import fr.treeptik.centreformation.domain.Seminaire;
import fr.treeptik.centreformation.exceptions.ServiceException;

public interface SeminaireService {
	
	Seminaire save(Seminaire seminaire) throws ServiceException;
	Seminaire findById(Integer Id) throws ServiceException;
	void remove(Seminaire seminaire) throws ServiceException;
	List<Seminaire> findAll() throws ServiceException;

}
