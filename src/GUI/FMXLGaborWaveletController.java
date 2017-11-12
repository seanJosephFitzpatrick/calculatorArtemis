package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import gabor.Gabor_Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FMXLGaborWaveletController implements Initializable {
	
    @FXML
    private TextField varphi;
    @FXML
    private TextField upsi;
    @FXML
    private TextField bandw;
    @FXML
    private Button btnGenerate;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		varphi.setText("90");
		upsi.setText("1");
		bandw.setText("1");
	}
	
    @FXML
    void onActionBtnGenerate(ActionEvent event) {
    	try {
    		double v = Double.parseDouble(varphi.getText());
    		double u = Double.parseDouble(upsi.getText());
    		double b = Double.parseDouble(bandw.getText());
    		Gabor_Driver.runGabor(v, u, b);
    	} catch (Exception e){
    		
    	}
    }
}
