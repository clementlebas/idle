package exception;

/**
 * Classe PasDansDossierImagesException
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */

@SuppressWarnings("serial")
public class PasDansDossierImagesException extends MauvaisDossierException{

	/**
	 * Constructeur dans le cas ou la Photo n'est pas dans le dossier images
	 * @param message contenant le message renvoyer par MauvaisDossierException
	 */
	public PasDansDossierImagesException(String message) {
		super(message);
	}

	/**
	 * @return String contenant le string à afficher
	 */
	public String toString() {
		return super.toString() + "images.";
	}
}
