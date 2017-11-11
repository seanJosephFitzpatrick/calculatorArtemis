package GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

public class FXMLMainPaneController {

    @FXML
    private StackPane stackPane;
    @FXML
    private MenuItem  idBasic;
    @FXML
    private MenuItem  idScientific;
    @FXML
    private MenuItem  idIntegral;
    @FXML
    private MenuItem idConversion;
    @FXML
    private MenuItem idDataCompression;
    @FXML
    private MenuItem idEquation;
    @FXML
    private MenuItem idFourier;
    @FXML
    private MenuItem idGabor;
    @FXML
    private MenuItem idMatrices;
    @FXML
    private MenuItem idSets;
    @FXML
    private Label headerLabel;

    public void setPane(Node node) {
    	stackPane.getChildren().setAll(node);
    }
    
    @FXML
    void onActionBasic(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.BASIC_CALCULATOR);
    }

    @FXML
    void onActionIntegral(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.INTEGRAL_CALCULATOR);
    }

    @FXML
    void onActionConversion(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.CONVERSION_CALCULATOR);
    }

    @FXML
    void onActionDataCompression(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.DATA_COMPRESSION_CALCULATOR);
    }

    @FXML
    void onActionEquation(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.EQUATION_CALCULATOR);
    }

    @FXML
    void onActionFourier(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.FOURIER_CALCULATOR);
    }

    @FXML
    void onActionGabor(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.GABORWAVELET_CALCULATOR);
    }

    @FXML
    void onActionMatrices(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.MATRICES_CALCULATOR);
    }
    
    @FXML
    void onActionScientific(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.SCIENTIFIC_CALCULATOR);
    }

    @FXML
    void onActionSets(ActionEvent event) {
    	WindowNavigator.loadPane(WindowNavigator.SETS_CALCULATOR);
    }
}