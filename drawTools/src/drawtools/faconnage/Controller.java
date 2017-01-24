package drawtools.faconnage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        diametres.add(new Diametre(6, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(8, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(10, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(12, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(14, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(16, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(18, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(20, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(22, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(26, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(30, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(34, diametres.lastIndexOf(this)+1));
        diametres.add(new Diametre(40, diametres.lastIndexOf(this)+1));     

        diametres.forEach((diam) -> diametreBox.getItems().add(diam.getDiam()));
        
        diametreBox.getSelectionModel().select(0);  
        updateValues(6);
    }
    
    private void iniListener() {
        diametreBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov, Number value, Number new_value){
                updateValues((int) new_value);
            }
        });       
    }
    
    private void updateValues(int diamSelected){
        System.out.println(diamSelected);
        Diametre str = diametres.stream()
                .filter(diam->diam.getId() == diamSelected)
                .findFirst()
                .get();
        
        if(!str.equals(null))
        System.out.print("diam:" + str.getDiam());
        /*System.out.print(" | D1:" + str.get().getD1());
        System.out.print(" | D2:" + str.get().getD2());
        System.out.println(" | D3:" + str.get().getD3());*/
    }
}
