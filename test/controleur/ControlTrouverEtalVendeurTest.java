package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import villagegaulois.*;
import personnages.*;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	void setUp() {
		System.out.println("Initialisation");
		village = new Village("Le village des irréductibles",10,5);
		abraracourcix = new Chef("Abraracourxic",10,village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur);
	}

	@Test
	void testTrouverEtalVendeur() {
		Gaulois bonemine = new Gaulois("Bonemine", 5);
		assertEquals(village.rechercherEtal(bonemine), null);
		//A FINIR
	}

}
