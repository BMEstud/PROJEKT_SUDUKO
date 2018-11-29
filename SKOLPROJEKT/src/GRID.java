
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GRID {

	private TextField tf;
	private BorderPane borderPane;
	private TilePane tilePane;
	final int SIZE = 50;
	private int count = 0;
	final int NBR_ROW = 9;
	final int NBR_COL = 9;
	public static final int EMPTY = 0;
	public int[][] GRID_TO_SOLVE;

	public GRID(int[][] GRID_TO_SOLVE) {

		this.GRID_TO_SOLVE = GRID_TO_SOLVE;

		// Behållarkomponenter, BorderPane är själva "grunden"
		this.borderPane = new BorderPane();
		this.tilePane = new TilePane();

		int c = 0;
		int r = 0;

		// 9:0rna bestämmer hur många rutor totalt i x-y led, dvs 9*9
		for (int i = 0; i < NBR_COL * NBR_ROW; i++) { // lägger till en ruta, totalt 81 st, 9*9

			TextField tf = new TextField();
			tf.setPrefSize(SIZE, SIZE);
			tilePane.getChildren().addAll(tf);
			tf.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));

			count++;

			tilePane.setPadding(new Insets(1, 1, 1, 1));
			tilePane.setHgap(2);
			tilePane.setVgap(2);

			int s = GRID_TO_SOLVE[r][c];
			String str = Integer.toString(s); // from int --> String

			tf.setText(str);

			if (s == 0) {
				tf.setText("");
			}

			c++;

			if (c == 9) {
				c = 0;
				r++;
			}

			if (!tf.getText().equals("")) {

				// Formatera texten, siffrorna från början ska vara stora och svarta
				tf.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
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
			borderPane.setCenter(tilePane);

		}

	}

	public BorderPane getBorderPane() {
		return this.borderPane;
	}

	public TilePane getTilePane() {
		return this.tilePane;
	}

	public int[][] getBoard() {

		return this.GRID_TO_SOLVE;
	}

	public void clearBoard(int[][] GRID_TO_SOLVE) {

		this.GRID_TO_SOLVE = GRID_TO_SOLVE;

		for (int row = 0; row < NBR_ROW; row++) {
			for (int col = 0; col < NBR_COL; col++) {

				GRID_TO_SOLVE[row][col] = 0;

			}
		}

	}

	public void readBoard(TilePane tilePane) {

		int row = 0;
		int col = 0;

		for (Node node : getTilePane().getChildren()) {

			if (checkInput(getTilePane()) != true) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Endast siffror");
				alert.setHeaderText(null);
				alert.setContentText("Endast siffror mellan 1-9 tillåtna");
				alert.showAndWait();
				return;

			}

			if (((TextField) node).getText().equals("")) {

				// the cells that contains no number are set to 0
				((TextField) node).setText("0");
			}

			this.GRID_TO_SOLVE[row][col] = Integer.parseInt(((TextField) node).getText());

			col++;

			if (col == 9) {
				col = 0;
				row++;
			}

		}

	}

	public boolean checkInput(TilePane tilePane) {

		for (Node node : getTilePane().getChildren()) {

			if (((TextField) node).getText().matches("[A-Za-z]") || !((TextField) node).getText().matches("\\d{0,1}") || ((TextField) node).getText().equals("0")) {

				return false;

			}

		}

		return true;

	}

	public void resetBoard() {

		for (Node node : getTilePane().getChildren()) {

			if (((TextField) node).getText().equals("0") || ((TextField) node).getText().matches("[A-Za-z]")) {

				// the cells that contains no number are set to 0
				((TextField) node).setText("");

			}

		}

	}

//
	private int getNbr(int i, int j) {

		return GRID_TO_SOLVE[i][j];

	}

//
	private void setNbr(int i, int j, int nbr) {

		GRID_TO_SOLVE[i][j] = nbr;
	}

//Check if a number is in the given row 
	private boolean isInRow(int row, int number) {
		for (int i = 0; i < NBR_ROW; i++)
			if (GRID_TO_SOLVE[row][i] == number)
				return true;

		return false;
	}

	// Check if the number is in the given column
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < NBR_COL; i++)
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
	public boolean solve(int i, int j) {
		for (int row = 0; row < NBR_ROW; row++) {
			for (int col = 0; col < NBR_COL; col++) {

				// There is no number in the cell
				if (GRID_TO_SOLVE[row][col] == EMPTY) {
					// we try possible numbers
					for (int number = 1; number <= 9; number++) {
						if (isOk(row, col, number)) {
							// number ok. it respects sudoku constraints, we fill the cell with a number
							GRID_TO_SOLVE[row][col] = number;

							if (solve(i, j)) { // we start backtracking recursively
								return true;
							} else { // if not a solution, we empty the cell and we continue
								GRID_TO_SOLVE[row][col] = EMPTY;
							}
						}
					}

					return false; // we return false

					// if there is a number in the cell
				}

			}
		}

		return true; // sudoku solved
	}

	public static void main(String[] args) {

	}

}
