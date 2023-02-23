package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;
import controleur.ControlVerifierIdentite;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			StringBuilder pasVillageois = new StringBuilder();
			pasVillageois.append("Je suis désolé " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.\n");
			System.out.println(pasVillageois);
		}
		else {
			StringBuilder bonjour = new StringBuilder();
			bonjour.append("Bonjour " + nomVendeur + ", Je vais regarder si je peux vous trouver un étal.");
			System.out.println(bonjour);
			StringBuilder resteEtal = new StringBuilder();
			if(!controlPrendreEtal.resteEtals()) {
				resteEtal.append("Désolé " + nomVendeur + ". Je n'ai plus d'étals qui ne soit déjà occupé.");
				System.out.println(resteEtal);
			}
			else {
				resteEtal.append("C'est parfait, il me reste un étal pour vous!\n");
				resteEtal.append("Il me faudrait quelques renseignements :\n");
				resteEtal.append("Quel produit souhaitez-vous vendre ?\n");
				System.out.println(resteEtal);
				String produitVendu = scan.nextLine();
				StringBuilder combien = new StringBuilder();
				combien.append("Combien souhaitez-vous en vendre ?\n");
				int qtyProduit = Clavier.entrerEntier(combien.toString());
				int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produitVendu, qtyProduit);
				if (numEtal != -1) {
					StringBuilder numeroEtal = new StringBuilder();
					numeroEtal.append("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal+1 + ".\n");
					System.out.println(numeroEtal);
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
