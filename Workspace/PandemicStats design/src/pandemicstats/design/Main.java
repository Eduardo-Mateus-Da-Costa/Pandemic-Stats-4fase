package pandemicstats.design;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application{
	
	public void start(Stage pStage, int larg, int altu, String arquivo, String arquivocss) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(arquivo));
			Scene scene = new Scene(root,altu,larg);
			scene.getStylesheets().add(getClass().getResource(arquivocss).toExternalForm());
			pStage.setScene(scene);
			pStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Stage pStage= new Stage();
		int larg=400;
		int altu=350;
		String arquivo="Login.fxml";
		String arquivocss="Login.css";
		Main main = new Main();
		main.start(pStage, altu, larg, arquivo, arquivocss);
	}
}
