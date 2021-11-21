package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class afterLogInController {

    @FXML
    private Button logoutButt;

    @FXML
    private AnchorPane LogOutButt;

    @FXML
    private Label titleLabel2;

    @FXML
    private Button BonificoButton;

    @FXML
    private Label saldoLabel;

    @FXML
    private TextField saldoText;

    @FXML
    void execLogout(ActionEvent event) 
    {
    	saldoText.clear();
    	SceneHandler.setCurrent("LOGIN");
    }

}
