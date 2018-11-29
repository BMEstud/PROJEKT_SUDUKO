
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Solver {

	private BorderPane borderPane;
	private TilePane tilePane;
	final int SIZE = 50;
	private int count = 0;
	final int NBR_ROW = 9;
	final int NBR_COL = 9;
	private static final int EMPTY = 0;
	private int[][] GRID_TO_SOLVE;

	public Solver(int[][] GRID_TO_SOLVE) {

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

	/**
	 * The method resets the matrix by replacing all numbers by 0
	 * 
	 * @param int[][], the matrix consisted of 9*9 fields
	 **/

	public void clearBoard(int[][] GRID_TO_SOLVE) {

		this.GRID_TO_SOLVE = GRID_TO_SOLVE;

		for (int row = 0; row < NBR_ROW; row++) {
			for (int col = 0; col < NBR_COL; col++) {

				GRID_TO_SOLVE[row][col] = 0;

			}
		}

	}

	/**
	 * The method scans the tilePane for inputs (textFields) and replaces every ""
	 * with zeros. It then fills the matrix GRID_TO_SOLVE with the values.
	 * 
	 * The method also calls the checkInput-method to check if the inputs are
	 * satisfied by the input constraints, i.e integers between 1-9. If the method
	 * finds any character not allowed, the user will get an information message
	 * 
	 * @param TilePane, the tilePane consisting of textFields
	 * @return An alert message box
	 */

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

				// the empty cells are set to 0
				((TextField) node).setText("0");
			}

			// The matrix get filled up with values from the textfields
			this.GRID_TO_SOLVE[row][col] = Integer.parseInt(((TextField) node).getText());

			col++;

			if (col == 9) {
				col = 0;
				row++;
			}

		}

	}

	/**
	 * The method checks if the inputs are satisfied by the input constraints, i.e
	 * integers between 1-9. If the method finds any character not allowed, the
	 * method will return false, else true.
	 * 
	 * @param TilePane, the tilePane consisted of 9*9 textFields
	 * @return true if the textfields only consists of integers between 1-9
	 * @return false, if any non integers between 1-9 are detected
	 */
	public boolean checkInput(TilePane tilePane) {

		for (Node node : getTilePane().getChildren()) {

			if (((TextField) node).getText().matches("[A-Za-ö]") || !((TextField) node).getText().matches("\\d{0,1}")) {

				return false;

			}

		}

		return true;

	}

	/**
	 * The method seeks for the characters either, 0 or a-ö and replaces the
	 * character by " "
	 * 
	 */
	public void resetBoard() {

		for (Node node : getTilePane().getChildren()) {

			if (((TextField) node).getText().equals("0") || ((TextField) node).getText().matches("[A-Za-ö]")) {

				// the cells that contains no number are set to 0
				((TextField) node).setText("");

			}

		}

	}

	/**
	 * the method checks if a given number is in a specific row
	 * 
	 * @param row    Of type int which corresponds to the row number in which a
	 *               specific number (second param) will be searched for
	 * @param number Of type int. The number the method will seek for
	 * @return true If the number can be fond
	 * @return false If the number can not be found
	 **/
	private boolean isInRow(int row, int number) {
		for (int i = 0; i < NBR_ROW; i++)
			if (GRID_TO_SOLVE[row][i] == number)
				return true;

		return false;
	}

	/**
	 * the method checks if a given number is in a specific column
	 * 
	 * @param col    Of type int which corresponds to the row number in which a
	 *               specific number (second param) will be searched for
	 * @param number Of type int. The number the method will seek for
	 * @return true If the number can be fond
	 * @return false If the number can not be found
	 **/
	private boolean isInCol(int col, int number) {
		for (int i = 0; i < NBR_COL; i++)
			if (GRID_TO_SOLVE[i][col] == number)
				return true;

		return false;
	}

	/**
	 * the method checks if a given number is in a box (3*3 field)
	 * 
	 * @param row    Of type int which corresponds to the row number in which a
	 *               specific number will be searched for
	 * @param col    Of type int which corresponds to the column in which a the num
	 *               param will be searched for
	 * @param number Of type int. The number the method will seek for
	 * @return true If the number can be fond
	 * @return false If the number can not be found
	 **/
	private boolean isInBox(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;

		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (GRID_TO_SOLVE[i][j] == number)
					return true;

		return false;
	}

	/**
	 * the method checks if a given number is
	 * 
	 * @param row    Of type int which corresponds to the row number in which a
	 *               specific number will be searched for
	 * @param col    Of tyoe int which corrsponds to the column number in which the
	 *               specifi number will be searched for
	 * @param number Of type int. The number the method will seek for
	 * @return true If the number can not be found in the given row, column or a box
	 * @return false f the number can be found in the given row, column or a box
	 **/
	private boolean isOk(int row, int col, int number) {
		return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
	}

	/**
	 * The method solves the suduko recurvisely with backtracking method
	 * 
	 * @param i Of type int which corresponds to the x coordinate where the method
	 *          will begin
	 * @param j Of type int which corrsponds to the y coordinate
	 * @return true If the suduko can be solved
	 * @return false If the suduko can not be solved
	 **/
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

				}

			}
		}

		return true; // sudoku solved
	}

	/**
	 * the method returns the bordepane
	 *
	 * @return borderpane
	 **/
	public BorderPane getBorderPane() {
		return this.borderPane;
	}

	/**
	 * the method returns the tilepane
	 *
	 * @return tilepane
	 **/
	public TilePane getTilePane() {
		return this.tilePane;
	}

	/**
	 * the method returns the matrix
	 *
	 * @return GRID_TO_SOLVE
	 **/
	public int[][] getBoard() {

		return this.GRID_TO_SOLVE;
	}

}
