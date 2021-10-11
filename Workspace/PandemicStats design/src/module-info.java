module PandemicStats.design {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens pandemicstats.design to javafx.graphics, javafx.fxml;
}
