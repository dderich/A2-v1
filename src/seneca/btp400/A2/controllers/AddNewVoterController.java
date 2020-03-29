package seneca.btp400.A2.controllers;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * @author Daniel Derich
 * @since 2020-03-28
 * displays form for add new voter. Takes info and puts it into the database
 */

import seneca.btp400.A2.dao.dbAccessObj;
import seneca.btp400.A2.model.Voter;
public class AddNewVoterController  implements Initializable {
    @FXML
    private TextField fnameTyped;   
    @FXML
    private TextField lnameTyped; 
    @FXML
    private TextField stnumTyped;
    @FXML
    private TextField emailTyped;
    @FXML
    private PasswordField passTyped;   
    @FXML
    private Label displayed; 
    @FXML
    private Button backBtn;
    @FXML
    private Button submitBtn;
    @FXML
    private Button resetBtn;
    
    dbAccessObj db;
    Voter voter;

	public boolean createVoter() throws SQLException {
		int studentNumber = Integer.parseInt(stnumTyped.getText());
		ResultSet rs = db.compareVoter(studentNumber, emailTyped.getText()); // checks if student already exists in
																				// database

		if (rs.next() == false) {
			voter = new Voter(studentNumber, fnameTyped.getText(), lnameTyped.getText(), emailTyped.getText(), false);
			voter.setPassword(passTyped.getText());
			db.newVoter(studentNumber, fnameTyped.getText(), lnameTyped.getText(), emailTyped.getText(), passTyped.getText());

			ResultSet check = db.compareVoter(studentNumber, emailTyped.getText()); // checks if student inserted properly
			if (check.next() == true) {
				return true;
			} else {
				displayed.setText("Input Invalid!");
				return false;
			}
		} else {
			displayed.setText("Student already registered!");
			return false;
		}
	}
	
    @FXML
    private void SubmitAction(ActionEvent event) throws IOException, SQLException {
        
       boolean register = createVoter();
      //displayed.setStyle("-fx-font-weight: bold");
        if (register) {
            //displayed.setStyle("-fx-color: green");
            displayed.setText("Successfully registered!");
        } else {
            //displayed.setStyle("-fx-color: red");
        }
    }
    
    @FXML
    private void BackAction(ActionEvent event) throws IOException, SQLException {
    	Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/WelcomeAdmin.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }
    
    
   
    
    
    @FXML
    public void clearDisplay() {
        displayed.setText("");
        fnameTyped.setText("");
        lnameTyped.setText("");
        stnumTyped.setText("");
        emailTyped.setText("");
        passTyped.setText("");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            db = new dbAccessObj();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}