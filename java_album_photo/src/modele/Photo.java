package modele;
import exception.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Classe Photo représentant des photos dites "normales" (n'appartient pas à un évènement)
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */

public class Photo {

	private String nom;
	private File fichier;
	private Date date;
	
	/**
	 * Définition du constructeur à partir d'un File
	 * @param f le File à partir duquel on instancie une Photo
	 * @throws FileNotFoundException si le File f n'existe pas
	 */
	public Photo(File f) throws FileNotFoundException, MauvaisFormatException, PasDansDossierImagesException {
		
		if(!(f.exists())) {
			FileNotFoundException e = new FileNotFoundException("le fichier " + f.getName() + " n'existe pas.");
			throw e;
		}
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "gif", "jpeg", "png");
		if(!(filter.accept(f))) {
			MauvaisFormatException e = new MauvaisFormatException(f.getName());
			throw e;
		}
		
		if(!f.getParentFile().getName().equals("images")) {
			PasDansDossierImagesException e = new PasDansDossierImagesException(f.getName());
			throw e;
		}

		this.nom = f.getName().substring(0, f.getName().lastIndexOf("."));
		this.fichier = f;
		this.date = new Date(f.lastModified());	
	}
	
	/**
	 * Définition d'un second constructeur qui sera appelé par le constructeur de PhotoEvenement
	 * 
	 */
	public Photo(File f, String s) throws FileNotFoundException, MauvaisFormatException {
		
		if(!(f.exists())) {
			FileNotFoundException e = new FileNotFoundException("le fichier " + f.getName() + " n'existe pas.");
			throw e;
		}
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "gif", "jpeg", "png");
		if(!(filter.accept(f))) {
			MauvaisFormatException e = new MauvaisFormatException(f.getName());
			throw e;
		}
		
		this.nom = f.getName().substring(0, f.getName().lastIndexOf("."));
		this.fichier = f;
		this.date = new Date(f.lastModified());	
	}
	
	/**
	 * Définition d'un getter qui récupère le file
	 * @return File f associé à la photo
	 */
	public File getFichier() {
		return this.fichier;
	}
	
	/**
	 * Définition d'un getter qui récupère le nom de la photo
	 * @return String contenant le nom
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Définition de la méthode toString qui gèrera l'affiche d'une Photo
	 * @return un String qui s'affichera
	 */
	public String toString() {
		DateFormat df1 = new SimpleDateFormat("dd/MM/yy");
		DateFormat df2 = new SimpleDateFormat("HH:mm");
		String s = new String("La photo " + this.nom + " réalisée le " + df1.format(this.date) + " à " + df2.format(this.date) + ".");
		return s;
	}
		  
}
