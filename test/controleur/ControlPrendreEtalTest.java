package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.*;
import personnages.*;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;

	@BeforeEach
	void setUp() {
		System.out.println("Initialisation");
		village = new Village("Le village des irréductibles",10,5);
		abraracourcix = new Chef("Abraracourxic",10,village);
		village.setChef(abraracourcix);
		
	}

	@Test
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		//Test avec etals libres
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		
		//Test sans Etals
		Village village2 = new Village("Le village 2",10,0);
		ControlVerifierIdentite controlVerifierIdentite2 = new ControlVerifierIdentite(village2);
		ControlPrendreEtal controlPrendreEtal2 = new ControlPrendreEtal(controlVerifierIdentite2, village2);
		assertFalse(controlPrendreEtal2.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		int numEtal =  village.numEtalVide();
		assertEquals(controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 5), numEtal);
		
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));		
		assertFalse(controlPrendreEtal.verifierIdentite("Existe pas"));
	}

}
