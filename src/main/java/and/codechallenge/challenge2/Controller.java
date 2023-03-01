package and.codechallenge.challenge2;

import java.net.URL;
import java.util.ResourceBundle;

import and.codechallenge.challenge2.controller.Game;
import and.codechallenge.challenge2.model.Ant;
import and.codechallenge.challenge2.model.Board;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;

public class Controller implements Initializable {
	
	
	@FXML
	private ChoiceBox<String> startingOrientation;
	@FXML
	private ChoiceBox<String> startingGridSize;
	@FXML
	private ChoiceBox<String> stepsPerRefresh;
	@FXML
	private ChoiceBox<String> delayTime;
	@FXML
	private ChoiceBox<String> maxRounds;
	
	@FXML
	private Button resetButton;
	@FXML
	private GridPane langtonAntGridPane;
	
	private final String[] ORIENTATION = {"UP","DOWN","LEFT","RIGHT"};
	private final String[] GRID = {"5 x 5","15 x 15","30 x 30", "100 x 100"};
	private final String[] STEPS = {"1","10","100","1000","10000"};
	private final String[] DELAY = {"0.01","0.1","0.5","1","2"};
	private final String[] ROUNDS = {"1","2","10","100","1000","10000","12000","100000"};
	
	private Ant ant;
	private Board board;
	
	public Controller() {
		ant = Ant.getInstance();
		board = Board.getInstance();
		setupListeners();
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		
		startingOrientation.getItems().addAll(ORIENTATION);
		startingGridSize.getItems().addAll(GRID);
		stepsPerRefresh.getItems().addAll(STEPS);
		delayTime.getItems().addAll(DELAY);
		maxRounds.getItems().addAll(ROUNDS);
		
		startingOrientation.getSelectionModel().select(0);
		startingGridSize.getSelectionModel().select(0);
		stepsPerRefresh.getSelectionModel().select(0);
		delayTime.getSelectionModel().select(3);
		maxRounds.getSelectionModel().select(1);
		
		paintGrid();
	}
	
	// Main start button
	public void setAntFree() {
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Action not yet working");
		alert.setHeaderText("Action not yet working");
		alert.setContentText("Action not yet working. Move ant using 'Play Next'");
		alert.show();
		
//		rotateAnt();
//		updateBoardInputVariables();
//		new Game(ant, board).start();
//		System.out.println(ant.getCoordinate());
	}
	public void playNext() {
		new Game(ant, board).moveAnt();
	}
	public void reset() {
		rotateAnt();
		updateBoardInputVariables();
		paintGrid();
	}
	
	
	private void updateBoardInputVariables() {
		board.setup(getGridSize(), getRounds(), getStepsPerRound(), getDelay());
	}
	
	
	public void rotateAnt() {
		Ant ant = Ant.getInstance();
		ant.setDirection(startingOrientation.getValue());
		ant.getImageView().rotateProperty().setValue(ant.getDirection());
	}
	
	public void updateGridSize() {
		board.setGridSize(getGridSize());
	}
	
	private void paintGrid() {
		
		langtonAntGridPane.getChildren().clear();
		langtonAntGridPane.getColumnConstraints().clear();
		langtonAntGridPane.getRowConstraints().clear();
		langtonAntGridPane.setBackground(Background.fill(Paint.valueOf("#000000")));
		langtonAntGridPane.setGridLinesVisible(true);
		langtonAntGridPane.autosize();
		
		int antX = ant.getCoordinate().getX();
		int antY = ant.getCoordinate().getY();
		
		int gridSize = board.getGridSize().get();
		
		int w = (int)((langtonAntGridPane.widthProperty().intValue()/gridSize)*0.99);
		int h = (int)((langtonAntGridPane.heightProperty().intValue()/gridSize)*0.99);
		
		
		for (int i = 0; i < gridSize; i++) {
			ColumnConstraints columnConstraints = new ColumnConstraints(-1, -1, -1, Priority.ALWAYS, HPos.CENTER, true);
			columnConstraints.setPercentWidth(100/gridSize);
			langtonAntGridPane.getColumnConstraints()
					.add(columnConstraints);
			for (int j = 0; j < gridSize; j++) {
				if (i == 0) {
					RowConstraints rowConstraints = new RowConstraints(-1, -1, -1, Priority.ALWAYS, VPos.CENTER, true);
					rowConstraints.setPercentHeight(100/gridSize);
					langtonAntGridPane.getRowConstraints()
							.add(rowConstraints);
				}
				
				StackPane gridPane = board.getGridPaneMap().get(i).get(j);
				gridPane.setBorder(Border.stroke(Paint.valueOf("#111111")));
				gridPane.setMaxWidth(w);
				gridPane.setMaxHeight(h);
				if(i == antX && j == antY) {
					ant.getImageView().setFitWidth(w*0.9);
					ant.getImageView().setFitHeight(h*0.9);
					gridPane.getChildren().add(ant.getImageView());
				}
				langtonAntGridPane.add(gridPane, i, j);
			}
		}
	}
	
	private String getValue(ChoiceBox<String> choiceBox) throws IllegalStateException{
		String value = choiceBox.getValue();
		if (value == null || value.isBlank())
			throw new IllegalStateException("All input fields required");
		return choiceBox.getValue();
	}
	
	private int getGridSize() {
		int gridSize;
		switch (getValue(startingGridSize)) {
			case "5 x 5" :
				gridSize = 5;
				break;
			case "15 x 15" :
				gridSize = 15;
				break;
			case "30 x 30" :
				gridSize = 30;
				break;
			default:
				gridSize = 1;
				break;
		}
		return gridSize;
	}
	
	
	private long getDelay() {
		return Long.parseLong(getValue(delayTime));
	}
	
	
	private int getStepsPerRound() {
		return Integer.parseInt(getValue(stepsPerRefresh));
	}
	
	
	private int getRounds() {
		return Integer.parseInt(getValue(maxRounds));
	}
	
	private void setupListeners() {
		board.getGridSize().addListener((observableValue, number, t1) -> {
			System.out.println("Grid changed");
			paintGrid();
		});
	}
}
