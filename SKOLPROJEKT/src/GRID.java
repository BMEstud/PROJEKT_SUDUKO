
import java.util.Random;

import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GRID {

	private TextField tf;
	private int[][] board = new int[9][9];
	final int SIZE = 50;
	private int count = 0;
	private int r = 0;
	private int c = 0;
	int[][] GRID_TO_SOLVE = { { 9, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
			{ 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
			{ 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

	public GRID(int[][] board) {

		// 9:0rna bestämmer hur många rutor totalt i x-y led, dvs 9*9
		for (int i = 0; i < board.length * board.length; i++) { // lägger till en ruta, totalt 81 st, 9*9
			TilePane tilePane = new TilePane();
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

	}
}
