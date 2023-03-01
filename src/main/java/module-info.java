module and.codechallenge {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens and.codechallenge.challenge2 to javafx.fxml;
	exports and.codechallenge.challenge2;
}