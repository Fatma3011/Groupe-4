package Projet;

import java.util.Scanner;
public class ZoneGeo {
	int nL;     // nombre des lignes de la grille
	int nC;     // nombre des colonnes de la grille
	int xdp;    // l'abscisse du point de d�part
	int ydp;    // l'ordonn�e du point de d�part 
	int xar;    // l'abscisse du point d'arriv�e
	int yar;    // l'ordonn�e du point de d�part 
	Objet [][] grille;  // une matrice qui repr�sente la zone g�ographique 
	ZoneGeo(int nL,int nC, int xdp,int ydp,int xar,int yar) throws ErrDimensions,ErrCoord,ErrEgaux{
		if (nL<0 || nC<0 ) throw new ErrDimensions("le nombre des lignes et le nombre des colnnes doivent �tre positifs !!");
		else if (xdp>=nC || ydp >=nL || xar>=nC || yar>=nL) throw new ErrCoord("les coordonn�es des points de d�part et d'arriv�e doivent respecter les dimensions de la grille !!");
		else if (xdp==xar && ydp==yar) throw new ErrEgaux("le point de d�part et le point d'arriv�e doivent �tre diff�rents !! ");
		else {
			this.nL=nL;
			this.nC=nC;
			this.xdp=xdp;
			this.ydp=ydp;
			this.xar=xar;
			this.yar=yar;
			grille = new Objet[nL][nC];
			
			
		}
	}
	void ajouter(Objet o)   //m�thode pour ajouter un objet � la grille 
	{
		grille[o.x][o.y]=o;
		System.out.println("l'objet a �t� ajout� avec succ�s");
	}
	void supprimer(Objet o)   //m�thode pour supprimer un objet de la grille
	{
		grille[o.x][o.y]=o;
		System.out.println("l'objet a �t� supprim� avec succ�s");
		
	}
	boolean EstVide(int x,int y)  // m�thode qui retourne "true" si une case donn�e de la grille est vide et "false" sinon  
	{
		if (grille[x][y]==null) {
			System.out.println("cette case est vide ");
			return true;
		}
		else {
			System.out.println("cette case n'est pas vide");
			return false;
		}
	}
	public static void main (String[] args) throws ErrDimensions,ErrCoord,ErrEgaux 
	{
		
		  Scanner sc = new Scanner(System.in);
		
	       System.out.println("saisir le nombre de ligne ");
		     int nL = sc.nextInt();

		
		    System.out.println("saisir le nombre de colonnes ");
		    int nC = sc.nextInt();
		   	ZoneGeo z=new ZoneGeo(nL,nC,0,0,nL-1,nC-1);
			
		   	Robot r = new Robot (0,0);
			if (nL % 2 == 0) {
				int k=0;
				while (k<nL) {
					int i;
					for ( i=0; i<nC;i++) {
						 r.avancer(); 
						 if (i==nC-1) {r.SetDirection(DIRECTION.Sud);
							r.avancer();
							r.SetDirection(DIRECTION.Ouest);
							for (int j=0;j<nC;j++) {
								r.avancer();
								if (j==nC-1)
								{
									r.SetDirection(DIRECTION.Sud);
									r.avancer();
									
								}}
							 }
						 }
					
					
					
				
				
				
				
						 r.SetDirection(DIRECTION.Est);	k+=2;}
				if (k==nL) { for (int h=0;h<nC;h++) r.avancer();}
			                  }
			
			
			
			else  {
			
			
				int k=0;
				while (k<nL-2) {
					int i;
					for ( i=0; i<nC;i++) {
						 r.avancer(); 
						 if (i==nC-1) {r.SetDirection(DIRECTION.Sud);
							r.avancer();
							r.SetDirection(DIRECTION.Ouest);
							for (int j=0;j<nC;j++) {
								r.avancer();
								if (j==nC-1)
								{
									r.SetDirection(DIRECTION.Sud);
									r.avancer();
								
									
								}}
							 }
						 }
					
					
					
				
				
				
				
						 r.SetDirection(DIRECTION.Est);	k+=2;}r.SetDirection (DIRECTION.Sud);r.avancer();
						 for (int i=0; i<nC;i++) {
						 r.diag();
						 r.avancer();}}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
		
		
		
	}
	
}

class ErrDimensions extends Exception
{  ErrDimensions(String s){super(s);}}
class ErrCoord extends Exception
{  ErrCoord(String s){super(s);}}
class ErrEgaux extends Exception
{ErrEgaux(String s){super(s);}}