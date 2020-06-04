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
	
	public Sudoku(int[][] original)
	{
		this.original = original;
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
	
	/**
	 * Gets the answer
	 * @return The answer
	 */
	public int[][] getAnswer()
	{
		return answer;
	}
	
	/**
	 * Sets the answer
	 * @param grid The answer to set
	 */
	public void setAnswer(int[][] grid)
	{
		this.answer = grid;
	}
	
	/**
	 * Checks if the answer given is correct or not
	 * @param grid The grid to check
	 * @return True if it is correct
	 * @precondition answer cannot be null
	 */
	public boolean compareAnswer(int[][] grid)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (grid[i][j] != answer[i][j])
					return false;
			}
		}
		return true;
	}

	private int[][] grid;
	private int[][] original;
	private int[][] answer;
}
