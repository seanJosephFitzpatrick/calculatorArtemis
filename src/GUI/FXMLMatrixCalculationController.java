package GUI;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
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

public class FXMLMatrixCalculationController implements Initializable {
	@FXML
    private Button buttonGenerateMatrix1;

    @FXML
    private TextField textFieldMatrix100;

    @FXML
    private TextField textFieldMatrix101;

    @FXML
    private TextField textFieldMatrix102;

    @FXML
    private TextField textFieldMatrix110;

    @FXML
    private TextField textFieldMatrix111;

    @FXML
    private TextField textFieldMatrix112;

    @FXML
    private TextField textFieldMatrix103;

    @FXML
    private TextField textFieldMatrix113;

    @FXML
    private TextField textFieldMatrix123;

    @FXML
    private TextField textFieldMatrix133;

    @FXML
    private TextField textFieldMatrix132;

    @FXML
    private TextField textFieldMatrix122;

    @FXML
    private TextField textFieldMatrix121;

    @FXML
    private TextField textFieldMatrix120;

    @FXML
    private TextField textFieldMatrix131;

    @FXML
    private TextField textFieldMatrix130;

    @FXML
    private TextField textFieldMatrix201;

    @FXML
    private TextField textFieldMatrix202;

    @FXML
    private TextField textFieldMatrix203;

    @FXML
    private TextField textFieldMatrix204;

    @FXML
    private TextField textFieldMatrix205;

    @FXML
    private TextField textFieldMatrix206;

    @FXML
    private TextField textFieldMatrix207;

    @FXML
    private TextField textFieldMatrix208;

    @FXML
    private TextField textFieldMatrix209;

    @FXML
    private TextField textFieldMatrix210;

    @FXML
    private TextField textFieldMatrix211;

    @FXML
    private TextField textFieldMatrix212;

    @FXML
    private TextField textFieldMatrix213;

    @FXML
    private TextField textFieldMatrix214;

    @FXML
    private TextField textFieldMatrix215;

    @FXML
    private TextField textFieldMatrix216;

    @FXML
    private Button buttonGenerateMatrix2;

    @FXML
    private TextField textFieldMatrix301;

    @FXML
    private TextField textFieldMatrix302;

    @FXML
    private TextField textFieldMatrix303;

    @FXML
    private TextField textFieldMatrix304;

    @FXML
    private TextField textFieldMatrix305;

    @FXML
    private TextField textFieldMatrix306;

    @FXML
    private TextField textFieldMatrix307;

    @FXML
    private TextField textFieldMatrix308;

    @FXML
    private TextField textFieldMatrix309;

    @FXML
    private TextField textFieldMatrix310;

    @FXML
    private TextField textFieldMatrix311;

    @FXML
    private TextField textFieldMatrix312;

    @FXML
    private TextField textFieldMatrix313;

    @FXML
    private TextField textFieldMatrix314;

    @FXML
    private TextField textFieldMatrix315;

    @FXML
    private TextField textFieldMatrix316;

    @FXML
    private Button buttonAddMatrix;

    @FXML
    private Button buttonSubtractMatrix;

    @FXML
    private Button buttonDivideMatrix;

    @FXML
    private Button buttonMultiplyMatrix;

    @FXML
    private TextField[] textFieldsMatrix1 ;
    
    @FXML
    private TextField[] textFieldsMatrix2 ;
    
	    
	    
	    @FXML
	    void onActionBtnAddMatrix(ActionEvent event) {

	    }

	    @FXML
	    void onActionBtnDivideMatrix(ActionEvent event) {

	    }

	    @FXML
	    void onActionBtnGenerateMatrix1(ActionEvent event) {
	    	NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(3);
			String test = "textfield";
			
			int step1 = 0;
			int step2 = 0;
			
	    	for(int i = 0; i < MatrixCalculations.MatrixCalculator.testA.length; i++){
				for(int j = 0; j < MatrixCalculations.MatrixCalculator.testA[0].length; j++){
					//System.out.print(nf.format(MatrixCalculations.MatrixCalculator.testA[i][j]) + "\t");
					//System.out.println(test+i+j);
					//System.out.println(textFieldsMatrix11[step1].getId());
					//textFieldsMatrix11[step1].setText(""+MatrixCalculations.MatrixCalculator.testA[i][j]);
					//textFieldMatrix100.setText(""+MatrixCalculations.MatrixCalculator.testA[i][j]);
					textFieldsMatrix1[step1].setText(""+MatrixCalculations.MatrixCalculator.testA[i][j]);
					step1++;
				}
				//System.out.println();
				//System.out.println(test+i);
				//step2++;
			}
	    }

	    @FXML
	    void onActionBtnGenerateMatrix2(ActionEvent event) {
	    	int step1 = 0;
	    	for(int i = 0; i < MatrixCalculations.MatrixCalculator.testB.length; i++){
				for(int j = 0; j < MatrixCalculations.MatrixCalculator.testB[0].length; j++){
					
					textFieldsMatrix2[step1].setText(""+MatrixCalculations.MatrixCalculator.testB[i][j]);
					step1++;
				}
				
			}
	    }

	    @FXML
	    void onActionBtnMultiplyMatrix(ActionEvent event) {

	    }

	    @FXML
	    void onActionBtnSubtractMatrix(ActionEvent event) {

	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			  textFieldsMatrix1 = new TextField[] {textFieldMatrix100,textFieldMatrix101,textFieldMatrix102, textFieldMatrix103, 
					  textFieldMatrix110, textFieldMatrix111, textFieldMatrix112, textFieldMatrix113,
					  textFieldMatrix120, textFieldMatrix121, textFieldMatrix122, textFieldMatrix123,
					  textFieldMatrix130, textFieldMatrix131, textFieldMatrix132, textFieldMatrix133};
			  
			  textFieldsMatrix2 = new TextField[] {
					  textFieldMatrix201, textFieldMatrix202, textFieldMatrix203,textFieldMatrix204,
					  textFieldMatrix205, textFieldMatrix206, textFieldMatrix207, textFieldMatrix208, 
					  textFieldMatrix209, textFieldMatrix210, textFieldMatrix211,textFieldMatrix212,
					  textFieldMatrix213, textFieldMatrix214, textFieldMatrix215, textFieldMatrix216
					  
			  };
			
		}
}
