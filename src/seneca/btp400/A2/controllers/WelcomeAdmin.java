package seneca.btp400.A2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seneca.btp400.A2.model.Administrator;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class WelcomeAdmin implements Initializable {
	Administrator admin;
	@FXML
	Button viewCandidates;
	@FXML
	Button addVoterBtn;
	@FXML
	Button changePassword;
	@FXML
	Label welcomeMessageLbl;
	@FXML
	Button logOut;
	@FXML
	Button addCandidatebtn;
	@FXML
	Button deleteCandidatebtn;



	public void initData(Administrator admin) {
		this.admin = admin;
		welcomeMessageLbl.setText("Welcome, "+ this.admin.getFullName());
	}

	@FXML
	private void addCandidate(ActionEvent event) throws IOException{
		//link to addCandidate
		Parent addC = FXMLLoader.load(getClass().getResource("../resources/fxml/AddCandidate.fxml"));
		Scene addCScene = new Scene(addC);

		// get stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(addCScene);
		window.show();
	}

	@FXML
	private void deleteCandidate(ActionEvent event)throws IOException{
		//link to deleteCandidate
		Parent deleteC = FXMLLoader.load(getClass().getResource("../resources/fxml/DeleteCandidate.fxml"));
		Scene deleteCscene = new Scene(deleteC);

		// get stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(deleteCscene);
		window.show();
	}

	@FXML
	private void logAdminOut (ActionEvent event) throws IOException{
        admin = null;
        Parent welcome = FXMLLoader.load(getClass().getResource("../resources/fxml/AdminLogin.fxml"));
        Scene welcomeScene = new Scene(welcome);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }
	
	@FXML
	private void addVoter (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/addNewVoter.fxml"));
		Parent welcomeAdmin = loader.load();

		Scene welcomeAdminScene = new Scene(welcomeAdmin);

		AddNewVoterController controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(welcomeAdminScene);
		window.show();
	}
	
	@FXML
	private void getVotingResults (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/ViewCandidateResults.fxml"));
		Parent welcomeAdmin = loader.load();

		Scene welcomeAdminScene = new Scene(welcomeAdmin);

		ViewCandidateResults controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(welcomeAdminScene);
		window.show();
	}
	
	@FXML
	private void passwordCh (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../resources/fxml/AdminChangePassword.fxml"));
		Parent welcomeAdmin = loader.load();

		Scene scene = new Scene(welcomeAdmin);

		AdminChangePassword controller = loader.getController();
		controller.setAdmin(admin);
		admin = null;

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
