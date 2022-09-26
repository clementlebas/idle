package modele;
import java.util.ArrayList;

/**
 * Classe Evenement représentant un évènement et plusieurs personnes
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */

public class Evenement {

  private String nomEvenement;
  private ArrayList<Personne> liste;

  /**
   * Définition du constructeur Evenement
   * @param nom le nom de l'évènement
   */
   public Evenement(String nom){
     this.nomEvenement = nom;
     this.liste = new ArrayList<Personne>();
   }

   /**
    * Définition du getters pour récupérer le nom de l'évènement
    * @return String contenant le nom de l'évènement
    */
    public String getNom(){
      return this.nomEvenement;
    }

   /**
    * Définition du getters pour récupérer la liste des personnes liées à l'évènement
    * @return ArrayList de Personne
    */
    public ArrayList<Personne> getListe(){
    	return this.liste;
    }
    
   /**
    * Définition de la méthode toString
    * @return le string qui s'affichera
    */
    public String toString(){
      String s = new String("Voici les liste des personnes présentes lors de l'évènement " + this.nomEvenement + ":\n");
      for(Personne p : this.liste){
        s += "\t" + p.toString() + "\n";
      }
      return s;
    }

    /**
     * Méthode qui ajoute une personne à la liste des personne concerné par l'évènement
     * @param p Personne à ajouter à la liste
     * @return true si tout s'est bien passé, false sinon
     */
     public boolean ajouterPersonne(Personne p){
      if(this.liste.add(p)){
         return true;
       }
       return false;
    }
     
    public boolean existe(String nom) {
    	if(this.nomEvenement.equals(nom))
    		return true;
    	return false;
    }

 }
