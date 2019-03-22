package des;
	
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application
{
	public static Stage window;
	public AnchorPane root;
	@Override
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		try
		{
			root = FXMLLoader.load(getClass().getResource("layouts/main_layout.fxml"));
			Scene scene = new Scene(root,300,400);
			scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());
			window.setScene(scene);
			window.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
		
	}
}
