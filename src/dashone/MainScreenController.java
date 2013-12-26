/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dashone;

import static dashone.DashOne.screen2ID;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
/**
 *
 * @author ksaghari
 */
public class MainScreenController implements Initializable, ControlledScreen {
    
    ScreensController myController; 
    
    @FXML private Button incBut;
    @FXML private Button decBut;
    
    @FXML private ProgressIndicator fuelLevel;
    @FXML private ProgressIndicator battLevel;
    
    @FXML private Label fuel;
    @FXML private Label battery;
    @FXML private Label kph; 
        
    @FXML private Text velocityField; 
    @FXML private Text rpmField; 
    @FXML private Text fuseText;
    @FXML private Text safeText;
    @FXML private Text controlText;
    @FXML private Text batteryText;
   
    @FXML private ProgressBar rpmGauge;
    @FXML private ProgressBar socBar;
    @FXML private ProgressBar muBar;
    @FXML private ProgressBar hvBar;
    
    @FXML private Rectangle redLayer;
    @FXML private Rectangle amberLayer;
    @FXML private Rectangle greenLayer;
    
    private double incrementHolder = 0.0;
    private int mapKey = 0;
    
    private static final HashMap<Integer, String> rpmMap = new HashMap();
    
    private void fillMap() { 
        for(int i = 0; i <= 11; i += 1) {
            switch(i) {
                case(0):    rpmMap.put(0, "N"); break;
                case(1):    rpmMap.put(1, "G 1"); break;
                case(2):    rpmMap.put(2, "G 2"); break;
                case(3):    rpmMap.put(3, "G 3"); break;
                case(4):    rpmMap.put(4, "G 4"); break;
                case(5):    rpmMap.put(5, "G 5"); break;
                case(6):    rpmMap.put(6, "G 6"); break;
                case(7):    rpmMap.put(7, "R"); break;
                case(8):    rpmMap.put(8, "--"); break;
                case(9):    rpmMap.put(9, "--"); break;
                case(10):   rpmMap.put(10, "MAX"); break;
                default:    break; 
            }
        } 
    }

    @FXML
    private void incrementAction() {
        incrementHolder = (incrementHolder >= 1) ? (incrementHolder + 0.000000) : (incrementHolder + 0.100000);
        mapKey = (mapKey == 10) ? (mapKey + 0) : (mapKey + 1);
        fuelLevel.setProgress(incrementHolder);
        battLevel.setProgress(incrementHolder);
        
        fuseText.setOpacity(incrementHolder);
        controlText.setOpacity(incrementHolder);
        safeText.setOpacity(incrementHolder);
        batteryText.setOpacity(incrementHolder);
        
      //  rpmGauge.setProgress(incrementHolder);
        
        socBar.setProgress(incrementHolder);
        muBar.setProgress(incrementHolder);
        hvBar.setProgress(incrementHolder);
        
        velocityField.setText(""+(mapKey*10));
        rpmField.setText(rpmMap.get(mapKey));
        updateRPMGauge();

    }
    
    @FXML
    private void decrementAction() {
        incrementHolder = (incrementHolder <= 0) ? (incrementHolder + 0.000000) : (incrementHolder - 0.100000);
        mapKey = (mapKey == 0) ? (mapKey + 0) : (mapKey - 1);
        fuelLevel.setProgress(incrementHolder);
        battLevel.setProgress(incrementHolder);
        
        fuseText.setOpacity(incrementHolder);
        controlText.setOpacity(incrementHolder);
        safeText.setOpacity(incrementHolder);
        batteryText.setOpacity(incrementHolder);
        
      //  rpmGauge.setProgress(incrementHolder);
        
        socBar.setProgress(incrementHolder);
        muBar.setProgress(incrementHolder);
        hvBar.setProgress(incrementHolder);
        
        velocityField.setText(""+(mapKey*10));
        rpmField.setText(rpmMap.get(mapKey));
        updateRPMGauge();
    }
    
    private void updateRPMGauge() {
        switch(mapKey) {
            case(0):            greenLayer.setOpacity(1.0);
                                amberLayer.setOpacity(0.0);
                                redLayer.setOpacity(0.0);
                                break; 
            case(1):            greenLayer.setOpacity(0.9);
                                amberLayer.setOpacity(0.1);
                                redLayer.setOpacity(0.0);
                                break; 
            case(2):            greenLayer.setOpacity(0.8);
                                amberLayer.setOpacity(0.2);
                                redLayer.setOpacity(0.0);
                                break; 
            case(3):            greenLayer.setOpacity(0.7);
                                amberLayer.setOpacity(0.3);
                                redLayer.setOpacity(0.0);
                                break; 
            case(4):            greenLayer.setOpacity(0.6);
                                amberLayer.setOpacity(0.4);
                                redLayer.setOpacity(0.0);
                                break; 
            case(5):            greenLayer.setOpacity(0.5);
                                amberLayer.setOpacity(0.5);
                                redLayer.setOpacity(0.0);
                                break; 
            case(6):            greenLayer.setOpacity(0.25);
                                amberLayer.setOpacity(0.6);
                                redLayer.setOpacity(0.1);
                                break; 
            case(7):            greenLayer.setOpacity(0.0);
                                amberLayer.setOpacity(0.75);
                                redLayer.setOpacity(0.25);
                                break; 
            case(8):            greenLayer.setOpacity(0.0);
                                amberLayer.setOpacity(0.75);
                                redLayer.setOpacity(0.5);
                                break; 
            case(9):            greenLayer.setOpacity(0.0);
                                amberLayer.setOpacity(0.25);
                                redLayer.setOpacity(0.85);
                                break; 
            case(10):           greenLayer.setOpacity(0.0);
                                amberLayer.setOpacity(0.0);
                                redLayer.setOpacity(1.0);
                                break;
                
            default:            break;              
        }
    }
    
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent; 
    }
    
    @FXML
    private void goToEngineStats() { 
        myController.setScreen(screen2ID); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillMap();  
        updateRPMGauge();
        fuelLevel.setProgress(incrementHolder);
        battLevel.setProgress(incrementHolder);
        
        fuseText.setOpacity(incrementHolder);
        controlText.setOpacity(incrementHolder);
        safeText.setOpacity(incrementHolder);
        batteryText.setOpacity(incrementHolder);
        
      //  rpmGauge.setProgress(incrementHolder);
        
        socBar.setProgress(incrementHolder);
        muBar.setProgress(incrementHolder);
        hvBar.setProgress(incrementHolder);
        
        velocityField.setText(""+(mapKey*10));
        rpmField.setText(rpmMap.get(mapKey));
    }   
}
