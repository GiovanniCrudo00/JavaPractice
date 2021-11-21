package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class app extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane Loginroot = (AnchorPane) FXMLLoader.load(Main.class.getResource("/login.fxml"));
		Scene scene = new Scene(Loginroot, 300, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
		primaryStage.setMinHeight(100);
		primaryStage.setMinWidth(150);
		primaryStage.show();
	}
	
	public static void main(String args[]) {
		launch(args);
	}
}
