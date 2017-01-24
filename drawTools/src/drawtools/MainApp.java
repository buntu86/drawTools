package drawtools;

import drawtools.faconnage.Diametre;
import drawtools.root.RootLayoutController;
import static drawtools.utils.Log.msg;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author adrien.pillonel
 */
public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    public MainApp(){
    }
    
    public static void main(String[] args) {
        launch(args);   
    }    

    @Override
    public void start(Stage primaryStage) { 
        this.primaryStage = primaryStage;
        setTitlePrimaryStage("");
        showRootLayout();        
    }
    
    public void showRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/drawtools/root/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);           
            controller.iniListener();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            msg(1, "Error RootLayout.fxml | " + e.getMessage());
        }
    }           
    public Stage getPrimaryStage() {
        return this.primaryStage;
    }
    
    public void setTitlePrimaryStage(String str)
    {
        if(!str.isEmpty())
            str = " - " + str;
        this.primaryStage.setTitle("drawTools" + str);
    }    
    
    public BorderPane getRootLayout(){
        return rootLayout;
    }
}
