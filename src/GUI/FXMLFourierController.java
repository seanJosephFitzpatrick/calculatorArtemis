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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import FourierSeries.*;

public class FXMLFourierController implements Initializable {

	String answer = "clear";
	
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
    private TextField inputTextFieldXMin;
    @FXML
    private TextField inputTextFieldXMax;
    @FXML
    private TextField inputTextFieldSamFreq;
    @FXML
    private Label labelSamFreq;
    @FXML
    private Label labelXAxis;
    @FXML
    private Text  textDash;
    @FXML
    private ComboBox<String>  comboBoxHar;
    
    
   
       
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBoxFourier.getItems().removeAll(comboBoxFourier.getItems());
		comboBoxFourier.getItems().addAll("Fourier Series", "Signal Sampling");
		comboBoxFourier.getSelectionModel().select("Fourier Series");
		comboBoxWaveform.getItems().removeAll(comboBoxWaveform.getItems());
		comboBoxWaveform.getItems().addAll("Square", "Triangle", "Sawtooth");
		comboBoxWaveform.getSelectionModel().select("Square");
		comboBoxHar.getItems().removeAll(comboBoxHar.getItems());
		comboBoxHar.getItems().addAll( "Odd","Even", "Odd & Even");
		comboBoxHar.getSelectionModel().select("Odd");
		inputTextFieldPhase.setVisible(false);
    	comboBoxWaveform.setVisible(true);
    	textDash.setVisible(false);
    	labelXAxis.setVisible(false);
    	inputTextFieldXMin.setVisible(false);
    	inputTextFieldXMax.setVisible(false);
    	comboBoxHar.setVisible(true);
    	inputTextFieldSamFreq.setVisible(false);
    	labelSamFreq.setText("Harmonic Type");
	}
	
    @FXML
    void OnActionLabelComboBox(ActionEvent event) {
    	String output = comboBoxFourier.getSelectionModel().getSelectedItem().toString();
	    if(output.equalsIgnoreCase("Fourier Series")){
	    	labelOneFourier.setText("Harmonics");
	    	labelTwoFourier.setText("Fourier Series");
	    	labelThreeFourier.setText("Waveform");
	    	labelFourFourier.setText("Frequency");
	    	inputTextFieldPhase.setVisible(false);
	    	comboBoxWaveform.setVisible(true);
	    	textDash.setVisible(false);
	    	labelXAxis.setVisible(false);
	    	inputTextFieldXMin.setVisible(false);
	    	inputTextFieldXMax.setVisible(false);
	    	comboBoxHar.setVisible(true);
	    	inputTextFieldSamFreq.setVisible(false);
	    	labelSamFreq.setText("Harmonic Type");
	    	
	    }else if(output.equalsIgnoreCase("Signal Sampling")){
	    	labelOneFourier.setText("amplitude");
	    	labelTwoFourier.setText("user Defined Waveform");
	    	labelThreeFourier.setText("Phase");
	    	labelFourFourier.setText("Frequency");
	    	comboBoxWaveform.setVisible(false);
	    	inputTextFieldPhase.setVisible(true);
	    	textDash.setVisible(true);
	    	labelXAxis.setVisible(true);
	    	inputTextFieldXMin.setVisible(true);
	    	inputTextFieldXMax.setVisible(true);
	    	inputTextFieldSamFreq.setVisible(true);
	    	labelSamFreq.setText("Sampling Frequency");
	    	comboBoxHar.setVisible(false);
	    	
	    }
    }

    @FXML
    void OnActionSubmit(ActionEvent event) throws Exception {
    	
    	String outputFourier = comboBoxFourier.getSelectionModel().getSelectedItem().toString();
    	String outputWaveform = comboBoxWaveform.getSelectionModel().getSelectedItem().toString();
    	System.out.println(outputWaveform);
	    if(outputFourier.equalsIgnoreCase("Fourier Series")){
	    	
	    	int harmonic = Integer.parseInt(inputTextFieldHarAmp.getText());
	    	double period = 1/Double.parseDouble(inputTextFieldPeriod.getText());
	    	String harmonicType = comboBoxHar.getSelectionModel().getSelectedItem().toString();
	    	
    	
	    	FourierSeries.generatePlotPointsFourier(harmonic, period, outputWaveform,harmonicType, -(period+period*.5));
        

	    	
	    	Application app2 =  new FourierSeries(); 
	        Stage anotherStage = new Stage();
	        app2.start(anotherStage);
	        FourierSeries.generatePlotPointsDFT(period); 
	       Stage anotherStage1 = new Stage();
	       app2.start(anotherStage1);
	   }else{
		   
		// FourierSeries.setMode(outputFourier);

	    	
   	   	//FourierSeries.setAmplitude(Integer.parseInt(inputTextFieldHarAmp.getText()));

   	   	//FourierSeries.setPeriod(Double.parseDouble(inputTextFieldPeriod.getText()));
   	   //	FourierSeries.setPhase(Double.parseDouble(inputTextFieldPhase.getText()));
		   double amplitude=Double.parseDouble(inputTextFieldHarAmp.getText());
		   double period = 1/Double.parseDouble(inputTextFieldPeriod.getText());
		   double phase = Double.parseDouble(inputTextFieldPhase.getText());
		   double samplingPeriod = 1/Double.parseDouble(inputTextFieldSamFreq.getText());
		   double xAxisMin = Double.parseDouble(inputTextFieldXMin.getText());
		   double xAxisMax = Double.parseDouble(inputTextFieldXMax.getText());
	    	FourierSeries.generatePlotPointsFourier(amplitude, period, phase, xAxisMin,xAxisMax,samplingPeriod);

	        Application app2 =  new FourierSeries(); 
	        Stage anotherStage = new Stage();
	        app2.start(anotherStage);
	        FourierSeries.generatePlotPointsDFT(samplingPeriod); 
	        Stage anotherStage1 = new Stage();
	        app2.start(anotherStage1);

	    }    	
    }
}
