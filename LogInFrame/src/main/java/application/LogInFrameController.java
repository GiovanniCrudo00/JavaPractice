package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LogInFrameController {
	
    @FXML
    private PasswordField passField;

    @FXML
    private Label UserLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private AnchorPane logInpane;

    @FXML
    private TextField UserArea;

    @FXML
    private Label PassLabel;

    @FXML
    private Label creatorLabel;

    @FXML
    private Button logInButt;

    @FXML
    void execLogIn(ActionEvent event) throws SQLException {
    	String url="jdbc:sqlite:banca.db"; 
		@SuppressWarnings("unused")
		Connection con=DriverManager.getConnection(url);
		//if(con!=null && !con.isClosed()) System.out.println("Connesso");
    	String user=UserArea.getText();
    	String pass=passField.getText();
    	String query="SELECT codiceFiscale,password,saldo FROM users;";
    	PreparedStatement stmt=con.prepareStatement(query);
		ResultSet rs=stmt.executeQuery();
		boolean is_here=false;
		String cfT="";
		String checkPass="";
		while(rs.next())
		{
			cfT=rs.getString("codiceFiscale");
			if(cfT.equals(user)) 
			{
				is_here=true;
				checkPass+=rs.getString("password");
				break;
			}
		}
    	if(is_here)//controllo credenziali
    	{
    		if(user.equals(cfT))
    		{
    			boolean matched=BCrypt.checkpw(pass, checkPass);
    			if(matched)
    			{
    				SceneHandler.setCurrent("AFTERLOGIN");
    			}
    			else
    			{
    				Alert alert = new Alert(AlertType.ERROR);
    		        alert.setTitle("Errore");
    		        alert.setHeaderText("Database says:");
    		        alert.setContentText("Password errata");
    		        alert.showAndWait();
    			}
    		}
    		else
    		{
    			Alert alert = new Alert(AlertType.ERROR);
    	        alert.setTitle("Errore");
    	        alert.setHeaderText("Database says:");
    	        alert.setContentText("Username errato");
    	        alert.showAndWait();
    		}
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Errore");
	        alert.setHeaderText("Database says:");
	        alert.setContentText("Username non presente");
	        alert.showAndWait();
    	}
    }
    @FXML
    void reguser(ActionEvent event) 
    {
    	SceneHandler.setCurrent("REGISTRAZIONE");

    }

}

