
package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import integrals.SimpsonsRule;

public class FXMLIntegralController implements Initializable {

    @FXML
    private TextField inputTextField;
    @FXML
    private TextField topValueTextField;
    @FXML
    private TextField bottomValueTextField;
    @FXML
    private Button calculate;
    @FXML
    private TextField inputTextFieldN;
    @FXML
    private TextField outputTextField;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}  
    
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
    void OnActionCalculate(ActionEvent event) throws Exception {
    	//inputTextField.clear();
    	
    	SimpsonsRule rule = new SimpsonsRule();

    	double valueA = Double.parseDouble(topValueTextField.getText().toString());
    	System.out.println("value a : "+ valueA);
       	double valueB = Double.parseDouble(bottomValueTextField.getText().toString());
       	System.out.println("1");
       	SimpsonsRule.setFunctionText(inputTextField.getText());
       	
    	double answer = rule.integrate(valueA, valueB, inputTextField.getText().toString(), true);	//boolean value needs to be assigned
    	System.out.println("2");
    	System.out.println(answer);
    	String str = Double.toString(answer);											//from GUI
    	outputTextField.clear();
    	outputTextField.appendText(str);
    }
        
    @FXML
    void OnActionOutput(ActionEvent event) {

    }

}