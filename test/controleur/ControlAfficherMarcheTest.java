package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.*;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	void setUp(){
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche afficherMarche = new ControlAfficherMarche(village);
		assertNotNull(afficherMarche,"Contructeur n'est pas null");
	}

	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 3);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlChercherEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlChercherEtal.prendreEtal("Bonemine", "fleurs", 10);
		assertEquals(controlAfficherMarche.donnerInfosMarche()[1],village.donnerEtatMarche()[1]);
		Village village2 = new Village("le village des irréductibles", 10, 5);
		assertNotEquals(controlAfficherMarche.donnerInfosMarche(),village2.donnerEtatMarche());
	}

}
