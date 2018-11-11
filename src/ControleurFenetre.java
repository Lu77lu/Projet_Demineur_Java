import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * La classe <code>ControleurFenetre</code> est utilise pour sauvegarder les donnees
 * lorsque la fenetre se ferme.
 * 
 * @version 1.0
 * @author Maxime
 *
 */

public class ControleurFenetre implements WindowListener {

	/**
	 * Attribut contenant la fenetre a observer.
	 */
	private Fenetre f;

	/**
	 * Appelle la fonction de sauvegarde de f lorsque la fenetre se ferme.
	 *
	 * @param e l'action lie a la fermeture de la fenetre.
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		f.sauvegarder();
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Constructeur utilise pour pouvoir recuperer la fenetre et pouvoir
	 * utilise sa fonction de sauvegarde.
	 * 
	 * @param f la fenetre a observer
	 */
	public ControleurFenetre(Fenetre f) {
		this.f = f;
	}
}
