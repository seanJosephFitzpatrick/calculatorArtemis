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

public class FXMLScientificController implements Initializable {

	String answer = "clear";
	String memory = "0";
	String userInput = "";
	double PI = Math.PI;
	
    @FXML
    private Button basicCalculator;
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
    @FXML
    void OnActionBtnAddition(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "+");
    		userInput += (answer + "+");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("+");
    		userInput += "+";
    	}
    }

    @FXML
    void OnActionBtnAllClear(ActionEvent event) {
    	inputTextField3.clear();
    	inputTextField4.clear();
    	userInput = "";
    }

    @FXML
    void OnActionBtnArccos(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("cos");
    	userInput += "bac";
    }

    @FXML
    void OnActionBtnArcsin(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("asin");
    	userInput += "dsn";
    }

    @FXML
    void OnActionBtnArctan(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("atan");
    	userInput += "atn";
    }

    @FXML
    void OnActionBtnBack(ActionEvent event) {
    	String curr = inputTextField3.getText();
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
    	
    	if(!Character.isLetter(userInput.charAt(userInput.length() - 1))){
    		userInput = userInput.substring(0, userInput.length() - 1);
    	} else {
    		int i = 3;
    		while(i > 0 && userInput.length() != 0){
    			userInput = userInput.substring(0, userInput.length() - 1);
    			i--;
    		}
    	}
    	System.out.println("Front: " + inputTextField3.getText());
    	System.out.println("Back: " + userInput);
    }

    @FXML
    void OnActionBtnCos(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("cos");
    	userInput += "cos";
    }

    @FXML
    void OnActionBtnDivide(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "/");
    		userInput += (answer + "/");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("/");
    		userInput += "/";
    	}
    }

    @FXML
    void OnActionBtnDot(ActionEvent event) {
    	answer = "clear";
    	String curr = inputTextField3.getText();
    	if(curr.length() == 0){
    		inputTextField3.appendText("0.");
    		userInput += "0.";
    	} else if(!Character.isDigit(curr.charAt(curr.length() -1))){
    		inputTextField3.appendText("0.");
    		userInput += "0.";
    	} else {
    		inputTextField3.appendText(".");
    		userInput += ".";
    	}
    }

    @FXML
    void OnActionBtnEight(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("8");
    	userInput += "8";
    }

    @FXML
    void OnActionBtnEquals(ActionEvent event) {
    	System.out.println(userInput);
    	inputTextField4.clear();
    	String result = CalcInterface.run(userInput, true);	//boolean value needs to be set from GUI button
    	answer = result;
    	inputTextField4.appendText(result);
    	inputTextField3.clear();
    	userInput = "";
    }

    @FXML
    void OnActionBtnFive(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("5");
    	userInput += "5";
    }

    @FXML
    void OnActionBtnFour(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("4");
    	userInput += "4";
    }

    @FXML
    void OnActionBtnLeftBrace(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("(");
    	userInput += "(";
    }

    @FXML
    void OnActionBtnLogTen(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("log");
    	userInput += "lgt";
    }

    @FXML
    void OnActionBtnMemoryAdd(ActionEvent event) {
    	double inMem = Double.parseDouble(memory);
    	double toAdd = Double.parseDouble(inputTextField4.getText());
    	memory = "";
    	memory += Double.toString(inMem + toAdd);
    }

    @FXML
    void OnActionBtnMemorySubtract(ActionEvent event) {
    	double inMem = Double.parseDouble(memory);
    	double toAdd = Double.parseDouble(inputTextField4.getText());
    	memory = "";
    	memory += Double.toString(inMem - toAdd);
    }

    @FXML
    void OnActionBtnMultiply(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "*");
    		userInput += (answer + "*");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("*");
    		userInput += "*";
    	}
    }

    @FXML
    void OnActionBtnNaturalLog(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("ln");
    	userInput += "elg";
    }

    @FXML
    void OnActionBtnNine(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("9");
    	userInput += "9";
    }

    @FXML
    void OnActionBtnOne(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("1");
    	userInput += "1";
    }

    @FXML
    void OnActionBtnPercentage(ActionEvent event) {
    	
    }

    @FXML
    void OnActionBtnPi(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText(Double.toString(PI));
    	userInput += Double.toString(PI);
    }

    @FXML
    void OnActionBtnPowerOf(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "\u00B2");
    		userInput += (answer + "^2");
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("\u00B2");
    		userInput += "^2";
    	}
    }

    @FXML
    void OnActionBtnRecall(ActionEvent event) {
    	if(!memory.equals("0")){
    		inputTextField3.appendText(memory);
    		userInput += memory;
    	}
    }

    @FXML
    void OnActionBtnSeven(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("7");
    	userInput += "7";
    }

    @FXML
    void OnActionBtnSin(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("sin");
    	userInput += "sin";
    }

    @FXML
    void OnActionBtnSix(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("6");
    	userInput += "6";
    }

    @FXML
    void OnActionBtnSquareRoot(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("\u221A");
    	userInput += "rts";
    }

    @FXML
    void OnActionBtnSubtract(ActionEvent event) {
    	if(!answer.equals("clear") && (!answer.equals("Syntax Error"))){
    		inputTextField3.appendText(answer + "-");
    		userInput += "-";
    		answer = "clear";
    	} else {
    		answer = "clear";
    		inputTextField3.appendText("-");
    		userInput += "-";
    	}
    }

    @FXML
    void OnActionBtnTan(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("tan");
    	userInput += "tan";
    }

    @FXML
    void OnActionBtnThree(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("3");
    	userInput += "3";
    }

    @FXML
    void OnActionBtnTwo(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("2");
    	userInput += "2";
    }

    @FXML
    void OnActionBtnZero(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText("0");
    	userInput += "0";
    }

    @FXML
    void OnActionMemoryClear(ActionEvent event) {
    	memory = "0";
    }

    @FXML
    void OnActionMemoryStore(ActionEvent event) {
    	if(inputTextField4.getText().length() != 0){
    		memory = "";
    		memory += inputTextField4.getText();
    	}
    }

    @FXML
    void OnActionRightBrace(ActionEvent event) {
    	answer = "clear";
    	inputTextField3.appendText(")");
    	userInput += ")";
    }

}
