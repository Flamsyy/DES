package des.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class MainController implements Initializable
{
	@FXML public VBox mainVBox;
	@FXML public TextArea inputTextArea;
	@FXML public ComboBox<String> modeComboBox;
	@FXML public RadioButton paddingOneButton;
	@FXML public RadioButton paddingTwoButton;
	@FXML public TextField keyTextField;
	@FXML public Button encryptButton;
	@FXML public Button decryptButton;
	@FXML public TextArea outputTextArea;
	@FXML public ToggleGroup paddingGroup;
	
	public String mode, padding, key;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		mainVBox.setStyle("-fx-background-color: #E6E6E6;");
		
		inputTextArea.setPromptText("Enter text to encrypt/decrypt here...");
		
		modeComboBox.setItems(FXCollections.observableArrayList("Electronic Code Book (ECB)", "Cipher Block Training (CBC)", "Cipher Feedback Mode (CFB)", "Output Feedback Mode (OFB)", "Counter Mode (CTR)"));
		
		modeComboBox.setPromptText("Mode"); 
	
		paddingGroup = new ToggleGroup();
		paddingOneButton.setToggleGroup(paddingGroup);
		paddingTwoButton.setToggleGroup(paddingGroup);
		
		keyTextField.setPromptText("Key");
		
		outputTextArea.setEditable(false);
		encryptButton.setOnAction(e ->
		{
			System.out.println("Encrypting...");
		});
		decryptButton.setOnAction(e ->
		{
			System.out.println("Decrypting...");
		});
		
	}
}
