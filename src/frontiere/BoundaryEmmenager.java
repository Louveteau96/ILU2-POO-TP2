package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerVillageois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//Presentation
		StringBuilder bonjour = new StringBuilder();
		bonjour.append("Bienvenu Druide " + nomVisiteur + "\n");
		bonjour.append("Quelle est votre force ?\n");
		int forceUtilisateur = -1;
		forceUtilisateur = Clavier.entrerEntier(bonjour.toString());
		
		int potionMin=-1;
		int potionMax=-2;
		while (potionMax<potionMin) {
			
			//Potion Min
			StringBuilder forcePotionMin = new StringBuilder();
			forcePotionMin.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
			potionMin = Clavier.entrerEntier(forcePotionMin.toString());
			
			//Potion Max
			StringBuilder forcePotionMax = new StringBuilder();
			forcePotionMax.append("Quelle est la force de potion la plus forte que vous produisez ?\n");
			potionMax = Clavier.entrerEntier(forcePotionMax.toString());
			
			if (potionMax<potionMin) {
				StringBuilder erreurePotion = new StringBuilder();
				erreurePotion.append("Attention Druide, vous vous êtes trompé entre le minimum et le maximum\n");
				System.out.println(erreurePotion);
			}
		}
		controlEmmenager.ajouterDuide(nomVisiteur, forceUtilisateur, potionMin, potionMax);
	}
	
	
	private void emmenagerVillageois(String nomVisiteur) {
		//
		StringBuilder bonjour = new StringBuilder();
		bonjour.append("Bienvenu Villageois " + nomVisiteur + "\n");
		bonjour.append("Quelle est votre force ?\n");
		int forceUtilisateur = -1;
		forceUtilisateur = Clavier.entrerEntier(bonjour.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur, forceUtilisateur);
	}
}
