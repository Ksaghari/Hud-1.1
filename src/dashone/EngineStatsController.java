/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dashone;

import static dashone.DashOne.screen1ID;
import static dashone.DashOne.screen3ID;
import static dashone.DashOne.screen4ID;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


/**
 * FXML Controller class
 *
 * @author ksaghari
 */
public class EngineStatsController implements Initializable, ControlledScreen {
    
    ScreensController myController; 
     
    @FXML private Button goToMain;
    @FXML private Button goToControlSystem;
    @FXML private Button goToHVStats;
    
    @FXML private Button override1;
    @FXML private Button override2;
    @FXML private Button override3;
    @FXML private Button override4;
    @FXML private Button override5;
    @FXML private Button override6;
    @FXML private Button override7;
    @FXML private Button override8;
    @FXML private Button override9;
    
    @FXML private TextArea engineStatsField; 
    
    @Override
    public void setScreenParent(ScreensController screenParent) { 
        myController = screenParent; 
    }
    
    @FXML
    private void overridePressed(ActionEvent event) {
        String buttonName = event.getSource().toString().substring(event.getSource().toString().indexOf("override"), event.getSource().toString().indexOf("override")+9);
        engineStatsField.appendText("Override button : " + buttonName + " was pressed. \n");
    }
    
    @FXML
    private void toMain(ActionEvent event) { 
        myController.setScreen(screen1ID);
    }
    @FXML 
    private void toControlSystem(ActionEvent event) { 
        myController.setScreen(screen3ID);
    }
    @FXML
    private void toHVStats(ActionEvent event) {
        myController.setScreen(screen4ID);
    }
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
