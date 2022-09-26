package graphique;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import exception.MauvaisFormatException;
import exception.PasDansDossierEvenementException;
import exception.PasDansDossierImagesException;
import modele.AlbumPhoto;
import modele.Photo;
import modele.PhotoEvenement;

/**
 * class FenetreAlbum qui affiche l'image d'une photo
 * @author ROZENFELD Benjamin, LECUNFF Xavier, NSOUMOU Japhet, LEBAS Clément
 *
 */
@SuppressWarnings("serial")
public class FenetreAlbum extends JFrame{

	private static final int SUIVANT = 1, PRECEDENT = 0;
	private static final int AJOUT = 2, SUPPRESSION = 3;
	/**
	 * une classe FenetreAlbum est associé à un albumPhoto donné
	 */
	private AlbumPhoto ap;
	private int position;
	private JLabel labelCentre;
	private JLabel labelNord;
	private JLabel labelPositionDansAlbum;
	private JButton suivant;
	private JButton precedent;
	private JMenuItem ajouterPhoto;
	private JMenuItem supprimerPhoto;
	
	/**
	 * Construit une FenetreAlbum à partir d'un AlbumPhoto, d'une largeur et d'une hauteur
	 * @param album AlbumPhoto à partir duquel sera initialisé la FenetreAlbum
	 * @param w int représentant la largeur de la fenêtre
	 * @param h int représentant la hauteur de la fenêtre
	 */
	public FenetreAlbum(AlbumPhoto album, int w, int h) {
		super(album.getNom());
		this.ap = album;
		this.position = 1;
		this.initComposants();
		this.initialiseMenu();
		this.setSize(w, h);
		this.setVisible(true);
	}
	
	/**
	 * Construit une FenetreAlbum à partir d'un AlbumPhoto, d'une largeur et d'une hauteur, d'une position x et d'une position y
	 * @param album AlbumPhoto à partir duquel sera initialisé la FenetreAlbum
	 * @param w int représentant la largeur de la fenêtre
	 * @param h int représentant la hauteur de la fenêtre
	 * @param x int représentant la position horizontale de la fenêtre
	 * @param y représentant la position vertical de la fenêtre
	 */
	public FenetreAlbum(AlbumPhoto album, int x, int y, int w, int h) {
		super(album.getNom());
		this.ap = album;
		this.position = 1;
		this.initComposants();
		this.initialiseMenu();
		this.setBounds(x, y, w, h);
		this.setVisible(true);
	}
	
	/**
	 * Méthode privée qui initialise les composants à l'intérieur de la fenêtre
	 * Le ManagerLayout est de type BorderLayout
	 * La 1ère image de l'album sera au centre et son nom au nord
	 */
	private void initComposants() {
		this.labelCentre = new JLabel(new ImageIcon(this.ap.getAlbum().get(this.position - 1).getFichier().getAbsolutePath()), JLabel.CENTER);
		this.add(this.labelCentre, BorderLayout.CENTER);
		
		this.labelNord = new JLabel(this.ap.getAlbum().get(this.position - 1).getNom(), JLabel.CENTER);
		this.add(this.labelNord, BorderLayout.NORTH);
		JPanel pSud = this.creePanelSud(this.ap.tailleAlbum());
		this.add(pSud, BorderLayout.SOUTH);
	}
	
	/**
	 * Méthode privée qui initialise le JPanel positionnée au sud de la fenêtre
	 * @param nbr int représentant le nombre de Photo dans l'album 
	 * @param pos int représentant la position de la photo qui s'affiche dans l'album
	 * @return
	 */
	private JPanel creePanelSud(int nbr) {
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
		JPanel pSud = new JPanel();
		this.suivant = new JButton(">>");
		this.precedent = new JButton("<<");
		this.labelPositionDansAlbum = new JLabel(this.position + "/" + nbr);
		this.precedent.setEnabled(false);
		if(this.position == this.ap.tailleAlbum()) {
			this.suivant.setEnabled(false);
		}
	    pSud.add(this.precedent);
	    pSud.add(this.labelPositionDansAlbum);
	    pSud.add(this.suivant);
	    
	    this.suivant.addActionListener(new ChangeListener(SUIVANT));
	    this.precedent.addActionListener(new ChangeListener(PRECEDENT));
	    return pSud;
	}
	
