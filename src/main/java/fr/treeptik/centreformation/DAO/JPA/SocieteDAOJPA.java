package fr.treeptik.centreformation.DAO.JPA;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.DAO.SocieteDAO;
import fr.treeptik.centreformation.domain.Societe;

@Repository
public class SocieteDAOJPA extends GenericDAOJPA<Societe, Integer> implements SocieteDAO{

	public SocieteDAOJPA() {
		super(Societe.class);
	}
	
	

}
