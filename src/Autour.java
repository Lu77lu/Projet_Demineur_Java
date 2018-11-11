/**
 * La classe <code>Autour</code> est utilise pour calculer les mines presentes autour 
 * de chaque cases.
 * 
 * @version 1.0
 * @author Lucas Lefevre, Maxime Menault
 *
 */
public class Autour {
	/**
	 * Fonction qui calcule le nombre de mines presentes autour de chaque cases.
	 * 
	 * @param colonnes le nombre de colonnes du demineur.
	 * @param lignes le nombre de lignes du demineur.
	 * @param tabCases le tableau contenant chaque cases.
	 */
	public static void DetecteMines(int colonnes, int lignes, Cases[][] tabCases) {
		for(int i =0; i<colonnes; i++) {
			for(int j=0; j<lignes; j++) {
				if(tabCases[i][j].getMine()) {
					
					if((i!=0)&&(j!=0)) {
						if(!(tabCases[i-1][j-1].getMine())) {
							tabCases[i-1][j-1].plusMineAutour();
						}
					}
					
					if(j!=0) {
						if(!(tabCases[i][j-1].getMine())) {
							tabCases[i][j-1].plusMineAutour();
						}
					}
					
					if((i!=colonnes-1)&&(j!=0)) {	
						if(!(tabCases[i+1][j-1].getMine())) {
							tabCases[i+1][j-1].plusMineAutour();
						}
					}
					
					if(i!=0) {	
						if(!(tabCases[i-1][j].getMine())) {
							tabCases[i-1][j].plusMineAutour();
						}
					}
					
					if(i!=colonnes-1) {	
						if(!(tabCases[i+1][j].getMine())) {
							tabCases[i+1][j].plusMineAutour();
						}
					}
					
					if((i!=0)&&(j!=lignes-1)) {	
						if(!(tabCases[i-1][j+1].getMine())) {
							tabCases[i-1][j+1].plusMineAutour();
						}
					}
					
					if(j!=lignes-1) {
						if(!(tabCases[i][j+1].getMine())) {
							tabCases[i][j+1].plusMineAutour();
						}
					}
					
					if((i!=colonnes-1)&&(j!=lignes-1)) {
						if(!(tabCases[i+1][j+1].getMine())) {
							tabCases[i+1][j+1].plusMineAutour();
						}
					}
				}
			}
		}
	}
}