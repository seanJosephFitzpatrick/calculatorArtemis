package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import Equations.CubicEquations;
import Equations.LinearEquations;
import Equations.QuadraticEquation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLEquationCalcController implements Initializable {

	@FXML
	private ComboBox<String> comboBoxEquation;
	@FXML
	private TextField inputTextFieldA;
	@FXML
	private TextField inputTextFieldB;
	@FXML
	private TextField inputTextFieldC;
	@FXML
	private TextField inputTextFieldD;
	@FXML
	private TextField outputTextFieldX1;
	@FXML
	private TextField outputTextFieldX2;
	@FXML
	private TextField outputTextFieldX3;
	@FXML
	private Button calculate;
	@FXML
	private Label labelA;
	@FXML
	private Label labelB;
	@FXML
	private Label labelC;
	@FXML
	private Label labelD;
	@FXML
	private Button btnCalculate;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBoxEquation.getItems().removeAll(comboBoxEquation.getItems());
		comboBoxEquation.getItems().addAll("Cubic", "Quadratic", "Linear");
		comboBoxEquation.getSelectionModel().select("Cubic");
	}

	@FXML
	void onActionCalculate(ActionEvent event) throws Exception {
		CubicEquations.setX1("");
		CubicEquations.setX2("");
		CubicEquations.setX3("");
		QuadraticEquation.setX1("");
		QuadraticEquation.setX2("");
		
		
		if (comboBoxEquation.getSelectionModel().getSelectedItem().toString().equals("Cubic")) {

			CubicEquations cubicEquations = new CubicEquations();


			double valueA = Double.parseDouble(inputTextFieldA.getText().toString());
			double valueB = Double.parseDouble(inputTextFieldB.getText().toString());
			double valueC = Double.parseDouble(inputTextFieldC.getText().toString());
			double valueD = Double.parseDouble(inputTextFieldD.getText().toString());
			String root = CubicEquations.caclCubicEquation(valueA, valueB, valueC, valueD);

			outputTextFieldX1.setText(CubicEquations.getX1());
			outputTextFieldX2.setText(CubicEquations.getX2());
			outputTextFieldX3.setText(CubicEquations.getX3());

		} else if (comboBoxEquation.getSelectionModel().getSelectedItem().toString().equals("Quadratic")) {

			QuadraticEquation quadraticEquation = new QuadraticEquation();
			double valueA = Double.parseDouble(inputTextFieldA.getText().toString());
			double valueB = Double.parseDouble(inputTextFieldB.getText().toString());
			double valueC = Double.parseDouble(inputTextFieldC.getText().toString());

			String root = QuadraticEquation.caclQuadratic(valueA, valueB, valueC);
			outputTextFieldX1.setText(QuadraticEquation.getX1());
			outputTextFieldX2.setText(QuadraticEquation.getX2());
		} else {

			LinearEquations linearEquations = new LinearEquations();
			double valueA = Double.parseDouble(inputTextFieldA.getText().toString());
			double valueB = Double.parseDouble(inputTextFieldB.getText().toString());
			String root = LinearEquations.caclLinear(valueA, valueB);

			outputTextFieldX1.setText(root);
		}
	}

	@FXML
	void onActionComboBoxEquation(ActionEvent event) {
		String output = comboBoxEquation.getSelectionModel().getSelectedItem().toString();
		if(output.equalsIgnoreCase("Cubic")){
			inputTextFieldA.setVisible(true);
			inputTextFieldB.setVisible(true);
			inputTextFieldC.setVisible(true);
			inputTextFieldD.setVisible(true);
			labelA.setVisible(true);
			labelB.setVisible(true);
			labelC.setVisible(true);
			labelD.setVisible(true);
		}else if(output.equalsIgnoreCase("Quadratic")){
			inputTextFieldA.setVisible(true);
			inputTextFieldB.setVisible(true);
			inputTextFieldC.setVisible(true);
			inputTextFieldD.setVisible(false);
			labelA.setVisible(true);
			labelB.setVisible(true);
			labelC.setVisible(true);
			labelD.setVisible(false);
		}else if(output.equalsIgnoreCase("Linear")){
			inputTextFieldA.setVisible(true);
			inputTextFieldB.setVisible(true);
			inputTextFieldC.setVisible(false);
			inputTextFieldD.setVisible(false);
			labelA.setVisible(true);
			labelB.setVisible(true);
			labelC.setVisible(false);
			labelD.setVisible(false);
		}
	}

}
