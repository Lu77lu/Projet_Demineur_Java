import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * La classe <code>Fenetre</code> est utilise pour afficher les
 * differents menus du demineur puis le jeu en lui meme.
 * 
 * @version 1.0
 * @author Maxime Menault, Lucas Lefevre
 *
 */
public class Fenetre extends JFrame {
	/**
	 * Attribut contenant le gestionnaire utilise dans le menu principal.
	 */
	private FlowLayout gestionnaire;
	/**
	 * Attribut contenant le JPanel situe au centre de la fenetre dans le menu principal et 
	 * dans le menu de parametres.
	 */
	private JPanel panneauCenter;
	/**
	 * Attribut contenant le JPanel situe a droite de la fenetre lorsque le jeu est en cours.
	 */
	private JPanel panneauEast;
	/**
	 * Attribut contenant la grille du demineur.
	 */
	private Grille grille;
	/**
	 * Attribut contenant le bouton utilise pour commencer la partie. 
	 */
	private JButton bouton_commencer;
	/**
	 * Attribut contenant le bouton utilise pour reprendre une partie en cours.
	 */
	private JButton bouton_reprendre;
	/**
	 * Attribut contenant le bouton utilise pour quitter le programme.
	 */
	private JButton bouton_quitter;
	/**
	 * Attribut contenant le bouton utilise pour lancer le jeu dans le menu de parametres.
	 */
	private JButton bouton_jeu;
	/**
	 * Attribut contenant la zone de texte dans laquelle on entre le nombre de lignes souhaitees.
	 */
	private JTextField lignes;
	/**
	 * Attribut contenant la zone de texte dans laquelle on entre le nombre de colonnes souhaitees.
	 */
	private JTextField colonnes;
	/**
	 * Attribut contenant la zone de texte dans laquelle on entre le nombre de mines souhaitees.
	 */
	private JTextField mines;
	/**
	 * Attribut contenant le tableau de cases du demineur.
	 */
	private Cases[][] tabCases = null;
	/**
	 * Attribut contenant l'observateur de la souris.
	 */
	private ControleurSouris souris;
	/**
	 * Attribut contenant le nombre de colonnes du demineur.
	 */
	private int nombreColonnes;
	/**
	 * Attribut contenant le nombre de lignes du demineur.
	 */
	private int nombreLignes;
	/**
	 * Attribut contenant le nombre de mines du demineur.
	 */
	private int nombreMines;
	/**
	 * Attribut contenant l'observateur de la fenetre.
	 */
	private ControleurFenetre observateurFenetre;
	/**
	 * Attribut contenant l'affichage du nombre de mines restantes
	 */
	private JLabel minesRestantes;
	/**
	 * Attibut contenant le nombre de drapeau place.
	 */
	private int nombreDrapeau = 0;
	
	/**
	 * Constructeur de la fenetre utilise pour creer la fenetre et affchezr le menu principal.
	 */
	public Fenetre(){
		super("DEMINEUR");
		this.setLocation(0,0);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panneauCenter = new JPanel();
		this.panneauCenter.setBackground(Color.WHITE);
		this.gestionnaire = new FlowLayout(FlowLayout.CENTER);
		this.gestionnaire.setHgap(50);
		this.gestionnaire.setVgap(25);
		this.panneauCenter.setLayout(gestionnaire);		
		
		Dimension dim = new Dimension(200,100);
		this.bouton_commencer = new JButton("Commencer Partie");
		this.bouton_commencer.setMaximumSize(dim);
		this.bouton_commencer.setPreferredSize(dim);
		this.bouton_reprendre = new JButton("Reprendre Partie");
		this.bouton_reprendre.setMaximumSize(dim);
		this.bouton_reprendre.setPreferredSize(dim);		
		this.bouton_quitter = new JButton("Quitter DEMINEUR");		
		this.bouton_quitter.setMaximumSize(dim);
		this.bouton_quitter.setPreferredSize(dim);
		
		this.bouton_commencer.addActionListener(new ControleurBoutonMenu(this));
		this.bouton_quitter.addActionListener(new ControleurBoutonMenu(this));
		this.bouton_reprendre.addActionListener(new ControleurBoutonMenu(this));
	
		this.panneauCenter.add(this.bouton_commencer);
		this.panneauCenter.add(this.bouton_reprendre);
		this.panneauCenter.add(this.bouton_quitter);
		this.add(panneauCenter,BorderLayout.CENTER);

		this.setVisible(true);
	}
	
