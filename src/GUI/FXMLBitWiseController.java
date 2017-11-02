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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class FXMLBitWiseController implements Initializable {

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
    @FXML
    private TextField inputTextFieldSetB;
    @FXML
    private TextField inputTextFieldSetA;
    final ToggleGroup group = new ToggleGroup();
    @FXML
    private RadioButton btnIntersectionA_B;
    @FXML
    private RadioButton btnUnionA_B;
    @FXML
    private RadioButton btnDifferenceA_B;
    @FXML
    private RadioButton btnComponentOfA;
    @FXML
    private RadioButton btnComponentOfB;
    @FXML
    private TextField inputTextFieldResultSet;
    @FXML
    private Button btnClear;
    
    @FXML
    void OnActionBtnClear(ActionEvent event) {

    }
     
    @FXML
    void OnActionBtnComponentOfA(ActionEvent event) {
    	btnComponentOfA.setToggleGroup(group);
    }

    @FXML
    void OnActionBtnComponentOfB(ActionEvent event) {
    	btnComponentOfB.setToggleGroup(group);
    	//Difference
    	
    	
    	
    }

    @FXML
    void OnActionBtnDifferenceA_B(ActionEvent event) {
    	btnDifferenceA_B.setToggleGroup(group);
    }

    @FXML
    void OnActionBtnIntersectionA_B(ActionEvent event) {
    	btnIntersectionA_B.setToggleGroup(group);
    }

    @FXML
    void OnActionBtnUnionA_B(ActionEvent event) {
    	btnUnionA_B.setToggleGroup(group);
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
    void NavigateFourierCalculator(ActionEvent event) {
    	try {
			Parent scientific_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLFourier.fxml"));
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
    void NavigateBasicCalculator(ActionEvent event) {
    	try {
			Parent integral_calculator_parent = FXMLLoader.load(getClass().getResource("FXMLBasic.fxml"));
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
    	inputTextField.setText(inputTextField.getText().substring(0, inputTextField.getText ().length() - 1));
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
    	inputTextField2.clear();
    	String result = CalcInterface.run(inputTextField.getText(), true);	//True here needs to be a boolean 
    	answer = result;														//Set on the GUI
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
