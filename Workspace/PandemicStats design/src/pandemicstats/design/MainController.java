package pandemicstats.design;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class MainController {
	@FXML
	private Label  LBLLogin;
	
	@FXML
	private TextField TXTLoginLogin;
	
	@FXML
	private PasswordField PSWTXTSenhaLogin;
	
	public void LoginPaciente(ActionEvent event) throws IOException
	{
		if (TXTLoginLogin.getText().equals("Dudu") && PSWTXTSenhaLogin.getText().equals("Teste")) 
		{
			LBLLogin.setText("Login Sucess");
			Stage secondaryStage = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("SistemaPaciente.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}
		else
		{
			LBLLogin.setText("Login Failed");
		}
	}
	public void LoginEmpresa(ActionEvent event) throws IOException
	{
		if (TXTLoginLogin.getText().equals("Dudu") && PSWTXTSenhaLogin.getText().equals("Teste")) 
		{
			LBLLogin.setText("Login Sucess");
			Stage secondaryStage = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("SistemaEmpresa.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}
		else
		{
			LBLLogin.setText("Login Failed");
		}
	}
	public void LoginMedico(ActionEvent event) throws IOException
	{
		if (TXTLoginLogin.getText().equals("Dudu") && PSWTXTSenhaLogin.getText().equals("Teste")) 
		{
			LBLLogin.setText("Login Sucess");
			Stage secondaryStage = new Stage();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("SistemaMedico.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setScene(scene);
			secondaryStage.show();
		}
		else
		{
			LBLLogin.setText("Login Failed");
		}
	}
	
}
