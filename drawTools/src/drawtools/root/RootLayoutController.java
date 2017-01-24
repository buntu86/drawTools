package drawtools.root;

import drawtools.MainApp;
import drawtools.echelle.Controller;
import static drawtools.utils.Log.msg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
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
    
    public void iniListener(){
        showEchelle();
        rootTabPane.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                switch(rootTabPane.getSelectionModel().getSelectedIndex()){
                    case 0:     showEchelle();
                                break;
                    case 1:     showFaconnage();
                                break;
                    default:    showEchelle();
                                break;
                }
            }
        }
        );        
    }
    
    public void showEchelle(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/drawtools/echelle/Viewer.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Controller echelleController = loader.getController();
            echelleController.iniListener();
            rootTabPane.getSelectionModel().getSelectedItem().setContent(page);
        } catch (Exception e) {
            msg(1, "Error Viewer.fxml | " + e.getMessage());
        }
    }

    public void showFaconnage(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/drawtools/faconnage/Viewer.fxml"));
            AnchorPane page2 = (AnchorPane) loader.load();
            //Controller faconnageController = loader.getController();
            //faconnageController.iniListener();
            rootTabPane.getSelectionModel().getSelectedItem().setContent(page2);
        } catch (Exception e) {
            msg(1, "Error Viewer.fxml | " + e.getMessage());
        }
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }    
}
