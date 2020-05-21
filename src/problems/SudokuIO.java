/**
 * 
 */
package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author ryoki
 *
 */
public class SudokuIO {
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
