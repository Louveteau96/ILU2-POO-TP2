package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.*;

class ControlLibererEtalTest {
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
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testViderEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testLibererEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testIsVendeur() {
		fail("Not yet implemented");
	}

}
