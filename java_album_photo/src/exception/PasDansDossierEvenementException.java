package exception;

/**
 * Class PasDansDossierEvenementException qui génère une exception si le fichier image n'est pas dans un répertoire au nom de l'évènement
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */

@SuppressWarnings("serial")
public class PasDansDossierEvenementException extends MauvaisDossierException {

	/**
	 * Constructeur d'une exception si on crée une photo qui n'est pas dans le répertoire associé à l'évènement
	 * @param message le message d'erreur à envoyer
	 */
	public PasDansDossierEvenementException(String message){
		super(message);
	}

	/**
	 * Définition de la méthode toString 	
	 * @return le string qui s'affichera
	 */
	public String toString(){
		return super.toString() + "associé à l'évènement. ";
	}
}

