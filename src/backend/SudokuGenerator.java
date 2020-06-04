/**
 * 
 */
package backend;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import model.Sudoku;

/**
 * @author Programmerryoki
 *
 */
public class SudokuGenerator {
	/**
	 * Generate and return a new Sudoku
	 * @return New sudoku
	 */
	public static Sudoku generateSudoku()
	{
		int[][] generate = notEfficientGenerateAnswerGrid();
		while (generate == null)
			generate = notEfficientGenerateAnswerGrid();
		int[][] question = new int[9][9];
		String[] order = new String[81];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				order[i*9+j] = i+""+j;
				question[i][j] = generate[i][j];
			}
		}
		List<String> strList = Arrays.asList(order);
		Collections.shuffle(strList);
		strList.toArray(order);
		for (int i = 0; i < strList.size(); i++)
		{
			int row = strList.get(i).charAt(0) - '0';
			int col = strList.get(i).charAt(1) - '0';
			int val = question[row][col];
			question[row][col] = 0;
			int c = 0;
			for (int j = 1; j < 10; j++)
				if (Answer.canPut(question, row, col, j))
					c++;
			if (c != 1)
				question[row][col] = val;
		}
		Sudoku answer = new Sudoku();
		answer.setAnswer(generate);
		answer.setOriginal(question);
		return answer;
	}
	
	private static int[] possibleList(int[][] grid, int i, int j)
	{
		int[] poss = new int[] {1,1,1,1,1,1,1,1,1};
		for (int k = 0; k < 9; k++)
			poss[grid[i][k] - 1] = 0;
		for (int k = 0; k < 9; k++)
			poss[grid[k][j] - 1] = 0;
		i = i/3;
		j = j/3;
		for (int a = 0; a < 3; a++)
			for (int b = 0; b < 3; b++)
				poss[grid[i+a][j+b] - 1] = 0;
		return poss;
	}
	
	private static boolean isPossible(int[][] grid, int i, int j, int val)
	{
		for (int k = 0; k < 9; k++)
			if (grid[i][k] == val)
				return false;
		for (int k = 0; k < 9; k++)
			if (grid[k][j] == val)
				return false;
		for (int a = 0; a < 3; a++)
			for (int b = 0; b < 3; b++)
				if (grid[i+a][j+b] == val)
					return false;
		return true;
	}
	
	private static int[][] notEfficientGenerateAnswerGrid()
	{
		int[][] ans = new int[9][9];
//		return genAns(ans);
		
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				int n = (int)(Math.random()*9 + 1);
				HashSet<Integer> count = new HashSet<>();
				while (!Answer.canPut(ans, i, j, n) && count.size() < 9)
				{
					n = (int)(Math.random()*9 + 1);
					count.add(n);
				}
				if (count.size() == 9)
				{
					return null;
				}
				ans[i][j] = n;
			}
		}
		return ans;
	}
	
//	private static int[][] genAns(int[][] grid)
//	{
//		int[] randOrd = new int[] {1,2,3,4,5,6,7,8,9};
//		List<Integer> intList = Arrays.asList(randOrd);
//		Collections.shuffle(intList);
//		intList.toArray(randOrd);
//		
//		boolean change = true;
//		for (int i = 0; i < 9; i++)
//		{
//			for (int j = 0; j < 9; j++)
//			{
//				if (grid[i][j] == 0)
//				{
//					change = true;
//					int val = (int)(Math.random()*9 + 1);
//					if (isPossible(grid, i, j, val))
//					{
//						int[][] temp = new int[9][9];
//						for (int row = 0; row < 9; row++)
//							for (int col = 0; col < 9; col++)
//								temp[i][j] = grid[i][j];
//						temp[i][j] = val;
//						genAns(grid);
//					}
//				}
//			}
//		}
//		if (change)
//			return 
//	}
	
//	public static void main(String[] args)
//	{
//		
//		int[][] grid = notEfficientGenerateAnswerGrid();
//		int c = 0;
//		while (grid == null)
//		{
//			grid = notEfficientGenerateAnswerGrid();
//			c ++;
//		}
//		System.out.println(c);
//		for (int[] i : grid)
//		{
//			for (int j : i)
//			{
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(Answer.solved(grid));
//	}
}
