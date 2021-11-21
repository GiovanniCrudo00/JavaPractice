package Controllers;
import java.sql.SQLException;
import java.util.regex.Pattern;
import Application.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public class ControllerLogin {

    @FXML
     Button Login_Button;

    @FXML
    private AnchorPane Loginroot;
    @FXML
    private ToggleButton Dark_mode=new ToggleButton();
    @FXML
    private TextField Userane;

    @FXML
    private PasswordField Password;
    @FXML
    void Login_Attempt(ActionEvent event) throws SQLException {
    	String Pass=Password.getText();
    	if (Pattern.matches( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%_^&+=])(?=\\S+$).{8,}$", Pass)) {
    		String User=Userane.getText();
    		boolean isok=Database.Checkuser(User, Pass);
    		if(!isok) {
    			Alert errorAlert = new Alert(AlertType.ERROR);
        		errorAlert.setHeaderText("Accesso negato");
        		errorAlert.setContentText("username o password errati");
        		errorAlert.showAndWait();
    		}
    		else {
    		// implementare pagina principale
    		}
    		
    	}
    	else {
    		Alert errorAlert = new Alert(AlertType.ERROR);
    		errorAlert.setHeaderText("Password non valida");
    		errorAlert.setContentText("la Password deve contenere almeno un numero,una lettera maiuscola,una minuscola e un carattere speciale");
    		errorAlert.showAndWait();
    	}
    }
    @FXML
    void Set_Dark(ActionEvent event) {
    	if (Dark_mode.isSelected()) Loginroot.setStyle("-fx-base:black");
    	else Loginroot.setStyle("");
    }

}
