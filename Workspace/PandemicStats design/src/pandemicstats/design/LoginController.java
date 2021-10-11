package pandemicstats.design;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class LoginController {
	@FXML
	private Label  LBLLogin;
	
	@FXML
	private TextField TXTLoginLogin;
	
	@FXML
	private PasswordField PSWTXTSenhaLogin;
	
	@FXML
	private CheckBox CKBCadastroLogin;
	
	public Main main=new Main();
	
	public void LoginPaciente(ActionEvent event) throws IOException
	{
		if (CKBCadastroLogin.isSelected())
		{
			if(TXTLoginLogin.getText()=="" || PSWTXTSenhaLogin.getText()=="")
			{
				LBLLogin.setText("As informações não podem ser vazias");
			}
			else
			{
				String Login=TXTLoginLogin.getText();
				String Senha=PSWTXTSenhaLogin.getText();
			
				//Para fins de teste
				LBLLogin.setText(Login+Senha);
			
				main.start(new Stage(), 600, 600, "SistemaPaciente.fxml", "SistemaPaciente.css");
			}
		}
		else
		{
			if (TXTLoginLogin.getText().equals("Dudu") && PSWTXTSenhaLogin.getText().equals("Teste")) 
			{
				main.start(new Stage(), 600, 600, "SistemaPaciente.fxml", "SistemaPaciente.css");
			}
			else
			{
				LBLLogin.setText("O login ou a senha estão incorretos");
			}
		}
	}
	public void LoginEmpresa(ActionEvent event) throws IOException
	{
		if (CKBCadastroLogin.isSelected())
		{
			if(TXTLoginLogin.getText()=="" || PSWTXTSenhaLogin.getText()=="")
			{
				LBLLogin.setText("As informações não podem ser vazias");
			}
			else
			{
				String Login=TXTLoginLogin.getText();
				String Senha=PSWTXTSenhaLogin.getText();
			
				//Para fins de teste
				LBLLogin.setText(Login+Senha);
			
				main.start(new Stage(), 600, 600, "SistemaEmpresa.fxml", "SistemaEmpresa.css");
			}
		}
		else
		{
			if (TXTLoginLogin.getText().equals("Dudu") && PSWTXTSenhaLogin.getText().equals("Teste")) 
			{
				main.start(new Stage(), 600, 600, "SistemaEmpresa.fxml", "SistemaEmpresa.css");
			}
			else
			{
				LBLLogin.setText("O login ou a senha estão incorretos");
			}
		}
	}
	public void LoginMedico(ActionEvent event) throws IOException
	{
		if (CKBCadastroLogin.isSelected())
		{
			if(TXTLoginLogin.getText()=="" || PSWTXTSenhaLogin.getText()=="")
			{
				LBLLogin.setText("As informações não podem ser vazias");
			}
			else
			{
				String Login=TXTLoginLogin.getText();
				String Senha=PSWTXTSenhaLogin.getText();
			
				//Para fins de teste
				LBLLogin.setText(Login+Senha);
				
				main.start(new Stage(), 600, 600, "SistemaMedico.fxml", "SistemaMedico.css");
			}
		}
		else
		{
			if (TXTLoginLogin.getText().equals("Dudu") && PSWTXTSenhaLogin.getText().equals("Teste")) 
			{
				main.start(new Stage(), 600, 600, "SistemaMedico.fxml", "SistemaMedico.css");
			}
			else
			{
				LBLLogin.setText("O login ou a senha estão incorretos");
			}
		}
		
	}
	
}
