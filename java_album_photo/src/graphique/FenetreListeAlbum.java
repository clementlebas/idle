package graphique;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modele.AlbumPhoto;
import modele.Photo;

/**
 * class FenetreListeAlbum qui affiche le contenu d'un album photo sous forme de JList
 * @author ROZENFELD Benjamin, LECUNFF Xavier, NSOUMOU Japhet, LEBAS Clément
 *
 */

public class FenetreListeAlbum extends JFrame{
	
	private AlbumPhoto ap;
	
	/**
	 * Construit une FenetreListeAlbum à partir d'un AlbumPhoto, d'une largeur et d'une hauteur, d'une position x et d'une position y
	 * @param album AlbumPhoto à partir duquel sera initialisé la FenetreAlbum
	 * @param w int représentant la largeur de la fenêtre
	 * @param h int représentant la hauteur de la fenêtre
	 * @param x int représentant la position horizontale de la fenêtre
	 * @param y représentant la position vertical de la fenêtre
	 */
	public FenetreListeAlbum(AlbumPhoto album, int x, int y, int w, int h) {
		super(album.getNom());
		this.ap = album;
		this.initComposants();
		this.initMenu();
		this.setBounds(x, y, w, h);
		this.setVisible(true);
	}
	
	/**
	 * Initialise les composants à l'intérieur de la fenêtre
	 */
	private void initComposants() {
		DefaultListModel<Photo> dlm = new DefaultListModel<Photo>();
		for(Photo p : this.ap.getAlbum()) {
			dlm.addElement(p);
		}
		JList<Photo> jl = new JList(dlm.toArray());
		this.add(jl);
	}
	
	/**
	 * Initialise le menu
	 */
	private void initMenu() {
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
