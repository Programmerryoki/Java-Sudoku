
package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * The IO for the Sudoku
 * @author Programmerryoki
 *
 */
public class SudokuIO {
	/**
	 * Returns the grid which get input from given file
	 * @param fileName The file to read sudoku from
	 * @return The grid which contains number fron sudoku
	 */
	public static int[][] readFile(String fileName)
	{
		int[][] input = new int[9][9];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/problems/"+fileName+"/"));
			int i = 0;
			while (br.ready() && i < 9) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < 9; j++)
				{
					input[i][j] = Integer.parseInt(line[j]);
				}
				i++;
			}
			br.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		return input;
	}
}
