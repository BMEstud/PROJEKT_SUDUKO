
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class SudoKu extends Application {

	
	//Antal rader och kolumner i brädet
	private int NBR_COL = 9;
	private int NBR_ROW = 9;
	final int SIZE = 50; // bestämmer rutstorleken, kan bara göras en gång.. Ty Final
	private int count = 0;

	
	
	@Override
	public void start(Stage stage) throws Exception {

		
		//Behållarkomponenter, BorderPane är själva "grunden"
		BorderPane borderPane = new BorderPane();
		TilePane tilePane = new TilePane();
		HBox hb = new HBox();
	

		//Knappar
		Button clear = new Button("Clear");
		Button solve = new Button("Solve");

		// Mellanrum mellan knapparna (buttons)
		hb.setSpacing(20);
		hb.getChildren().addAll(clear, solve);

		tilePane.setPadding(new Insets(1, 1, 1, 1));
		tilePane.setHgap(2);
		tilePane.setVgap(2);
	
		// 9:0rna bestämmer hur många rutor totalt i x-y led, dvs 9*9
		for (int i = 0; i < NBR_COL*NBR_ROW/3; i++) { // lägger till en ruta, totalt 81 st, 9*9

			TextField tf = new TextField();
			tf.setPrefSize(SIZE, SIZE);
			
			tilePane.getChildren().addAll(tf);
			
		
					
					tf.setStyle("-fx-background-color:  pink;");
					
			
		
		
			

			//lägger till tilepane i borderpane, centrerat
			borderPane.setLeft(tilePane);
			
			
			//Lägger till knapparna längst ner i fönstret
			borderPane.setBottom(hb);

		}
		
	

		
		
		stage.setResizable(false);// för att inte kunna ändra storlek på brädet

		Scene scene = new Scene(borderPane, (SIZE*NBR_COL+10), SIZE*NBR_ROW+50);
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
