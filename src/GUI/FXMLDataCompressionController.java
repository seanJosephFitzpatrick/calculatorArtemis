 package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Sets drop down on initialization
		dropdownSelectImage.getItems().removeAll(dropdownSelectImage.getItems());
		dropdownSelectImage.getItems().addAll("Lena", "Baboon", "Barbara", "Moon");
		dropdownSelectImage.getSelectionModel().select("Lena");
	}

    @FXML
    void onActionBtnCompress(ActionEvent event) {
    	
    	//What to do when compress button selected
    	//The outputTextArea is just a variable to output your text.
    	
    	/*The drop down will have "Lena" auto selected
    	 * The import file variable will be null unless file selected*/
    }

    @FXML
    void onActionBtnImportImage(ActionEvent event) throws IOException {
    	Stage stage = null;
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
        	
        	//The location of the selected image is saved to savepath variable//
            savePath = file.getAbsolutePath().toString();
            
        } else {
        	savePath = null;
        }
    }

    @FXML
    String onActionDropdownSelectImage(ActionEvent event) {
    	//This returns the selected string from drop dwon and stores in output
    	String output = dropdownSelectImage.getSelectionModel().getSelectedItem().toString();
    	
    	//This is just if of what to do based on selected drop down
    	if(output.equalsIgnoreCase("Lena")){
    		return "Lena.jpg";
    	}else if(output.equalsIgnoreCase("Baboon")){
    		return "Babbon.png";
    	}else if(output.equalsIgnoreCase("Barbara")){
    		return "Barbara.png";
    	}else if(output.equalsIgnoreCase("Moon")){
    		return "Moon.png";
    	}else{
    		return null;
    	}
    }

}
