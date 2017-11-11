package GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ReversePolishNotation.CalcInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import FourierSeries.*;

public class FXMLConversionController implements Initializable {

	final private double INCH_TO_METER = 0.0254;
	final private double FOOT_TO_METER = 0.3048;
	final private double MILE_TO_METER = 1609.344;
	final private double MM_TO_METER = 0.001;
	final private double CM_TO_METER = 0.01;
	final private double KM_TO_METER = 1000;
	final private double YD_TO_METER = 0.9144;
	final private double GALLON_TO_LITER = 3.78541178;
	final private double PINT_TO_LITER = 0.473176473;
	final private double MILLILITER_TO_LITER = 0.001;
	final private double CUBIC_METER_TO_LITER = 1000.000;
	final private double POUND_TO_KG = 0.45359237;
	final private double OUNCE_TO_KG = 0.0283495231;
	final private double STONE_TO_KG = 6.35029318;
	private double factor;
	private String choice = "from";
	
	String answer = "clear";
    
    @FXML
    private TextField textFieldConvResult;
    @FXML
    private TextField textFieldValueConvert;
    @FXML
    private Button buttonConvert;
    @FXML
    private ComboBox<String> comboBoxConvert;
    @FXML
    private ComboBox<String> comboBoxUnitsLiters;
    @FXML
    private ComboBox<String> comboBoxUnitsMeters;
    @FXML
    private ComboBox<String> comboBoxUnitsKgs; 
    @FXML
    private RadioButton radioButtonFrom;
    @FXML
    private RadioButton radioButtonTo;
 	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboBoxConvert.getItems().removeAll(comboBoxConvert.getItems());
		comboBoxConvert.getItems().addAll("Meters", "Liters", "Kgs");
		comboBoxConvert.getSelectionModel().select("Meters");
		comboBoxUnitsMeters.getItems().removeAll(comboBoxUnitsMeters.getItems());
		comboBoxUnitsMeters.getItems().addAll("in", "ft", "mi", "mm", "cm", "km", "yd");
		comboBoxUnitsMeters.getSelectionModel().select("in");
		comboBoxUnitsLiters.getItems().removeAll(comboBoxUnitsLiters.getItems());
		comboBoxUnitsLiters.getItems().addAll("gallons", "pints", "milliliters", "cubic meters");
		comboBoxUnitsLiters.getSelectionModel().select("gallons");
		comboBoxUnitsKgs.getItems().removeAll(comboBoxUnitsKgs.getItems());
		comboBoxUnitsKgs.getItems().addAll("pounds", "ounces", "stones");
		comboBoxUnitsKgs.getSelectionModel().select("pounds");


		final ToggleGroup group = new ToggleGroup();

		radioButtonTo.setToggleGroup(group);
		radioButtonFrom.setToggleGroup(group);
		radioButtonFrom.setSelected(true);

		
		comboBoxUnitsMeters.setVisible(true);
		comboBoxUnitsLiters.setVisible(false);
		comboBoxUnitsKgs.setVisible(false);
	}
	
    @FXML
    void onActionComboBoxConvert(ActionEvent event) {
    	String output = comboBoxConvert.getSelectionModel().getSelectedItem().toString();
	    if(output.equalsIgnoreCase("Meters")){
	    	comboBoxUnitsMeters.setVisible(true);
			comboBoxUnitsLiters.setVisible(false);
			comboBoxUnitsKgs.setVisible(false);
	    }else if(output.equalsIgnoreCase("Liters")){
	    	comboBoxUnitsMeters.setVisible(false);
			comboBoxUnitsLiters.setVisible(true);
			comboBoxUnitsKgs.setVisible(false);
	    }else if(output.equalsIgnoreCase("Kgs")){
	    	comboBoxUnitsMeters.setVisible(false);
			comboBoxUnitsLiters.setVisible(false);
			comboBoxUnitsKgs.setVisible(true);
	    }
    }
    
    @FXML
    void onActionComboBoxUnitsMeters(ActionEvent event) {
    	String unit = comboBoxUnitsMeters.getSelectionModel().getSelectedItem().toString();
    	if(unit.equalsIgnoreCase("in")){
			factor= INCH_TO_METER;
		}else if(unit.equalsIgnoreCase("ft")){
			factor = FOOT_TO_METER;
		}else if(unit.equalsIgnoreCase("mi")){
			factor = MILE_TO_METER;
		}else if(unit.equalsIgnoreCase("mm")){
			factor = MM_TO_METER;
		}else if(unit.equalsIgnoreCase("cm")){
			factor = CM_TO_METER;
		}else if(unit.equalsIgnoreCase("km")){
			factor = KM_TO_METER;
		}else if(unit.equalsIgnoreCase("yd")){
			factor = YD_TO_METER;
		}
    }

    @FXML
    void onActionComboBoxUnitsLiters(ActionEvent event) {
    	String unit = comboBoxUnitsLiters.getSelectionModel().getSelectedItem().toString();
    	if(unit.equalsIgnoreCase("gallons")){
			factor= GALLON_TO_LITER;
		}else if(unit.equalsIgnoreCase("pints")){
			factor = PINT_TO_LITER;
		}else if(unit.equalsIgnoreCase("milliliters")){
			factor = MILLILITER_TO_LITER;
		}else if(unit.equalsIgnoreCase("cubic meters")){
			factor = CUBIC_METER_TO_LITER;
		}
    }
    
    @FXML
    void onActionComboBoxUnitsKgs(ActionEvent event) {
    	String unit = comboBoxUnitsKgs.getSelectionModel().getSelectedItem().toString();
    	if(unit.equalsIgnoreCase("pounds")){
			factor= POUND_TO_KG;
		}else if(unit.equalsIgnoreCase("ounces")){
			factor = OUNCE_TO_KG;
		}else if(unit.equalsIgnoreCase("stones")){
			factor = STONE_TO_KG;
		}
    }

    @FXML
    void onActionRadioButtonFrom(ActionEvent event) {
    	if(radioButtonFrom.isSelected()){
    		choice = "from";
    	}
    }

    @FXML
    void onActionRadioButtonTo(ActionEvent event) {
    	if(radioButtonTo.isSelected()){
    		choice = "to";
    	}
    }
    
    public double toOrFromConvert(String what, double measurment){
		if(what.equalsIgnoreCase("to")){
			return (measurment*factor);
		}else{
			return(measurment / factor);
		}
	}
    
    @FXML
    void onActionButtonConvert(ActionEvent event) {
    	double val = Double.parseDouble(textFieldValueConvert.getText());
    	double res = toOrFromConvert(choice, val);
    	textFieldConvResult.setText(""+res);

    }

}
