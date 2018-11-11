/**
 * La classe <code>Clics</code> est utilise pour afficher les cases lorsque l'on
 * clique dessus.
 * 
 * @version 1.0
 * @author Lucas Lefevre, Maxime Menault
 *
 */
public class Clics {

	/**
	 * Attribut contenant le tableau de cases du demineur.
	 */
	private Cases[][] tabCases;
	/**
	 * Attribut representant le nombre de colonnes du demineur.
	 */
	private int colonnes;
	/**
	 * Attribut representant le nombre de lignes du demineur.
	 */
	private int lignes;
	/**
	 * Attribut contenant la grille du demineur.
	 */
	private Grille grille;
	/**
	 * Attribut contenant la fenetre dans laquelle il y a la grille.
	 */
	private Fenetre fenetre;
	/**
	 * Attribut contenant le nombre de mines du demineur.
	 */
	private int nombreMines;

	/**
	 * Constructeur initialisant les attributs de la classe.
	 * 
	 * @param tabCases le tableau de cases du demineur.
	 * @param colonnes le nombre de colonnes du demineur.
	 * @param lignes le nombre de lignes du demineur.
	 * @param nombreMines le nombre de mines du demineur.
	 * @param grille la grille du demineur.
	 * @param fenetre la fenetre dans laquelle il y a la grille.
	 */
	public Clics(Cases[][] tabCases,int colonnes, int lignes,int nombreMines,Grille grille,Fenetre fenetre) {
		this.tabCases = tabCases;
		this.colonnes = colonnes;
		this.lignes = lignes;
		this.nombreMines = nombreMines;
		this.grille = grille;
		this.fenetre = fenetre;
	}
	
	/**
	 * Fonction utilise lorsque l'on effectue un clic droit dans la grille.
	 * 
	 * @param x l'abscisse de la case dans laquelle on a cliquee.
	 * @param y l'ordonnee de la case dans laquelle on a cliquee.s
	 */
	public void clicDroit(int x, int y) {
		if((x<this.colonnes) && (y<this.lignes)&&(!(tabCases[x][y].estRevele()))) {
			if(tabCases[x][y].estDrapeau()) {
				tabCases[x][y].interrogation();
				this.fenetre.affichageMines(false);
			}else {
				if(tabCases[x][y].estInterrogation()) {
					tabCases[x][y].enleverInterrogation();
				}else {
					tabCases[x][y].drapeau();
					this.fenetre.affichageMines(true);
				}
			}
		}
		this.grille.repaint();
	}

	/**
	 * Fonction utilise lorsque l'on effectue un clic gauche dans la grille.
	 * 
	 * @param x l'abscisse de la case dans laquelle on a cliquee.
	 * @param y l'ordonnee de la case dans laquelle on a cliquee.
	 */
	public void clicGauche(int x, int y) {
		if((x<this.colonnes)&&(y<this.lignes)&&(!tabCases[x][y].estDrapeau())&&(!tabCases[x][y].estInterrogation())) {
			tabCases[x][y].Revele();
			grille.repaint();
			if(tabCases[x][y].getMine()) {
				tabCases[x][y].mineExplose();
				fenetre.FinDePartie("PERDU");
			}
			this.cascade(x,y);
			int i,j,k=0;
			for(i=0;i<this.colonnes;i++) {
				for(j=0;j<lignes;j++) {
					if(this.tabCases[i][j].estRevele()) {
						k++;
					}
				}
			}
			if(k==((this.lignes*this.colonnes)-nombreMines)) {
				this.fenetre.FinDePartie("GAGNE");
			}
		}
	}
	
	/**
	 * Fonction permettant l'affichage en cascade des cases du tableau lorsque l'on clique gauche sur 
	 * une case "blanches" (sans mines autour).
	 * 
	 * @param x l'abscisse de la case dans laquelle on a cliquee.
	 * @param y l'ordonnee de la case dans laquelle on a cliquee.
	 */
	public void cascade(int x, int y) {
		if(tabCases[x][y].getMineAutour() == 0) {
			if((x>0)&&(y>0)) {
				tabCases[x-1][y-1].trueCascade();
			}
			if(y>0) {
				tabCases[x][y-1].trueCascade();
			}
			if((x<(this.colonnes-1))&&(y>0)) {
				tabCases[x+1][y-1].trueCascade();
			}
			if(x>0) {
				tabCases[x-1][y].trueCascade();
			}
			if(x<(this.colonnes-1)) {
				tabCases[x+1][y].trueCascade();
			}
			if((x>0)&&(y<(this.lignes-1))) {
				tabCases[x-1][y+1].trueCascade();
			}
			if(y<(this.lignes-1)) {
				tabCases[x][y+1].trueCascade();
			}
			if((x<(this.colonnes-1))&&(y<(this.lignes-1))) {
				tabCases[x+1][y+1].trueCascade();
			}
		}
		for(int i=0; i<this.colonnes; i++) {
			for(int j=0; j<this.lignes; j++) {
				if((tabCases[i][j].getCascade())&&(tabCases[i][j].getDejaCascade())) {
					tabCases[i][j].dejaCascade();
					tabCases[i][j].Revele();
					this.cascade(i, j);
				}
			}
		}
	}
}
