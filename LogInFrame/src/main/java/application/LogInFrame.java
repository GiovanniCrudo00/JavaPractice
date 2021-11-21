package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogInFrame extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader1=new FXMLLoader(getClass().getResource("/application/logIn.fxml"));
		FXMLLoader loader2=new FXMLLoader(getClass().getResource("/application/afterLogin.fxml"));
		FXMLLoader loader3=new FXMLLoader(getClass().getResource("/application/registrazione.fxml"));
		AnchorPane root1=(AnchorPane) loader1.load();
		AnchorPane root2=(AnchorPane) loader2.load();
		AnchorPane root3=(AnchorPane) loader3.load();
		Scene scene=new Scene(root1,800,600);
		SceneHandler.init(scene);
		SceneHandler.add("LOGIN",root1);
		SceneHandler.add("AFTERLOGIN",root2);
		SceneHandler.add("REGISTRAZIONE",root3);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args)
	{
		launch(args);
	}

}
