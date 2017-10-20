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
    private Button basicCalculator;
    @FXML
    private TextField inputTextField;
    @FXML
    private TextField inputTextField2;
    @FXML
    private TextField inputTextField3;
    @FXML
    private TextField inputTextField4;
    @FXML
    private Button submit;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private Label labelOneFourier;
    @FXML
    private Label labelThreeFourier;
    @FXML
    private Label labelFourFourier;
    @FXML
    private Label labelTwoFourier;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	    comboBox.getItems().removeAll(comboBox.getItems());
	    comboBox.getItems().addAll("Fourier Series", "user Defined Waveform");
	    comboBox.getSelectionModel().select("Fourier Series");
	    comboBox1.getItems().removeAll(comboBox.getItems());
	    comboBox1.getItems().addAll("Square", "Triangle", "Sawtooth");
	    comboBox1.getSelectionModel().select("Square");
    	inputTextField.setVisible(false);
    	comboBox1.setVisible(true);
	}
	
    @FXML
    void OnActionLabelComboBox(ActionEvent event) {
    	String output = comboBox.getSelectionModel().getSelectedItem().toString();
	    if(output.equalsIgnoreCase("Fourier Series")){
	    	labelOneFourier.setText("Harmonics");
	    	labelTwoFourier.setText("Fourier Series");
	    	labelThreeFourier.setText("Waveform");
	    	labelFourFourier.setText("Period");
	    	inputTextField.setVisible(false);
	    	comboBox1.setVisible(true);
	    }else if(output.equalsIgnoreCase("user Defined Waveform")){
	    	labelOneFourier.setText("amplitude");
	    	labelTwoFourier.setText("user Defined Waveform");
	    	labelThreeFourier.setText("Phase");
	    	labelFourFourier.setText("Period");
	    	comboBox1.setVisible(false);
	    	inputTextField.setVisible(true);
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
    void OnActionSubmit(ActionEvent event) throws Exception {
    	
    	String output = comboBox.getSelectionModel().getSelectedItem().toString();
	    if(output.equalsIgnoreCase("Fourier Series")){
	    	
	    	FourierSeries.setMode(inputTextField4.getText());

	    	FourierSeries.setWaveform(inputTextField.getText());
	    	FourierSeries.setHarmonic(Integer.parseInt(inputTextField3.getText()));
	    	FourierSeries.setPeriod(Double.parseDouble(inputTextField2.getText()));
	    	
	    	Application app2 =  new FourierSeries(); 
	        Stage anotherStage = new Stage();
	        app2.start(anotherStage);
	    }else if(output.equalsIgnoreCase("user Defined Waveform")){

	    }    	
    }
}
