package fr.treeptik.testservices;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.centreformation.domain.Societe;
import fr.treeptik.centreformation.exceptions.ServiceException;
import fr.treeptik.centreformation.services.SocieteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestSaveServices {

	@Autowired
	private SocieteService societeService;


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


}
