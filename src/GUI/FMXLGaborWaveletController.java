package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import gabor.Gabor_Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
    void onActionBtnGenerate(ActionEvent event) throws IOException, URISyntaxException {
    	try {
    		double v = Double.parseDouble(varphi.getText());
    		double u = Double.parseDouble(upsi.getText());
    		double b = Double.parseDouble(bandw.getText());
    		Gabor_Driver.runGabor(v, u, b);
    	} catch (Exception e){
    		
    	}
    }
}
