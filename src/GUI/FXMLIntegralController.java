package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import integrals.SimpsonsRule;

public class FXMLIntegralController {

    @FXML
    private TextField inputTextField;
    
    @FXML
    private TextField topValueTextField;

    @FXML
    private TextField bottomValueTextField;

    @FXML
    private Button calculate;
    
    @FXML
    private TextField outputTextField;

    @FXML
    void OnActionInput(ActionEvent event) {
		    	
    }
    
    @FXML
    void OnActionBottomValue(ActionEvent event) {

    }
    
    @FXML
    void OnActionTopValue(ActionEvent event) {
    }

    @FXML
    void OnActionCalculate(ActionEvent event) {
    	//inputTextField.clear();
    	outputTextField.appendText(inputTextField.getText());
    	SimpsonsRule rule = new SimpsonsRule();

    	double valueA = Double.parseDouble(topValueTextField.getText());
    	System.out.println("value a : "+ valueA);
       	double valueB = Double.parseDouble(bottomValueTextField.getText());
    	double answer = rule.integrate(valueA, valueB, inputTextField.getText(), true);	//boolean value needs to be assigned
    	System.out.println(answer);
    	String str = Double.toString(answer);											//from GUI
    	outputTextField.clear();
    	outputTextField.appendText(str);
    }
    
    @FXML
    void OnActionOutput(ActionEvent event) {

    }  
}