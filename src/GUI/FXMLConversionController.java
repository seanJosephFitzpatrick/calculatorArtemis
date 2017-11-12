package GUI;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLConversionController implements Initializable {

	private double factor;
	private String choice = "from";

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
		factor = conversions.Converter.lengths(unit);
	}

	@FXML
	void onActionComboBoxUnitsLiters(ActionEvent event) {
		String unit = comboBoxUnitsLiters.getSelectionModel().getSelectedItem().toString();
		factor = conversions.Converter.volumes(unit);
	}

	@FXML
	void onActionComboBoxUnitsKgs(ActionEvent event) {
		String unit = comboBoxUnitsKgs.getSelectionModel().getSelectedItem().toString();
		factor = conversions.Converter.weight(unit);
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


	@FXML
	void onActionButtonConvert(ActionEvent event) {
		double val = Double.parseDouble(textFieldValueConvert.getText());
		double res = conversions.Converter.toOrFromConvert(choice, val, factor);
		textFieldConvResult.setText(""+res);

	}

}
