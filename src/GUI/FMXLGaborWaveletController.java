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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FMXLGaborWaveletController implements Initializable {
	
    @FXML
    private Button basicCalculator;
    @FXML
    private Button scientificCalculator;
    @FXML
    private Button fourierCalculator;
    @FXML
    private Button integralCalculator;
    @FXML
    private Button bitWiseCalculator;
    @FXML
    private TextField varphi;
    @FXML
    private TextField upsi;
    @FXML
    private TextField bandw;
    @FXML
    private Button btnGenerate;
    @FXML
    private Button equationCalculator;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		varphi.setText("90");
		upsi.setText("1");
		bandw.setText("1");
	}
	
    @FXML
    void onActionBtnGenerate(ActionEvent event) {

    }
    
    @FXML
    void NavigateEquationCalculator(ActionEvent event) {
      	try {
			Parent scientific_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLEquationCalc.fxml"));
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
			Parent basic_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLFourier.fxml"));
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
