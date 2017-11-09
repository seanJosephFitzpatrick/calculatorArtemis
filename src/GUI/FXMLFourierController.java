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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import FourierSeries.*;

public class FXMLFourierController implements Initializable {

	String answer = "clear";
	
    @FXML
    private Button scientificCalculator;
    @FXML
    private Button integralCalculator;
    @FXML
    private Button fourierCalculator;
    @FXML
    private Button basicCalculator;
    @FXML
    private TextField inputTextFieldPhase;
    @FXML
    private TextField inputTextFieldPeriod;
    @FXML
    private TextField inputTextFieldHarAmp;
    @FXML
    private Button submit;
    @FXML
    private ComboBox<String> comboBoxFourier;
    @FXML
    private ComboBox<String> comboBoxWaveform;
    @FXML
    private Label labelOneFourier;
    @FXML
    private Label labelThreeFourier;
    @FXML
    private Label labelFourFourier;
    @FXML
    private Label labelTwoFourier;
    @FXML
    private TextField inputTextFieldMode;
    @FXML
    private TextField inputTextFieldWaveform;
    @FXML
    private Button bitWiseCalculator;
    
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
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboBoxFourier.getItems().removeAll(comboBoxFourier.getItems());
		comboBoxFourier.getItems().addAll("Fourier Series", "user Defined Waveform");
		comboBoxFourier.getSelectionModel().select("Fourier Series");
		comboBoxWaveform.getItems().removeAll(comboBoxWaveform.getItems());
		comboBoxWaveform.getItems().addAll("Square", "Triangle", "Sawtooth");
		comboBoxWaveform.getSelectionModel().select("Square");
		inputTextFieldPhase.setVisible(false);
    	comboBoxWaveform.setVisible(true);
	}
	
    @FXML
    void OnActionLabelComboBox(ActionEvent event) {
    	String output = comboBoxFourier.getSelectionModel().getSelectedItem().toString();
	    if(output.equalsIgnoreCase("Fourier Series")){
	    	labelOneFourier.setText("Harmonics");
	    	labelTwoFourier.setText("Fourier Series");
	    	labelThreeFourier.setText("Waveform");
	    	labelFourFourier.setText("Period");
	    	inputTextFieldPhase.setVisible(false);
	    	comboBoxWaveform.setVisible(true);
	    }else if(output.equalsIgnoreCase("user Defined Waveform")){
	    	labelOneFourier.setText("amplitude");
	    	labelTwoFourier.setText("user Defined Waveform");
	    	labelThreeFourier.setText("Phase");
	    	labelFourFourier.setText("Period");
	    	comboBoxWaveform.setVisible(false);
	    	inputTextFieldPhase.setVisible(true);
	    }
    }

//    @FXML
//    void OnActionLabelOneFourier(MouseEvent event) {
//	    String output = comboBox.getSelectionModel().getSelectedItem().toString();
//	    
//	    String output1 = "Fourier Series";
//	    if(output1.equalsIgnoreCase("Fourier Series")){
//	    	labelTwoFourier.setText("Fourier Series");
//	    }else{
//	    	labelTwoFourier.setText("user Defined Waveform");
//	    }
//    }

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
    void OnActionSubmit(ActionEvent event) throws Exception {
    	
    	String outputFourier = comboBoxFourier.getSelectionModel().getSelectedItem().toString();
    	String outputWaveform = comboBoxWaveform.getSelectionModel().getSelectedItem().toString();
    	System.out.println(outputWaveform);
	    if(outputFourier.equalsIgnoreCase("Fourier Series")){
    	
        	FourierSeries.setMode(outputFourier);

    	
        	FourierSeries.setWaveform(outputWaveform.toLowerCase());
        	System.out.println(outputWaveform);

    	   	FourierSeries.setHarmonic(Integer.parseInt(inputTextFieldHarAmp.getText()));

    	   	FourierSeries.setPeriod(Double.parseDouble(inputTextFieldPeriod.getText()));

	    	
	    	Application app2 =  new FourierSeries(); 
	        Stage anotherStage = new Stage();
	        app2.start(anotherStage);
	   }else{
		   
		 FourierSeries.setMode(outputFourier);

	    	
       	
       	

   	   	FourierSeries.setAmplitude(Integer.parseInt(inputTextFieldHarAmp.getText()));

   	   	FourierSeries.setPeriod(Double.parseDouble(inputTextFieldPeriod.getText()));
   	   	FourierSeries.setPhase(Double.parseDouble(inputTextFieldPeriod.getText()));

	    	
	    	Application app2 =  new FourierSeries(); 
	        Stage anotherStage = new Stage();
	        app2.start(anotherStage);

	    }    	
    }
}
