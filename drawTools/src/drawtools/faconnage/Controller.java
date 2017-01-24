package drawtools.faconnage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
    
    @FXML
    private ChoiceBox<Integer> diametreBox = new ChoiceBox<>();  
    
    @FXML
    private TextField diametreD1;

    @FXML
    private TextField diametreD2;
    
    @FXML
    private TextField diametreD3;
    
    private List<Diametre> diametres = new ArrayList<Diametre>();
    private int diamSelected;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniDiametres();
        iniListener();
    }    

    private void iniDiametres() {
        diametres.add(new Diametre(6, diametres.size()));
        diametres.add(new Diametre(8, diametres.size()));
        diametres.add(new Diametre(10, diametres.size()));
        diametres.add(new Diametre(12, diametres.size()));
        diametres.add(new Diametre(14, diametres.size()));
        diametres.add(new Diametre(16, diametres.size()));
        diametres.add(new Diametre(18, diametres.size()));
        diametres.add(new Diametre(20, diametres.size()));
        diametres.add(new Diametre(22, diametres.size()));
        diametres.add(new Diametre(26, diametres.size()));
        diametres.add(new Diametre(30, diametres.size()));
        diametres.add(new Diametre(34, diametres.size()));
        diametres.add(new Diametre(40, diametres.size()));     

        diametres.forEach((diam) -> diametreBox.getItems().add(diam.getDiam()));
    }
    
    private void iniListener() {
        diametreBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov, Number value, Number new_value){
                updateValues((int) new_value);
            }
        });       
        
        //Choice of start diam selected 0->6 | 1->8 | 2->10...
        diametreBox.getSelectionModel().select(2);
    }
    
    private void updateValues(int diamSelected){
        System.out.println("diamSelected : " + diamSelected);
        Diametre diam = null;
        diam = diametres.stream()
                .filter(tmpDiam->tmpDiam.getId() == diamSelected)
                .findFirst()
                .get();
        
        if(diam!=null)
        {
            diametreD1.setText(Integer.toString(diam.getD1()));
            diametreD2.setText(Integer.toString(diam.getD2()));
            diametreD3.setText(Integer.toString(diam.getD3()));
        }
    }
}
