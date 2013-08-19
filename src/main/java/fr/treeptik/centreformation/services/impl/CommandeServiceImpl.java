package fr.treeptik.centreformation.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.centreformation.DAO.CommandeDAO;
import fr.treeptik.centreformation.domain.Commande;
import fr.treeptik.centreformation.exceptions.DAOException;
import fr.treeptik.centreformation.exceptions.ServiceException;
import fr.treeptik.centreformation.services.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService{
	
	@Autowired
	private CommandeDAO commandeDAO;

	@Override
	@Transactional
	public Commande save(Commande commande) throws ServiceException {
		try {
			commande = commandeDAO.save(commande);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return commande;
	}

	@Override
	public Commande findById(Integer Id) throws ServiceException {
		Commande commande = new Commande();
		try {
			commande = commandeDAO.findById(Id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return commande;
	}

	@Override
	@Transactional
	public void remove(Commande commande) throws ServiceException {
		try {
			commande =commandeDAO.findById(commande.getNumeroCommande());
			commandeDAO.remove(commande);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Commande> findAll() throws ServiceException {
		try {
			List<Commande> commandes = new ArrayList<>();
			commandes = commandeDAO.findAll();
			return commandes;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}	
	}
}
