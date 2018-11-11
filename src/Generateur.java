import java.util.Random;
import javax.swing.JFrame;
/**
 * La classe <code>Generateur</code> est utilise pour generer le tableau
 * contenant toutes les cases du demineur.
 * 
 * @version 1.0
 * @author Lucas Lefevre, Maxime Menault
 *
 */
public class Generateur {

	/**
	 * Initialise le tableau.
	 * 
	 * @param colonnes le nombre de colonnes du demineur.
	 * @param lignes le nombre de lignes du demineur.
	 * @param tabCases le tableau contenant chaque cases.
	 */
	public static void PasMines(int colonnes,int lignes,Cases[][] tabCases) {
		for(int i=0; i<colonnes; i++) {
			for(int j=0; j<lignes; j++) {
				tabCases[i][j]= new Cases();
			}
		}
	}
	/**
	 * Genere des mines dans le tableau de Cases donne.
	 * 
	 * @param colonnes le nombre de colonnes du demineur.
	 * @param lignes le nombre de lignes du demineur.
	 * @param nbMines le nombre de mines du demineur.
	 * @param tabCases le tableau contenant chaque cases.
	 */
	public static void Mines(int colonnes, int lignes, int nbMines, Cases[][] tabCases){
		int aleaX,aleaY;
		Random rand = new Random();
		for(int i=0; i<nbMines; i++) {
			aleaX = rand.nextInt(colonnes);
			aleaY = rand.nextInt(lignes);
			if(!(tabCases[aleaX][aleaY].getMine())) {
				tabCases[aleaX][aleaY].trueMine();
				tabCases[aleaX][aleaY].moinsMineAutour();
			}
			else {
				i--;
			}
		}
	}
	
	
}
