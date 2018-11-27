
//huiwdbjwbdkjwbdkwbdkwjd

import javafx.application.Application;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class SudoKu3 extends Application {

	// Antal rader och kolumner i brädet
	private int NBR_COL = 9;
	private int NBR_ROW = 9;
	final int SIZE = 50; // bestämmer rutstorleken, kan bara göras en gång.. Ty Final
	public TextField tf;
	public BorderPane borderPane;
	public TilePane tilePane;
	private GRID grid;
	private Stage stage;

	int[][] EMPTY_GRID = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
	
	int[][] GRID_TO_SOLVE = { { 7, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;

		grid = new GRID(GRID_TO_SOLVE);

		HBox hb = new HBox();
		Button clear = new Button("Clear");
		Button solve = new Button("Solve");
		hb.setSpacing(20);
		hb.getChildren().addAll(clear, solve);

		grid.getBorderPane().setCenter(grid.getTilePane());
		grid.getBorderPane().setBottom(hb);

		solve.setOnAction(event -> {

			int row = 0;
			int col = 0;

			// the text Fields are read off and transfered to the model (i.e GRID_TO_SOLVE),
			// 81 textfields are read off
			for (Node node : grid.getTilePane().getChildren()) {

				if (((TextField) node).getText().equals("")) {

					// the cells that contains no number are set to 0
					((TextField) node).setText("0");
				}

				// every textfield are being read off and put into the matrix model
				// Integer.parseInt(((TextField) node).getText()); gives every number the user
				// has entered
				GRID_TO_SOLVE[row][col] = Integer.parseInt(((TextField) node).getText());

				col++;

				if (col == 9) {
					col = 0;
					row++;
				}

			}

			// we call the GRID-class with the new matrix, the matrix now corresponds to
			// what values the user has entered
			// in the textfields
			grid = new GRID(GRID_TO_SOLVE);

			// When we use the solve method,the matrix EMPTY_GRID will change..
			if (grid.solve(0, 0) == false) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sudukot går ej att lösa");
				alert.setHeaderText(null);
				alert.setContentText("Det saknas lösning");
				alert.showAndWait();

				return;

			}

//			//we create a new object with an updated matrix, since this matrix will be used in the stage
			grid = new GRID(grid.getBoard());
			grid.getBorderPane().setCenter(grid.getTilePane());
			grid.getBorderPane().setBottom(hb);

			setStage2(grid.getBorderPane()).show();

		});

		clear.setOnAction(event ->

		{

			// When we use "clear" we will empty the board, i.e empty the textfields
			grid = new GRID(EMPTY_GRID);

			grid.getBorderPane().setCenter(grid.getTilePane());
			grid.getBorderPane().setBottom(hb);

			setStage2(grid.getBorderPane()).show();
		});

		setStage(grid.getBorderPane()).show();

	}

	private Stage setStage(BorderPane borderPane) {

		Scene scene = new Scene(borderPane, (50 * NBR_COL + 10), SIZE * NBR_ROW + 50);
		stage.setTitle("Suduko");
		stage.setScene(scene);

		stage.setResizable(false);// för att inte kunna ändra storlek på brädet

		return stage;
	}

	private Stage setStage2(BorderPane borderPane) {

		Scene scene = new Scene(borderPane, (50 * NBR_COL + 22), SIZE * NBR_ROW + 62);
		stage.setTitle("Suduko");
		stage.setScene(scene);

		stage.setResizable(false);// för att inte kunna ändra storlek på brädet

		return stage;
	}

	public static void main(String[] args) {
		
		// Mainmetoden anv�nds endast f�r att starta javaFX, d�refter har javaFX
		// kontrollen.

		Application.launch(args); // Det skapas automatiskt ett objekt av v�r BookReaderController och v�r metod
									// start anropas p� objektet

	}
}
