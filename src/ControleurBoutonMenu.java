import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe <code>ControleurBoutonMenu</code> est utilise lorsque l'on appuie sur un des boutons
 * present sur la fenetre de l'application, elle execute alors la fonciton correspondante au bouton.
 * 
 * @version 1.0
 * @author Maxime Menault, Lucas Lefevre
 *
 */

public class ControleurBoutonMenu implements ActionListener {

	
	/**
	 * Appelle les fonctions correspondantes au bouton qui est appuye.
	 * 
	 * @param e l'evenement lie a la pression du bouton
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Quitter DEMINEUR") {
			f.dispose();
		}else {
			if(e.getActionCommand() == "Commencer Partie") {
				f.parametres();
			}else {
				if(e.getActionCommand() == "JOUER") {
					try {
						int lignes = Integer.parseInt(f.recupererParametres("lignes"));
						int colonnes = Integer.parseInt(f.recupererParametres("colonnes"));
						int mines = Integer.parseInt(f.recupererParametres("mines"));
						if(lignes>=4 && lignes<=30) {
							if(colonnes>=4 && colonnes<=30) {
								if(mines>=1 && mines<(lignes*colonnes))
									f.jouer(colonnes,lignes,mines,false);
							}
						}
					}catch(NumberFormatException exception){
						System.err.println("ERREUR");
					}
				}else {
					if(e.getActionCommand() == "Vous avez gagne !" || e.getActionCommand() == "Quitter le jeu") {
						f.dispose();
					}else {
						if(e.getActionCommand() == "Retour menu") {
							f.dispose();
							Fenetre f2 = new Fenetre();
						}else {
							if(e.getActionCommand() == "Sauvegarder et quitter") {
								f.sauvegarder();
								f.dispose();
							}else {
								f.reprendrePartie();
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Fenetre dans laquelle sont les boutons.
	 */
	private Fenetre f;
	
	/**
	 * Constructeur permettant d'obtenir la fenetre dans laquelle sont les boutons afin d'en appeler ses fonctions.
	 * 
	 * @param f la fenetre dans laquelle sont les boutons.
	 */
	public ControleurBoutonMenu(Fenetre f) {
		this.f = f;
	}
	
}
