package fr.treeptik.centreformation.services.JPA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.centreformation.DAO.FactureDAO;
import fr.treeptik.centreformation.domain.Facture;
import fr.treeptik.centreformation.exceptions.DAOException;
import fr.treeptik.centreformation.exceptions.ServiceException;
import fr.treeptik.centreformation.services.FactureService;

@Service
public class FactureServiceJPA implements FactureService{
	
	@Autowired
	private FactureDAO factureDAO;

	@Override
	@Transactional
	public Facture save(Facture facture) throws ServiceException {
		try {
			facture = factureDAO.save(facture);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return facture;
	}

	@Override
	public Facture findById(Integer Id) throws ServiceException {
		Facture facture = new Facture();
		try {
			facture = factureDAO.findById(Id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return facture;
	}

	@Override
	@Transactional
	public void remove(Facture facture) throws ServiceException {
		try {
			facture =factureDAO.findById(facture.getNumeroFacture());
			factureDAO.remove(facture);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Facture> findAll() throws ServiceException {
		try {
			List<Facture> factures = new ArrayList<>();
			factures = factureDAO.findAll();
			return factures;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}	
	}
}
