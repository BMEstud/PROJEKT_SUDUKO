
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GRID {

	public TextField tf;
	final int SIZE = 50;
	private int count = 0;
	private int r = 0;
	private int c = 0;
	public int[][] board;
	public TilePane tilePane;
	public int NBR_ROW = 9;
	public int NBR_COL = 9;
	public Object getTextField;
	

	public GRID(int[][] board) {

		this.board = board;
		tilePane = new TilePane();

		// 9:0rna bestämmer hur många rutor totalt i x-y led, dvs 9*9
		for (int i = 0; i < NBR_COL * NBR_ROW; i++) { // lägger till en ruta, totalt 81 st, 9*9
		
			tf = new TextField();
			tf.setPrefSize(SIZE, SIZE);
			tilePane.getChildren().addAll(tf);
			tf.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
			count++;
			
			tilePane.setPadding(new Insets(1, 1, 1, 1));
			tilePane.setHgap(2);
			tilePane.setVgap(2);
		
			int s = board[r][c];
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

		}
		
	
		
		
		

	}

	public TilePane getTilePane() {

		return tilePane;
	}

	public String getTextField() {

		return tf.getText();
	}
	
	public int[][] getBoard() {
		
		return board;
	}
	
	
//	//Hämta nummer ur en ruta
//	public int getNumber(int row, int col) {
//		for(int i = 0; i < NBR_ROW; i++ ) {
//			for(int j = 0; j < NBR_COL; j++ ) {
//				
//				if()
//				
//				
//				
//				
//				
//			}
//			
//		}
//		
		
	//	return row;
		
		
		
	}


	 
	


