package drawtools.root;

import drawtools.MainApp;
import drawtools.echelle.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class RootLayoutController {

    private MainApp mainApp;

    @FXML
    private TabPane rootTabPane = new TabPane();
    
    @FXML
    private void handleExit(){
        System.exit(0);
    }

    public RootLayoutController(){      
    }      
    
    public void showEchelle(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/drawtools/echelle/Viewer.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Controller echelleController = loader.getController();
            rootTabPane.getSelectionModel().getSelectedItem().setContent(page);
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }    
}
