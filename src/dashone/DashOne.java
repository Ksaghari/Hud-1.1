/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dashone;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ksaghari
 */
public class DashOne extends Application {
    
    public static final String screen1ID = "MainScreenController";
    public static final String screen1File = "MainScreen.fxml"; 
    public static final String screen2ID = "EngineStatsController"; 
    public static final String screen2File = "EngineStats.fxml"; 
    public static final String screen3ID = "ControlSystemController"; 
    public static final String screen3File = "ControlSystem.fxml"; 
    public static final String screen4ID = "HVStatsController"; 
    public static final String screen4File = "HVStats.fxml"; 
    
    
    @Override
    public void start(Stage primaryStage) {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(screen1ID, screen1File);
        mainContainer.loadScreen(screen2ID, screen2File);
        mainContainer.loadScreen(screen3ID, screen3File);
        mainContainer.loadScreen(screen4ID, screen4File);
        
        mainContainer.setScreen(DashOne.screen1ID);
        
        Group root = new Group(); 
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }  
}
