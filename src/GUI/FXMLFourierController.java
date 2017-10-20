package GUI;
import java.io.IOException;
import ReversePolishNotation.CalcInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import FourierSeries.*;

public class FXMLFourierController {

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
    	
    	
    	
    	FourierSeries.setMode(inputTextField4.getText());
    	
    	FourierSeries.setWaveform(inputTextField.getText());
    	FourierSeries.setHarmonic(Integer.parseInt(inputTextField3.getText()));
    	FourierSeries.setPeriod(Double.parseDouble(inputTextField2.getText()));
    	
    	Application app2 =  new FourierSeries(); 
        Stage anotherStage = new Stage();
        app2.start(anotherStage);
    		
    	
    }

}
