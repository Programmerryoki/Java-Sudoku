package backend;

public class Answer {
	public boolean solved(int[][] grid)
	{
		
	}
	
	private boolean vertical(int[][] grid)
	{
		// Vertical Check
		for (int col = 0; col < grid.length; col++)
		{
			int[] count = new int[9];
			for (int row = 0; row < grid[0].length; row++)
			{
				count[grid[row][col] - 1] ++;
			}
			
			for (int i = 1; i <= grid.length; i++)
				if (count[i] != 1)
					return false;
		}
		return true;
	}
	
	private boolean horizontal(int[][] grid)
	{
		// Horizontal Check
		for (int row = 0; row < grid.length; row++)
		{
			int[] count = new int[9];
			for (int col = 0; col < grid[0].length; col++)
			{
				count[grid[row][col] - 1] ++;
			}
			
			for (int i = 1; i <= grid.length; i++)
				if (count[i] != 1)
					return false;
		}
		return true;
	}
}
