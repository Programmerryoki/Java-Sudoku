package model;

/**
 * Class that holds sudoku
 * @author Programmerryoki
 *
 */
public class Sudoku {
	public Sudoku()
	{
	}
	
	/**
	 * Gets the grid
	 * @return The grid
	 */
	public int[][] getGrid() {
		return grid;
	}
	
	/**
	 * Sets the grid
	 * @param grid The grid to be set
	 */
	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	/**
	 * Gets the original restriction of sudoku
	 * @return The original grid
	 */
	public int[][] getOriginal() {
		return original;
	}

	/**
	 * Sets the original restriction of sudoku to given one
	 * @param original The original restriction to set
	 */
	public void setOriginal(int[][] original) {
		this.original = original;
	}

	private int[][] grid;
	private int[][] original;
}
