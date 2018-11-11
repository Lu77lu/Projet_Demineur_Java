import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * La classe <code>ControleurSouris</code> est utilise pour recuperer les coordonnes
 * de la souris lorsque l'on clique et recuperer quel clic est appuye. 
 * 
 * @version 1.0
 * @author Maxime Menault, Lucas Lefevre
 *
 */

public class ControleurSouris implements MouseListener {

	/**
	 * Attributs correspondant a l'abscisse (x) et a l'ordonne (y) de la souris.
	 */
	private int x,y;
	/**
	 * Attribut contenant un objet de la classe contenant les fonctions qui traitent les clics.
	 */
	private Clics clics;
	
	/**
	 * Recupere les coordonnees de la souris et appelle les fonctions correspondantes au clic appuye.
	 * 
	 * @param e l'evenement lie au clic de souris
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		this.x = (e.getX()-8)/32;
		this.y = (e.getY()-32)/32;
		if(e.getButton() == MouseEvent.BUTTON1) {
			clics.clicGauche(this.x,this.y);
		}
		else {
			if(e.getButton() == MouseEvent.BUTTON3) {
				clics.clicDroit(x,y);
			}
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	/**
	 * Constructeur utilise pour recuperer un objet de la classe Clics
	 * pour pouvoir appeler ses fonctions.
	 * 
	 * @param clics un objet de la classe Clics
	 */
	public ControleurSouris(Clics clics) {
		this.clics = clics;
	}
}
