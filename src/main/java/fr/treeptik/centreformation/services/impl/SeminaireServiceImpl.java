package fr.treeptik.centreformation.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.centreformation.DAO.SeminaireDAO;
import fr.treeptik.centreformation.domain.Seminaire;
import fr.treeptik.centreformation.exceptions.DAOException;
import fr.treeptik.centreformation.exceptions.ServiceException;
import fr.treeptik.centreformation.services.SeminaireService;

@Service
public class SeminaireServiceImpl implements SeminaireService{
	
	@Autowired
	private SeminaireDAO seminaireDAO;

	@Override
	@Transactional
	public Seminaire save(Seminaire seminaire) throws ServiceException {
		try {
			seminaire = seminaireDAO.save(seminaire);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return seminaire;
	}

	@Override
	public Seminaire findById(Integer Id) throws ServiceException {
		Seminaire seminaire = new Seminaire();
		try {
			seminaire = seminaireDAO.findById(Id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return seminaire;
	}

	@Override
	@Transactional
	public void remove(Seminaire seminaire) throws ServiceException {
		try {
			seminaire =seminaireDAO.findById(seminaire.getCodeSeminaire());
			seminaireDAO.remove(seminaire);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Seminaire> findAll() throws ServiceException {
		try {
			List<Seminaire> seminaires = new ArrayList<>();
			seminaires = seminaireDAO.findAll();
			return seminaires;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}	
	}

	@Override
	public List<Object[]> findMostSuccessfull() throws ServiceException {
		try {
			List<Object[]> seminaires = new ArrayList<>(5);
			seminaires = seminaireDAO.findMostSuccessfull();
			return seminaires;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Seminaire> findbyCapacity(Integer placesMin) throws ServiceException {
		try {
			List<Seminaire> seminaires = new ArrayList<>(5);
			seminaires = seminaireDAO.findByCapcacity(placesMin);
			return seminaires;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
}
