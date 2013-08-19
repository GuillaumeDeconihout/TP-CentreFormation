package fr.treeptik.centreformation.DAO.JPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.centreformation.DAO.SeminaireDAO;
import fr.treeptik.centreformation.domain.Seminaire;
import fr.treeptik.centreformation.exceptions.DAOException;

@Repository
public class SeminaireDAOJPA extends GenericDAOJPA<Seminaire, Integer>
		implements SeminaireDAO {

	public SeminaireDAOJPA() {
		super(Seminaire.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findMostSuccessfull() throws DAOException {
		Query query = entitymanager
				.createQuery("select ses.seminaire.codeSeminaire,count(ses) as nombre from Commande com join com.session ses group by ses.seminaire order by nombre desc");
		List<Object[]> result = query.getResultList();
		return result;
	}

	@Override
	public List<Seminaire> findByCapcacity(Integer placesMin)
			throws DAOException {
		List<Seminaire> seminaires = new ArrayList<>(5);
		TypedQuery<Seminaire> typedQuery = entitymanager.createQuery("select sem from Seminaire sem where sem.nbPlacesSeminaire >= :placesMin order by sem.nbPlacesSeminaire desc",Seminaire.class);
		typedQuery.setParameter("placesMin", placesMin);
		seminaires = typedQuery.getResultList();
		return seminaires;
	}

}
