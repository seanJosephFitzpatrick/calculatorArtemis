package GUI;
import java.io.IOException;

import ReversePolishNotation.CalcInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLBasicController {

	String answer = "clear";
	
    @FXML
    private Button scientificCalculator;
    @FXML
    private Button btnFour;
    @FXML
    private TextField inputTextField;
    @FXML
    private TextField inputTextField2;
    @FXML
    private Button btnleftBrace;
    @FXML
    private Button btnSeven;
    @FXML
    private Button btnOne;
    @FXML
    private Button btnZero;
    @FXML
    private Button btnRightBrace;
    @FXML
    private Button btnDot;
    @FXML
    private Button btnEight;
    @FXML
    private Button btnFive;
    @FXML
    private Button btnTwo;
    @FXML
    private Button btnNine;
    @FXML
    private Button btnSix;
    @FXML
    private Button btnThree;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDivision;
    @FXML
    private Button btnMultiplication;
    @FXML
    private Button btnSubtraction;
    @FXML
    private Button btnEquals;
    @FXML
    private Button btnAddition;

    boolean lastValueIsOperator(){
    	boolean recentOperator = false;
    	String operators = "+*/-";
    	String toTest = inputTextField.getText();
    	if(operators.contains(Character.toString(toTest.charAt(toTest.length() - 1)))){
    		recentOperator = true;
    	}
    	return recentOperator;
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
    void OnActionBtnFour(ActionEvent event) {
    	inputTextField.appendText("4");
    }
    
    @FXML
    void OnActionBtnAddition(ActionEvent event) {
    	if(answer.equals("clear") && !lastValueIsOperator()){
    		inputTextField.appendText("+");
    	} else if(!answer.equals("clear")){
    		inputTextField.appendText(answer + "+");
    		answer = "clear";
    	}
    }

    @FXML
    void OnActionBtnClear(ActionEvent event) {
    	inputTextField.clear();
    	inputTextField2.clear();
    }

    @FXML
    void OnActionBtnDivision(ActionEvent event) {
    	if(answer.equals("clear") && !lastValueIsOperator()){
    		inputTextField.appendText("/");
    	} else if(!answer.equals("clear")){
    		inputTextField.appendText(answer + "/");
    		answer = "clear";
    	}
    }

    @FXML
    void OnActionBtnDot(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText(".");
    }

    @FXML
    void OnActionBtnEight(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("8");
    }

    @FXML
    void OnActionBtnEquals(ActionEvent event) {
    	inputTextField2.clear();
    	String result = CalcInterface.run(inputTextField.getText());
    	answer = result;
    	inputTextField2.appendText(result);
    	inputTextField.clear();
    }

    @FXML
    void OnActionBtnFive(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("5");
    }

    @FXML
    void OnActionBtnLeftBrace(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("(");
    }

    @FXML
    void OnActionBtnMultiplication(ActionEvent event) {
    	if(answer.equals("clear") && !lastValueIsOperator()){
    		inputTextField.appendText("*");
    	} else if(!answer.equals("clear")){
    		inputTextField.appendText(answer + "*");
    		answer = "clear";
    	}
    }

    @FXML
    void OnActionBtnNine(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("9");
    }

    @FXML
    void OnActionBtnOne(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("1");
    }

    @FXML
    void OnActionBtnRightBrace(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText(")");
    }

    @FXML
    void OnActionBtnSeven(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("7");
    }

    @FXML
    void OnActionBtnSix(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("6");
    }

    @FXML
    void OnActionBtnSubtraction(ActionEvent event) {
    	if(answer.equals("clear") && !lastValueIsOperator()){
    		inputTextField.appendText("-");
    	} else if(!answer.equals("clear") && inputTextField.toString().length() == 0){
    		inputTextField.appendText(answer + "-");
    		answer = "clear";
    	}
    }

    @FXML
    void OnActionBtnThree(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("3");
    }

    @FXML
    void OnActionBtnTwo(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("2");
    }

    @FXML
    void OnActionBtnZero(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("0");
    }

}
