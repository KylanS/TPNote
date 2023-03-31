package application;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controleur {
	
	@FXML
	private Button sauvegarde;
	
	@FXML
	private Button ajouter;
	
	@FXML
	private Button supprimer;
	
	@FXML
	private TextField nom;
	
	@FXML
	private TextField rouge;
	
	@FXML
	private TextField vert;
	
	@FXML
	private TextField bleu;
	
	@FXML
	private ListView<Couleur> affichageListe;
	
	private ObservableList<Couleur> listeCouleurs;
	
	
	@FXML
	public void initialize() {
		
	}
	
	public Controleur() {
		ModelGestionnaire modele = new ModelGestionnaire();
		this.listeCouleurs = FXCollections.observableArrayList(modele.getListeCouleurs());
		
//		this.listeCouleurs.addListener((ListChangeListener.Change<? extends Couleur> change) -> {
//		while (change.next()) {
//			if (change.wasAdded()) {
//				
//			}
//		}
//	});
	}
	
	/**
	 * Ajoute une nouvelle couleur a la liste si les champs sont correctement remplis
	 * @param event
	 */
	@FXML
	public void clicAjouter(MouseEvent event) {
		if (!(this.nom.getText() == "" || this.rouge.getText() == "" || this.vert.getText() == "" || this.bleu.getText() == "")) {
			Couleur c = new Couleur(this.nom.getText(), Integer.valueOf(this.rouge.getText()), Integer.valueOf(this.vert.getText()), Integer.valueOf(this.bleu.getText()));
			if (this.listeCouleurs.contains(c)){
				this.listeCouleurs.add(c);
			}
		}
	}
	
	@FXML
	public void clicSauvegarder() {
		ModelGestionnaire.serialiseListe();
	}
}
