package drawtools.echelle;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    @FXML
    private ChoiceBox<String> uniteBox = new ChoiceBox<>();  
    
    @FXML
    private TextField echelleTextField, aTextField, bTextField;
    
    @FXML
    private Label echelleLabel;

    @FXML
    private Label annot2mm;
    @FXML
    private Label annot25mm;
    @FXML
    private Label annot35mm;    
    @FXML
    private Label annot5mm;    
    @FXML
    private Label annot7mm;

    @FXML
    private Label echelle2mm;
    @FXML
    private Label echelle25mm;
    @FXML
    private Label echelle35mm;    
    @FXML
    private Label echelle5mm;    
    @FXML
    private Label echelle7mm;
    


    private int idEchelle=1, valueEchelleInt=50;
    private double unite;
    private String valueEchelleStr="50";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uniteBox.getItems().add("mm"); //idEchelle 0
        uniteBox.getItems().add("cm"); //idEchelle 1
        uniteBox.getItems().add("m"); //idEchelle 2
        uniteBox.getSelectionModel().select(1);
        echelleTextField.setText("50");
        updateValues(idEchelle, valueEchelleStr);
    }    
    
    public void iniListener()
    {
        uniteBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue ov, Number value, Number new_value){
                updateValues(new_value.intValue(), valueEchelleStr);
            }
        });    

        echelleTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            updateValues(idEchelle, newValue);
        });
    }
    
    private void updateValues(int idEchelle, String valueEchelleStr){
        switch (idEchelle) {
            case 0:
                unite=1;
                break;
            case 1:
                unite=0.1;
                break;
            case 2:
                unite=0.001;
                break;
            default:
                unite=0.1;
                break;
        }
        this.idEchelle=idEchelle;
        setValueEchelle(valueEchelleStr);
        
        if(!valueEchelleStr.isEmpty())
        {
            DecimalFormat format = new DecimalFormat();
            format.setDecimalSeparatorAlwaysShown(false);   
            //DecimalFormat format=new DecimalFormat("#.#");
            
            bTextField.setText("" + unite * Integer.parseInt(valueEchelleStr.trim()));
            echelleLabel.setText("Echelle 1:" + valueEchelleStr);

            annot2mm.setText(format.format(2 * unite));
            annot25mm.setText(format.format(2.5 * unite));
            annot35mm.setText(format.format(3.5 * unite));
            annot5mm.setText(format.format(5 * unite));
            annot7mm.setText(format.format(7 * unite));

            echelle2mm.setText(format.format(2 * unite * valueEchelleInt));
            echelle25mm.setText(format.format(2.5 * unite * valueEchelleInt));
            echelle35mm.setText(format.format(3.5 * unite * valueEchelleInt));
            echelle5mm.setText(format.format(5 * unite * valueEchelleInt));
            echelle7mm.setText(format.format(7 * unite * valueEchelleInt));
        }
        else
        {
            bTextField.setText("");
            echelleLabel.setText("Echelle - ");
            annot2mm.setText("-");
            annot25mm.setText("-");
            annot35mm.setText("-");
            annot5mm.setText("-");
            annot7mm.setText("-");

            echelle2mm.setText("-");
            echelle25mm.setText("-");
            echelle35mm.setText("-");
            echelle5mm.setText("-");
            echelle7mm.setText("-");
        }
        
        System.out.println(idEchelle + " - 1:" + valueEchelleStr + " - " + unite);
    }

    private void setValueEchelle(String valueEchelle) {
        this.valueEchelleStr = valueEchelle;

        try{
            this.valueEchelleInt = Integer.parseInt(valueEchelle.trim());
        }catch(Exception e){
            this.valueEchelleInt = 0;
        }
    }
}
