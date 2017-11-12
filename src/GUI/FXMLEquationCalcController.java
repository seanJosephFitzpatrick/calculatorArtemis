package GUI;

import java.net.URL;
import java.util.ResourceBundle;
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
    
}
