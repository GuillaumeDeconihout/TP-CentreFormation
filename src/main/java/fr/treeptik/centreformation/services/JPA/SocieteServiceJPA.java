package fr.treeptik.centreformation.services.JPA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.centreformation.DAO.SocieteDAO;
import fr.treeptik.centreformation.domain.Societe;
import fr.treeptik.centreformation.exceptions.DAOException;
import fr.treeptik.centreformation.exceptions.ServiceException;
import fr.treeptik.centreformation.services.SocieteService;

public class SocieteServiceJPA implements SocieteService{
	
	@Autowired
	private SocieteDAO societeDAO;

	@Override
	@Transactional
	public Societe save(Societe societe) throws ServiceException {
		try {
			societe = societeDAO.save(societe);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return societe;
	}

	@Override
	public Societe findById(Integer Id) throws ServiceException {
		Societe societe = new Societe();
		try {
			societe = societeDAO.findById(Id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return societe;
	}

	@Override
	@Transactional
	public void remove(Societe societe) throws ServiceException {
		try {
			societe =societeDAO.findById(societe.getCodeSociete());
			societeDAO.remove(societe);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Societe> findAll() throws ServiceException {
		try {
			List<Societe> societees = new ArrayList<>();
			societees = societeDAO.findAll();
			return societees;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}	
	}
}