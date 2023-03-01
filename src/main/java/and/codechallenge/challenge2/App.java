package and.codechallenge.challenge2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	
	
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("langant.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		stage.setTitle("Langton's Ant");
		stage.getIcons().add(new Image(getClass().getResourceAsStream("ant_icon.png")));
		stage.setScene(scene);
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}