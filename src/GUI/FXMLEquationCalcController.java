package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private Button scientificCalculator;
    @FXML
    private Button integralCalculator;
    @FXML
    private Button equationCalculator;
    @FXML
    private Button fourierCalculator;
    @FXML
    private Button basicCalculator;
    @FXML
    private Button bitWiseCalculator;
    @FXML
    private Button gaborCalculator;
    @FXML
    private Button btnCalculate;
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		comboBoxEquation.getItems().removeAll(comboBoxEquation.getItems());
		comboBoxEquation.getItems().addAll("Cubic", "Quadratic", "Linear");
		comboBoxEquation.getSelectionModel().select("Cubic");

    	//comboBoxWaveform.setVisible(true);
		
	}
	
    @FXML
    void onActionCalculate(ActionEvent event) {

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
    
    @FXML
    void NavigateBasicCalculator(ActionEvent event) {
    	try {
			Parent scientific_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLBasic.fxml"));
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
    void NavigateBitWiseCalculator(ActionEvent event) {
    	try {
			Parent scientific_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLBitWise.fxml"));
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
    void NavigateGaborCalculator(ActionEvent event) {
    	try {
			Parent scientific_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLGaborWavelet.fxml"));
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
    void NavigateIntegralCalculator(ActionEvent event) {
    	try {
			Parent integral_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLIntegral.fxml"));
			Scene integral_calculator_scene = new Scene(integral_calculator_parent, 800, 400);
			Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			stage.hide();
			stage.setScene(integral_calculator_scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
