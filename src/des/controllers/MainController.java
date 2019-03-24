package des.controllers;

import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import des.DES;
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
	public ToggleGroup paddingGroup;
	
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
			String msg = inputTextArea.getText();
			String mode = modeComboBox.getSelectionModel().getSelectedItem();
			String padding = null;
			RadioButton selected = (RadioButton) paddingGroup.getSelectedToggle();
			String key = keyTextField.getText();
			String encryptedMsg = "";
			
			if(mode == null || selected == null || key == null || key.equals(""))
			{
				System.out.println("Please fill in all fields");
				return;
			}
			padding = selected.getText();
			mode = mode.substring(mode.indexOf("(")+1, mode.lastIndexOf(")"));
			if(key.length() != 8)
			{
				System.out.printf("invalid key length %d, expecting %d\n", key.length(), 8);
				return;
			}
			try
			{
				encryptedMsg = DES.encrypt(msg, mode, padding, key);
			}
			catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException | InvalidAlgorithmParameterException e2)
			{
				e2.printStackTrace();
			}
			outputTextArea.setText(encryptedMsg);
		});
		decryptButton.setOnAction(e ->
		{
			String msg = inputTextArea.getText();
			String mode = modeComboBox.getSelectionModel().getSelectedItem();
			String padding = null;
			RadioButton selected = (RadioButton) paddingGroup.getSelectedToggle();
			String key = keyTextField.getText();
			String decryptedMsg = "";
			
			if(mode == null || selected == null || key == null || key.equals(""))
			{
				System.out.println("Please fill in all fields");
				return;
			}
			padding = selected.getText();
			mode = mode.substring(mode.indexOf("(")+1, mode.lastIndexOf(")"));
			if(key.length() != 8)
			{
				System.out.printf("invalid key length %d, expecting %d\n", key.length(), 8);
				return;
			}
			try
			{
				decryptedMsg = DES.decrypt(msg, mode, padding, key);
			}
			catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
					| BadPaddingException | InvalidAlgorithmParameterException e2)
			{
				e2.printStackTrace();
			}
			outputTextArea.setText(decryptedMsg);
		});
		
	}
}
