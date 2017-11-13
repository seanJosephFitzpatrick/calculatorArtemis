package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
    @FXML
    private Button buttonPrevious;
    @FXML
    private Button buttonNext;
    @FXML
    private ImageView imageViewWindow;
    private static ArrayList<String> names;
    private static int count=0;
    
    
    //private static String filePath="file:///C:\\Users\\Marti\\git\\calculatorartemis\\GaborImages\\";
    private static String filePath;
    
    //file path has to be changed on different machines.
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		varphi.setText("90");
		upsi.setText("1");
		bandw.setText("1");
		buttonNext.setVisible(false);
		buttonPrevious.setVisible(false);
		
		String absolutePath = new File(".").getAbsolutePath();//Get path of your Project Folder
		int last = absolutePath.length()-1;
		absolutePath = absolutePath.substring(0, last);//Remove dot from path
		String file =  "GaborImages\\";
		filePath = ("file:///"+absolutePath + file);//Append GaborImages folder
		filePath = filePath.replace("\\", "/");//replace backslash with forward slash
		//System.out.println(filePath);
		
	}
	
    @FXML
    void onActionBtnGenerate(ActionEvent event) throws IllegalArgumentException,IOException, URISyntaxException {
    	try {
    		double v = Double.parseDouble(varphi.getText());
    		double u = Double.parseDouble(upsi.getText());
    		double b = Double.parseDouble(bandw.getText());
    		Gabor_Driver.runGabor(v, u, b);
    		File f = new File("GaborImages\\");
    		names = new ArrayList<String>(Arrays.asList(f.list()));    		
    		System.out.println(names);
    		buttonNext.setVisible(true);
    		buttonPrevious.setVisible(true);
        	imageViewWindow.setImage(new Image(filePath+names.get(count)));
        	
   
    	} catch (Exception e){
    		
    	}
    }
    @FXML
    void onActionButtonNext(ActionEvent event){
    	if(count==names.size()-1){
    		count=0;
    	}else{
    		count++;
    	}
    	imageViewWindow.setImage(new Image(filePath+names.get(count)));
    	
    }	
    @FXML
    void onActionButtonPrevious(ActionEvent event){
    	if(count==0){
    		count=names.size()-1;
    	}else{
    		count--;
    	}
    	imageViewWindow.setImage(new Image(filePath+names.get(count)));
    }
}
