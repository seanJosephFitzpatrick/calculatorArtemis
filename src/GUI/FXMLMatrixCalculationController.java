package GUI;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLMatrixCalculationController implements Initializable {
	private int[][] matrix1;
	private int[][] matrix2;

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
	private TextField[] textFieldsMatrixResult;



	@FXML
	void onActionBtnAddMatrix(ActionEvent event) {
		int[][] resultMatrix = MatrixCalculations.MatrixCalculator.addMatrix(matrix1, matrix2);

		int loop = 0;

		for(int i = 0; i < resultMatrix.length; i++){
			for(int j = 0; j < resultMatrix[0].length; j++){
				textFieldsMatrixResult[loop].setText(""+resultMatrix[i][j]);
				loop++;
			}
		}
	}

	@FXML
	void onActionBtnDivideMatrix(ActionEvent event) {
		int[][] resultMatrix = MatrixCalculations.MatrixCalculator.divideMatrix(matrix1, matrix2);
		int loop = 0;

		for(int i = 0; i < resultMatrix.length; i++){
			for(int j = 0; j < resultMatrix[0].length; j++){
				textFieldsMatrixResult[loop].setText(""+resultMatrix[i][j]);
				loop++;
			}
		}
	}

	@FXML
	void onActionBtnGenerateMatrix1(ActionEvent event) {
		matrix1 = MatrixCalculations.MatrixCalculator.GenerateNumbers();
		int loop = 0;

		for(int i = 0; i < matrix1.length; i++){
			for(int j = 0; j < matrix1[0].length; j++){
				textFieldsMatrix1[loop].setText(""+matrix1[i][j]);
				loop++;
			}
		}
	}

	@FXML
	void onActionBtnGenerateMatrix2(ActionEvent event) {
		matrix2 = MatrixCalculations.MatrixCalculator.GenerateNumbers();
		int loop = 0;

		for(int i = 0; i < matrix2.length; i++){
			for(int j = 0; j < matrix2[0].length; j++){
				textFieldsMatrix2[loop].setText(""+matrix2[i][j]);
				loop++;
			}
		}
	}

	@FXML
	void onActionBtnMultiplyMatrix(ActionEvent event) {
		int[][] resultMatrix = MatrixCalculations.MatrixCalculator.multiplyMatrix(matrix1, matrix2);
		int loop = 0;

		for(int i = 0; i < resultMatrix.length; i++){
			for(int j = 0; j < resultMatrix[0].length; j++){
				textFieldsMatrixResult[loop].setText(""+resultMatrix[i][j]);
				loop++;
			}
		}
	}

	@FXML
	void onActionBtnSubtractMatrix(ActionEvent event) {
		int[][] resultMatrix = MatrixCalculations.MatrixCalculator.subtractMatrix(matrix1, matrix2);
		int loop = 0;

		for(int i = 0; i < resultMatrix.length; i++){
			for(int j = 0; j < resultMatrix[0].length; j++){
				textFieldsMatrixResult[loop].setText(""+resultMatrix[i][j]);
				loop++;
			}
		}
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

		matrix1 = new int[4][4];
		matrix2 = new int[4][4];

		textFieldsMatrixResult = new TextField[] {
				textFieldMatrix301, textFieldMatrix302, textFieldMatrix303,textFieldMatrix304,
				textFieldMatrix305, textFieldMatrix306, textFieldMatrix307, textFieldMatrix308, 
				textFieldMatrix309, textFieldMatrix310, textFieldMatrix311,textFieldMatrix312,
				textFieldMatrix313, textFieldMatrix314, textFieldMatrix315, textFieldMatrix316
		};

	}
}