	/**
	 * Fonction permettant d'afficher le menu de parametres.
	 */
	public void parametres() {
		this.panneauCenter.remove(this.bouton_commencer);
		this.panneauCenter.remove(this.bouton_reprendre);
		this.panneauCenter.remove(this.bouton_quitter);		
		this.panneauCenter.setLayout(new GridLayout(4,1));
		
		this.lignes = new JTextField("Entrez le nombre de lignes (entre 4 et 30)",1);
		lignes.setSize(new Dimension(180,30));
		lignes.setMinimumSize(new Dimension(180,30));		
		lignes.setPreferredSize(new Dimension(180,30));
		lignes.setHorizontalAlignment(JTextField.CENTER);
		lignes.addFocusListener(new ControleurTextField(this.lignes));
		
		this.colonnes = new JTextField("Entrez le nombre de colonnes (entre 4 et 30)",1);
		colonnes.setSize(new Dimension(180,30));
		colonnes.setMinimumSize(new Dimension(180,30));		
		colonnes.setPreferredSize(new Dimension(180,30));
		colonnes.setHorizontalAlignment(JTextField.CENTER);
		colonnes.addFocusListener(new ControleurTextField(this.colonnes));

		this.mines = new JTextField("Entrez le nombre de mines (entre 1 et lignes * colonnes)",1);
		mines.setSize(new Dimension(180,30));
		mines.setMinimumSize(new Dimension(180,30));		
		mines.setPreferredSize(new Dimension(180,30));
		mines.setHorizontalAlignment(JTextField.CENTER);		
		mines.addFocusListener(new ControleurTextField(this.mines));
		
		this.bouton_jeu = new JButton("JOUER");
		this.bouton_jeu.addActionListener(new ControleurBoutonMenu(this));
		this.panneauCenter.add(lignes);
		this.panneauCenter.add(colonnes);
		this.panneauCenter.add(mines);		
		this.panneauCenter.add(bouton_jeu);
		this.setSize(800, 600);
	}
	
	/**
	 * Fonction recuperant les parametres entrees dans le menu de parametres.
	 * 
	 * @param s le nom de la zone de texte dont on veut recuperer le texte.
	 * @return Le texte ecrit dans une zone de texte du menu de parametres.
	 */
	public String recupererParametres(String s) {
		String nombre = null;
		if(s == "lignes") {
			nombre = lignes.getText();
		}else {
			if(s == "colonnes") {
				nombre = colonnes.getText();
			}else {
				nombre = mines.getText();
			}
		}	
		return nombre;
	}
	
	/**
	 * Lance le jeu et affiche la grille du demineur.
	 * 
	 * @param nombreColonnes le nombre de colonnes du demineur.
	 * @param nombreLignes le nombre de lignes du demineur.
	 * @param nombreMines le nombre de mines du demineur.
	 * @param save booleen indiquant si l'on reprend une sauvegarde ou non.
	 */
	public void jouer(int nombreColonnes, int nombreLignes, int nombreMines,boolean save) {
		this.remove(panneauCenter);
		this.nombreColonnes = nombreColonnes;
		this.nombreLignes = nombreLignes;
		this.nombreMines = nombreMines;
		
		if(!save) {
			tabCases = new Cases[nombreColonnes][nombreLignes];
			Generateur.PasMines(nombreColonnes,nombreLignes, tabCases);
			Generateur.Mines(nombreColonnes,nombreLignes,nombreMines, tabCases);
			Autour.DetecteMines(nombreColonnes,nombreLignes, tabCases);		
		}
		
		this.observateurFenetre = new ControleurFenetre(this);
		this.addWindowListener(observateurFenetre);
		
		this.panneauEast = new JPanel();
		this.panneauEast.setLayout(new GridLayout(3,1));
		this.panneauEast.setBackground(Color.WHITE);
		this.panneauEast.setSize(64, this.getHeight());
		
		JLabel AfficheurMines = new JLabel("Nombre de mines restantes :");
		this.panneauEast.add(AfficheurMines);
		this.minesRestantes = new JLabel(Integer.toString(nombreMines));
		this.panneauEast.add(minesRestantes);
		JButton boutonQuitter = new JButton("Sauvegarder et quitter");
		boutonQuitter.addActionListener(new ControleurBoutonMenu(this));
		this.panneauEast.add(boutonQuitter);
		this.add(panneauEast, BorderLayout.EAST);
		
		this.setSize(32*nombreColonnes+210,32*(nombreLignes+2));
		this.grille = new Grille(nombreColonnes,nombreLignes,tabCases);
		Clics clics = new Clics(this.tabCases,nombreColonnes,nombreLignes,nombreMines,this.grille,this);
		this.add(grille,BorderLayout.CENTER);
		souris = new ControleurSouris(clics);
		this.addMouseListener(souris);
	}
	
