package Projet;

import java.util.Scanner;
public class Voiture extends Objet {
	boolean vide ;   // si vide=true la voiture est vide 
	Homme contenu;  // si la voiture n'est pas vide le chauffeur sera ajout� 
	public Voiture(boolean v,int x,int y){
		super(x,y);
		type="voiture";
		if(v==true) {
			System.out.println("Une voiture vide a �t� ajout�e avec succ�s ");
		}
		else{
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez saisir 'oui' si le chauffeur a une attestation de d�placement et 'non' sinon ");
			String motif = sc.nextLine();
			if (motif=="oui") {
				contenu = new Homme(x,y,true);
				System.out.println("Une voiture contenant un chauffeur ayant une attestation de d�placement a �t� ajout�e avec succ�s ");
			}
			else {
				contenu = new Homme(x,y,false);
				System.out.println("Une voiture contenant un chauffeur n'ayant pas une attestation de d�placement a �t� ajout�e avec succ�s ");
			}
			sc.close();
		}
	}
	public void setcontenu(Homme h)
	{
		contenu=h;
	}
	public Homme getContenu() {
		return contenu;
	}

}