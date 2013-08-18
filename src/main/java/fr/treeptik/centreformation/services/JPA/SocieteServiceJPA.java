package fr.treeptik.centreformation.services.JPA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.centreformation.DAO.SocieteDAO;
import fr.treeptik.centreformation.domain.Societe;
import fr.treeptik.centreformation.exceptions.DAOException;
import fr.treeptik.centreformation.exceptions.ServiceException;
import fr.treeptik.centreformation.services.SocieteService;

@Service
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
			List<Societe> societes = new ArrayList<>();
			societes = societeDAO.findAll();
			return societes;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}	
	}

	@Override
	public List<Societe> findAllWithCommande() throws ServiceException {
		try {
			List<Societe> societes = new ArrayList<>();
			societes = societeDAO.findAllWithCommande();
			return societes;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}	
	}

	@Override
	public List<Societe> findAllWithoutCommande() throws ServiceException {
		try {
			List<Societe> societes = new ArrayList<>();
			societes = societeDAO.findAllWithoutCommande();
			return societes;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Object[]> findIncomeBySociete() throws ServiceException {
		try {
			List<Object[]> societes = new ArrayList<>();
			societes = societeDAO.findIncomeBySociete();
			return societes;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
}
