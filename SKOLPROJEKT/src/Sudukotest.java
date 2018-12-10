import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Sudukotest {
	
	private Solver solver;
	private GUI gui;
	private int[][] EMPTY_GRID = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
	
	private int[][] UNSOLVE_GRID = { { 5, 0, 0, 5, 0, 0, 0, 1, 0 }, { 2, 7, 8, 0, 0, 0, 4, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 2, 0, 0, 0, 0, 0, 9, 0 }, { 0, 0, 0, 0, 4, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
	
	private int[][] SOLVED_GRID = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
			{ 7, 8, 9, 1, 2, 3, 4, 5, 6 }, {2, 1, 4, 3, 6, 5, 8, 9, 7 }, {3, 6, 5, 8, 9, 7, 2, 1, 4 },
			{ 8, 9, 7, 2, 1, 4, 3, 6, 5 }, { 5, 3, 1, 6, 4, 2, 9, 7, 8 }, { 6, 4, 2, 9, 7, 8, 5, 3, 1 },
			{ 9, 7, 8, 5, 3, 1, 6, 4, 2 }, };

	@BeforeEach
	void setUp() throws Exception {
		 gui = new GUI();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testEmptyGrid() {
//		 solver.solve(0,0);
//		 
//		 
//		 
//		assertSame("hhshs", solver.getTilePane(), EMPTY_GRID );
//		
//		
//	}
	
	@Test
	void testUnsolvableGrid()
	{
		Solver solver = new Solver(EMPTY_GRID);
		assertTrue(solver.solve(0, 0));
	}

}
