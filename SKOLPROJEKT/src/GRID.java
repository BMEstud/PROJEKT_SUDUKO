
import java.util.Random;



public class GRID {


	public GRID(int[][] board) {
		board = new int[9][9];
		Random rand = new Random();

		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				board[i][k] = rand.nextInt(9);


			}

		}

	}

}
