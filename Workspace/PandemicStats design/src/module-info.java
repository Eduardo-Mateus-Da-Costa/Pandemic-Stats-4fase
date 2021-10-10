module PandemicStats.design {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens pandemicstats.design to javafx.graphics, javafx.fxml;
}
