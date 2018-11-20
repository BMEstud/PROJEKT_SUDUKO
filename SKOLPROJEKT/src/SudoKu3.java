
import java.util.ArrayList;
//huiwdbjwbdkjwbdkwbdkwjd

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
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
	private GRID grid;



	int[][] GRID_TO_SOLVE = { { 7, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	// KOMMENTAR
	//
	// JAG HAR ÄNDRAT SÅ JAG HAR DELAT UPP DET I OLIKA KLASSER. GRID-KLASSEN SKÖTER
	// OM SJÄLVA SPELPLANEN (MALLEN),
	// MEDAN DENNA KLASSEN (SudoKU3) är det grafiska

	@Override
	public void start(Stage stage) throws Exception {

		// Behållarkomponenter, BorderPane är själva "grunden"
		BorderPane borderPane = new BorderPane();
		HBox hb = new HBox();
		Button clear = new Button("Clear");
		Button solve = new Button("Solve");
		hb.setSpacing(20);
		hb.getChildren().addAll(clear, solve);

		grid = new GRID(GRID_TO_SOLVE);

		// lägger till tilepane i borderpane, centrerat
		borderPane.setLeft(grid.getTilePane());
		//lägger tillknapparna längst ner
		borderPane.setBottom(hb);

		stage.setResizable(false);// för att inte kunna ändra storlek på brädet
		
		

//			}

		// KALLA PÅ METODEN SOLVE I LÖSAR-KLASSEN
//			solver.solve();
//			
//			solver.display();

//			I den lyssnaren som kopplas till knappen ”Solve” ser man till att läsa av alla textfälten och
//			föra över motsvarande värden till modellen. Därefter anropas modellens solve-metod. Om
//			denna returnerar true hämtar man alla rutornas värden från modellen och visar dessa i
//			motsvarande textfält. Annars visas ett dialogfönster där det anges att ingen lösning finns.
//			Lyssnaren kopplad till knappen ”Clear” tömmer textfälten i vyn.
		
	

//		});
//
		solve.setOnAction(event -> {

			// KALLA PÅ METODEN CLEAR I LÖSAR-KLASSEN
			
			//brädet ska "läsas av" och föras över till modellen, dvs lösaren.
			
			Lösaren2 lösaren2 = new Lösaren2(GRID_TO_SOLVE);
			
			lösaren2.solve();
			System.out.print(lösaren2.getBoard());
			
			
			
			//loopa igenom hela brädet
			 
//			for(int i = 0; i<GRID_TO_SOLVE.length; i++) {
//				for(int j = 0; j<GRID_TO_SOLVE.length; j++) {
//				
//	
//					String s = grid.getTextField();
//					
//					array.add(s);
//				
//				} 
//	
//			}
//			

			
			
			
			
		

		});

		// ----------------------------------------------------

		Scene scene = new Scene(borderPane, (SIZE * NBR_COL + 10), SIZE * NBR_ROW + 50);
		stage.setTitle("Suduko");
		stage.setScene(scene); // f�r att koppla scen-objektet till scengolvet (stage)

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
