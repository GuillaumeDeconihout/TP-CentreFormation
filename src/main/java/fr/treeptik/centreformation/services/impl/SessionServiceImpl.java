package fr.treeptik.centreformation.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.centreformation.DAO.SessionDAO;
import fr.treeptik.centreformation.domain.Session;
import fr.treeptik.centreformation.exceptions.DAOException;
import fr.treeptik.centreformation.exceptions.ServiceException;
import fr.treeptik.centreformation.services.SessionService;

@Service
public class SessionServiceImpl implements SessionService{
	
	@Autowired
	private SessionDAO sessionDAO;

	@Override
	@Transactional
	public Session save(Session session) throws ServiceException {
		try {
			session = sessionDAO.save(session);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return session;
	}

	@Override
	public Session findById(Integer Id) throws ServiceException {
		Session session = new Session();
		try {
			session = sessionDAO.findById(Id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return session;
	}

	@Override
	@Transactional
	public void remove(Session session) throws ServiceException {
		try {
			session =sessionDAO.findById(session.getNumeroSession());
			sessionDAO.remove(session);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Session> findAll() throws ServiceException {
		try {
			List<Session> sessions = new ArrayList<>();
			sessions = sessionDAO.findAll();
			return sessions;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}	
	}
}
