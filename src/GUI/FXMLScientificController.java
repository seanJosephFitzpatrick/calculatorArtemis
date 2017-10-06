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

public class FXMLScientificController implements Initializable {

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
    private TextField inputTextField;
    @FXML
    private TextField inputTextField2;

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
    	
    }

    @FXML
    void OnActionBtnAllClear(ActionEvent event) {

    }

    @FXML
    void OnActionBtnArccos(ActionEvent event) {

    }

    @FXML
    void OnActionBtnArcsin(ActionEvent event) {

    }

    @FXML
    void OnActionBtnArctan(ActionEvent event) {

    }

    @FXML
    void OnActionBtnBack(ActionEvent event) {

    }

    @FXML
    void OnActionBtnCos(ActionEvent event) {

    }

    @FXML
    void OnActionBtnDivide(ActionEvent event) {

    }

    @FXML
    void OnActionBtnDot(ActionEvent event) {

    }

    @FXML
    void OnActionBtnEight(ActionEvent event) {

    }

    @FXML
    void OnActionBtnEquals(ActionEvent event) {

    }

    @FXML
    void OnActionBtnFive(ActionEvent event) {

    }

    @FXML
    void OnActionBtnFour(ActionEvent event) {

    }

    @FXML
    void OnActionBtnLeftBrace(ActionEvent event) {

    }

    @FXML
    void OnActionBtnLogTen(ActionEvent event) {

    }

    @FXML
    void OnActionBtnMemoryAdd(ActionEvent event) {

    }

    @FXML
    void OnActionBtnMemorySubtract(ActionEvent event) {

    }

    @FXML
    void OnActionBtnMultiply(ActionEvent event) {

    }

    @FXML
    void OnActionBtnNaturalLog(ActionEvent event) {

    }

    @FXML
    void OnActionBtnNine(ActionEvent event) {

    }

    @FXML
    void OnActionBtnOne(ActionEvent event) {

    }

    @FXML
    void OnActionBtnPercentage(ActionEvent event) {

    }

    @FXML
    void OnActionBtnPi(ActionEvent event) {

    }

    @FXML
    void OnActionBtnPowerOf(ActionEvent event) {

    }

    @FXML
    void OnActionBtnRecall(ActionEvent event) {

    }

    @FXML
    void OnActionBtnSeven(ActionEvent event) {

    }

    @FXML
    void OnActionBtnSin(ActionEvent event) {

    }

    @FXML
    void OnActionBtnSix(ActionEvent event) {

    }

    @FXML
    void OnActionBtnSquareRoot(ActionEvent event) {

    }

    @FXML
    void OnActionBtnSubtract(ActionEvent event) {

    }

    @FXML
    void OnActionBtnTan(ActionEvent event) {

    }

    @FXML
    void OnActionBtnThree(ActionEvent event) {

    }

    @FXML
    void OnActionBtnTwo(ActionEvent event) {

    }

    @FXML
    void OnActionBtnZero(ActionEvent event) {

    }

    @FXML
    void OnActionMemoryClear(ActionEvent event) {

    }

    @FXML
    void OnActionMemoryStore(ActionEvent event) {

    }

    @FXML
    void OnActionRightBrace(ActionEvent event) {

    }

}

