
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
//hej
public class GRID {

	public TextField tf;
	public BorderPane borderPane;
	public TilePane tilePane;
	final int SIZE = 50;
	private int count = 0;
	final int NBR_ROW = 9;
	final int NBR_COL = 9;
	public static final int EMPTY = 0;
	private int[][] GRID_TO_SOLVE;
	

	public GRID(int[][] GRID_TO_SOLVE) {
		
		this.GRID_TO_SOLVE = GRID_TO_SOLVE;
		
		// Behållarkomponenter, BorderPane är själva "grunden"
		this.borderPane = new BorderPane();
		this.tilePane = new TilePane();

        int c = 0;
        int r = 0;

		// 9:0rna bestämmer hur många rutor totalt i x-y led, dvs 9*9
		for (int i = 0; i < NBR_COL * NBR_ROW; i++) { // lägger till en ruta, totalt 81 st, 9*9
		
		    this.tf = new TextField();
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
			
			if ( count < 4) {
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
			borderPane.setCenter(tilePane);
			
//			//till varje textfield kopplas en mouseevent-handler
//			tf.setOnMousePressed(new EventHandler<MouseEvent>() {
//			      public void handle(MouseEvent me) {
//			   
//			    	  
//			    	  if(!tf.getText().equals("")) {
//			    		  System.out.println("Tom rut");
//			    	  }else {
//			    		  System.out.println("Ingen tom ruta");
//			    	  }
//			    	  
//			        }
//			      });

		}
		

	}
public BorderPane getBorderPane() {
	return this.borderPane;
}

public TilePane getTilePane() {
	return this.tilePane;
}

public TextField getTextField() {
	return this.tf;
}
	
	

	

	//Vi tittar om ett nummer redan finns i en rad
	private boolean isInRow(int row, int number) {
		for (int i = 0; i < SIZE; i++)
			if (GRID_TO_SOLVE[row][i] == number)
				return true;

		return false;
	}

	//Vi tittar om det finns ett nummer redan i en kolumn
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < SIZE; i++)
			if (GRID_TO_SOLVE[i][col] == number)
				return true;

		return false;
	}

	// Vi tittar om det finns ett nummer i boxen (det rosa)
	private boolean isInBox(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;

		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (GRID_TO_SOLVE[i][j] == number)
					return true;

		return false;
	}

	// combined method to check if a number possible to a row,col position is ok
	private boolean isOk(int row, int col, int number) {
		return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
	}

	// Solver-metod, Backtracking

	public boolean solve() {
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				//. Aktuell ruta är inte från början fylld (av användaren). Då provar man i tur och ordning
				// att fylla den med något av talen 1..9
				if (GRID_TO_SOLVE[row][col] == EMPTY) {
					// we try possible numbers
					for (int number = 1; number <= SIZE; number++) {
						if (isOk(row, col, number)) {
							// number ok. it respects sudoku constraints
							GRID_TO_SOLVE[row][col] = number;

							if (solve()) { // we start backtracking recursively
								return true;
							} else { // if not a solution, we empty the cell and we continue
								GRID_TO_SOLVE[row][col] = EMPTY;
							}
						}
					}

					return false; // we return false
				}
			}
		}

		return true; // sudoku solved
	}



	public static void main(String[] args) {


		// we try resolution
//		if (sudoku.solve()) {
//			System.out.println("Sudoku Grid solved with simple BT");
//			sudoku.display();
//		} else {
//			System.out.println("Unsolvable");
//		}
	}


		
		
	}


	 
	


