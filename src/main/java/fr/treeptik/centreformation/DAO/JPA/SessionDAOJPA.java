package fr.treeptik.centreformation.DAO.JPA;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.DAO.SessionDAO;
import fr.treeptik.centreformation.domain.Session;

@Repository
public class SessionDAOJPA extends GenericDAOJPA<Session, Integer> implements SessionDAO{

	public SessionDAOJPA() {
		super(Session.class);
	}
	
	

}
