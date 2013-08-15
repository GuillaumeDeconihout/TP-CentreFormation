package fr.treeptik.centreformation.DAO.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.treeptik.centreformation.DAO.GenericDAO;

public class GenericDAOJPA<T,PK> implements GenericDAO<T, PK> {
	
	@PersistenceContext
	protected EntityManager entitymanager;

	private Class<T> type;
	
	

	public GenericDAOJPA(Class<T> type) {
		this.type = type;
	}

	@Override
	public T save(T entity) {
		entitymanager.persist(entity);
		return entity;
	}

	@Override
	public T findById(PK id) {
		return entitymanager.find(type, id);
	}

	@Override
	public void remove(T entity) {
		entitymanager.remove(entity);		
	}

	@Override
	public List<T> findAll() {
		return entitymanager.createQuery("select o from "+ type.getSimpleName() + " o",type).getResultList();
	}

}
