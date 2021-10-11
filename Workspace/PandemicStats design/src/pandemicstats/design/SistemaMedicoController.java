package pandemicstats.design;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pandemicstats.entidades.Paciente;
import javafx.event.ActionEvent;

public class SistemaMedicoController {
	
	@FXML
	private ComboBox<String> CMBXfabricanteMedico;
	
	@FXML
	private TableView<String> TBLMedico;
	
	@FXML
	private TextField TXTcpfMedico;
	
	@FXML
	private TableColumn CLNcodigoMedico;
	
	@FXML
	private TableColumn CLNnomeMedico;
	
	@FXML
	private TableColumn CLNcpfMedico;
	
	@FXML
	private TableColumn CLN1doseMedico;
	
	@FXML
	private TableColumn CLN2doseMedico;
	
	
	public void buscar()
	{
		Paciente pac=new Paciente(); 
	}
	
	public void Fabricante(ActionEvent event)
	{
		CMBXfabricanteMedico.getItems().addAll("Pfizer", "Jansen","Coronavac");
	}
	
	public void atualizar(ActionEvent event)
	{
		System.out.println(TBLMedico.getSelectionModel().getSelectedItem());
	}
}
