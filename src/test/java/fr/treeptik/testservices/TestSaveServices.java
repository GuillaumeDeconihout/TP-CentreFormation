package fr.treeptik.testservices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.centreformation.domain.Commande;
import fr.treeptik.centreformation.domain.Facture;
import fr.treeptik.centreformation.domain.Seminaire;
import fr.treeptik.centreformation.domain.Session;
import fr.treeptik.centreformation.domain.Societe;
import fr.treeptik.centreformation.exceptions.ServiceException;
import fr.treeptik.centreformation.services.CommandeService;
import fr.treeptik.centreformation.services.FactureService;
import fr.treeptik.centreformation.services.SeminaireService;
import fr.treeptik.centreformation.services.SessionService;
import fr.treeptik.centreformation.services.SocieteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Ignore
public class TestSaveServices {

	@Autowired
	private SocieteService societeService;
	@Autowired
	private FactureService factureService;
	@Autowired
	private SeminaireService seminaireService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private CommandeService commandeService;


	@Test
	public void TestSaveSociete() {
		try {
			Societe societe = new Societe(null,"BNP PARIBAS");
			societe = societeService.save(societe);
			Assert.assertNotNull(societe.getCodeSociete());
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TestSaveFacture() {
		try {
			Facture facture = new Facture(null,new Date(),new Double(12000),new Integer(10));
			facture = factureService.save(facture);
			Assert.assertNotNull(facture.getNumeroFacture());
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TestSaveSeminaire() {
		try {
			Seminaire seminaire = new Seminaire(null,new Double(2300),3,"Debutant",64);
			seminaire = seminaireService.save(seminaire);
			Assert.assertNotNull(seminaire.getCodeSeminaire());
		} catch (ServiceException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TestSaveSession() {
		try {
			Seminaire seminaire = new Seminaire(null,new Double(3400),3,"Confirme",35);
			seminaire = seminaireService.save(seminaire);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			Date heureDebut = dateFormat.parse("10:00");
			Date heureFin = dateFormat.parse("18:00");
			
			Session session = new Session(null, new Date(),heureDebut, heureFin,seminaire);
			session = sessionService.save(session);
			Assert.assertNotNull(session.getNumeroSession());
			
		} catch (ServiceException | ParseException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TestSaveCommande() {
		try {
			// Creation Societe
			Societe societe = new Societe(null,"SAP");
			societe = societeService.save(societe);
			
			// Creation Seminaire
			Seminaire seminaire = new Seminaire(null,new Double(2800),3,"Expert",42);
			seminaire = seminaireService.save(seminaire);
			
			//Creation Session
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			Date heureDebut = dateFormat.parse("09:00");
			Date heureFin = dateFormat.parse("17:00");
			Session session = new Session(null, new Date(),heureDebut, heureFin,seminaire);
			session = sessionService.save(session);
			
			// Creation facture
			Facture facture = new Facture(null,new Date(),new Double(25000),new Integer(6));
			facture = factureService.save(facture);
			
			// Creation commande
			Commande commande = new Commande(null,new Date(),50,societe,session,facture);
			commande = commandeService.save(commande);
			Assert.assertNotNull(commande.getNumeroCommande());
			
		} catch (ServiceException | ParseException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
