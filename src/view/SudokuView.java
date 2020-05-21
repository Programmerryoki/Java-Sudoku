package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class SudokuView extends JPanel{
	public SudokuView(ActionListener controller)
	{
		setLayout(new BorderLayout());
		
		JPanel sudoGrids = new JPanel();
//		sudoGrids.setPreferredSize(new Dimension(100,100));
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
					b[0] = 2;
				if (j == 3 || j == 6)
					b[1] = 2;
				if (i == 2 || i == 5)
					b[2] = 2;
				if (j == 2 || j == 5)
					b[3] = 2;
				grid.setBorder(BorderFactory.createMatteBorder(b[0], b[1], b[2], b[3], Color.black));
				grid.setActionCommand("Grid"+i+j);
				grid.addActionListener(controller);
				grid.setPreferredSize(new Dimension(10,10));
				sudoGrids.add(grid);
				grids[i][j] = grid;
			}
		}
		
		add(sudoGrids, BorderLayout.CENTER);
		
		noBtn = new JRadioButton[10];
		JPanel radios = new JPanel();
		radios.setLayout(new GridLayout(10,1));
		noBtnGroup = new ButtonGroup();
		for (int i = 0; i <= 9; i++)
		{
			JRadioButton radioBtn = new JRadioButton("" + i);
			if (i == 0)
				radioBtn.setText("Empty");
			radioBtn.setMnemonic(KeyEvent.VK_0 + i);
			noBtnGroup.add(radioBtn);
			radios.add(radioBtn);
			noBtn[i] = radioBtn;
		}
		add(radios, BorderLayout.EAST);
		
		JPanel buttonsP = new JPanel();
		JButton saveBtn = new JButton();
		saveBtn.setText("Save");
		saveBtn.setActionCommand("Save");
		saveBtn.addActionListener(controller);
		buttonsP.add(saveBtn);
		
		JButton checkBtn = new JButton();
		checkBtn.setText("Check");
		checkBtn.addActionListener(controller);
		checkBtn.setActionCommand("Check");
		buttonsP.add(checkBtn);
		
		add(buttonsP, BorderLayout.SOUTH);
	}
	
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
	
	public void setGridAt(int row, int col, String val)
	{
		grids[row][col].setText(val);
	}
	
	public int getSelectedNumber()
	{
		for (int i = 0; i < noBtn.length; i++)
			if (noBtn[i].isSelected())
				return i;
		return 0;
	}
	
	private JButton[][] grids;
	private JRadioButton[] noBtn;
	private ButtonGroup noBtnGroup;
}
