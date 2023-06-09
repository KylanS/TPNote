package application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

import javafx.beans.property.SimpleObjectProperty;

public class ModelGestionnaire {
	
	// Liste couleurs sauvegardees	
	private static ArrayList<Couleur> listeCouleurs;
	// Indice de la couleur courante dans la liste de couleurs
	private int indiceCouleurCourante;
	// Nom du fichier de sauvegarde de la liste de couleurs
	private static final String FIC_SAUVEGARDE = "src/ressources/sauvegardeCouleurs.bin";
	
	// Objet de mise a jour de la couleur
	private SimpleObjectProperty<Color> majCouleur;
	
	/**
	 * Construit le modele
	 * Désérialise listeCouleurs depuis le fichier FIC_SAUVEGARDE
	 */
	public ModelGestionnaire() {
		ModelGestionnaire.listeCouleurs = (ArrayList<Couleur>) ModelGestionnaire.deserialiseListe();
		this.indiceCouleurCourante = 0;
		
		// Initialisation de l'interface avec la couleur initiale
		if (!ModelGestionnaire.listeCouleurs.isEmpty()) {
			Couleur initiale = listeCouleurs.get(indiceCouleurCourante);
			this.majCouleur = new SimpleObjectProperty<>(Color.rgb(initiale.getRouge(), initiale.getVert(), initiale.getBleu()));
		} else {
			// Affichage en blanc si la liste de couleurs est vide
			this.majCouleur = new SimpleObjectProperty<>(Color.rgb(0, 0, 0));
		}
	}
	
	/**
	 * Recupere la liste de couleurs depuis le fichier de sauvegarde
	 * @return Liste de couleurs obtenue ou une liste vide si le fichier est vide
	 */
	public static List<Couleur> deserialiseListe() {
		// Liste a retourner
		ArrayList<Couleur> resultat;
		//Chemin du fichier de sauvegarde
		Path p1 = Paths.get(System.getProperty("user.dir"), FIC_SAUVEGARDE);
		
		try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(p1))){
			// Deserialisation
			resultat = (ArrayList<Couleur>) ois.readObject();
		}catch(Exception e){
			e.printStackTrace();
			// Si le fichier est vide, on cree une nouvelle liste vide
			resultat = new ArrayList<>();
		}
		return resultat;
	}
	
	/**
	 * Sauvegarde la liste de couleurs dans le fichier de sauvegarde
	 */
	public static void serialiseListe() {
		//Chemin du fichier de sauvegarde
		Path p1 = Paths.get(System.getProperty("user.dir"), FIC_SAUVEGARDE);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(p1))){
			// Serialisation
			oos.writeObject(ModelGestionnaire.listeCouleurs);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Couleur> getListeCouleurs() {
		return listeCouleurs;
	}
}
