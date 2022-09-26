package modele;

import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * Classe AlbumPhotoEvenement contenant uniquement des PhotoEvenement
 * @version 1.0
 * @author ROZENFELD Benjamin, LEBAS Clément, LECUNFF Xavier, NSMOU Jaĥet
 */

public class AlbumPhotoEvenement {

	private Evenement evenement;
	private String nom;
	private ArrayList<PhotoEvenement> album;
	
	/**
	 * Définition du constructeur de AlbumPhotoEvenement
	 * @param ev Evenement associé à cet album photo
	 * @see Evenement
	 */
	public AlbumPhotoEvenement(Evenement ev) {
		
		this.evenement = ev;
		this.nom = ev.getNom();
		this.album = new ArrayList<PhotoEvenement>();
	}
	
	/**
	 * Définition du getters pour récupérer le nom
	 * @return String contenant le nom de l'album
	 */
	public String getNom() {
		return this.nom;
	}
	
	
	/** 
	 * Définition de la méthode toString
	 * @return String contenant l'affichage
	 */
	public String toString() {
		String s = new String("L'album photo évènement " + this.nom + " contient les photos suivantes: \n");
		for(PhotoEvenement pe : this.album){
			s += pe.toString() + "\n";
		}
		return s;
	}
	
	/**
	 * Méthode qui ajoute une PhotoEvenement à l'album photo évènement
	 * @param pe PhotoEvenement à ajouter à l'album
	 * @see PhotoEvenement
	 * @return boolean true si tout s'est bien passé, false sinon
	 */
	public boolean ajouterPhoto(PhotoEvenement pe) {
		if(this.album.add(pe)){
			return true;
		}
		return false;
	}
	
	/**
	 * Méthode qui envoie l'album Photo aux personnes présentes lors de l'évènement
	 */
	public void envoyerAlbum() {
		String smtpServeur = "smtp.gmail.com";
		String nomUtilisateur = "comptebronze5@gmail.com";
		String motDePasse = "projetjava1.";
		
		Properties propriete = new Properties();
		propriete.setProperty("mail.smtp.ssl.enable", "true");
		propriete.setProperty("mail.smtp.host", smtpServeur);
		
		Session session = Session.getInstance(propriete);
		
		for(Personne p : this.evenement.getListe()) {
			String destinataire = p.getMail();
			String texte = "Veuillez trouvez ci-joint les photos de " + this.getNom() + ". \n";
			texte += "\n Cordialement";
			String objet = "Album Photo " + this.getNom();
			
			try {
				Message mail = new MimeMessage(session);
				mail.setSubject(objet);
				mail.setFrom(new InternetAddress(nomUtilisateur));
				mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire, false));
				BodyPart message = new MimeBodyPart(); 
				message.setText(texte);
				Multipart piecesJointes = new MimeMultipart();
				piecesJointes.addBodyPart(message);
				
				for(PhotoEvenement pe : this.album) {
					message = new MimeBodyPart();
					String cheminFichier = new String(pe.getFichier().getAbsolutePath());
					DataSource source = new FileDataSource(cheminFichier);
					message.setDataHandler(new DataHandler(source));
					message.setFileName(pe.getNom());
					piecesJointes.addBodyPart(message);
					mail.setContent(piecesJointes);
				}
				
				Transport.send(mail, nomUtilisateur, motDePasse);
				System.out.println("Message bien envoyé à " + p.getNom());
			}
			catch(AddressException e) {
				System.out.println(e);
			}
			catch(MessagingException e) {
				System.out.println(e);;
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}

	}
}