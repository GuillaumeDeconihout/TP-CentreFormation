package fr.treeptik.testservices;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.centreformation.domain.Seminaire;
import fr.treeptik.centreformation.domain.Societe;
import fr.treeptik.centreformation.exceptions.ServiceException;
import fr.treeptik.centreformation.services.SeminaireService;
import fr.treeptik.centreformation.services.SocieteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestQueriesServices {

	
	@Autowired
	private SocieteService societeService;
	
	@Autowired
	private SeminaireService seminaireService;

	@Test
	public void TestFindAllSocieteWithCommande() {
		System.out
				.println("******************  FindAllSocieteWithCommande *****************");
		try {
			List<Societe> societes;
			societes = societeService.findAllWithCommande();
			for (Societe societe : societes) {
				System.out.println("Société :" + societe.getNomSociete());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestFindAllSocieteWithoutCommande() {
		System.out
				.println("******************  FindAllSocieteWithoutCommande *****************");
		try {
			List<Societe> societes;
			societes = societeService.findAllWithoutCommande();
			for (Societe societe : societes) {
				System.out.println("Société :" + societe.getNomSociete());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestFindIncomeBySociete() {
		System.out
				.println("******************  FindIncomeBySociete *****************");
		try {
			List<Object[]> resultList;
			resultList = societeService.findIncomeBySociete();
			for (Object[] objects : resultList) {
				System.out.println("Societe : "+objects[0]+ " - Chiffre d'affaire :"+objects[1]);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestFindMostSuccessfullSeminaire() {
		System.out
				.println("******************  FindMostSuccessfullSeminaire *****************");
		try {
			List<Object[]> seminaires;
			seminaires = seminaireService.findMostSuccessfull();
			for (Object[] objects : seminaires) {
				System.out.println("Seminaire : "+objects[0]+ " - Nombre :"+objects[1]);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestFindSeminaireByCapacity() {
		System.out
				.println("******************  FindSeminaireByCapacity *****************");
		try {
			List<Seminaire> seminaires;
			seminaires = seminaireService.findbyCapacity(50);
			for (Seminaire seminaire : seminaires) {
				System.out.println("Seminaire: "+seminaire.getCodeSeminaire()+" nombre de place :"+seminaire.getNbPlacesSeminaire());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
