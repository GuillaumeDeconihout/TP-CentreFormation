package fr.treeptik.centreformation.DAO.JPA;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.DAO.FactureDAO;
import fr.treeptik.centreformation.domain.Facture;

@Repository
public class FactureDAOJPA extends GenericDAOJPA<Facture, Integer> implements FactureDAO{

	public FactureDAOJPA() {
		super(Facture.class);
	}
	
	

}
