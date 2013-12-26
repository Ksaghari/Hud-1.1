/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dashone;

import static dashone.DashOne.screen1ID;
import static dashone.DashOne.screen2ID;
import static dashone.DashOne.screen4ID;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 * FXML Controller class
 *
 * @author ksaghari
 */
public class ControlSystemController implements Initializable, ControlledScreen {
    
    ScreensController myController; 

    @FXML private Button goToMain;
    @FXML private Button goToEngineStats;
    @FXML private Button goToHVStats;
    
    @FXML private Label drivingMode;
    @FXML private Label throttlePosition;
    @FXML private Label brakePosition;
    @FXML private Label clutchStatus;
    @FXML private Label torqueStatus;
   
    @Override
    public void setScreenParent(ScreensController screenParent) { 
        myController = screenParent; 
    }
    @FXML
    private void toMain(ActionEvent event) { 
        myController.setScreen(screen1ID);
    }
    @FXML 
    private void toEngineStats(ActionEvent event) { 
        myController.setScreen(screen2ID);
    }
    @FXML
    private void toHVStats(ActionEvent event) {
        myController.setScreen(screen4ID);
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        drivingMode.setText("\tTest");
        brakePosition.setText("\tTest");
        clutchStatus.setText("\tTest");
        throttlePosition.setText("\tTest");
        torqueStatus.setText("\tTest");
    }    
}
