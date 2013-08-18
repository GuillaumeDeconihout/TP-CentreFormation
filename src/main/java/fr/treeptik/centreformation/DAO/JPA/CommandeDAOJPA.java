package fr.treeptik.centreformation.DAO.JPA;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.DAO.CommandeDAO;
import fr.treeptik.centreformation.domain.Commande;

@Repository
public class CommandeDAOJPA extends GenericDAOJPA<Commande, Integer> implements CommandeDAO{

	public CommandeDAOJPA() {
		super(Commande.class);
	}
	
	

}
