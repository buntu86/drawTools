package drawtools.faconnage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class Controller implements Initializable {
    
    @FXML
    private TextField 
            diametreD1, diametreD2, diametreD3, 
            diametre_aD1, diametre_aD2, diametre_aD3,
            diametre_bD1, diametre_bD2, diametre_bD3,
            diametre_cD1,
            diametre_aCrochet, diametre_bCrochet,            
            diametreAs, diametreKg,
            diametreRecouv50, diametreRecouv60, diametreRecouv70;       
    
    @FXML
    private Slider slider = new Slider();
    
    private List<Diametre> diametres;

    public Controller() {
        this.diametres = new ArrayList<>();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniDiametres();
        iniListener();
        iniSlider();
    }    

    private void iniDiametres() {
        diametres.add(new Diametre(6, diametres.size(),0,0,0,0,40,90,60,60,70,25,50,50));	
        diametres.add(new Diametre(8, diametres.size(),0,0,0,0,50,100,70,70,100,30,80,60));	
        diametres.add(new Diametre(10, diametres.size(),0,0,0,0,60,120,100,90,130,40,100,70));	
        diametres.add(new Diametre(12, diametres.size(),180,310,230,190,70,150,130,110,160,50,120,100));	
        diametres.add(new Diametre(14, diametres.size(),210,370,260,200,80,170,140,130,180,60,140,120));	
        diametres.add(new Diametre(16, diametres.size(),240,420,280,240,100,210,160,150,200,70,160,130));	
        diametres.add(new Diametre(18, diametres.size(),270,470,300,260,110,220,170,170,220,0,0,0));	
        diametres.add(new Diametre(20, diametres.size(),300,520,350,300,120,240,180,180,240,0,0,0));	
        diametres.add(new Diametre(22, diametres.size(),330,570,370,360,180,320,250,250,340,0,0,0));	
        diametres.add(new Diametre(26, diametres.size(),390,680,440,440,210,370,290,290,390,0,0,0));	
        diametres.add(new Diametre(30, diametres.size(),450,780,480,500,240,420,330,330,450,0,0,0));	
        diametres.add(new Diametre(34, diametres.size(),510,880,560,600,340,560,350,440,520,0,0,0));	
        diametres.add(new Diametre(40, diametres.size(),600,1040,680,700,400,640,440,510,640,0,0,0));
    }
    
    private void iniListener() {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateValues((int) newValue.intValue());
        });
    }
    
    private void updateValues(int diamSelected){
        Diametre diam = null;
        diam = diametres.stream()
                .filter(tmpDiam->tmpDiam.getId() == diamSelected)
                .findFirst()
                .get();
        
        if(diam!=null)
        {
            diametreAs.setText(String.format("%1$,.1f", diam.getAs()));
            diametreKg.setText(String.format("%1$,.3f", diam.getKg()));
            diametreRecouv50.setText(Integer.toString(diam.getRecouv50()));
            diametreRecouv60.setText(Integer.toString(diam.getRecouv60()));
            diametreRecouv70.setText(Integer.toString(diam.getRecouv70()));
            
            diametreD1.setText(Integer.toString(diam.getD1()));
            diametreD2.setText(Integer.toString(diam.getD2()));
            diametreD3.setText(Integer.toString(diam.getD3()));
            
            diametre_aD1.setText(Integer.toString(diam.get_aD1()));
            diametre_bD1.setText(Integer.toString(diam.get_bD1()));
            diametre_cD1.setText(Integer.toString(diam.get_cD1()));
            
            diametre_aD2.setText(Integer.toString(diam.get_aD2()));
            diametre_bD2.setText(Integer.toString(diam.get_bD2()));
            
            diametre_aD3.setText(Integer.toString(diam.get_aD3()));
            diametre_bD3.setText(Integer.toString(diam.get_bD3()));
            
            diametre_aCrochet.setText(Integer.toString(diam.get_aCrochet()));
            diametre_bCrochet.setText(Integer.toString(diam.get_bCrochet()));
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
