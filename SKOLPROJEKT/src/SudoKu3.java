
//huiwdbjwbdkjwbdkwbdkwjd

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SudoKu3 extends Application {

	// Antal rader och kolumner i brädet
	private int NBR_COL = 9;
	private int NBR_ROW = 9;
	final int SIZE = 50; // bestämmer rutstorleken, kan bara göras en gång.. Ty Final
	private int count = 0;
	private int ROW;
	private int COL;
	private Map<String, String> map;
	public TextField tf;
	public BorderPane borderPane;
	public TilePane tilePane;

	int[][] GRID_TO_SOLVE = { { 7, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	@Override
	public void start(Stage stage) throws Exception {

		
		GRID grid = new GRID(GRID_TO_SOLVE);
		
		HBox hb = new HBox();
		Button clear = new Button("Clear");
		Button solve = new Button("Solve");
		hb.setSpacing(20);
		hb.getChildren().addAll(clear, solve);
		
		grid.getBorderPane().setCenter(grid.getTilePane());
		grid.getBorderPane().setBottom(hb);
		
		
		solve.setOnAction(event -> {
		
				grid.solve();
				
				GRID grid2 = new GRID(grid.getBoard());
				grid2.getBorderPane().setCenter(grid2.getTilePane());
				grid2.getBorderPane().setBottom(hb);
				
				Scene scene = new Scene(grid2.getBorderPane(), (50 * NBR_COL + 20), SIZE * NBR_ROW + 64);
				stage.setTitle("Suduko");
				stage.setScene(scene); // f�r att koppla scen-objektet till scengolvet (stage)
				stage.setResizable(false);// för att inte kunna ändra storlek på brädet

				// För att visa allt
				stage.show();
				
				
	});
		
		
		
		

		// ----------------------------------------------------

		Scene scene = new Scene(grid.getBorderPane(), (50 * NBR_COL + 10), SIZE * NBR_ROW + 50);
		stage.setTitle("Suduko");
		stage.setScene(scene); // f�r att koppla scen-objektet till scengolvet (stage)
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
