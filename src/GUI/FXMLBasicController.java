package GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ReversePolishNotation.CalcInterface;
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

public class FXMLBasicController implements Initializable {

	String answer = "clear";
	
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
    private Button btnDivision;
    @FXML
    private Button btnMultiplication;
    @FXML
    private Button btnSubtraction;
    @FXML
    private Button btnEquals;
    @FXML
    private Button btnAddition;
    @FXML
    private Button btnAllClear;
    @FXML
    private Button btnBack;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
    
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
    void OnActionBtnFour(ActionEvent event) {
    	inputTextField.appendText("4");
    }
    
    @FXML
    void OnActionBtnAddition(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField.appendText(answer + "+");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField.appendText("+");
    	}
    }

    @FXML
    void OnActionBtnAllClear(ActionEvent event) {
    	inputTextField.clear();
    	inputTextField2.clear();
    }
    
    @FXML
    void OnActionBtnBack(ActionEvent event) {
    	if(inputTextField.getText().toString().length() > 0){
    		inputTextField.setText(inputTextField.getText().substring(0, inputTextField.getText ().length() - 1));
    	}
    }

    @FXML
    void OnActionBtnDivision(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField.appendText(answer + "/");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField.appendText("/");
    	}
    }

    @FXML
    void OnActionBtnDot(ActionEvent event) {
    	answer = "clear";
    	String curr = inputTextField.getText();
    	if(curr.length() == 0){
    		inputTextField.appendText("0.");
    	} else if(!Character.isDigit(curr.charAt(curr.length() -1))){
    		inputTextField.appendText("0.");
    	} else {
    		inputTextField.appendText(".");
    	}
    }

    @FXML
    void OnActionBtnEight(ActionEvent event) {
    	answer = "clear";
    	inputTextField.appendText("8");
    }

    @FXML
    void OnActionBtnEquals(ActionEvent event) {
    	if(inputTextField.getText().toString().length() > 0){
    		inputTextField2.clear();
    		String result = CalcInterface.run(inputTextField.getText(), true);	//True here needs to be a boolean 
    		answer = result;														//Set on the GUI
    		inputTextField2.appendText(result);
    		inputTextField.clear();
    	}
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
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField.appendText(answer + "*");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField.appendText("*");
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
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField.appendText(answer + "-");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField.appendText("-");
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
