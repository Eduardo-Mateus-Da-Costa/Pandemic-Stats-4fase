module PandemicStats.design {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens pandemicstats.design to javafx.graphics, javafx.fxml;
}
