package backend;

/**
 * Class that checks if the sudoku is solved or not
 * @author Programmerryoki
 *
 */
public class Answer {
	/**
	 * Method that Checks if the given 9x9 sudoku grid is solved correctly
	 * @param grid The grid to check
	 * @return True if the grid is solved, false otherwise
	 */
	public static boolean solved(int[][] grid)
	{
		return strictVertical(grid) && strictHorizontal(grid) && strictGridWay(grid);
	}
	
	/**
	 * Method to check if the given value can be put at place (row, col) with out
	 * violating sudoku rule
	 * @param grid The grid to put the value
	 * @param row The row to put the value
	 * @param col The column to put the value
	 * @param val The value to put
	 * @return True if the value is placeable with out violating rule, False otherwise
	 */
	protected static boolean canPut(int[][] grid, int row, int col, int val)
	{
		return vertical(grid,col, val) && horizontal(grid, row, val) && gridWay(grid, row, col, val);
	}
	
	private static boolean vertical(int[][] grid, int col, int val)
	{
		//Checks if the val is in col
		for (int row = 0; row < 9; row++)
			if (grid[row][col] == val)
				return false;
		return true;
	}
	
	private static boolean horizontal(int[][] grid, int row, int val)
	{
		// Checks if val is in row
		for (int col = 0; col < 9; col++)
			if (grid[row][col] == val)
				return false;
		return true;
	}
	
	private static boolean gridWay(int[][] grid, int i, int j, int val)
	{
		// Checks if val is in 3x3 grid which contains i and j
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (grid[row + i/3 * 3][col + j/3 * 3] == val)
					return false;
		return true;
	}
	
	private static boolean strictVertical(int[][] grid)
	{
		// Vertical Check if the grid is finished and correct
		for (int col = 0; col < grid.length; col++)
		{
			int[] count = new int[10];
			for (int row = 0; row < grid[0].length; row++)
			{
				count[grid[row][col]] ++;
			}
			
			for (int i = 1; i <= grid.length; i++)
				if (count[i] != 1)
					return false;
		}
		return true;
	}
	
	private static boolean strictHorizontal(int[][] grid)
	{
		// Horizontal Check if the grid is finished and correct
		for (int row = 0; row < grid.length; row++)
		{
			int[] count = new int[10];
			for (int col = 0; col < grid[0].length; col++)
			{
				count[grid[row][col]] ++;
			}
			
			for (int i = 1; i <= grid.length; i++)
				if (count[i] != 1)
					return false;
		}
		return true;
	}
	
	private static boolean strictGridWay(int[][] grid)
	{
		// Grid way checking if the grid is finished and correct
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				int[] count = new int[10];
				for (int row = 0; row < 3; row++)
				{
					for (int col = 0; col < 3; col++)
					{
						count[grid[row + i * 3][col + j * 3]] ++ ;
					}
				}
				
				for (int k = 1; k <= grid.length; k++)
					if (count[k] != 1)
						return false;
			}
		}
		return true;
	}
}
