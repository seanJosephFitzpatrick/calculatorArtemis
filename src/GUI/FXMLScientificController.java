package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ReversePolishNotation.CalcInterface;
import ReversePolishNotation.EquationGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class FXMLScientificController implements Initializable {

	String answer = "clear";
	String memory = "0";
	String userInput = "";
	double PI = Math.PI;
	boolean radians = true;
	
    @FXML
    private Button memoryClear;
    @FXML
    private Button sin;
    @FXML
    private Button cos;
    @FXML
    private Button tan;
    @FXML
    private Button leftBrace;
    @FXML
    private Button memoryRecall;
    @FXML
    private Button arcsin;
    @FXML
    private Button arccos;
    @FXML
    private Button arctan;
    @FXML
    private Button rightBrace;
    @FXML
    private Button memoryStore;
    @FXML
    private Button elg;
    @FXML
    private Button memoryAdd;
    @FXML
    private Button btnPercentage;
    @FXML
    private Button lgt;
    @FXML
    private Button memorySubtract;
    @FXML
    private Button btnSeven;
    @FXML
    private Button btnFour;
    @FXML
    private Button btnOne;
    @FXML
    private Button btnZero;
    @FXML
    private Button allClear;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnEight;
    @FXML
    private Button btnNine;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btnFive;
    @FXML
    private Button btnSix;
    @FXML
    private Button btnMultiply;
    @FXML
    private Button btnTwo;
    @FXML
    private Button btnThree;
    @FXML
    private Button btnSubtract;
    @FXML
    private Button btnDot;
    @FXML
    private Button btnEquals;
    @FXML
    private Button btnAddition;
    @FXML
    private Button pi;
    @FXML
    private Button squareRoot;
    @FXML
    private Button powerOf;
    @FXML
    private TextField inputTextField3;
    @FXML
    private TextField inputTextField4;
    @FXML
    private RadioButton radiansRadionBtn;
    @FXML
    private RadioButton degreesRadioBtn;
    @FXML
    private Button powerOfN;
    @FXML
    private Button logBaseN;
    final ToggleGroup group = new ToggleGroup();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		degreesRadioBtn.setSelected(true);
		degreesRadioBtn.setToggleGroup(group);
	}
	
    @FXML
    void OnActionBtnAddition(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "+");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("+");
    	}
    }
    
    @FXML
    void onActionLogBaseN(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("lgx");
    }


    @FXML
    void onActionPowerOfN(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "^");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("^");
    	}
    }
    
    @FXML
    void OnActionDegreesRadioBtn(ActionEvent event) {
    	radians = true;
    	degreesRadioBtn.setToggleGroup(group);
    }
    
    @FXML
    void OnActionRadiansRadioBtn(ActionEvent event) {
    	radians = false;
    	radiansRadionBtn.setToggleGroup(group);
    }

    @FXML
    void OnActionBtnAllClear(ActionEvent event) {
    	inputTextField3.clear();
    	inputTextField4.clear();
    }

    @FXML
    void OnActionBtnArccos(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("acos");
    }

    @FXML
    void OnActionBtnArcsin(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("asin");
    }

    @FXML
    void OnActionBtnArctan(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("atan");
    }

    @FXML
    void OnActionBtnBack(ActionEvent event) {
    	String curr = inputTextField3.getText();
    	if(inputTextField3.getText().toString().length() > 0){
    		if(!Character.isLetter(curr.charAt(curr.length() - 1))){
    			curr = curr.substring(0, curr.length() - 1);
    			inputTextField3.setText(curr);
    		} else {
    			int i = 3;
    			while(i > 0 && curr.length() != 0){
    				curr = curr.substring(0, curr.length() - 1);
    				i--;
    			}
    			if(curr.length() != 0 && curr.charAt(curr.length() - 1) == 'a'){
    				curr = curr.substring(0, curr.length() - 1);	//Temporary fix allows acos, asin, atan! longer functions need 
    			}													//something more robust!
    			inputTextField3.setText(curr);
    		}
    	}
    }

    @FXML
    void OnActionBtnCos(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("cos");
    }

    @FXML
    void OnActionBtnDivide(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "/");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("/");
    	}
    }

    @FXML
    void OnActionBtnDot(ActionEvent event) {
    	answer = "clear";
    	String curr = inputTextField3.getText();
    	if(curr.length() == 0){
    		inputTextField3.appendText("0.");
    	} else if(!Character.isDigit(curr.charAt(curr.length() -1))){
    		inputTextField3.appendText("0.");
    	} else {
    		inputTextField3.appendText(".");
    	}
    }

    @FXML
    void OnActionBtnEight(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("8");
    }

    @FXML
    void OnActionBtnEquals(ActionEvent event) throws Exception{
    	try {
    		if(inputTextField3.getText().toString().length() > 0){
    			userInput = EquationGenerator.formatEquation(inputTextField3.getText());
    			System.out.println(userInput);
    			inputTextField4.clear();
    			String result = CalcInterface.run(userInput, radians);	//boolean value needs to be set from GUI button
    			answer = result;
    			inputTextField4.appendText(result);
    			inputTextField3.clear();
    			userInput = "";
    		} 

    	} catch (IllegalArgumentException e){
    		if(!inputTextField4.getText().equals("Syntax Error")){
    			inputTextField4.appendText("Syntax Error");
    		}
    	} 
    }

    @FXML
    void OnActionBtnFive(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("5");
    }

    @FXML
    void OnActionBtnFour(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("4");
    }

    @FXML
    void OnActionBtnLeftBrace(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("(");
    }

    @FXML
    void OnActionBtnLogTen(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("log");
    }

    @FXML
    void OnActionBtnMemoryAdd(ActionEvent event) {
    	double inMem = Double.parseDouble(memory);
    	double toAdd = Double.parseDouble(inputTextField4.getText());
    	double result = inMem + toAdd;
    	memory = "";
    	memory += Double.toString(result);
    }

    @FXML
    void OnActionBtnMemorySubtract(ActionEvent event) {
    	double inMem = Double.parseDouble(memory);
    	double toAdd = Double.parseDouble(inputTextField4.getText());
    	double result = inMem - toAdd;
    	memory = "";
    	memory += Double.toString(result);
    }

    @FXML
    void OnActionBtnMultiply(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "*");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("*");
    	}
    }

    @FXML
    void OnActionBtnNaturalLog(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("ln");
    }

    @FXML
    void OnActionBtnNine(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("9");
    }

    @FXML
    void OnActionBtnOne(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("1");
    }

    @FXML
    void OnActionBtnPercentage(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "\u00B2");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("!");
    	}
    }

    @FXML
    void OnActionBtnPi(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("\u03C0");
    }

    @FXML
    void OnActionBtnPowerOf(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "\u00B2");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("\u00B2");
    	}
    }

    @FXML
    void OnActionBtnRecall(ActionEvent event) {
    	if(!memory.equals("0")){
    		inputTextField3.appendText(memory);
    	}
    }

    @FXML
    void OnActionBtnSeven(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("7");
    }

    @FXML
    void OnActionBtnSin(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("sin");
    }

    @FXML
    void OnActionBtnSix(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("6");
    }

    @FXML
    void OnActionBtnSquareRoot(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("\u221A");
    }

    @FXML
    void OnActionBtnSubtract(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "-");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("-");
    	}
    }

    @FXML
    void OnActionBtnTan(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("tan");
    }

    @FXML
    void OnActionBtnThree(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("3");
    }

    @FXML
    void OnActionBtnTwo(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("2");
    }

    @FXML
    void OnActionBtnZero(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("0");
    }

    @FXML
    void OnActionMemoryClear(ActionEvent event) {
    	memory = "0";
    }

    @FXML
    void OnActionMemoryStore(ActionEvent event) {
    	if(inputTextField4.getText().length() != 0){
    		memory = "";
    		memory += inputTextField4.getText().toString();
    	}
    }

    @FXML
    void OnActionRightBrace(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText(")");
    }

}
