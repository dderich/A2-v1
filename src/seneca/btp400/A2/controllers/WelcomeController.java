package seneca.btp400.A2.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ruby Anne Bautista, Daniel Derich
 * @since 2020-03-27
 * @version 2.0
 * Controller for the Welcome scene. Moves the user, admin to the login scene
 */
public class WelcomeController implements Initializable {

    @FXML
    Button LoginBtn; // User Login
    @FXML
    Button AdminBtn;
    
    /**
     * Moves the user into the Login scene
     * @param event Click
     * @throws IOException
     */
    @FXML
    private void LoginAction(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("../resources/fxml/Login.fxml"));
        Scene loginScene = new Scene(login);

        //get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    @FXML
    private void AdminLoginAction(ActionEvent event) throws IOException {
        Parent alogin = FXMLLoader.load(getClass().getResource("../resources/fxml/AdminLogin.fxml"));
        Scene adminloginScene = new Scene(alogin);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(adminloginScene);
        window.show();
    }
    
    //add new voter- for Daniel
    //TODO: Implement method that activated upon pressing 'Add new voter'
    //This is will need new table in database that contains users with this privilege
    //Todo: add table in database for admins and managers- people who can edit the student info
    //look in dao -R
    private void addNewVoter(ActionEvent event){
        //change the page into the addNewVoter


    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
