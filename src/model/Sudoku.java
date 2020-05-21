package model;

public class Sudoku {
	public Sudoku()
	{
	}
	
	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	public int[][] getOriginal() {
		return original;
	}

	public void setOriginal(int[][] original) {
		this.original = original;
	}

	private int[][] grid;
	private int[][] original;
}
