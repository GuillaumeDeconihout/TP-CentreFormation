package fr.treeptik.centreformation.DAO.JPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.DAO.SocieteDAO;
import fr.treeptik.centreformation.domain.Societe;
import fr.treeptik.centreformation.exceptions.DAOException;

@Repository
public class SocieteDAOJPA extends GenericDAOJPA<Societe, Integer> implements
		SocieteDAO {

	public SocieteDAOJPA() {
		super(Societe.class);
	}

	@Override
	public List<Societe> findAllWithCommande() {
		List<Societe> societes = new ArrayList<>(5);
		TypedQuery<Societe> typedQuery = entitymanager.createQuery(
				"select distinct soc from Commande com join com.societe soc",
				Societe.class);
		societes = typedQuery.getResultList();
		return societes;

	}

	@Override
	public List<Societe> findAllWithoutCommande() throws DAOException {
		List<Societe> societes = new ArrayList<>(5);
		TypedQuery<Societe> typedQuery = entitymanager
				.createQuery(
						"select distinct soc from Commande com right join com.societe soc where com is null",
						Societe.class);
		societes = typedQuery.getResultList();
		return societes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findIncomeBySociete() throws DAOException {
		List<Object[]> resultList = new ArrayList<>(5);
		Query query = entitymanager
				.createQuery("select soc.nomSociete,sum(fac.montantFacture) as total from Commande com right join com.societe soc left join com.facture fac group by soc.nomSociete order by total desc");
		resultList = query.getResultList();
		return resultList;
	}

}
