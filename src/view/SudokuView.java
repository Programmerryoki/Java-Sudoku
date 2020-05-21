package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

/**
 * The class that has the GUI of Sudoku
 * @author Programmerryoki
 *
 */
public class SudokuView extends JPanel{
	/**
	 * Ctor that creates GUI of the Sudoku
	 * @param controller The controller which listen to action of sudokuview
	 */
	public SudokuView(ActionListener controller)
	{
		setLayout(new BorderLayout());
		
		//************************
		// Created the Sudoku grid
		//************************
		JPanel sudoGrids = new JPanel();
		sudoGrids.setLayout(new GridLayout(9,9,0,0));
		sudoGrids.setBorder(BorderFactory.createTitledBorder("Sudoku"));
		
		grids = new JButton[9][9];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				JButton grid = new JButton();
				grid.setBackground(UIManager.getColor("Label.background"));
				int[] b = new int[] {1,1,1,1};
				if (i == 0)
					b[0] = 0;
				if (j == 0)
					b[1] = 0;
				if (i == 8)
					b[2] = 0;
				if (j == 8)
					b[3] = 0;
				if (i == 3 || i == 6)
					b[0] = 3;
				if (j == 3 || j == 6)
					b[1] = 3;
				if (i == 2 || i == 5)
					b[2] = 3;
				if (j == 2 || j == 5)
					b[3] = 3;
				grid.setBorder(BorderFactory.createMatteBorder(b[0], b[1], b[2], b[3], Color.black));
				grid.setActionCommand("Grid"+i+j);
				grid.addActionListener(controller);
				grid.setPreferredSize(new Dimension(10,10));
				sudoGrids.add(grid);
				grids[i][j] = grid;
			}
		}
		
		add(sudoGrids, BorderLayout.CENTER);
		
		//*********************
		// Radio Button Created
		//*********************
		noBtn = new JRadioButton[10];
		JPanel radios = new JPanel();
		radios.setLayout(new GridLayout(10,1));
		noBtnGroup = new ButtonGroup();
		for (int i = 0; i <= 9; i++)
		{
			JRadioButton radioBtn = new JRadioButton("" + i);
			if (i == 0)
			{
				radioBtn.setText("Empty");
				radioBtn.setSelected(true);
			}
			radioBtn.addActionListener(controller);
			radioBtn.setMnemonic(KeyEvent.VK_0 + i);
			radioBtn.setActionCommand("Radio " + i);
			noBtnGroup.add(radioBtn);
			radios.add(radioBtn);
			noBtn[i] = radioBtn;
		}
		add(radios, BorderLayout.EAST);
		
		//****************
		// Button to Check
		//****************
		JPanel buttonsP = new JPanel();
		
		JButton checkBtn = new JButton();
		checkBtn.setText("Check");
		checkBtn.addActionListener(controller);
		checkBtn.setActionCommand("Check");
		buttonsP.add(checkBtn);
		
		add(buttonsP, BorderLayout.SOUTH);
	}
	
	/**
	 * Gets the number inputted onto the sudoku
	 * @return The grid which has all the input
	 */
	public int[][] getGridNumbers()
	{
		int[][] ans = new int[9][9];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				try
				{
					ans[i][j] = Integer.parseInt(grids[i][j].getText());
				}
				catch (Exception e)
				{
					ans[i][j] = 0;
				}
			}
		}
		return ans;
	}
	
	/**
	 * Sets the grid of the sudoku to be the given grid
	 * @param grid The grid to set number
	 */
	public void setGridNumbers(int[][] grid)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (grid[i][j] != 0)
					grids[i][j].setText("" + grid[i][j]);
				else
					grids[i][j].setText("");
			}
		}
	}
	
	/**
	 * Sets the grid of sudoku and fixed the number so the user can't edit it
	 * @param grid The grid to set
	 */
	public void fixGridNumbers(int[][] grid)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (grid[i][j] != 0)
				{
					grids[i][j].setEnabled(false);
					grids[i][j].setText("" + grid[i][j]);
					grids[i][j].setFont(new Font(grids[i][j].getFont().getFontName(), Font.PLAIN, 20));
				}
				else
					grids[i][j].setText("");
			}
		}
	}
	
	/**
	 * Gets the value of cell at position (row, col)
	 * @param row The row of cell
	 * @param col The column of cell
	 * @return The value of the cell
	 */
	public int getGridAt(int row, int col)
	{
		String val = grids[row][col].getText();
		try
		{
			return Integer.parseInt(val);
		}
		catch (Exception e)
		{
			return 0;
		}
	}
	
	/**
	 * Sets the value of input to the cell at position (row, col)
	 * @param row The row of the cell
	 * @param col The column of the cell
	 * @param val The value to set
	 */
	public void setGridAt(int row, int col, String val)
	{
		grids[row][col].setText(val);
	}
	
	/**
	 * Gets the selected number of radio button
	 * @return The integer of radio button
	 */
	public int getSelectedNumber()
	{
		for (int i = 0; i < noBtn.length; i++)
			if (noBtn[i].isSelected())
				return i;
		return 0;
	}
	
	/**
	 * Change the color of cell which has the given value
	 * @param color The color of the cell
	 * @param val The value to check
	 */
	public void changeColor(Color color, int val)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (grids[i][j].getText().equals(""+val))
					grids[i][j].setBackground(color);
			}
		}
	}
	
	/**
	 * Resets the color of cell to original
	 */
	public void resetColor()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				grids[i][j].setBackground(Color.white);
			}
		}
	}
	
	private JButton[][] grids;
	private JRadioButton[] noBtn;
	private ButtonGroup noBtnGroup;
}
