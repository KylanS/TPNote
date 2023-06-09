package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("IHM.fxml"));
			Scene scene = new Scene(root,500,400);
			scene.setFill(Color.LIGHTGRAY);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Gestionnaire de couleurs");
			primaryStage.setResizable(false);
			
			Image icone3iL = new Image("ressources/logo_3iL.png");
			primaryStage.getIcons().add(icone3iL);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() throws Exception {
		Controleur control = new Controleur();
	}
	
	@Override
	public void stop() throws Exception {
		
		super.stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