	/**
	 * Affiche le menu de fin de partie.
	 * @param s la chaine de caracteres representant la victoire ou la defaite.
	 */
	public void FinDePartie(String s) {
		this.removeMouseListener(souris);
		this.removeWindowListener(observateurFenetre);
		this.remove(panneauEast);
		if(s == "GAGNE") {
			s = "Vous avez gagne !";
		}else {
			s = "Quitter le jeu";
		}
		
		JPanel panneauFin = new JPanel();
		panneauFin.setLayout(new GridLayout(2,1));
		JButton boutonFin = new JButton(s);
		boutonFin.addActionListener(new ControleurBoutonMenu(this));
		JButton boutonRecommencer = new JButton("Retour menu");
		boutonRecommencer.addActionListener(new ControleurBoutonMenu(this));
		
		panneauFin.add(boutonFin);
		panneauFin.add(boutonRecommencer);
		this.add(panneauFin,BorderLayout.EAST);
		this.setSize(this.getWidth()+1,this.getHeight());
	}

	/**
	 * Permet la sauvegarde des donnees.
	 */
	public void sauvegarder() {
		try {
			FileOutputStream fichier = new FileOutputStream("save.dat");
			ObjectOutputStream sortie = new ObjectOutputStream(fichier);
			sortie.writeInt(this.nombreColonnes);
			sortie.writeInt(this.nombreLignes);
			sortie.writeInt(this.nombreMines);
			sortie.writeObject(this.tabCases);
			sortie.close();
		}
		catch(IOException e) {
			System.err.println("Erreur lors de l'ecriture des donnees : "+e.getMessage());
		}
	}

	/**
	 * Charge les donnees puis lance le jeu.
	 */
	public void reprendrePartie() {
		try {
			FileInputStream fichier = new FileInputStream("save.dat");
			ObjectInputStream entree = new ObjectInputStream(fichier);
			this.nombreColonnes = entree.readInt();
			this.nombreLignes = entree.readInt();
			this.nombreMines = entree.readInt();
			this.tabCases = ((Cases[][]) entree.readObject()).clone();
			entree.close();
			this.jouer(nombreColonnes, nombreLignes, nombreMines,true);
		}
		catch(FileNotFoundException e) {
			System.err.println("Aucun fichier de sauvgarde");
		}
		catch(IOException e2) {
			System.err.println("Erreur lors de la lecture");
		}
		catch(ClassNotFoundException e3) {
			System.err.println("Erreur lors de la lecture du tableau");
		}
	}

	/**
	 * Change l'affichage du nombre de mines en le  decrementant si il y a un nouveau drapeau ou en l'incrementant si un drapeau est enleve.
	 * 
	 * @param drapeau booleen representant la presence d'un nouveau drapeau.
	 */
	public void affichageMines(boolean drapeau) {
		if(drapeau) {
			this.nombreDrapeau++;
		}else {
			this.nombreDrapeau--;
		}
		this.minesRestantes.setText(Integer.toString(this.nombreMines-this.nombreDrapeau));
	}
}