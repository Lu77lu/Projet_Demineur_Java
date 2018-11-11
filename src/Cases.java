import java.io.Serializable;
/**
 * La classe <code>Cases</code> est utilise pour representer
 * une case du demineur.
 * 
 * @version 1.0
 * @author Lucas Lefevre, Maxime Menault
 *
 */
public class Cases implements Serializable{
	/**
	 * Booleen indiquant si la case est une mine.
	 */
	private boolean mine = false;
	/**
	 * Booleen indiquant que la mine a explose.
	 */
	private boolean mineExplose = false;
	/**
	 * Booleen indiquant s'il y a un drapeau sur la case.
	 */
	private boolean drapeau = false;
	/**
	 * Booleen indiquant si la case est revele.
	 */
	private boolean revele = false;
	/**
	 * Booleen indiquant s'il y a un "?" sur la case.
	 */
	private boolean interrogation = false;
	/**
	 * Attribut indiquant le nombre de mines autour de cette case.
	 */
	private int mineAutour = 0;
	/**
	 * Booleen indiquant si la case doit etre revele lors de la cascade.
	 */
	private boolean cascade;
	/**
	 * Booleen indiquant si la case a deja ete revelee lors de la cascade afin de ne pas la reconsiderer.
	 */
	private boolean dejaCascade = true;
	
	/**
	 * Indique qu'il y a une mine a cette case.
	 */
	public void trueMine(){
		this.mine = true;
	}

	/**
	 * Retourne si la case est une mine ou non.
	 * @return le booleen indiquant la presence d'une mine a cette case.
	 */
	public boolean getMine(){
		return this.mine;
	}
	
	/**
	 * Ajoute un au compteur de mines autour de la case.
	 */
	public void plusMineAutour() {
		this.mineAutour ++;
	}

	/**
	 * Enleve un au compteur de mines autour de la case.
	 */
	public void moinsMineAutour() {
		this.mineAutour --;
	}
	
	/**
	 * Retourne le nombre de mines autour de la case.
	 * @return la valeur du compteur de mines autour de la case.
	 */
	public int getMineAutour() {
		return this.mineAutour;
	}
	
	/**
	 * Indique qu'il y a une mine a cette case.
	 */
	public void drapeau() {
		this.drapeau = true;
	}
	
	/**
	 * Retourne si la case a un drapeau ou non.
	 * @return la valeur du booleen indiquant la presence d'un drapeau.
	 */
	public boolean estDrapeau() {
		return this.drapeau;
	}
	
	/**
	 * Indique qu'il n'y a plus de "?" sur cette case.
	 */
	public void enleverInterrogation() {
		this.interrogation = false;
	}
	
	/**
	 * Retourne si la case a un "?" ou non.
	 * @return la valeur du booleen indiqaunt la presence d'un "?".
	 */
	public boolean estInterrogation() {
		return this.interrogation;
	}
	
	/**
	 * Indique qu'il y a un "?" sur la case.
	 */
	public void interrogation() {
		this.interrogation = true;
		this.drapeau = false;
	}
	
	/**
	 * Retourne si la case est revele ou non.
	 * @return la valeur du booleen indiquant si la case est revele.
	 */
	public boolean estRevele() {
		return this.revele;
	}	
	
	/**
	 * Indique que la case est revele.
	 */
	public void Revele() {
		this.revele = true;
	}
	
	/**
	 * Indique que la case doit etre revele lors de la cascade.
	 */
	public void trueCascade() {
		this.cascade = true;
	}
	
	/**
	 * Retourne si la case doit etre revelee lors de la cascade.
	 * @return la valeur du booleen indiquant s'il faut reveler la case lors de la cascade.
	 */
	public boolean getCascade() {
		return this.cascade;
	}
	
	/**
	 * Indique que la case a deja ete traitee pour la cascade.
	 */
	public void dejaCascade() {
		this.dejaCascade = false;
	}
	
	/**
	 * Retourne si la case a deja ete traitee pour la cascade.
	 * @return la valeur du booleen indiquant s'il faut ignorer cette case pour la prochaine cascade.
	 */
	public boolean getDejaCascade() {
		return this.dejaCascade;
	}
	
	/**
	 * Indique que cette case est une mine qui a explose.
	 */
	public void mineExplose() {
		this.mineExplose = true;
	}
	
	/**
	 * Retourne si cette case est la mine qui a explose.
	 * @return 
	 */
	public boolean getMineExplose() {
		return this.mineExplose;
	}
}
