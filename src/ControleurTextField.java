import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 * La classe <code>ControleurTextField</code> est utilise pour effacer le texte des JTextField
 * dans le menu des parametres lorsqu'on clique dessus.
 * 
 * @version 1.0
 * @author Maxime Menault, Lucas Lefevre
 *
 */
public class ControleurTextField implements FocusListener {
	/**
	 * Attribut contenant le JTextField a effacer.
	 */
	private JTextField zoneDeTexte;
	
	/**
	 * Efface le texte du JTextField lorsqu'on lui clique dessus.
	 */
	@Override
	public void focusGained(FocusEvent e) {
		this.zoneDeTexte.setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {
	}
	
	/**
	 * Constructeur urilise pour recuperer le JTextField pour pouvoir
	 * effacer son texte.
	 * 
	 * @param zoneDeTexte le JTextField a effacer.
	 */
	public ControleurTextField(JTextField zoneDeTexte) {
		this.zoneDeTexte = zoneDeTexte;
	}

}
