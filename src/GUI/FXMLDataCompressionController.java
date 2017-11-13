 package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DCT.DCTDriver;
import DCT.ImageFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//@TODO retrieve qValue from Text Field
//@TODO show output in TextField
public class FXMLDataCompressionController implements Initializable {
    @FXML
    private Button btnOpenFile;
    @FXML
    private Button btnImportImage;
    @FXML
    private Button btnCompress;
    @FXML
    private ComboBox<String> dropdownSelectImage;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private TextField qValue;
    private String savePath;
    private double quantizationValue;
    @FXML
    private Button btnCompare;
    @FXML
    private TextField newFileSizeTextField;
    @FXML
    private TextField oldFileSizeTextField;
    @FXML
    private TextField indexTextField;
    private DCTDriver driver;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Sets drop down on initialization
		dropdownSelectImage.getItems().removeAll(dropdownSelectImage.getItems());
		dropdownSelectImage.getItems().addAll("lena.jpg", "baboon.png", "moon.png");
		dropdownSelectImage.getSelectionModel().select("lena.jpg");
		driver = new DCTDriver();
	}

    @FXML
    void onActionBtnCompress(ActionEvent event) {
    	quantizationValue = Double.parseDouble(qValue.getText());
    	driver.loadImage(dropdownSelectImage.getSelectionModel().getSelectedItem().toString());
    	driver.compressImage(quantizationValue);

    	File oldFile = new File("Images/" + dropdownSelectImage.getSelectionModel().getSelectedItem().toString());
    	File newFile = new File("Images/compressedImage.jpg");

    	oldFileSizeTextField.setText(Long.toString(oldFile.length()) + " bytes");
    	newFileSizeTextField.setText(Long.toString(newFile.length()) + " bytes");
    }

    @FXML
    void onActionBtnCompare(ActionEvent event) {
    	driver.resetStringBuilder();
    	outputTextArea.clear();
    	outputTextArea.setText(driver.compareChunks(Integer.parseInt(indexTextField.getText())) + "\n\n");
    }

    @FXML
    void onActionBtnImportImage(ActionEvent event) throws IOException {
    	Stage stage = null;
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
        	//The location of the selected image is saved to savepath variable//
            savePath = file.getAbsolutePath().toString();
            ImageFactory.importImage(savePath);
        } else {
        	savePath = null;
        }
    }

    @FXML
    String onActionDropdownSelectImage(ActionEvent event) {
    	//This returns the selected string from drop down and stores in output
    	String output = dropdownSelectImage.getSelectionModel().getSelectedItem().toString();

    	//This is just if of what to do based on selected drop down
    	if(output.equalsIgnoreCase("Lena")){
    		return  "lena.jpg";
    	}else if(output.equalsIgnoreCase("Baboon")){
    		return "laboon.png";
    	}else if(output.equalsIgnoreCase("Barbara")){
    		return "barbara.png";
    	}else if(output.equalsIgnoreCase("Moon")){
    		return "moon.png";
    	}else{
    		return "lena.jpg";
    	}
    }

}
