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
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class Controller implements Initializable {
    
    @FXML
    private ChoiceBox<Integer> diametreBox = new ChoiceBox<>();  
    
    @FXML
    private TextField diametreD1;

    @FXML
    private TextField diametreD2;
    
    @FXML
    private TextField diametreD3;
    
    @FXML
    private Slider slider = new Slider();
    
    private List<Diametre> diametres = new ArrayList<Diametre>();
    private int diamSelected;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniDiametres();
        iniListener();
        iniSlider();
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
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateValues((int) newValue.intValue());
        });
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

    private void iniSlider() {
        slider.setMin(0);
        slider.setMax(12);
        slider.setValue(2);
        slider.setMinorTickCount(0);
        slider.setMajorTickUnit(1);
        slider.setSnapToTicks(true);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);        
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if (n==0) return "6";
                if (n==1) return "8";
                if (n==2) return "10";
                if (n==3) return "12";
                if (n==4) return "14";
                if (n==5) return "16";
                if (n==6) return "18";
                if (n==7) return "20";
                if (n==8) return "22";
                if (n==9) return "26";
                if (n==10) return "30";
                if (n==11) return "34";
                
                return "40";
                
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "6":
                        return 0d;
                    case "8":
                        return 1d;
                    case "10":
                        return 2d;
                    case "12":
                        return 3d;
                    case "14":
                        return 4d;                        
                    case "16":
                        return 5d;                        
                    case "18":
                        return 6d;
                    case "20":
                        return 7d;
                    case "22":
                        return 8d;
                    case "26":
                        return 9d;
                    case "30":
                        return 10d;
                    case "34":
                        return 11d;
                    default:
                        return 12d;
                }
            }
        }); 
    }
}
