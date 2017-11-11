package GUI;

import javafx.fxml.FXMLLoader;

import java.io.IOException;


public class WindowNavigator {


    public static final String MAIN    = "FXMLMainPane.fxml";
    public static final String BASIC_CALCULATOR = "FXMLBasic.fxml";
    public static final String CONVERSION_CALCULATOR = "FXMLConversion.fxml";
    public static final String DATA_COMPRESSION_CALCULATOR = "FXMLDataCompression.fxml";
    public static final String EQUATION_CALCULATOR = "FXMLEquationCalc.fxml";
    public static final String FOURIER_CALCULATOR = "FXMLFourier.fxml";
    public static final String GABORWAVELET_CALCULATOR = "FXMLGaborWavelet.fxml";
    public static final String INTEGRAL_CALCULATOR = "FXMLIntegral.fxml";
    public static final String MATRICES_CALCULATOR = "FXMLMatrixCalculation.fxml";
    public static final String SCIENTIFIC_CALCULATOR = "FXMLScientific.fxml";
    public static final String SETS_CALCULATOR = "FXMLBitWise.fxml";
  

    
    private static FXMLMainPaneController mainController;


    public static void setMainController(FXMLMainPaneController mainController) {
        WindowNavigator.mainController = mainController;
    }


    public static void loadPane(String fxml) {
        try {
            mainController.setPane(
                FXMLLoader.load(
                    WindowNavigator.class.getResource(
                        fxml
                    )
                )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}