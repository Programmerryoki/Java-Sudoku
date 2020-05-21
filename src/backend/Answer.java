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
		if (vertical(grid) && horizontal(grid) && gridWay(grid))
			return true;
		return false;
	}
	
	private static boolean vertical(int[][] grid)
	{
		// Vertical Check
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
	
	private static boolean horizontal(int[][] grid)
	{
		// Horizontal Check
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
	
	private static boolean gridWay(int[][] grid)
	{
		// Grid way checking
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
