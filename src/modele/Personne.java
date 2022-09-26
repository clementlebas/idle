package modele;
/**
 * Classe Personne représentant des personnes présentent à un évènement
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */

 public class Personne {

   private String nom;
   private String mail;

/**
  * Définition du constructeur de Personne
  * @param n le nom de la personne
  * @param m le mail de la personne
  */
  public Personne(String n, String m){
    this.nom = n;
    this.mail = m;
  }

  /**
   * Getter pour récupérer le nom
   * @return String contenant le nom de la personne
   */
  public String getNom() {
	  return this.nom;
  }
  
  /**
   * getter pour récupérer le mail
   * @return String contenant le mail
   */
  public String getMail() {
	  return this.mail;
  }
  
/**
  * Définition de la méthode toString
  * @return le string qui s'affichera
  */
  public String toString(){
    String s = new String(this.nom + " dont le mail est " + this.mail + ".");
    return s;
    }

 }
