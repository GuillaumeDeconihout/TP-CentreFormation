package fr.treeptik.centreformation.DAO;

import java.util.List;

import fr.treeptik.centreformation.domain.Seminaire;
import fr.treeptik.centreformation.exceptions.DAOException;

public interface SeminaireDAO extends GenericDAO<Seminaire, Integer>{

	List<Object[]> findMostSuccessfull() throws DAOException;

	List<Seminaire> findByCapcacity(Integer placesMin) throws DAOException;

}
