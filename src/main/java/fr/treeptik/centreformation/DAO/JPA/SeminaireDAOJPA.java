package fr.treeptik.centreformation.DAO.JPA;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.DAO.SeminaireDAO;
import fr.treeptik.centreformation.domain.Seminaire;

@Repository
public class SeminaireDAOJPA extends GenericDAOJPA<Seminaire, Integer> implements SeminaireDAO{

	public SeminaireDAOJPA() {
		super(Seminaire.class);
	}
	
	

}
