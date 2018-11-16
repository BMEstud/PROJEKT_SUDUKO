
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	private int count = 0;
	private TextField tf;
	private int r = 0;
	private int c = 0;
	private Lösaren solver;

	int[][] GRID_TO_SOLVE = { { 9, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	@Override
	public void start(Stage stage) throws Exception {

		// Behållarkomponenter, BorderPane är själva "grunden"
		BorderPane borderPane = new BorderPane();
		TilePane tilePane = new TilePane();
		HBox hb = new HBox();

		
		Lösaren solver = new Lösaren(GRID_TO_SOLVE);
		// Knappar
		Button clear = new Button("Clear");
		Button solve = new Button("Solve");

		// Mellanrum mellan knapparna (buttons)
		hb.setSpacing(20);
		hb.getChildren().addAll(clear, solve);

		tilePane.setPadding(new Insets(1, 1, 1, 1));
		tilePane.setHgap(2);
		tilePane.setVgap(2);

		
		// 9:0rna bestämmer hur många rutor totalt i x-y led, dvs 9*9
		for (int i = 0; i < NBR_COL * NBR_ROW; i++) { // lägger till en ruta, totalt 81 st, 9*9

			tf = new TextField();
			tf.setPrefSize(SIZE, SIZE);
			tilePane.getChildren().addAll(tf);
			tf.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
			count++;
			

			int s = GRID_TO_SOLVE[r][c];
			String str = Integer.toString(s);
			tf.setText(str);

			if (s == 0) {
				tf.setText("");
			}

			c++;

			if (c == 9) {
				c = 0;
				r++;
			}

			// Tittar, ifall rutan är tom, så ska det gå att skriva, annars ej
			if (!tf.getText().equals("")) {

				// Formatera texten, siffrorna från början ska vara stora och svarta
				tf.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
				tf.setEditable(false);
			}
			
		
			

			// -----------------FÄRGA BRÄDET---------------------

			if (count < 4 && i < 29) {
				tf.setStyle("-fx-background-color:  pink;");
			}

			if (count > 6 && count < 13) {
				tf.setStyle("-fx-background-color:  pink;");
			}

			if (count > 15 && count < 22) {
				tf.setStyle("-fx-background-color:  pink;");
			}
			if (count > 24 && count < 28) {
				tf.setStyle("-fx-background-color:  pink;");
			}

			// ---------------------------------------------------

			if (count > 30 && count < 34) {
				tf.setStyle("-fx-background-color:  pink;");
			}

			if (count > 39 && count < 43) {
				tf.setStyle("-fx-background-color:  pink;");
			}

			if (count > 48 && count < 52) {
				tf.setStyle("-fx-background-color:  pink;");
			}

			//---------------------------------------------------

			if (count > 54 && i < 57) {
				tf.setStyle("-fx-background-color:  pink;");
			}

			if (count > 60 && count < 67) {
				tf.setStyle("-fx-background-color:  pink;");
			}

			if (count > 69 && count < 76) {
				tf.setStyle("-fx-background-color:  pink;");
			}
			if (count > 78 && count < 82) {
				tf.setStyle("-fx-background-color:  pink;");
			}

		}
		

		// lägger till tilepane i borderpane, centrerat
		borderPane.setLeft(tilePane);

		// Lägger till knapparna längst ner i fönstret
		borderPane.setBottom(hb);
		
		
			
		
		
		
		//----------------------HANTERA KNAPPARNA----------------

		stage.setResizable(false);// för att inte kunna ändra storlek på brädet

		solve.setOnAction(event -> {
			
			for (int i = 0; i < NBR_COL * NBR_ROW; i++) {
				
				
			
			}

			//KALLA PÅ METODEN SOLVE I LÖSAR-KLASSEN
			solver.solve();
			
			solver.display();
			
//			I den lyssnaren som kopplas till knappen ”Solve” ser man till att läsa av alla textfälten och
//			föra över motsvarande värden till modellen. Därefter anropas modellens solve-metod. Om
//			denna returnerar true hämtar man alla rutornas värden från modellen och visar dessa i
//			motsvarande textfält. Annars visas ett dialogfönster där det anges att ingen lösning finns.
//			Lyssnaren kopplad till knappen ”Clear” tömmer textfälten i vyn.
			

		});

		clear.setOnAction(event -> {

			// KALLA PÅ METODEN CLEAR I LÖSAR-KLASSEN

		});
		
		//----------------------------------------------------

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
