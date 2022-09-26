package exception;
/**
 * Classe MauvaisFormatException qui génère une exception si un File n'est pas dans le bon format
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */

@SuppressWarnings("serial")
public class MauvaisFormatException extends Exception{

	/**
	 * Constructeur qui crée un MauvaisFormatException si le fichier n'est pas dans le bon format
	 * @param message String qui contient le nom du fichier ne possédant pas le bon format
	 */
	public MauvaisFormatException(String message) {
		super(message);
	}
	
	/**
	 * Définition de la méthode toString
	 * @return le string qui s'affichera
	 */
	public String toString(){
		return super.toString() + " ne possède pas un format adéquat.";
	}
}
