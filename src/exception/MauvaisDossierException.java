package exception;
/**
 * Classe MauvaisDossierException abstraite
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */

@SuppressWarnings("serial")
public abstract class MauvaisDossierException extends Exception{

	/**
	 * Constructeur qui génère une exception si un fichier n'est pas dans le bon format
	 * @param message String contenant le nom du File qui n'est pas dans le bon dossier
	 */
	public MauvaisDossierException(String message) {
		super(message);
	}
	
	/**
	 * Définition de la méthode toString qui gèrera l'affichage
	 * @return le string qui s'affichera
	 */
	public String toString() {
		return super.toString() + " n'est pas dans le dossier ";
	}
	
}
