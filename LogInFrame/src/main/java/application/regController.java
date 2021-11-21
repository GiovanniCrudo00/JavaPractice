package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class regController {

    @FXML
    private Label saldolab;

    @FXML
    private TextField passArea2;

    @FXML
    private TextField nomeArea;

    @FXML
    private TextField saldoArea;

    @FXML
    private Label cflab;

    @FXML
    private Label cognomelab;

    @FXML
    private TextField passArea;

    @FXML
    private Button logoutbutt2;

    @FXML
    private Label nomelab;

    @FXML
    private Label passlab2;

    @FXML
    private TextField cognomeArea;

    @FXML
    private Label passlab;

    @FXML
    private Button regExecButt;

    @FXML
    private TextField cfArea;

    @FXML
    void execReg(ActionEvent event) throws SQLException 
    {
    	String url="jdbc:sqlite:banca.db"; 
		@SuppressWarnings("unused")
		Connection con=DriverManager.getConnection(url);
		//if(con!=null && !con.isClosed()) System.out.println("Connesso");
    	String cf=cfArea.getText();
    	String nome=nomeArea.getText();
    	String cognome=cognomeArea.getText();
    	String originalPass=passArea.getText();
    	String pass2=passArea2.getText();
    	String saldo=saldoArea.getText();
    	if(originalPass.equals(pass2))
    	{
	    	String pass=BCrypt.hashpw(originalPass, BCrypt.gensalt(12));
	    	boolean is_here=false;
	    	String query1="SELECT codiceFiscale FROM users;";
	    	PreparedStatement stmt=con.prepareStatement(query1);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				String cfT=rs.getString("codiceFiscale");
				if(cfT.equals(cf)) is_here=true;
			}
			stmt.close();
			if(is_here)
			{
				Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Errore");
		        alert.setHeaderText("Database says:");
		        alert.setContentText("Codice fiscale già presente");
		        alert.showAndWait();
			}
			else
			{
				String query="INSERT INTO users (codiceFiscale,nome,cognome,password,saldo) VALUES ('"+cf+"','"+nome+"','"+cognome+"','"+pass+"','"+saldo+"');";
				Statement stmt1=con.createStatement();
				stmt1.executeUpdate(query);
				stmt1.close();
				Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Successo");
		        alert.setHeaderText("Database says:");
		        alert.setContentText("Utente registrato");
		        alert.showAndWait();
			}
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Errore");
	        alert.setHeaderText("Password non corrette");
	        alert.setContentText("Hai digitato due password diverse");
	        alert.showAndWait();
    	}
    	
    }

    @FXML
    void logout2(ActionEvent event) 
    {
    	passArea.clear();
    	nomeArea.clear();
    	cognomeArea.clear();
    	cfArea.clear();
    	passArea2.clear();
    	saldoArea.clear();
    	SceneHandler.setCurrent("LOGIN");
    }

}
