package fr.treeptik.centreformation.DAO;

import java.util.List;

import fr.treeptik.centreformation.exceptions.DAOException;

public interface GenericDAO <T,PK>{
	T save(T entity) throws DAOException;
	T findById(PK id) throws DAOException;
	void remove(T entity) throws DAOException;
	List<T> findAll() throws DAOException;
}
