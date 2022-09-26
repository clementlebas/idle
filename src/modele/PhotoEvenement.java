package modele;

import java.io.File;
import java.io.FileNotFoundException;

import exception.MauvaisFormatException;
import exception.PasDansDossierEvenementException;
import modele.Photo;

/**
 * Classe PhotoEvenement représentant des photos prises lors d'un Evenement
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */
public class PhotoEvenement extends Photo{

	/**
	 * 	
	 * @param f File à partir duquel on va créer une PhotoEvenement
	 * @param s String contenant le nom du dossier parent
	 * @throws FileNotFoundException si le File f n'existe pas
	 * @throws MauvaisFormatException si le File f n'est pas au bon format
	 * @throws PasDansDossierEvenementException si le File f n'est pas contenu dans le répertoire évènement
	 */
	public PhotoEvenement(File f, String s) throws FileNotFoundException, MauvaisFormatException, PasDansDossierEvenementException{
		
		super(f, s);
		
		if(!(f.getParentFile().getName().equals(s))) {
			PasDansDossierEvenementException e = new PasDansDossierEvenementException(f.getName());
			throw e;
		}
		
	}
}
