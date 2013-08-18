package fr.treeptik.centreformation.DAO;

import java.util.List;

import fr.treeptik.centreformation.domain.Societe;
import fr.treeptik.centreformation.exceptions.DAOException;

public interface SocieteDAO extends GenericDAO<Societe, Integer>{

	List<Societe> findAllWithCommande() throws DAOException;
	List<Societe> findAllWithoutCommande() throws DAOException;
	List<Object[]> findIncomeBySociete() throws DAOException;

}
