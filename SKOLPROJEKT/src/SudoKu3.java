
//huiwdbjwbdkjwbdkwbdkwjd

import javafx.application.Application;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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

	int[][] EMPTY_GRID = { { 7, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 }, { 8, 0, 0, 0, 4, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 2, 6, 0, 0, 9 },
			{ 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 }, { 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	int[][] EMPTY_GRID_TEMP = { { 7, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	int[][] EMPTY_GRI1D = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };

	@Override
	public void start(Stage stage) throws Exception {

		GRID grid = new GRID(EMPTY_GRID);

		HBox hb = new HBox();
		Button clear = new Button("Clear");
		Button solve = new Button("Solve");
		hb.setSpacing(20);
		hb.getChildren().addAll(clear, solve);

		grid.getBorderPane().setCenter(grid.getTilePane());
		grid.getBorderPane().setBottom(hb);

		solve.setOnAction(event -> {

//			I den lyssnaren som kopplas till knappen ”Solve” ser man till att läsa av alla textfälten och
//			föra över motsvarande värden till modellen. Därefter anropas modellens solve-metod. Om
//			denna returnerar true hämtar man alla rutornas värden från modellen och visar dessa i
//			motsvarande textfält. Annars visas ett dialogfönster där det anges att ingen lösning finns.

			int row = 0;
			int col = 0;

			// the text Fields are read off and transfered to the model (i.e GRID_TO_SOLVE)
			for (Node node : grid.getTilePane().getChildren()) {

				if (((TextField) node).getText().equals("")) {

					// the cells that contains no number are set to 0
					((TextField) node).setText("0");
				}

				EMPTY_GRID[row][col] = Integer.parseInt(((TextField) node).getText());

				col++;

				if (col == 9) {
					col = 0;
					row++;
				}

			}

			if (grid.solve(0, 0) == false) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sudukot går ej att lösa");
				alert.setHeaderText(null);
				alert.setContentText("Det saknas lösning");
				alert.showAndWait();

			} else {
//				
				GRID grid2 = new GRID(grid.getBoard());
				grid2.getBorderPane().setCenter(grid2.getTilePane());
				grid2.getBorderPane().setBottom(hb);

				Scene scene = new Scene(grid2.getBorderPane(), (50 * NBR_COL + 20), SIZE * NBR_ROW + 64);
				stage.setTitle("Suduko");
				stage.setScene(scene); // f�r att koppla scen-objektet till scengolvet (stage)
				stage.setResizable(false);// för att inte kunna ändra storlek på brädet
//
//				 För att visa allt
				stage.show();

			}

		});

		clear.setOnAction(event ->

		{
			
			//When we use "clear" we will empty the board, even though we have solved the puzzle or not
			GRID grid2 = new GRID(EMPTY_GRI1D);
			grid2.getBorderPane().setCenter(grid2.getTilePane());
			grid2.getBorderPane().setBottom(hb);

			Scene scene = new Scene(grid2.getBorderPane(), (50 * NBR_COL + 20), SIZE * NBR_ROW + 64);
			stage.setTitle("Suduko");
			stage.setScene(scene); // f�r att koppla scen-objektet till scengolvet (stage)
			stage.setResizable(false);// för att inte kunna ändra storlek på brädet
//
//			 För att visa allt
			stage.show();

		});

		// ----------------------------------------------------

		Scene scene = new Scene(grid.getBorderPane(), (50 * NBR_COL + 10), SIZE * NBR_ROW + 50);
		stage.setTitle("Suduko");
		stage.setScene(scene); // f�r att koppla scen-objektet till
								// scengolvet (stage)
		stage.setResizable(false);// för att inte kunna ändra storlek på brädet

		// För att visa allt
		stage.show();

	}

	public static void main(String[] args) {
		// Mainmetoden anv�nds endast f�r att starta javaFX, d�refter har javaFX
		// kontrollen.

		Application.launch(args); // Det skapas automatiskt ett objekt av v�r BookReaderController och v�r metod
									// start anropas p� objektet

	}
}