	/**
	 * Méthode privée qui intialise un Menu
	 */
	private void initialiseMenu() {
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		
		JMenu mdef = new JMenu("Photos");
		jmb.add(mdef);
		
		this.ajouterPhoto = new JMenuItem("ajouter une photo");
		mdef.add(this.ajouterPhoto);
		
		this.supprimerPhoto = new JMenuItem("enlever une photo");
		mdef.add(this.supprimerPhoto);
		
		this.ajouterPhoto.addActionListener(new AjoutListener(AJOUT));
	}
	
	/**
	 * Méthode qui met à jour l'affichage à chaque clique de l'utilisateur sur les flèches
	 */
	private void miseAJourImage() {
		this.labelPositionDansAlbum.setText(FenetreAlbum.this.position + "/" + FenetreAlbum.this.ap.tailleAlbum());
		this.labelCentre.setIcon(new ImageIcon(FenetreAlbum.this.ap.getAlbum().get(FenetreAlbum.this.position - 1).getFichier().getAbsolutePath()));
		this.labelNord.setText(FenetreAlbum.this.ap.getAlbum().get(FenetreAlbum.this.position - 1).getNom());
	}
	
	/**
	 * Méthode qui gère l'activation et la désactivation des bouttons suivant et précédent
	 */
	private void miseAJourBoutton() {
		if(this.position > 1) {
			this.precedent.setEnabled(true);
		}
		else {
			this.precedent.setEnabled(false);
		}
		
		if(this.position == this.ap.tailleAlbum()) {
			this.suivant.setEnabled(false);
		}
		else {
			this.suivant.setEnabled(true);
		}
	}
	/**
	 * Méthode qui ajoute une photo lorsque l'on clique sur l'item menu "ajouter photo"
	 */
	private void ajouterPhoto() {
		JFileChooser fc = new JFileChooser("images/");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "gif","jpeg", "png");
		fc.setFileFilter(filter);	
		fc.setMultiSelectionEnabled(true);
		int returnVal = fc.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			File[] files = fc.getSelectedFiles();
			for(File f : files) {
				try {
					Photo p = new Photo(f);
					ap.ajouterPhoto(p);
				}
				catch(FileNotFoundException e) {
					System.out.println(e);
				}
				catch(MauvaisFormatException e){
					System.out.println(e);
				}
				catch(PasDansDossierImagesException e) {
					if(f.getParentFile().getParentFile().getName().equals("images")){
						try {
							PhotoEvenement pe = new PhotoEvenement(f, f.getParentFile().getName());
							ap.ajouterPhoto(pe);
						}
						catch(FileNotFoundException ex) {
							System.out.println(ex);
						}
						catch(MauvaisFormatException ex) {
							System.out.println(ex);
						}
						catch(PasDansDossierEvenementException ex) {
							System.out.println(ex);
						}
					}
					else {
						System.out.println(f.getName() + " n'est pas dans le bon répertoire");
					}
				}
			}
		}
	}
	
	
	class AjoutListener implements ActionListener {
		private int val;
		
		public AjoutListener(int i) {
			this.val = i;
		}
		
		public void actionPerformed(ActionEvent e) {
			switch(val) {
				case AJOUT:
					FenetreAlbum.this.ajouterPhoto();
					break;
			}
			FenetreAlbum.this.miseAJourImage();
			FenetreAlbum.this.miseAJourBoutton();
		}
	}
	
	
	class ChangeListener implements ActionListener {
		
		private int val;
		
		public ChangeListener(int i) {
			this.val = i;
		}
		
		public void actionPerformed(ActionEvent e) {
			switch(val) {
				case SUIVANT:
					FenetreAlbum.this.position++;
					break;
				case PRECEDENT:
					FenetreAlbum.this.position--;
					break;
			}
			FenetreAlbum.this.miseAJourImage();
			FenetreAlbum.this.miseAJourBoutton();
		}
	}
	
}
