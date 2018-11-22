
//huiwdbjwbdkjwbdkwbdkwjd

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
	private GRID grid;
	private int count = 0;

	int[][] GRID_TO_SOLVE2 = { { 7, 7, 7, 1, 0, 0, 6, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 6, 0, 0 }, { 0, 8, 1, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 2, 1, 9, 0, 4, 5, 7, 0 }, };

	int[][] GRID_TO_SOLVE = { { 7, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	// KOMMENTAR
	// JAG HAR ÄNDRAT SÅ JAG HAR DELAT UPP DET I OLIKA KLASSER. GRID-KLASSEN SKÖTER
	// OM SJÄLVA SPELPLANEN (MALLEN),
	// MEDAN DENNA KLASSEN (SudoKU3) är det grafiska

	@Override
	public void start(Stage stage) throws Exception {

		List<String> list = new ArrayList<String>();

		HBox hb = new HBox();
		Button clear = new Button("Clear");
		Button solve = new Button("Solve");
		hb.setSpacing(20);
		hb.getChildren().addAll(clear, solve);

		// Behållarkomponenter, BorderPane är själva "grunden"
		BorderPane borderPane = new BorderPane();
		TilePane tilePane = new TilePane();

		borderPane.setCenter(tilePane);
		borderPane.setBottom(hb);

		int c = 0;
		int r = 0;

		for (int i = 0; i < NBR_COL * NBR_ROW; i++) { // lägger till en ruta, totalt 81 st, 9*9

			TextField tf = new TextField();
			tf.setPrefSize(SIZE, SIZE);
			tilePane.getChildren().addAll(tf);
			tf.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
			
			//Detta är upeerdyperviktigt, gör så att varje textfield blir numrerat för att vi ska kunna hämta värden och "läsa av"
			String string = Integer.toString(i);
			tf.setId(string);;

			count++;

			tilePane.setPadding(new Insets(1, 1, 1, 1));
			tilePane.setHgap(2);
			tilePane.setVgap(2);

//			//för att hålla reda på vilken ruta som blir tryckt
//			tf.setOnMousePressed(new EventHandler<MouseEvent>() {
//			      public void handle(MouseEvent me) {
//			    	  
//			    	  System.out.println(tf.getText());
//			          
//			        }
//			      });

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

			if (count < 4) {
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

			// ---------------------------------------------------

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

			tf.setOnMousePressed(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent me) {
					
					tf.setOnKeyReleased(event -> {
						if (event.getCode() == KeyCode.ENTER) {
							
						double xCordinate = me.getScreenX();
						

						System.out.println( tf.getId());
		
							
					
							
						}
					});

				}

			});

			solve.setOnAction(event -> {

				

			});

		}

		// ----------------------------------------------------

		Scene scene = new Scene(borderPane, (50 * NBR_COL + 10), SIZE * NBR_ROW + 50);
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
