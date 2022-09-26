import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import exception.MauvaisFormatException;
import exception.PasDansDossierEvenementException;
import exception.PasDansDossierImagesException;
import graphique.FenetreAlbum;
import graphique.FenetreListeAlbum;
import graphique.FenetreTexteAlbum;
import modele.AlbumPhoto;
import modele.Photo;
import modele.PhotoEvenement;

public class TestProjetGraphique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlbumPhoto ap = new AlbumPhoto("test");
		/*
		ArrayList<AlbumPhoto> albumsPhoto = new ArrayList<AlbumPhoto>();
		
	    if((JOptionPane.showConfirmDialog(null, "Voulez-vous créer un Album Photo 'normal' ?") == JOptionPane.YES_OPTION)) {
	    	String str = JOptionPane.showInputDialog("Comment voulez-vous appelez votre album ?");
	    	AlbumPhoto ap = new AlbumPhoto(str);
	    	albumsPhoto.add(ap);
	    	JOptionPane.showMessageDialog(null, "Album photo " + str + " crée avec succès !");
	    }
	    
	    for(AlbumPhoto ap : albumsPhoto){
	    	JOptionPane.showMessageDialog(null, "Veuillez sélectionner les photos pour l'album " + ap.getNom());
    		*/
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
	 //   }
	    
    	Toolkit tk = Toolkit.getDefaultToolkit();
    	Dimension dim = tk.getScreenSize();
    	
		FenetreTexteAlbum fta = new FenetreTexteAlbum(ap, 0, 0, (int)((int)dim.getWidth()/3), (int)dim.getHeight());
		FenetreAlbum fa = new FenetreAlbum(ap, (int)((int)dim.getWidth()/3), 0, (int)((int)dim.getWidth()/3), (int)dim.getHeight());
    	FenetreListeAlbum fla = new FenetreListeAlbum(ap, (int)((int)dim.getWidth()/3)*2, 0, (int)((int)dim.getWidth()/3), (int)dim.getHeight());
    			
    			
	} // fin du main

} //fin de class
