package application;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelGestionnaire {
	
	// Liste couleurs sauvegardees	
	private ObservableList<Couleur> listeCouleurs;
	// Indice de la couleur courante dans la liste de couleurs
	private int indiceCouleurCourante;
	// Nom du fichier de sauvegarde de la liste de couleurs
	private final String FIC_SAUVEGARDE = "src/ressources/sauvegardeCouleurs.bin";
	
	// Objet de mise a jour de la couleur
	private SimpleObjectProperty<Color> majCouleur;
	
	/**
	 * Construit le modele
	 * Désérialise listeCouleurs depuis le fichier FIC_SAUVEGARDE
	 */
	public ModelGestionnaire() {
		this.listeCouleurs = this.deserialiseListe();
		this.indiceCouleurCourante = 0;
		
		// Initialisation de l'interface avec la couleur initiale
		if (!this.listeCouleurs.isEmpty()) {
			Couleur initiale = listeCouleurs.get(indiceCouleurCourante);
			this.majCouleur = new SimpleObjectProperty(Color.rgb(initiale.getRouge(), initiale.getVert(), initiale.getBleu()));
		} else {
			// Affichage en blanc si la liste de couleurs est vide
			this.majCouleur = new SimpleObjectProperty(Color.rgb(0, 0, 0));
		}
	}
	
	/**
	 * Recupere la liste de couleurs depuis le fichier de sauvegarde
	 * @return Liste de couleurs obtenue ou une liste vide si le fichier est vide
	 */
	public ObservableList<Couleur> deserialiseListe() {
		// Liste a retourner
		ObservableList<Couleur> resultat;
		//Chemin du fichier de sauvegarde
		Path P1 = Paths.get(System.getProperty("user.dir"), FIC_SAUVEGARDE);
		
		try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(P1))){
			// Deserialisation
			resultat = (ObservableList<Couleur>) ois.readObject();
		}catch(Exception e){
			e.printStackTrace();
			// Si le fichier est vide, on cree une nouvelle liste vide
			resultat = FXCollections.observableArrayList();
		}
		return resultat;
	}
	
	/**
	 * Sauvegarde la liste de couleurs dans le fichier de sauvegarde
	 */
	public void serialiseListe() {
		//Chemin du fichier de sauvegarde
		Path P1 = Paths.get(System.getProperty("user.dir"), FIC_SAUVEGARDE);
		
		try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(P1))){
			// Serialisation
			oos.writeObject(this.listeCouleurs);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
