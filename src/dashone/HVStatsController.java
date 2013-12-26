/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dashone;

import static dashone.DashOne.screen1ID;
import static dashone.DashOne.screen2ID;
import static dashone.DashOne.screen3ID;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author ksaghari
 */
public class HVStatsController implements Initializable, ControlledScreen {
    ScreensController myController; 
   
    @FXML private Label pageTitle; 
    
    @FXML private Button goToMain; 
    @FXML private Button goToEngineStats;
    @FXML private Button goToControlSystem;
    
    @FXML private ProgressIndicator socCharge;
    
    @FXML private LineChart<Double, Double> motorTemp;
    @FXML private LineChart<Double, Double> battTemp; 
    
    @FXML private NumberAxis motorTempXAxis;
    @FXML private NumberAxis battTempXAxis;
    
    @FXML private NumberAxis motorTempYAxis;
    @FXML private NumberAxis battTempYAxis;
    
    @FXML private TextArea warningLog; 
    
    private final ObservableList<XYChart.Series<Double, Double>> motorTempDataList = FXCollections.observableArrayList();
    private final ObservableList<XYChart.Series<Double, Double>> battTempDataList = FXCollections.observableArrayList();
    
    private final LineChart.Series<Double, Double> testMotorDataSeries = new LineChart.Series();
    private final LineChart.Series<Double, Double> testBattDataSeries = new LineChart.Series(); 
    
    private int sinVal = 0; private int cosVal = 0;  
    
    @Override
    public void setScreenParent(ScreensController screenParent) { 
        myController = screenParent; 
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
    private void toEngineStats(ActionEvent event) {
        myController.setScreen(screen2ID);
    }
    
    private void initializeMotorTemperatureChart() { 
        testMotorDataSeries.setName("Motor Temperature Test");
        for(double i = 0; i < 5; i++) { 
            testMotorDataSeries.getData().add(new XYChart.Data<>((double)sinVal,Math.sin(sinVal)));
            sinVal++; 
        }
        motorTempDataList.add(testMotorDataSeries); 
        motorTemp.setData(motorTempDataList);
        motorTemp.createSymbolsProperty(); 
    }
    
    private void initilizeBattTemperatureChart() { 
       testBattDataSeries.setName("Battery Temperature Test");
       for(double i = 0; i < 5; i ++) {
           testBattDataSeries.getData().add(new XYChart.Data<>((double)cosVal, Math.cos(cosVal))); 
           cosVal++; 
       }
       battTempDataList.add(testBattDataSeries);
       battTemp.setData(battTempDataList);
       battTemp.createSymbolsProperty(); 
    }
    
    @FXML 
    private void addRandomToMotorTemp() {
        updateMotorTemperatureChart();
    }
        
    @FXML
    private void addRandomToBatteryTemp() {
        updateBatteryTempratureChart();
    }
    
    @FXML
    private void removeFromBatteryTemp() {
        testBattDataSeries.getData().remove(0); 
    }
    
    @FXML
    private void removeFromMotorTemp() {
        testMotorDataSeries.getData().remove(0);
    }
        
    private void updateMotorTemperatureChart() {
        testMotorDataSeries.getData().add(new XYChart.Data<>((double)sinVal, Math.sin(sinVal))); 
        warningLog.appendText("Motor data added:\t"+testMotorDataSeries.getData().get(testMotorDataSeries.getData().size()-1)+".\n");
        sinVal++; 
    }
    
    private void updateBatteryTempratureChart() {
        testBattDataSeries.getData().add(new XYChart.Data<>((double)cosVal, Math.cos(cosVal)));
        warningLog.appendText("Battery data added:\t"+testBattDataSeries.getData().get(testBattDataSeries.getData().size()-1)+".\n");
        cosVal++; 
    }

    /**
     * Initializes the controller class.
     * @param url 
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initilizeBattTemperatureChart(); 
        initializeMotorTemperatureChart();
        socCharge.setProgress(0.75);
    }    
}
