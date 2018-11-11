import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
/**
 * La classe <code>Grille</code> est utilise pour representer la grille du
 * demineur sur la fenetre.
 * 
 * @version 1.0
 * @author Maxime Menault, Lucas Lefevre
 *
 */
public class Grille extends JComponent {
	/**
	 * Attribut representant le nombre de lignes du demineur.
	 */
	private int lignes;
	/**
	 * Attribut representant le nombre de colonnes du demineur.
	 */
	private int colonnes;
	/**
	 * Attribut contenant le tableau de cases du demineur.
	 */
	private Cases[][] tabCases;
	/**
	 * Image des cases avec 1 mine autour.
	 */
	private Image un;
	/**
	 * Images des cases avec 2 mines autour.
	 */
	private Image deux;
	/**
	 * Images des cases avec 3 mines autour.
	 */
	private Image trois;
	/**
	 * Images des cases avec 4 mines autour.
	 */
	private Image quatre;
	/**
	 * Images des cases avec 5 mines autour.
	 */
	private Image cinq;
	/**
	 * Images des cases avec 6 mines autour.
	 */
	private Image six;
	/**
	 * Images des cases avec 7 mines autour.
	 */
	private Image sept;
	/**
	 * Images des cases avec 8 mines autour.
	 */
	private Image huit;
	/**
	 * Image d'une mine.
	 */
	private Image mine;
	/**
	 * Image de la mine qui a explose.
	 */
	private Image mineExplose;
	/**
	 * Image d'un drapeau.
	 */
	private Image drapeau;
	/**
	 * Image d'un "?".
	 */
	private Image interrogation;
	
	/**
	 * Constructeur utilise pour initialiser les attributs de la grille et charger les images en memoire.
	 * 
	 * @param colonnes le nombre de colonnes du demineur.
	 * @param lignes le nombre de lignes du demineur.
	 * @param tabCases le tableau contenant les cases du demineur.
	 * @param fenetre la fenetre dans laquelle la grille est dessine.
	 */
	public Grille(int colonnes,int lignes, Cases[][] tabCases) {
		super();
		this.lignes = lignes;
		this.colonnes = colonnes;
		this.tabCases = tabCases;
	    this.un = Toolkit.getDefaultToolkit().getImage("images/1.png");
	    this.deux = Toolkit.getDefaultToolkit().getImage("images/2.png");
	    this.trois = Toolkit.getDefaultToolkit().getImage("images/3.png");
	    this.quatre = Toolkit.getDefaultToolkit().getImage("images/4.png");
	    this.cinq = Toolkit.getDefaultToolkit().getImage("images/5.png");
	    this.six = Toolkit.getDefaultToolkit().getImage("images/6.png");
	    this.sept = Toolkit.getDefaultToolkit().getImage("images/7.png");
	    this.huit = Toolkit.getDefaultToolkit().getImage("images/8.png");
	    this.mine = Toolkit.getDefaultToolkit().getImage("images/mine.png");
	    this.mineExplose = Toolkit.getDefaultToolkit().getImage("images/mine_explose.png");
	    this.drapeau = Toolkit.getDefaultToolkit().getImage("images/flag.png");
	    this.interrogation = Toolkit.getDefaultToolkit().getImage("images/point_dinterrogation.png");
	}
	
	/**
	 * Fonction dessinant la grille et affichant les cases deja revele, avec un drapeau, un "?" ou les mines.
	 * 
	 * @param g.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics pinceau = g.create();
		
		if(this.isOpaque()) {
			pinceau.setColor(this.getBackground());
			pinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		int i=0;
		int j=0;
		int tailleCase= 32;
		Image img = null;

		pinceau.setColor(Color.WHITE);
		pinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		pinceau.setColor(Color.LIGHT_GRAY);
		pinceau.fillRect(0, 0, tailleCase*colonnes, tailleCase*lignes);
		pinceau.setColor(Color.BLACK);
		pinceau.drawRect(0, 0, tailleCase*colonnes, tailleCase*lignes);		
		
		for(i=0; i<colonnes; i++) {
			for(j=0; j<lignes; j++) {
				if(tabCases[i][j].estRevele()) {
					if(!(tabCases[i][j].getMine())) {
						pinceau.setColor(Color.WHITE);
						pinceau.fillRect(i*32,j*32, 32,32);
						img = null;
						if(tabCases[i][j].getMineAutour() == 1) {
							img = this.un;							
						}
						if(tabCases[i][j].getMineAutour() == 2) {
							img = this.deux;							
						}
						if(tabCases[i][j].getMineAutour() == 3) {
							img = this.trois;							
						}
						if(tabCases[i][j].getMineAutour() == 4) {
							img = this.quatre;							
						}
						if(tabCases[i][j].getMineAutour() == 5) {
							img = this.cinq;							
						}
						if(tabCases[i][j].getMineAutour() == 6) {
							img = this.six;							
						}
						if(tabCases[i][j].getMineAutour() == 7) {
							img = this.sept;							
						}
						if(tabCases[i][j].getMineAutour() == 8) {
							img = this.huit;							
						}						
						pinceau.drawImage(img,i*32,j*32,this);						
					}
					else {
						for(int k=0; k<colonnes; k++) {
							for(int l=0; l<lignes; l++) {
								if(tabCases[k][l].getMineExplose()) {
									img = this.mineExplose;
									pinceau.setColor(Color.RED);
									pinceau.fillRect(k*32,l*32,32,32);
									pinceau.drawImage(img,k*32,l*32,this);	
								}else {
									if(tabCases[k][l].getMine()) {
										img = this.mine;
										pinceau.drawImage(img,k*32,l*32,this);
									}	
								}
							}
						}
					}
				}
				if(tabCases[i][j].estDrapeau() || tabCases[i][j].estInterrogation()) {
						if(tabCases[i][j].estDrapeau()) {
							img = this.drapeau;
						}else {
							img = this.interrogation;
						}
						pinceau.drawImage(img,i*32,j*32,this);
					}
				}
		}

		pinceau.setColor(Color.BLACK);		
		for(i=0;i<lignes;i++) {
			pinceau.drawLine(0,tailleCase*i,tailleCase*colonnes,tailleCase*i);
		}
		
		for(i=0;i<colonnes;i++) {
			pinceau.drawLine(tailleCase*i,0,tailleCase*i,tailleCase*lignes);
		}
				
		
	}
}
