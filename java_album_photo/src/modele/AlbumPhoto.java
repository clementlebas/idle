package modele;

import java.util.ArrayList;

/**
 * Classe AlbumPhoto contenant tout type de Photo
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */

public class AlbumPhoto {
	
	private String nom;
	private ArrayList<Photo> album;
	
	/**
	 * Définition du constructeur de AlbumPhoto
	 * @param nom String contenant le nom de l'album
	 * @see Photo
	 */
	public AlbumPhoto(String nom) {
		this.nom = nom;
		this.album = new ArrayList<Photo>();
	}
	
	/**
	 * Définition du getters pour récupérer le nom de l'album 
	 * @return String contenant le nom de l'album
	 */
	public String getNom() {
		return this.nom;
	}
	 
	/** 
	 * Définition du getter pour récupérer l'arrayList de Photos
	 * @return ArrayList<Photo>
	 */
	public ArrayList<Photo> getAlbum(){
		return this.album;
	}
	
	/**
	 * Définition de la méthode toString
	 * @return String qui s'affichera
	 */
	public String toString() {
		String s = new String("L'album photo " + this.nom + " contient les photos suivantes: \n");
		for(Photo p : this.album){
			s += p.toString() + "\n";
		}
		return s;
	}
	
	/**
	 * Méthode qui ajoute une Photo à l'album
	 * @param p Photo à ajouter à l'album
	 * @return boolean true si tout s'est bien passé, false sinon
	 */
	public boolean ajouterPhoto(Photo p) {
		if(this.album.add(p)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Méthode qui retourne la taille de l'album photo
	 * @return entier correspondant à la taille de l'album
	 */
	public int tailleAlbum() {
		return this.album.size();
	}
}
