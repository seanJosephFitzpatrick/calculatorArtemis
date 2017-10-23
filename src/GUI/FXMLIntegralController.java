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
    private Button scientificCalculator;
    @FXML
    private Button integralCalculator;
    @FXML
    private Button fourierCalculator;
    @FXML
    private Button basicCalculator;
    
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
    void NavigateScientificCalculator(ActionEvent event) {
    	try {
			Parent scientific_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLScientific.fxml"));
			Scene scientific_calculator_scene = new Scene(scientific_calculator_parent, 800, 400);
			Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			stage.hide();
			stage.setScene(scientific_calculator_scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void NavigateFourierCalculator(ActionEvent event) {
    	try {
			Parent scientific_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLFourier.fxml"));
			Scene scientific_calculator_scene = new Scene(scientific_calculator_parent, 800, 400);
			Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			stage.hide();
			stage.setScene(scientific_calculator_scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void NavigateBasicCalculator(ActionEvent event) {
    	try {
			Parent basic_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLBasic.fxml"));
			Scene basic_calculator_scene = new Scene(basic_calculator_parent, 800, 400);
			Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			stage.hide();
			stage.setScene(basic_calculator_scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void OnActionOutput(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}  
}