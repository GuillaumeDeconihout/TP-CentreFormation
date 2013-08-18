package fr.treeptik.centreformation.services;

import java.util.List;

import fr.treeptik.centreformation.domain.Session;
import fr.treeptik.centreformation.exceptions.ServiceException;

public interface SessionService {
	
	Session save(Session session) throws ServiceException;
	Session findById(Integer Id) throws ServiceException;
	void remove(Session session) throws ServiceException;
	List<Session> findAll() throws ServiceException;

}
