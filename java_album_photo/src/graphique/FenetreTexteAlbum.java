package graphique;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modele.AlbumPhoto;

/**
 * class FenetreTexteAlbum qui affiche le contenu d'un album photo sous forme de texte
 * @author ROZENFELD Benjamin, LECUNFF Xavier, NSOUMOU Japhet, LEBAS Clément
 *
 */

@SuppressWarnings("serial")
public class FenetreTexteAlbum extends JFrame {

	private AlbumPhoto ap;
	
	/**
	 * Initialise une FenetreTexteAlbum 
	 * @param album AlbumPhoto associé à la FenetreTexteAlbum
	 * @param w int représentant la largeur de la fenêtre
	 * @param h int représentant la hauteur de la fenêtre
	 */
	public FenetreTexteAlbum(AlbumPhoto album, int w, int h) {
		super(album.getNom());
		this.ap = album;
		this.initComposants();
		this.initialiseMenu();
	    this.setSize(w,h);
	    this.setVisible(true);
	}
	
	/**
	 * Construit une FenetreTexteAlbum à partir d'un AlbumPhoto, d'une largeur et d'une hauteur, d'une position x et d'une position y
	 * @param album AlbumPhoto à partir duquel sera initialisé la FenetreAlbum
	 * @param w int représentant la largeur de la fenêtre
	 * @param h int représentant la hauteur de la fenêtre
	 * @param x int représentant la position horizontale de la fenêtre
	 * @param y représentant la position vertical de la fenêtre
	 */
	public FenetreTexteAlbum(AlbumPhoto album, int x, int y, int w, int h){
		super(album.getNom());
		this.ap = album;
		this.initComposants();
		this.initialiseMenu();
		this.setBounds(x, y, w,h);
		this.setVisible(true);
	  }
	  
	/**
	 * Méthode qui organise l'intérieur de la fenêtre
	 * Ici ajoute un JTextArea contenant la liste des photos de l'album
	 */
	private void initComposants() {
		JTextArea jta = new JTextArea(this.ap.toString());
		jta.setEditable(false);
		this.add(jta);
	}
	
	/**
	 * Méthode qui intialise le Menu
	 */
	private void initialiseMenu() {
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		
		JMenu mdef = new JMenu("Photos");
		jmb.add(mdef);
		
		JMenuItem ajouterPhoto = new JMenuItem("ajouter une photo");
		mdef.add(ajouterPhoto);
		
		JMenuItem suppPhoto = new JMenuItem("enlever une photo");
		mdef.add(suppPhoto);
	}
}
